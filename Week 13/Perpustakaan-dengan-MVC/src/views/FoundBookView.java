package views;

import Entity.BookEntity;

import javax.swing.*;
import java.awt.*;

public class FoundBookView extends JFrame {

    private BookEntity book;
    private final JLabel labelheader = new JLabel("INI PERPUSTAKAAN");
    private final JLabel labeltitle = new JLabel("Judul");
    private final JLabel labelposisi = new JLabel("Tempat");
    private final JLabel labelstatus = new JLabel("Status");
    private final JLabel nama = new JLabel();
    private final JLabel posisi = new JLabel();
    private final JLabel status = new JLabel();
    private final JButton btnback = new JButton("Tutup");

    public FoundBookView(BookEntity book){
        this.book = book;
        initWindow();
        initComponent();
        initEvent();
    }

    private void initWindow(){
        setTitle("HOME");
        setSize(260,340);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    private void initComponent(){
        labelheader.setFont(new Font("Arial",Font.PLAIN,16));
        labelheader.setBounds(40,25,170,45);
        add(labelheader);

        labeltitle.setBounds(15,110,55,25);
        add(labeltitle);

        labelposisi.setBounds(15,155,55,25);
        add(labelposisi);

        labelstatus.setBounds(15,195,55,25);
        add(labelstatus);

        nama.setBounds(85,110,140,25);
        add(nama);

        posisi.setBounds(85,155,140,25);
        add(posisi);

        status.setBounds(85,195,140,25);
        add(status);

        btnback.setFocusPainted(false);
        btnback.setBounds(63,240,115,25);
        add(btnback);
    }

    private void initEvent(){
        nama.setText(book.getName());
        posisi.setText(book.getLocation());
        if(book.getJmlTersedia() > 0){
            status.setText("Tersedia");
        }else{
            status.setText("Tidak tersedia");
        }

        btnback.addActionListener(e -> {
            dispose();
        });

    }
}
