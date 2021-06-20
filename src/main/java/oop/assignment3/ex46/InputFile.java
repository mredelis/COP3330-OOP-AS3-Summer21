package oop.assignment3.ex46;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Edelis Molina
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InputFile {

    public String[] readFileAsStringArrayOfWords(String inputPath){
        String text = "";
        try {
            text = new String(Files.readAllBytes(Paths.get(inputPath)));
        } catch (IOException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        // Split the String into a String Array of words
        return text.split("\\W+"); // The \\W means not an alphanumeric character.
    }
}
