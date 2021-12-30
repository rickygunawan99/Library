package views;

import Controllers.VisitorController;
import Entity.VisitorEntity;

import javax.swing.*;
import java.awt.*;

public class DaftarMemberView extends JFrame {

    private final JLabel labelheader = new JLabel("INI PERPUSTAKAAN");
    private final JLabel labelnama = new JLabel("Nama");
    private final JLabel labelnoktp = new JLabel("No. Ktp");
    private final JLabel labelalamat = new JLabel("Alamat");
    private final JTextField nama = new JTextField();
    private final JTextField alamat = new JTextField();
    private final JTextField no_ktp = new JTextField();
    private final JButton btnback = new JButton("Batal");
    private final JButton btnok = new JButton("Daftar");

    public  DaftarMemberView(){
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

        labelnama.setBounds(15,110,55,25);
        add(labelnama);

        labelnoktp.setBounds(15,155,55,25);
        add(labelnoktp);

        labelalamat.setBounds(15,195,55,25);
        add(labelalamat);

        nama.setBounds(85,110,140,25);
        add(nama);

        no_ktp.setBounds(85,155,140,25);
        add(no_ktp);

        alamat.setBounds(85,195,140,25);
        add(alamat);

        btnback.setFocusPainted(false);
        btnback.setBounds(36,250,70,25);
        add(btnback);

        btnok.setFocusPainted(false);
        btnok.setBounds(122,250,70,25);
        add(btnok);
    }

    private void initEvent(){
        btnback.addActionListener(e -> {
            dispose();
        });

        btnok.addActionListener(e -> {
            if(nama.getText().length()!=0 && no_ktp.getText().length()!=0 && alamat.getText().length()!=0){
                VisitorEntity vs = new VisitorEntity(nama.getText(),no_ktp.getText(),alamat.getText());
                int cek = new VisitorController().reg(vs);
                if(cek != -1){
                    JOptionPane.showMessageDialog(null,"BERHASIL REGISTRASI");
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"GAGAL REGISTRASI");
                }
            }else{
                JOptionPane.showMessageDialog(null,"INPUT TIDAK BOLEH KOSONG");
            }
            clear();
        });
    }

    private void clear(){
        nama.setText(null);
        alamat.setText(null);
        no_ktp.setText(null);
    }
}
