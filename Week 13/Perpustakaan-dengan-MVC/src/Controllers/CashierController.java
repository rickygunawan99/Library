package Controllers;

import Entity.BookEntity;
import Entity.CashierEntity;
import Entity.RentBookEntity;
import Model.AllObjectModels;
import views.LoginAdminView;

public class CashierController {

    public int addBook(BookEntity book){
        return new AllObjectModels().cashier.addBook(book, new AllObjectModels().cashier.existBook(book));
    }

    public int login(String username, String password){
        return new AllObjectModels().cashier.login(username,password);
    }

    public CashierEntity getCurrentCashier(int id){
        return new AllObjectModels().cashier.getCurrentCashier(id);
    }

    public int insertListTable(RentBookEntity rentBook){
        return new AllObjectModels().cashier.insertListTable(rentBook);
    }

     public void viewLoginAdmin(){
        new LoginAdminView().setVisible(true);
    }
}
