package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Anastasia on 30-Apr-16.
 */
public class DeleteEntry extends JFrame {
    private JComboBox pleaseSelectWitchServiceComboBox;
    private JPanel mainPanel;


    DeleteEntry(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(mainPanel);
        setVisible(true);
        mainPanel.setPreferredSize(new Dimension(400, 200));
        pack();
        setLocationRelativeTo(null);
        new FileLister(pleaseSelectWitchServiceComboBox);
        pleaseSelectWitchServiceComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pleaseSelectWitchServiceComboBox = (JComboBox)e.getSource();
                File f = new File("C:\\password\\"+pleaseSelectWitchServiceComboBox.getSelectedItem().toString()+".txt");
                int reply = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete the selected entry?",
                        "Confirmation needed", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if(reply == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(mainPanel,"Service successfully deleted!");
                    f.delete();
                    System.out.println("Item deleted!");
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(mainPanel,"Service not deleted!");
                    System.out.println("Item not deleted!");
                    dispose();
                }
            }
        });

    }
}
