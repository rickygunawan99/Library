package views;

import Controllers.EditBookController;
import Entity.BookEntity;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class EditBookView extends JFrame {

    private final BookEntity book;
    private final JLabel labelheader = new JLabel("INI PERPUSTAKAAN");
    private final JLabel labeltitle = new JLabel("Judul");
    private final JLabel labelkode = new JLabel("Kode");
    private final JLabel labelposisi = new JLabel("Tempat");
    private final JLabel labelstatus = new JLabel("Status");
    private final JLabel nama = new JLabel();
    private final JLabel kode = new JLabel();
    private final JTextField posisi = new JTextField();
    private final JLabel status = new JLabel();
    private final JButton btnback = new JButton("Tutup");
    private final JButton btnedit = new JButton("Save");
    private final JButton btndelete = new JButton("DELETE");

    public EditBookView(BookEntity book){
        this.book = book;
        initWindow();
        initComponent();
        initEvent();
    }

    private void initWindow(){
        setTitle("HOME");
        setSize(260,380);
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

        labelkode.setBounds(15,155,55,25);
        add(labelkode);

        labelposisi.setBounds(15,195,55,25);
        add(labelposisi);

        labelstatus.setBounds(15,235,55,25);
        add(labelstatus);

        nama.setBounds(85,110,140,25);
        add(nama);

        kode.setBounds(85,155,140,25);
        add(kode);

        posisi.setBounds(85,195,70,25);
        add(posisi);

        status.setBounds(85,235,140,25);
        add(status);

        btnback.setFocusPainted(false);
        btnback.setBounds(63,310,115,25);
        add(btnback);

        btnedit.setFocusPainted(false);
        btnedit.setBounds(130,270,70,25);
        add(btnedit);

        btndelete.setFocusPainted(false);
        btndelete.setBounds(30,270,80,25);
        add(btndelete);

        nama.setText(book.getName());
        kode.setText(book.getBookCode());
        posisi.setText(book.getLocation());
        status.setText( book.getJmlTersedia() > 0 ? "Tersedia" : "Tidak tersedia");


    }

    private void initEvent(){

        btnback.addActionListener(e -> {
            dispose();
        });

        btnedit.addActionListener(e -> {
            try{
                BookEntity temp = new BookEntity(kode.getText(),nama.getText(),book.getJmlTersedia(),posisi.getText());
                System.out.println(temp.getBookCode() + temp.getName() + temp.getJmlTersedia() + temp.getLocation());
                int cek = new EditBookController(temp).edit();
                if(cek > 0){
                    JOptionPane.showMessageDialog(null,"UPDATE BERHASIL");
                }else{
                    JOptionPane.showMessageDialog(null,"UPDATE GAGAL");
                }
            }catch (Exception ex){
                System.out.println(ex);
            }
        });

        btndelete.addActionListener(e -> {
            try{
                String del = JOptionPane.showInputDialog("Jumlah untuk didelete : ");
                int cek = new EditBookController(book).delete(del);
            }catch (Exception ex){
                System.out.println(ex);
            }
        });

    }
}
