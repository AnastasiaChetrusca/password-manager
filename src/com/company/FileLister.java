package com.company;

import javax.swing.*;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * Created by Anastasia on 30-Apr-16.
 */
public class FileLister {
    FileLister(JComboBox comboServices){
        File f = new File("passwords");

        FilenameFilter textFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        };

        File[] files = f.listFiles(textFilter);
        for(File file : files){
            if (file.isDirectory()){
                System.out.println("directory: ");
            }else{
                System.out.println("file: ");
                comboServices.addItem(file.getName().replace(".txt", ""));
            }
            try {
                System.out.println(file.getCanonicalPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
