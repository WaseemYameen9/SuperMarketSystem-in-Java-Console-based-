import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class Warehouse {
    
    private static List<Item> Items = new ArrayList<>();

    public static List<Item> getItems() {
        return Items;
    }

    public static void setItems(List<Item> items) {
        Items = items;
    }

    public void AddItem(Item it)
    {
        Items.add(it);
    }

    public static void storeWarehouseInFile(String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            for (Item item : Items) {
                writer.write(item.getType() + "," + item.getCode() + "," + item.getPrice() + "," + item.getManufacturingDate() + "," + item.getExpiryDate() + "," + item.getQuantity() + "," + item.getThreshold() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadWarehouseFromFile(String filePath) {
        Date expiryDate = null;
        Date manufacturingDate = null;
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] itemData = line.split(",");
                String Type = itemData[0];
                String Code = itemData[1];
                double price = Double.parseDouble(itemData[2]);
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
                try {
                    manufacturingDate = dateFormat.parse(itemData[3]);
                } catch (ParseException e) {
                    // handle the exception here
                    e.printStackTrace();
                }
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
                try {
                    expiryDate = dateFormat1.parse(itemData[4]);
                } catch (ParseException e) {
                    // handle the exception here
                    e.printStackTrace();
                }

                int Qty = Integer.parseInt(itemData[5]);
                int Threshold = Integer.parseInt(itemData[6]);
                Item it = new Item(Type,Code,price,manufacturingDate,expiryDate,Qty,Threshold);
                Items.add(it);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
