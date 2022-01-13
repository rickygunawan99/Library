package Entity;

public class BookEntity {
    private int id;
    private String bookCode;
    private String name;
    private int jmlTersedia;
    private String location;

    public BookEntity(String bookCode, String name, int jmlTersedia, String location) {
        this.bookCode = bookCode;
        this.name = name;
        this.jmlTersedia = jmlTersedia;
        this.location = location;
    }

    public BookEntity(String bookCode, String name, String location) {
        this.bookCode = bookCode;
        this.name = name;
        this.location = location;
    }

    public BookEntity(String bookCode, String name) {
        this.bookCode = bookCode;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getBookCode() {
        return bookCode;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getJmlTersedia() {
        return jmlTersedia;
    }

    public void setJmlTersedia(int jmlTersedia) {
        this.jmlTersedia = jmlTersedia;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
