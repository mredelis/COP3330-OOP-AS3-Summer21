package oop.assignment3.ex41.base;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Edelis Molina
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NameSorterApplication {
    public static void main(String[] args) {
        // Open file exercise41_input.txt
        // Read each line into an List until the end of file
        // Sort the List of names
        // Create exercise41_output.txt file for the output
        // Print the sorted List of names to the output file
            // Print total of names
            // Print line of '-' separators
            // Print names in sorted order
        ArrayList<String> myList = new ArrayList<>();

        try {
            File myObj = new File("C:\\Users\\EDELITA\\Desktop\\OOPExercises\\assignment3\\src\\main\\java\\oop\\assignment3\\ex41\\exercise41_input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){

                myList.add(myReader.nextLine());
//                System.out.println(myList);
            }
        } catch (FileNotFoundException e){
            System.out.println("An error has occurred");
            e.printStackTrace();

        }

//        System.out.println(myList);

        for(int i = 0; i < myList.size(); i++)
            System.out.println(myList.get(i));

        Collections.sort(myList);

        System.out.println();

        for(int i = 0; i < myList.size(); i++)
            System.out.println(myList.get(i));

    }
}
