package Entity;

public class CashierEntity {
    private int id;
    private MemberEntity cashier;
    private String username;
    private String password;

    public CashierEntity(String name){
        cashier = new MemberEntity(name);
    }

    public CashierEntity(int id, MemberEntity cashier, String username, String password) {
        this.id = id;
        this.cashier = cashier;
        this.username = username;
        this.password = password;
    }

    public CashierEntity(MemberEntity cashier, String username, String password) {
        this.cashier = cashier;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public MemberEntity getCashier() {
        return cashier;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
