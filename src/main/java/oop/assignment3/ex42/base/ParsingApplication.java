package oop.assignment3.ex42.base;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Edelis Molina
 */

import java.util.List;

public class ParsingApplication {
    public static void main(String[] args) {

        // Open file exercise42.txt from the resources folder
        String inputPath = "InputFiles/exercise42_input.txt";
        ReadFile fp = new ReadFile();

        // Read each Line into a String array until the end of file
        List<String[]> csvLines = fp.readContent(inputPath);

        String header = String.format("%-10s%-10s%-10s\n%s\n", "Last", "First", "Salary", "--------------------------");
        String content = fp.createFormattedString(csvLines);

        // Display the results formatted as a table
        System.out.print(header + content);
    }
}
