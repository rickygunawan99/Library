package perpusatakaan;

import Controllers.FoundBookController;
import Controllers.HomeCashierController;
import Entity.BookEntity;
import Entity.CashierEntity;
import views.EditBookView;
import views.HomeView;
import views.InsertPinjamanView;
import views.LoginCashierView;

public class PerpustakaanApp {

    public static void main(String[] args) {
        BookEntity book = new FoundBookController().getBook("entahlah");
        CashierEntity cashier = new HomeCashierController(1).getCurrentCashier();
        new HomeView().setVisible(true);
    }
}
