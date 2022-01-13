package views;

import Controllers.HomeCashierController;
import Controllers.LoginCashierController;
import Controllers.Viewable;

import javax.swing.*;
import java.awt.*;

public class LoginCashierView extends JFrame {
    private final LoginCashierController cashier = new LoginCashierController();

    private final JLabel labelid = new JLabel("Username");
    private final JLabel labelpass = new JLabel("Password");
    private final JTextField fieldid = new JTextField();
    private final JTextField fieldpass = new JPasswordField();
    private final JButton btnlogin = new JButton("Login");
    private final JButton btncancel = new JButton("Cancel");

    public LoginCashierView(){
        initWindow();
        initComponenet();
        initEvent();
    }

    private void initWindow(){
        setTitle("HOME");
        setSize(260,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    private void initComponenet(){
        labelid.setBounds(20,125,60,25);
        add(labelid);
        labelpass.setBounds(20,165,60,25);
        add(labelpass);

        fieldid.setBounds(110,125,115,26);
        add(fieldid);
        fieldpass.setBounds(110,165,115,26);
        add(fieldpass);

        btnlogin.setBounds(120,210,80,25);
        add(btnlogin);

        btncancel.setBounds(25,210,80,25);
        add(btncancel);
    }

    private void initEvent(){
        btnlogin.addActionListener(e -> {
            String id = fieldid.getText();
            String pass = fieldpass.getText();
            if(id.length()!=0 && pass.length()!=0){
                int idx = cashier.login(id, pass );
                if (idx > 0 ){
                    JOptionPane.showMessageDialog(null,"Login berhasil");
                    Viewable homeCashierLogin = new HomeCashierController(idx);
                    homeCashierLogin.view();
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"ID ATAU PASSWORD SALAH");
                    clear();
                }
            }
        });
    }


    private void clear(){
        fieldid.setText(null);
        fieldpass.setText(null);
    }

}

