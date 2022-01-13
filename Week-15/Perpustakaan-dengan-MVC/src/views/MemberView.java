 package views;

import Controllers.HomeController;
import Controllers.MemberController;
import Controllers.Viewable;
import Entity.MemberEntity;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;

public class MemberView extends JFrame {
    private MemberEntity member;
    private final JTable table = new JTable(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private final JScrollPane sp = new JScrollPane(table);
    private final JLabel labelNama = new JLabel();
    private final JLabel labelNoKtp = new JLabel();
    private final JLabel labelAdress = new JLabel();
    private final JButton btnback = new JButton("Kembali");

    public MemberView(MemberEntity member){
        this.member = member;
        initWindow();
        initComponent();
        initEvent();
    }

    private void initWindow(){
        setTitle("HISTORY PINJAMAN");
        setSize(600,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    private void initComponent(){
        labelNama.setText("Nama       :   " + member.getName());
        labelNoKtp.setText("No.ktp      :   " + member.getIdKtp());
        labelAdress.setText("Alamat     :   " + member.getAdress());
        labelNama.setBounds(15,35,350,25);
        add(labelNama);
        labelNoKtp.setBounds(15,65,350,25);
        add(labelNoKtp);
        labelAdress.setBounds(15,95,350,25);
        add(labelAdress);

        table.setModel(new MemberController().getHistory(this.member.getIdKtp()));
        sp.setBounds(15,145,550,195);
        add(sp);

        btnback.setFocusPainted(false);
        btnback.setBounds(245,355,100,30);
        btnback.setFont(new Font("Arial",Font.PLAIN,12));
        add(btnback);
    }

    private void initEvent(){
        btnback.addActionListener(e -> {
            dispose();
            Viewable homeView = new HomeController();
            homeView.view();
        });
    }
}
