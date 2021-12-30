package Entity;

public class VisitorEntity {

    private String name;
    private String idKtp;
    private String adress;

    public VisitorEntity(String name) {
        this.name = name;
    }

    public VisitorEntity(String name, String idKtp, String adress) {
        this.name = name;
        this.idKtp = idKtp;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public String getIdKtp() {
        return idKtp;
    }

    public String getAdress() {
        return adress;
    }
}
