package oop.assignment3.ex42.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    private static Scanner scan;

    public List<String[]> readContent(String inputPath) {

        String[] lines;
        List<String[]> strArrayList = new ArrayList<>();

        try {
            File readFileObj = new File(inputPath);
            scan = new Scanner(readFileObj);
            while (scan.hasNextLine()) {
                lines = scan.nextLine().split(",");
                strArrayList.add(lines);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        return strArrayList;
    }


    public String createFormattedString(List<String[]> cvsArrayList){

        String line = "";
        for (String[] array : cvsArrayList) {  // This loop is used to iterate through the arraylist
            for (String element : array) {     // This loop is used to iterate through the array inside the arraylist
                line += String.format("%-10s", element);
            }
            line += "\n";
        }
        return line;
    }

}