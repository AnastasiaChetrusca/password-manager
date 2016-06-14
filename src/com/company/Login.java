package com.company;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.NoSuchAlgorithmException;

import static javax.swing.SwingUtilities.updateComponentTreeUI;

/**
 * Created by Anastasia on 30-Apr-16.
 */
public class Login extends JFrame {
    private JPanel mainPanel;
    private JButton buttonLogin;
    private JPasswordField passwordField1;
    private JTextField textField1;

    public Login() {
        setContentPane(mainPanel);

        //JFrame.setDefaultLookAndFeelDecorated(true);
        //UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels());


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(400, 200));
        pack();
        setLocationRelativeTo(null);
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(passwordField1.getText().isEmpty() || textField1.getText().isEmpty()){
                    JOptionPane.showMessageDialog(mainPanel,"Text field or password field is empty!");
                }
                else{
                    if( (passwordField1.getText().equals(new String("Anastasia")) &&
                            (textField1.getText().equals(new String("Anastasia"))) ) ){
                        //JOptionPane.showMessageDialog(mainPanel, "Access granted!");
                        dispose();

                        new MainPage();
                    }
                    else
                        JOptionPane.showMessageDialog(mainPanel, "Wrong name or password, please try again!");
                }
            }
        });
        setVisible(true);
    }
}
