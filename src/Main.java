
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class Main {
    //                Data Structures
    private static Supermarket market;


    //                Main
    public static void main(String[] args){
        
        market = new Supermarket();
        market.getWhouse().loadWarehouseFromFile("warehouseitems.txt");
        market.loadCustomerShelfFromFile("customerShelf.txt");
        market.loadManager();
        while(true) {
            int opt = market.MainMenu();

            if (opt == 1) {
                int choice5=1;
                while(true){
                Scanner in = new Scanner(System.in);
                System.out.print("Enter Manager ID: ");
                int id = in.nextInt();
                in.nextLine();
                System.out.print("Enter Manager Name: ");
                String name = in.nextLine();
                System.out.print("Enter Manager's Email: ");
                String email = in.nextLine();
                if(market.checkManager(id,name,email)) {
                    while (true) {
                        int choice1 = market.manager.ManagerMenu();
                        switch (choice1) {
                            case 1:
                                market.createItem();
                                break;
                            case 2:
                                market.displayItems();
                                break;
                            case 3:
                                market.AddProductsonCustomerShelf();
                                break;
                            case 4:
                                market.DisplayProductsonCustomerShelf();
                                break;
                            case 5:
                                market.whouse.displayItemLestThenThreshold();
                                break;
                            case 6:
                                break;
                        }
                        if (choice1 == 6) {
                            choice5=2;
                            break; // exit the loop if user chooses to exit program
                        }

                    }
                    if(choice5==2){
                        break;
                    }
                }
               }
            }

            if (opt == 2) {
                int choice3=1;
                while(true) {
                    Scanner in = new Scanner(System.in);
                    System.out.print("Enter Customer Name: ");
                    String name = in.nextLine();
                    System.out.print("Enter Customer Email: ");
                    String email = in.nextLine();
                    Customer c = new Customer(name, email);
                    market.customers.add(c);
                    if (c != null) {
                        while (true) {
                            int choice2 = market.CustomerMenu();
                            switch (choice2) {
                                case 1:
                                    market.whouse.displayItemsonWarehouse();
                                    break;
                                case 2:
                                    market.Buy(c);
                                    break;
                                case 3:
                                    market.viewmyShopping(c);

                                case 4:
                                    break;
                            }
                            if (choice2 == 4) {
                                choice3=2;
                                break; // exit the loop if user chooses to exit program
                            }
                        }
                        if(choice3==2){
                            break;
                        }

                    }
                }
            }
            if (opt == 3) {
                int choice=1;
                while(true) {
                    Scanner in = new Scanner(System.in);
                    System.out.print("Enter Cashier Name: ");
                    String name = in.nextLine();
                    System.out.print("Enter Cashier Number: ");
                    int CNumber = in.nextInt();
                    Cashier c = new Cashier(name, CNumber);
                    if (c != null) {
                        while (true) {
                            int choice1 = market.CashierMenu();
                            switch (choice1) {
                                case 1:
                                    System.out.print("Enter Customer Name: ");
                                    Scanner in1 = new Scanner(System.in);
                                    String Name = in1.nextLine();

                                    market.ViewItemsCustomerBought(Name);
                                    break;
                                case 2:
                                    market.ViewItemsofallCustomer();
                                    break;
                                case 3:
                                    break;
                            }
                            if (choice1 == 3) {
                                choice=2;
                                break; // exit the loop if user chooses to exit program
                            }
                        }
                        if(choice==2){
                            break;
                        }

                    }
                }
            }
            if (opt == -1) {
                market.getWhouse().storeWarehouseInFile("warehouseitems.txt");
                market.storeCustomerShelfInFile("customerShelf.txt");
                market.storeManager(market.manager);
                break;
            }
        }
    }

}
