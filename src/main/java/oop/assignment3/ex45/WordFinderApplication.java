package oop.assignment3.ex45;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Edelis Molina
 */

import java.util.Scanner;

public class WordFinderApplication {
    private final static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // Open file exercise41.txt from the resources folder
        String inputPath = "InputFiles/exercise45_input.txt";

        FileProcessing fp = new FileProcessing();
        // Read text in input file as String
        String originalString = fp.readFileAsString(inputPath);

        // Replace the word "utilize" with "use" in the String from the input file
        String modifiedString = fp.replaceText("utilize", "use", originalString);

        // Ask user for the name of the output file and scan input
        System.out.print("What is the name of the output file? ");
        String buffer = input.nextLine();

        // Path to the directory to create the file
        String fileName = buffer + ".txt";
        String path = "OutputFiles";

        // Create file in the specified directory and write the modified string
        fp.writeModStringToFile(path, fileName, modifiedString);

        System.out.println(originalString);
        System.out.println();
        System.out.println(modifiedString);
    }
}
