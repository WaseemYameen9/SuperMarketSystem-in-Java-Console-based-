
import java.util.Date;

public class Item {
    
    private String type;
    private String code;
    private double price;
    private Date manufacturingDate;
    private Date expiryDate;

    private int Quantity;

    private int Threshold;

    public Item(String type, String code, double price, Date manufacturingDate, Date expiryDate, int Qty, int threshold) {
        this.type = type;
        this.code = code;
        this.price = price;
        this.manufacturingDate = manufacturingDate;
        this.expiryDate = expiryDate;
        this.Quantity = Qty;
        this.Threshold = threshold;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Item{" + "type=" + type + ", code=" + code + ", price=" + price + ", manufacturingDate=" + manufacturingDate + ", expiryDate=" + expiryDate + '}';
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getThreshold() {
        return Threshold;
    }

    public void setThreshold(int threshold) {
        Threshold = threshold;
    }
}
