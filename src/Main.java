
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
    private static List<Customer> customers = new ArrayList<>();
    private static List<CustomerShelf> customerShelf = new ArrayList<>();
    private static List<Cashier> cashiers = new ArrayList<>();
    private static Manager manager;
    private static Supermarket market;


    //                Main
    public static void main(String[] args){
        
        market = new Supermarket();
        market.getWhouse().loadWarehouseFromFile("warehouseitems.txt");
        loadCustomerShelfFromFile("customerShelf.txt");
        loadManager();
        while(true) {
            int opt = MainMenu();

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
                if(checkManager(id,name,email)) {
                    while (true) {
                        int choice1 = ManagerMenu();
                        switch (choice1) {
                            case 1:
                                createItem();
                                break;
                            case 2:
                                displayItems();
                                break;
                            case 3:
                                AddProductsonCustomerShelf();
                                break;
                            case 4:
                                DisplayProductsonCustomerShelf();
                                break;
                            case 5:
                                market.displayItemLestThenThreshold();
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
                    customers.add(c);
                    if (c != null) {
                        while (true) {
                            int choice2 = CustomerMenu();
                            switch (choice2) {
                                case 1:
                                    market.displayItemsonWarehouse();
                                    break;
                                case 2:
                                    Buy(c);
                                    break;
                                case 3:
                                    viewmyShopping(c);

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
                            int choice1 = CashierMenu();
                            switch (choice1) {
                                case 1:
                                    System.out.print("Enter Customer Name: ");
                                    Scanner in1 = new Scanner(System.in);
                                    String Name = in1.nextLine();

                                    ViewItemsCustomerBought(Name);
                                    break;
                                case 2:
                                    ViewItemsofallCustomer();
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
                storeCustomerShelfInFile("customerShelf.txt");
                storeManager(manager);
                break;
            }
        }
    }


    //              Functions
    private static void createItem() {
        Scanner in = new Scanner(System.in);
        System.out.print("Item type: ");
        String type = in.nextLine();
        System.out.print("Item Code: ");
        String Code = in.nextLine();
        System.out.print("Item Price: ");
        double Price = in.nextDouble();
        in.nextLine();
        System.out.print("Manufacture Date (dd/MM/yyyy): ");
        String MDate = in.nextLine();
        Date mdate = null;
        Date edate = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
           mdate = dateFormat.parse(MDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter a date in dd/MM/yyyy format.");
        }
        System.out.print("Expiry Date (dd/MM/yyyy): ");
        String ExDate = in.nextLine();
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");

        try {
            edate = dateFormat1.parse(ExDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter a date in dd/MM/yyyy format.");
        }

        System.out.print("Quantity: ");
        int Qty = in.nextInt();
        in.nextLine();
        System.out.print("Threshold: ");
        int Threshold = in.nextInt();

        Item it = new Item(type,Code,Price,mdate,edate,Qty,Threshold);
        market.getWhouse().AddItem(it);
    }

    private static void displayItems() {
       market.displayItemsonWarehouse();
        System.out.println("----------------------------");
       DisplayProductsonCustomerShelf();
    }


    
    public static void displayShelf(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Customer ID: ");
        int id = in.nextInt();
        for (int a = 0; a < customers.size(); a++) {
            //if(customers.get(a).getId() == id){
                //customers.get(a).displayShelf();
                break;
           // }
        }
    }

    public static int MainMenu()
    {
        System.out.println("|---------------------------------------|");
        System.out.println("|              Super Market             |");
        System.out.println("|---------------------------------------|");
        System.out.println("|- Press 1 for Manager                  |");
        System.out.println("|- Press 2 for Customer                 |");
        System.out.println("|- Press 3 for Cashier                  |");
        System.out.println("|- Press -1 to Logout                   |");
        System.out.println("|---------------------------------------|");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Your Option:");
        int op = in.nextInt();;
        return op;


    }

    public static int ManagerMenu()
    {
        System.out.println("|---------------------------------------|");
        System.out.println("|              Manager                  |");
        System.out.println("|---------------------------------------|");
        System.out.println("|1. Create Item                         |");
        System.out.println("|2. Display Available Items             |");
        System.out.println("|3. Add Items on Customer Shelf         |");
        System.out.println("|4. Display Customer Shelf              |");
        System.out.println("|5. Display Items Less then Threshold   |");
        System.out.println("|6. Logout                              |");
        System.out.println("|---------------------------------------|");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Your Option:");
        int op = in.nextInt();;
        return op;
    }

    public static int CashierMenu()
    {
        System.out.println("|-----------------------------------------------|");
        System.out.println("|              Cashiew                          |");
        System.out.println("|-----------------------------------------------|");
        System.out.println("|1. View Items customer want to bought and Bill |");
        System.out.println("|2. View bought items of all Customers          |");
        System.out.println("|3. Logout                                      |");
        System.out.println("|-----------------------------------------------|");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Your Option:");
        int op = in.nextInt();;
        return op;


    }


    public static int CustomerMenu()
    {
        System.out.println("|---------------------------------------|");
        System.out.println("|               Customer                |");
        System.out.println("|---------------------------------------|");
        System.out.println("| 1- View Items                         |");
        System.out.println("| 2- Buy Items                          |");
        System.out.println("| 3- View My Shopping                   |");
        System.out.println("| 4- Logout                             |");
        System.out.println("|---------------------------------------|");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Your Option:");
        int op = in.nextInt();;
        return op;


    }

    public static void AddProductsonCustomerShelf()
    {
        market.displayItemsonWarehouse();
        try{
        Scanner in = new Scanner(System.in);
        System.out.print("Item type: ");
        String type = in.nextLine();
        System.out.print("Item Quantity: ");
        int Qty = in.nextInt();
        in.nextLine();
        System.out.print("Position: ");
        String Position = in.nextLine();
        if(cutItemFromWarehouse(type,Qty)){
            CustomerShelf cust = new CustomerShelf(type,Qty,Position);
            customerShelf.add(cust);
        }

        }
        catch (Exception e)
        {
            System.out.println("Error in Fields");
        }


    }

    private static void DisplayProductsonCustomerShelf()
    {
        System.out.println("Products on Customer Shelf: ");
        for (CustomerShelf cs : customerShelf) {
            System.out.println("Type: " + cs.getItemType());
            System.out.println("Quantity: " + cs.getItemQuantity());
            System.out.println("Position: " + cs.getPosition());
            System.out.println("---------------------------------");
        }

    }

    private static void Buy(Customer cust)
    {
        boolean flag=false;
        market.displayItemsonWarehouse();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the type of Product you want to buy: ");
        String type = in.nextLine();
        System.out.print("Enter Quantity: ");
        int Qty = in.nextInt();
        try{
            for (Item item : market.getWhouse().getItems()) {
                    if(item.getType().equals(type))   {
                        flag=true;
                        if(Qty<=item.getQuantity()){
                            item.setQuantity(item.getQuantity()-Qty);
                            Item itemm = new Item(item.getType(),item.getCode(),item.getPrice(),item.getManufacturingDate(),item.getExpiryDate(),Qty,item.getThreshold());
                            cust.getItemList().add(itemm);
                        }
                        else{
                            System.out.println("Enter valid Quantity");
                        }
                    }
            }
            if(flag==false){
                System.out.println("Enter valid type");
            }
        }

        catch (Exception e)
        {

        }

    }


    public static void viewmyShopping(Customer cus)
    {
        for (Item item : cus.getItemList()) {
            System.out.println("Type: " + item.getType());
            System.out.println("Code: " + item.getCode());
            System.out.println("Price: " + item.getPrice());
            System.out.println("Manufacturing Date: " + item.getManufacturingDate());
            System.out.println("Expiry Date: " + item.getExpiryDate());
            System.out.println("Quantity Bought: " + item.getQuantity());
            System.out.println("---------------------------------");
        }
    }

    public static boolean cutItemFromWarehouse(String type, int Qty)
    {
        for (Item item : market.getWhouse().getItems()) {
            if(item.getType().equals(type))   {
                if(Qty<=item.getQuantity()){
                    item.setQuantity(item.getQuantity()-Qty);
                    return true;
                }
                else{
                    System.out.println("Enter valid Quantity");
                }
            }
        }
        return  false;
    }

    public static void ViewItemsCustomerBought(String Name) {
        double bill=0;
        for (Customer customer : customers) {
            if (customer.getName().equals(Name)) {
                for (Item item : customer.getItemList()) {
                    System.out.println("Type: " + item.getType());
                    System.out.println("Code: " + item.getCode());
                    System.out.println("Price: " + item.getPrice());
                    System.out.println("Manufacturing Date: " + item.getManufacturingDate());
                    System.out.println("Expiry Date: " + item.getExpiryDate());
                    System.out.println("Quantity Bought: " + item.getQuantity());
                    System.out.println("---------------------------------");
                    bill = bill + (item.getQuantity()*item.getPrice());
                }
                System.out.println("------------------------------------------------");
                System.out.println("Your total bill is:" + bill);
                System.out.println("------------------------------------------------");
            }

        }
    }

    public static void ViewItemsofallCustomer() {
        double bill=0;
        for (Customer customer : customers) {
            for (Item item : customer.getItemList()) {
                System.out.println("Type: " + item.getType());
                System.out.println("Code: " + item.getCode());
                System.out.println("Price: " + item.getPrice());
                System.out.println("Manufacturing Date: " + item.getManufacturingDate());
                System.out.println("Expiry Date: " + item.getExpiryDate());
                System.out.println("Quantity Bought: " + item.getQuantity());
                System.out.println("---------------------------------");
                bill = bill + (item.getQuantity() * item.getPrice());
            }
                System.out.println("------------------------------------------------");
                System.out.println(customer.getName()+" Your total bill is:" + bill);
                System.out.println("------------------------------------------------");
            }

        }

    public static void storeCustomerShelfInFile(String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            for (CustomerShelf shelf : customerShelf) {
                writer.write(shelf.getItemType() + "," + shelf.getItemQuantity() + "," + shelf.getPosition() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadCustomerShelfFromFile(String filePath) {
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] shelfData = line.split(",");
                String itemType = shelfData[0];
                int itemQuantity = Integer.parseInt(shelfData[1]);
                String position = shelfData[2];
                CustomerShelf shelf = new CustomerShelf(itemType, itemQuantity, position);
                customerShelf.add(shelf);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void storeManager(Manager manager) {
        try {
            FileWriter writer = new FileWriter("manager.txt");
            writer.write(manager.getId() + "," + manager.getName() + "," + manager.getEmail() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadManager() {
        try {
            FileReader fileReader = new FileReader("manager.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            if (line != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String email = data[2];
                manager = new Manager(id, name, email);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static boolean checkManager(int id, String name, String email)
    {
        if(manager.getId() == id && manager.getName().equals(name) && manager.getEmail().equals(email)){
            return true;
        }
        return false;
    }





}
