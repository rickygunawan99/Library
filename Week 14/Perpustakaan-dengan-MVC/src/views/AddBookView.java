package views;

import Controllers.AddBookController;
import Controllers.EditBookController;
import Controllers.FoundBookController;
import Entity.BookEntity;
import Model.BookModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class AddBookView extends JFrame {

    private final JLabel labelheader = new JLabel("TAMBAH BUKU");
    private final JLabel labelnama = new JLabel("Nama");
    private final JLabel labelkode = new JLabel("Kode buku");
    private final JLabel labeltempat = new JLabel("Tempat");
    private final JTextField nama = new JTextField();
    private final JTextField kode = new JTextField();
    private final JTextField tempat = new JTextField();
    private final JButton btnback = new JButton("Batal");
    private final JButton btnok = new JButton("Daftar");

    public AddBookView(){
        initWindow();
        initComponent();
        initEvent();
    }

    private void initWindow(){
        setTitle("HOME");
        setSize(260,350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    private void initComponent(){
        labelheader.setFont(new Font("Arial",Font.PLAIN,16));
        labelheader.setBounds(40,25,170,45);
        add(labelheader);

        labelnama.setBounds(15,110,70,25);
        add(labelnama);

        labelkode.setBounds(15,155,70,25);
        add(labelkode);

        labeltempat.setBounds(15,195,70,25);
        add(labeltempat);

        nama.setBounds(110,110,120,25);
        add(nama);

        kode.setBounds(110,155,120,25);
        add(kode);

        tempat.setBounds(110,195,120,25);
        add(tempat);

        btnback.setFocusPainted(false);
        btnback.setBounds(36,250,70,25);
        add(btnback);

        btnok.setFocusPainted(false);
        btnok.setBounds(122,250,70,25);
        add(btnok);
    }

    private void initEvent(){
        btnok.addActionListener(e -> {
            if(nama.getText().length()!=0 && kode.getText().length()!=0 && tempat.getText().length()!=0){
                BookEntity book = new BookEntity(kode.getText(),nama.getText(),tempat.getText());
                int cek = new AddBookController(book).addBook();
                if ( cek > 0){
                    JOptionPane.showMessageDialog(null,"Berhasil insert buku");
                    dispose();
                }else if (cek == -2){
                    JOptionPane.showMessageDialog(null,"DUPLIKASI KODE");
                }else
                    JOptionPane.showMessageDialog(null,"GAGAL INSERT BUKU");
            }else{
                JOptionPane.showMessageDialog(null,"FIELD TIDAK BOLEH KOSONG");
            }

        });

        btnback.addActionListener(e -> {
            dispose();
        });
    }
}
