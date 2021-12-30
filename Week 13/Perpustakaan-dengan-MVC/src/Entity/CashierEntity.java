package Entity;

public class CashierEntity {
    private int id;
    private VisitorEntity cashier;
    private String username;
    private String password;

    public CashierEntity(String name){
        cashier = new VisitorEntity(name);
    }

    public CashierEntity(int id, VisitorEntity cashier, String username, String password) {
        this.id = id;
        this.cashier = cashier;
        this.username = username;
        this.password = password;
    }

    public CashierEntity(VisitorEntity cashier, String username, String password) {
        this.cashier = cashier;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public VisitorEntity getCashier() {
        return cashier;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
