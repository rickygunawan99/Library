package views;

import Controllers.FoundBookController;
import Controllers.InsertPinjamanController;
import Controllers.MemberController;
import Entity.BookEntity;
import Entity.CashierEntity;
import Entity.MemberEntity;
import Entity.RentBookEntity;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class InsertPinjamanView extends JFrame {
    private CashierEntity cashier;
    private int hari;

    private final JLabel labelbooktitle = new JLabel("Judul buku");
    private final JLabel labelidmember = new JLabel("Id member");
    private final JLabel labeltotalhari = new JLabel("Lama pinjam");
    private final JLabel labelharga = new JLabel("Harga/hari");
    private final JLabel labeltotal = new JLabel("Total harga");

    private final JTextField fieldbooktitle = new JTextField();
    private final JTextField fieldidmember = new JTextField();
    private final JTextField fieldhari = new JTextField();
    private final JTextField fieldharga = new JTextField();
    private final JTextField fieldtotal = new JTextField();

    private final JButton btnadd = new JButton("Insert");
    private final JButton btncancel = new JButton("Exit");

    public InsertPinjamanView(CashierEntity cashier){
        this.cashier = cashier;
        initWindow();
        initComponent();
        initEvent();
    }

    private void initWindow(){
        setTitle("INSERT PINJAM BUKU");
        setSize(300,375);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    private void initComponent(){
        fieldtotal.setEditable(false);

        labelbooktitle.setBounds(16,70,85,20);
        add(labelbooktitle);
        labelidmember.setBounds(16,115,85,20);
        add(labelidmember);
        labeltotalhari.setBounds(16,160,85,20);
        add(labeltotalhari);
        labelharga.setBounds(16,205,85,20);
        add(labelharga);
        labeltotal.setBounds(16,255,85,20);
        add(labeltotal);

        fieldbooktitle.setBounds(124,70,120,20);
        add(fieldbooktitle);
        fieldidmember.setBounds(124,115,120,20);
        add(fieldidmember);
        fieldhari.setBounds(124,160,120,20);
        add(fieldhari);
        fieldharga.setBounds(124,205,120,20);
        add(fieldharga);
        fieldtotal.setBounds(124,255,120,20);
        add(fieldtotal);

        btnadd.setFocusPainted(false);
        btnadd.setBounds(130,290,75,20);
        add(btnadd);

        btncancel.setFocusPainted(false);
        btncancel.setBounds(44,290,75,20);
        add(btncancel);
    }

    private void initEvent(){
        fieldharga.addActionListener(e -> {
            hari = Integer.parseInt(fieldhari.getText());
            int harga = Integer.parseInt(fieldharga.getText());
            int total = hari*harga;
            fieldtotal.setText(String.valueOf(total));
        });

        btnadd.addActionListener(e -> {
            LocalDate currentTime = LocalDate.now();

            BookEntity book = new FoundBookController().getBook(fieldbooktitle.getText());
            MemberEntity member = new MemberController().getMemberEntity(fieldidmember.getText());

            LocalDate expTime = currentTime.plusDays(Integer.parseInt(fieldhari.getText()));

            RentBookEntity rent = new RentBookEntity(book,cashier,member,currentTime.toString(),expTime.toString(),Integer.parseInt(fieldtotal.getText()));

            try {
                int val = new InsertPinjamanController().insert(rent);
                if(val > 0){
                    int id = new InsertPinjamanController().getIdPinjaman();
                    JOptionPane.showMessageDialog(null,"Berhasil Daftar Pinjaman dengan id " + id);
                    dispose();
                }else
                    JOptionPane.showMessageDialog(null,"Gagal Daftar Pinjaman");
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null,"GAGAL DAFTAR PINJAMAN");
            }
        });
    }
}
