package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by Anastasia on 30-Apr-16.
 */
public class MainPage extends JFrame {
    private JPanel mainPanel;
    private JButton addANewEntryButton;
    private JButton viewYourEntriesButton;
    private JButton EXITButton;
    private JButton deleteEntryButton;
    private JButton button1;

    public MainPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        mainPanel.setPreferredSize(new Dimension(400, 200));
        pack();
        setLocationRelativeTo(null);
        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        addANewEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEntry();
            }
        });

        viewYourEntriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewEntries(); }
        });

        deleteEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteEntry();
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Viewin();
            }
        });

        setVisible(true);
    }

}
