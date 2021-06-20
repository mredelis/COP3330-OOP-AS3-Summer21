package oop.assignment3.ex45;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Edelis Molina
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileProcessing {

    public String readFileAsString(String inputPath){
        String originalStr = "";
        try {
            originalStr = new String(Files.readAllBytes(Paths.get(inputPath)));
        } catch (IOException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        return originalStr;
    }

    public String replaceText(String wordToReplace, String replacementWord, String originalString){
        return originalString.replaceAll(wordToReplace, replacementWord);

    }


    public void writeModStringToFile(String path, String fileName, String content){
        String concatPath = path + "/" + fileName;

        try {
            File file = new File(concatPath);
            if(!file.exists())
                file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            fw.write(content);

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
