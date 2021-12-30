package Controllers;

import Entity.BookEntity;
import Entity.RentBookEntity;
import Entity.VisitorEntity;
import Model.AllObjectModels;
import views.DaftarMemberView;
import views.FoundBookView;
import views.HomeView;
import views.MemberView;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class VisitorController {

    public int reg(VisitorEntity vs){
        return new AllObjectModels().visitor.reg(vs);
    }

    public BookEntity getBook(String title){
        return new AllObjectModels().visitor.getBook(title);
    }

    public int getVisitor(String no_ktp){
        return new AllObjectModels().visitor.getVisitor(no_ktp);
    }

    public VisitorEntity getVisitorEntity(String no_ktp){
        return new AllObjectModels().visitor.getVisitorEntity(no_ktp);
    }

    public ArrayList<RentBookEntity> getListTable(String no_ktp){
        return new AllObjectModels().visitor.getListTable(no_ktp);
    }

    public DefaultTableModel getTable(String no_ktp){
        DefaultTableModel table = new DefaultTableModel();
        Object[] column = {"Kode Buku", "Judul", "Tgl Pinjam", "Tgl Kembali", "Status", "Denda"};
        table.setColumnIdentifiers(column);
        ArrayList<RentBookEntity> rent = getListTable(no_ktp);
        for (RentBookEntity rentBook : rent) {
            Object[] row = new Object[6];
            row[0] = rentBook.getBook().getBookCode();
            row[1] = rentBook.getBook().getName();
            row[2] = rentBook.getDayStart();
            row[3] = rentBook.getDayEnd();
            row[4] = rentBook.getStatus();
            row[5] = rentBook.getDenda();
            table.addRow(row);
        }
        return table;
    }

    public void viewHome(){
        new HomeView().setVisible(true);
    }

    public void viewMember(VisitorEntity vs){
        new MemberView(vs).setVisible(true);
    }

    public void foundBookView(BookEntity book){
        new FoundBookView(book).setVisible(true);
    }

    public void regView(){
        new DaftarMemberView().setVisible(true);
    }
}
