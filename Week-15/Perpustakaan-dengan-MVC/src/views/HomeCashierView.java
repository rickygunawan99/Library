package views;

import Controllers.*;
import Entity.BookEntity;
import Entity.CashierEntity;
import Entity.RentBookEntity;
import Entity.MemberEntity;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Scanner;


public class HomeCashierView extends JFrame{
    private final HomeCashierController homeCashier;

    private final JButton btnprofil = new JButton("Profil");

    private final JButton btnaddbook = new JButton("(+)Buku");
    private final JLabel labelcaribuku = new JLabel("Cari buku");
    private final JTextField fieldcari = new JTextField();
    private final JButton btnsearchbook = new JButton("OK");

    private final JButton btndaftar = new JButton("Daftarkan Pinjaman");
    private final JButton btnkonf = new JButton("Konfirmasi Pengembalian");
    private final JButton btnexit = new JButton("Logout");


    public HomeCashierView(final int id){
        this.homeCashier = new HomeCashierController(id);
        initWindow();
        initComponent();
        initEvent();
    }

    private void initWindow(){
        setTitle("HOME");
        setSize(340,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    private void initComponent(){
        btnprofil.setBounds(160,26,85,20);
        btnprofil.setFocusPainted(false);
        add(btnprofil);
        btnaddbook.setBounds(25,90,80,25);
        add(btnaddbook);
        labelcaribuku.setBounds(160,60,60,20);
        add(labelcaribuku);
        fieldcari.setBounds(160,90,80,25);
        add(fieldcari);
        btnsearchbook.setBounds(250,90,60,25);
        add(btnsearchbook);

        btndaftar.setBounds(65,150,190,60);
        btndaftar.setFocusPainted(false);
        add(btndaftar);

        btnkonf.setBounds(65,220,190,60);
        btnkonf.setFocusPainted(false);
        add(btnkonf);

        btnexit.setBounds(120,300,80,25);
        btnexit.setFocusPainted(false);
        add(btnexit);
    }

    private void initEvent(){
        btnprofil.addActionListener(e -> {

        });

        btnaddbook.addActionListener(e -> {
            Viewable addBook = new AddBookController();
            addBook.view();
        });

        btnsearchbook.addActionListener(e -> {
            try {
                BookEntity book = new FoundBookController().getBook(fieldcari.getText());
                Viewable bookView = new EditBookController(book);
                bookView.view();
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null,"BUKU TIDAK ADA");
            }
        });

        btndaftar.addActionListener(e -> {
            CashierEntity cashier = homeCashier.getCurrentCashier();
            Viewable insertPinjaman = new InsertPinjamanController(cashier);
            insertPinjaman.view();
        });

        btnkonf.addActionListener(e -> {

        });

        btnexit.addActionListener(e -> {
            Viewable home = new HomeController();
            home.view();
            dispose();
        });
    }

}
