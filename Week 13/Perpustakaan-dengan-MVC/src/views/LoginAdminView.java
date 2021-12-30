package views;

import javax.swing.*;
import java.awt.*;

public class LoginAdminView extends JFrame {

    private final JLabel labelid = new JLabel("Username");
    private final JLabel labelpass = new JLabel("Password");
    private final JTextField fieldid = new JTextField();
    private final JPasswordField fieldpass = new JPasswordField();
    private final JButton btnlogin = new JButton("Login");

    public LoginAdminView(){
        initWindow();
        initComponenet();
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

    private void initComponenet(){

    }

    private void initEvent(){

    }
}

