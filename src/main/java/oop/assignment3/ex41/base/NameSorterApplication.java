package oop.assignment3.ex41.base;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Edelis Molina
 */

import java.util.ArrayList;

public class NameSorterApplication {

    public static void main(String[] args) {

        // Open file exercise41.txt from the resources folder
        String inputPath = "src/main/resources/exercise41_input.txt";
        ReadFileContent reader = new ReadFileContent();

        // Read each line into a List until the end of file
        ArrayList<String> namesList = reader.readContent(inputPath);

        // Create output file to write the sorted names
        String outputPath = "src/main/resources/exercise41_output.txt";
        WriteToFile writer  = new WriteToFile();

        // Sort the List of names
        String sortedNames = writer.sortContent(namesList);

        // Get total number of names
        int numberOfNames = writer.numberOfNames(namesList);

        // Write the total number of names and the names sorted to the exercise41_output.txt file
        String content = "Total of " + numberOfNames + " names\n-----------------\n" + sortedNames;
        writer.writeToFile(content, outputPath);

    }

}
