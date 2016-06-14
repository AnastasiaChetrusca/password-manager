package com.company;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by Anastasia on 30-Apr-16.
 */
public class AddEntry extends JFrame {
    private JPanel mainPanel;
    private JTextField textService;
    private JTextField textUsername;
    private JTextField textPassword;
    private JButton buttonSave;
    private JButton buttonRandom;

    public AddEntry() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        buttonRandom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RandomForm();

                dispose();
            }
        });

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((textService.getText().isEmpty()) || (textUsername.getText().isEmpty()) || (textPassword.getText().isEmpty())){
                    JOptionPane.showMessageDialog(null, "All the fields must be filled, please try again!");
                }else{

                    File fileName = new File("."+"Chetrusca.txt");
                    PrintWriter outputData = null;
                    try {

                        outputData = new PrintWriter(fileName);
                        outputData.println("\t\tEntry \n");
                        outputData.println("Service:  "+textService.getText());
                        outputData.println("Username:  "+textUsername.getText());
                        outputData.println("Password:   "+textPassword.getText());
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    finally {
                        if(outputData != null){
                            outputData.close();
                        }
                    }
                    JOptionPane.showMessageDialog(mainPanel, "Entry successfully added!");
                    dispose();
                }

            }
        });

        setVisible(true);
    }
    public void setPassword (String sentPassword){
        textPassword.setText(sentPassword);
    }


}
