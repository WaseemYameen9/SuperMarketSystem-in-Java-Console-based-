public class Cashier {
    private String Name;
    private int number;


    public Cashier(String name, int number)
    {
        this.Name=name;
        this.number=number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
