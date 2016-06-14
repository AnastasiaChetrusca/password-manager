package com.company;

import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingUtilities.updateComponentTreeUI;

public class Main {

    public static void main(String[] args) {
        //new MainPage();

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new Login();


    }
}
