package views;

import Controllers.CashierController;
import Entity.BookEntity;
import Entity.CashierEntity;
import Entity.RentBookEntity;
import Entity.VisitorEntity;

import java.time.LocalDate;
import java.util.Scanner;


public class CashierView {
    private CashierEntity cashier;

    public CashierView(final int id){

    }

    public void addBook(BookEntity book){
        System.out.println(new CashierController().addBook(book));
    }


    public void insertRent(){
        Scanner scanner = new Scanner(System.in);
        cashier = new CashierController().getCurrentCashier(1);
        System.out.print("Book code : ");
        String code = scanner.next();
        System.out.print("Book title : ");
        String bookTitle = scanner.next();
        System.out.print("Nama peminjam : ");
        String visName = scanner.next();
        System.out.print("No ktp visitor :");
        String noKtp = scanner.next();
        scanner.nextLine();
        System.out.print("Alamat : ");
        String alamat = scanner.nextLine();
        System.out.print("Jumlah hari : ");
        int day = scanner.nextInt();
        System.out.print("Harga / hari : ");
        int harga = scanner.nextInt();

        LocalDate now = LocalDate.now();

        RentBookEntity rent = new RentBookEntity(new BookEntity(code,bookTitle),new CashierEntity(cashier.getCashier().getName()),
                new VisitorEntity(visName, noKtp,alamat),now.toString(),now.plusDays(day).toString(),harga*day
                );
        System.out.println(new CashierController().insertListTable(rent));
    }
}
