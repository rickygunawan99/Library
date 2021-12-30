package Entity;

import java.awt.print.Book;

public class RentBookEntity {
    private int id;
    private BookEntity book;
    private CashierEntity cashier;
    private VisitorEntity visitor;
    private String dayStart;
    private String dayEnd;
    private int totalPrice;
    private int denda;
    private int status;

    public RentBookEntity(BookEntity book, CashierEntity cashier,
                          VisitorEntity visitor, String dayStart, String dayEnd, int price) {
        this.book = book;
        this.cashier = cashier;
        this.visitor = visitor;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.totalPrice = price;
    }

    public RentBookEntity(BookEntity book, CashierEntity cashier,
                          String dayStart, String dayEnd, int totalPrice, int denda, int status) {
        this.book = book;
        this.cashier = cashier;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.totalPrice = totalPrice;
        this.denda = denda;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public BookEntity getBook() {
        return book;
    }

    public CashierEntity getCashier() {
        return cashier;
    }

    public VisitorEntity getVisitor() {
        return visitor;
    }

    public String getDayStart() {
        return dayStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getStatus() {
        return status;
    }

    public int getDenda() {
        return denda;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setDenda(int denda) {
        this.denda = denda;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
