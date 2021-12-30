package views;

import Controllers.CashierController;
import Controllers.HomeController;
import Controllers.VisitorController;
import Entity.BookEntity;
import Entity.VisitorEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomeView extends JFrame {

    private final JLabel labelheader = new JLabel("INI PERPUSTAKAAN");
    private final JLabel labelcek = new JLabel("Lihat history pinjaman");
    private final JLabel labelid = new JLabel("ID");
    private final JTextField fieldinputktp = new JTextField();
    private final JButton btncariid = new JButton("Cari");
    private final JLabel labelnotreg = new JLabel("Daftar member ?");
    private final JButton btnreg = new JButton("Klik disini");
    private final JLabel labelcaribuku = new JLabel("Cari Buku");
    private final JLabel labelbuku = new JLabel("Judul");
    private final JTextField fieldcaribuku = new JTextField();
    private final JButton btncaribuku = new JButton("OK");
    private final JButton btnadmin = new JButton("JANGAN DI KLIK!!");


    public HomeView(){
        initWindow();
        initComponent();
        initEvent();
    }

    private void initWindow(){
        setTitle("HOME");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    private void initComponent(){
        labelheader.setBounds(230,30,225,55);
        add(labelheader);
        labelcek.setBounds(60,110,200,30);
        add(labelcek);
        labelid.setBounds(73,150,100,35);
        labelid.setFont(new Font("Arial",Font.PLAIN,22));
        add(labelid);
        fieldinputktp.setBounds(103,150,350,27);
        add(fieldinputktp);
        btncariid.setBounds(460,150,80,27);
        btncariid.setFocusPainted(false);
        btncariid.setFont(new Font("Arial",Font.PLAIN,15));
        add(btncariid);

        labelnotreg.setBounds(200,330,95,20);
        labelnotreg.setFont(new Font("Arial",Font.PLAIN,12));
        add(labelnotreg);

        btnreg.setFocusPainted(false);
        btnreg.setBorder(null);
        btnreg.setBackground(Color.white);
        btnreg.setForeground(Color.BLUE);
        btnreg.setBounds(300,329,90,20);
        add(btnreg);

        labelcaribuku.setBounds(60,220,80,20);
        add(labelcaribuku);
        labelbuku.setBounds(57,250,80,30);
        labelbuku.setFont(new Font("Arial",Font.PLAIN,18));
        add(labelbuku);
        fieldcaribuku.setBounds(105,250,350,27);
        add(fieldcaribuku);
        btncaribuku.setBounds(460,250,80,27);
        btncaribuku.setFocusPainted(false);
        btncaribuku.setFont(new Font("Arial",Font.PLAIN,15));
        add(btncaribuku);

        btnadmin.setFocusPainted(false);
        btnadmin.setBorder(null);
        btnadmin.setBackground(Color.white);
        btnadmin.setForeground(Color.WHITE);
        btnadmin.setBounds(300,10,150,20);
        add(btnadmin);
    }

    private void initEvent(){
        btncariid.addActionListener(e -> {
            if(fieldinputktp.getText().length()!=0){
                VisitorEntity vs = new VisitorController().getVisitorEntity(fieldinputktp.getText());
                if(vs!=null){
                    new VisitorController().viewMember(vs);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"ID tidak ditemukan");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Field yang dicari tidak boleh kosong");
            }
            clearField();
        });

        btncaribuku.addActionListener(e -> {
            if(fieldcaribuku.getText().length()!=0){
                BookEntity book = new VisitorController().getBook(fieldcaribuku.getText());
                if(book != null){
                    new VisitorController().foundBookView(book);
                }else{
                    JOptionPane.showMessageDialog(null,"Buku tidak ditemukan");
                }
            }else {
                JOptionPane.showMessageDialog(null,"Field yang dciari tidak boleh kosong");
            }
            clearField();
        });

        btnadmin.addActionListener(e -> {
            new CashierController().viewLoginAdmin();
        });

        btnreg.addActionListener(e -> {
            new VisitorController().regView();
        });

        btnadmin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnadmin.setForeground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                btnadmin.setForeground(Color.WHITE);
            }
        });
    }



    private void clearField(){
        fieldinputktp.setText(null);
        fieldcaribuku.setText(null);
    }
}
