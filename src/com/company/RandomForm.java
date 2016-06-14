package com.company;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Anastasia on 30-Apr-16.
 */
public class RandomForm extends JFrame {
    public JButton a8CharactersButton;
    public JButton a16CharactersButton;
    public JTextField textField1;
    public JPanel rootPanel;
    private JButton useThisOneButton;
    String text;

    public RandomForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        pack();
        setLocationRelativeTo(null);
        a8CharactersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] numbers = new int[8];
                char[] letters = new char[8];
                for (int i = 0; i < 8; i++) {
                    numbers[i] = ThreadLocalRandom.current().nextInt(32, 127);
                    letters[i] = (char)numbers[i];
                }
                textField1.setText(new String(letters));
            }
        });
       a16CharactersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] numbers = new int[16];
                char[] letters = new char[16];
                for (int i = 0; i < 16; i++) {
                    numbers[i] = ThreadLocalRandom.current().nextInt(32, 127);
                    letters[i] = (char)numbers[i];
                }
                text = new String(letters);
                textField1.setText(text);
            }
        });
        setVisible(true);
        useThisOneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please generate a password first!");
                }else{
                    AddEntry addEntry = new AddEntry();
                    addEntry.setPassword(textField1.getText());
                }
                dispose();
            }
        });
    }
    public String getPass() {
        return text;
    }
}
