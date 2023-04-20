import java.util.Scanner;

public class Manager {
    
    private int id;
    private String name;
    private String email;
    
    public Manager(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
        return "ID: " + id + ", Name: "+ name + ", Email: " + email;
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
    
}
