
import java.util.*;

public class Supermarket {
    
    private static Warehouse whouse;
    
    public Supermarket(){
        whouse = new Warehouse();
    }

    public static Warehouse getWhouse() {
        return whouse;
    }

    public static void setWhouse(Warehouse whouse) {
        Supermarket.whouse = whouse;
    }

    public void displayItemsonWarehouse() {
        System.out.println("Avaialble Items on WareHouse: ");
        for (Item item : getWhouse().getItems()) {
            System.out.println("Type: " + item.getType());
            System.out.println("Code: " + item.getCode());
            System.out.println("Price: " + item.getPrice());
            System.out.println("Manufacturing Date: " + item.getManufacturingDate());
            System.out.println("Expiry Date: " + item.getExpiryDate());
            System.out.println("Quantity: " + item.getQuantity());
            System.out.println("Threshold: " + item.getThreshold());
            System.out.println("---------------------------------");
        }

    }


    public void displayItemLestThenThreshold() {
        System.out.println("Items Less then Threshold");
        for (Item item : getWhouse().getItems()) {
            if(item.getThreshold()>= item.getQuantity()){
            System.out.println("Type: " + item.getType());
            System.out.println("Code: " + item.getCode());
            System.out.println("Price: " + item.getPrice());
            System.out.println("Manufacturing Date: " + item.getManufacturingDate());
            System.out.println("Expiry Date: " + item.getExpiryDate());
            System.out.println("Quantity: " + item.getQuantity());
            System.out.println("Threshold: " + item.getThreshold());
            System.out.println("---------------------------------");
        }
        }

    }
    
    /* public void addItem(Item item){
        for (Stack<Item> stack : stacks) {
            if(stack.peek().getType().equalsIgnoreCase(item.getType())){
                stack.push(item);
                return;
            }
        }
        Stack<Item> s = new Stack<>();
        s.push(item);
        stacks.add(s);
    }
    
    public Item removeItem(String type){
        for (Stack<Item> stack : stacks) {
            if(stack.peek().getType().equalsIgnoreCase(type)){
                return stack.pop();
            }
        }
        return null;
    }
    
    public Item buyItem(String type){
        for (Stack<Item> stack : stacks) {
            if(stack.peek().getType().equalsIgnoreCase(type)){
                return stack.pop();
            }
        }
        return null;
    }

    public void displayItems() {
        System.out.println("Avaialble Items: ");
        for (Stack<Item> stack : stacks) {
            System.out.println(stack.peek().getType()+" ["+stack.peek().getCode()+"]");
        }
    }
    */

    
}
