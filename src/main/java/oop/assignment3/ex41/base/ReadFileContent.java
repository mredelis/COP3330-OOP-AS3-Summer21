package oop.assignment3.ex41.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ReadFileContent {
    private static Scanner scan;
    private static ArrayList<String> namesList = new ArrayList<>();

    public ArrayList<String> readContent(String inputPath){
        try {
            File readFileObj = new File(inputPath);
            scan = new Scanner(readFileObj);
            while (scan.hasNextLine()){
                namesList.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        return namesList;
    }

}
