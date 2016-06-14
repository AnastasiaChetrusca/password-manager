package com.company;

import java.io.File;
import java.io.Serializable;

/**
 * Created by Anastasia on 30-Apr-16.
 */
public class FileSerialize implements Serializable {
    private File textFile;

    public File getTextFile(){
        return textFile;
    }
    public void setTextFile(File textFile){
        this.textFile = textFile;
    }
}
