package com.company;

import javax.swing.*;
import java.io.*;
/**
 * Created by Anastasia Chetrusca on 5/11/2016.
 */
public class Viewin extends JFrame {

    public Viewin(){
        setLocation(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    JTextArea ta = new JTextArea(20,40);
    getContentPane().add(new JScrollPane(ta));
    pack();
    try{ta.read(new FileReader("."+"Chetrusca.txt"),null);}catch(IOException ioe){}
}


    public static void main(String[] args){new Viewin().setVisible(true);}
}

