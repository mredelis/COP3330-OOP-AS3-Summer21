package oop.assignment3.ex46;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Edelis Molina
 */

import java.util.*;

public class WordFreqFinderApplication {

    public static void main(String[] args) {

        // Read in content of the input file as a String and split the text into a String Array of words
        String inputPath = "src/main/resources/exercise46_input.txt";
        InputFile ifClass = new InputFile();
        String[] wordsArray = ifClass.readFileAsStringArrayOfWords(inputPath);

        WordFreqFinderApplication freqApplication = new WordFreqFinderApplication();

        // Create a Map with the "Word" as a key and update its value frequency
        Map<String, Integer> freqMap = freqApplication.createMap(wordsArray);

        // Sort the Hashmap by values (key, value)
        Map<String, Integer> freqMapSorted = freqApplication.sortByValue(freqMap);

        String str = "*";
        for (Map.Entry<String, Integer> entry : freqMapSorted.entrySet())
            System.out.printf("%-10s: %s\n", entry.getKey(), str.repeat(entry.getValue()));
    }


    public Map<String, Integer> createMap(String[] wArray){
        Map<String, Integer> freqMap = new HashMap<>();

        for (String s : wArray) {
            freqMap.compute(s, (key, val) -> (val == null) ? 1 : val + 1);
        }

        return freqMap;
    }


    public Map<String, Integer> sortByValue (Map<String, Integer> freqMap){
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer>> list = new LinkedList<>(freqMap.entrySet());

        // Sort the list using lambda expression
        list.sort(Map.Entry.comparingByValue());
        // Reverse the order
        Collections.reverse(list);

        // put data from sorted list to Map
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> iterator : list) {
            temp.put(iterator.getKey(), iterator.getValue());
        }
        return temp;
    }

}
