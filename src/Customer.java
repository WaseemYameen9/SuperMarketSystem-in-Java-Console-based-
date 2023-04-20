import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {

    private String name;
    private String email;
    private List<Item> itemList;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        itemList = new ArrayList<>();
    }
    
    //public void addToShelf(Item item){
      //  shelf.add(item);
    //}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return ", Name: "+ name + ", Email: " + email;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    //public void displayShelf() {
      //  shelf.display();
    //}
    public void Buy(Item item)
    {
        itemList.add(item);
    }



}
