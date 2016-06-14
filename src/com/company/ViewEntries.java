package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
//import java.nio.file.DirectoryStream;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Anastasia on 30-Apr-16.
 */
public class ViewEntries extends JFrame {
    private JComboBox comboServices;
    private JTextField textService;
    private JTextField textUsername;
    private JPasswordField textPassword;
    private JPanel mainPanel;
    private JButton copyUsernameButton;
    private JButton copyPasswordButton;

    public ViewEntries(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        new FileLister(comboServices);
        textService.setEditable(false);
        textUsername.setEditable(false);
        textPassword.setEditable(false);

        setVisible(true);

        comboServices.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                comboServices = (JComboBox) e.getSource();
                if (comboServices.getSelectedItem().toString().isEmpty()) {
                    System.out.println("Something went wrong!");
                } else {
                    File f = new File(comboServices.getSelectedItem().toString() + ".txt");
                    Scanner fileScan = null;
                    try {
                        fileScan = new Scanner(f);
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    textService.setText(fileScan.nextLine());
                    textUsername.setText(fileScan.nextLine());
                    textPassword.setText(fileScan.nextLine());
                }
            }
        }); 
        copyUsernameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection = new StringSelection(textUsername.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
        });
        copyPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection = new StringSelection(textPassword.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
        });
    }


}
