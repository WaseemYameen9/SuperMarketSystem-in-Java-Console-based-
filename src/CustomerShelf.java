
import java.util.*;

public class CustomerShelf {
    
    private String itemType;
    private int itemQuantity;
    private String Position;

    public CustomerShelf(String itemType,int itemQuantity,String Position)
    {
        this.itemType=itemType;
        this.itemQuantity=itemQuantity;
        this.Position=Position;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

   /* CustomerShelf(){
        items = new Stack<>();
    }
    
    public void add(Item item){
        items.add(item);
    }
    
    public void getItem(){
        items.pop();
    }
    
    public int getSize(){
        return items.size();
    }
    
    public void display(){
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

    */

    
}
