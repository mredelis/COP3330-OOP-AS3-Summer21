package oop.assignment3.ex46;

import oop.assignment3.ex45.FileProcessing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InputFileTest {

    @Test
    @DisplayName("Convert the text in the input file to a String Array of words ")
    void readFileAsStringArrayOfWords_Test() {
        InputFile iFile = new InputFile();
        String[] actual = iFile.readFileAsStringArrayOfWords("InputFiles/exercise46_input_Test.txt");
        String[] expected = {"orange", "apple", "banana", "apple", "peach", "peach", "orange", "orange", "apple", "apple"};

        assertArrayEquals(expected, actual);
    }

    @Test
    void createMap_Test(){
        WordFreqFinderApplication freqApp= new WordFreqFinderApplication();
        String[] wordArr = {"orange", "apple", "banana", "apple", "peach", "peach", "orange", "orange", "apple", "apple"};

        Map<String, Integer> wordFreqMap = freqApp.createMap(wordArr);

        Assertions.assertAll(() -> assertEquals(1, wordFreqMap.get("banana")),
                             () -> assertEquals(2, wordFreqMap.get("peach")),
                             () -> assertEquals(3, wordFreqMap.get("orange")),
                             () -> assertEquals(4, wordFreqMap.get("apple")) );
    }

    @Test
    void sortByValue_Test(){
        WordFreqFinderApplication freqApp= new WordFreqFinderApplication();
        String[] wordArr = {"orange", "apple", "banana", "apple", "peach", "peach", "orange", "orange", "apple", "apple"};

        Map<String, Integer> wordFreqMap = freqApp.createMap(wordArr);
        Map<String, Integer> wordFreqMapSorted = freqApp.sortByValue(wordFreqMap);

        Object[] keys = wordFreqMapSorted.keySet().toArray();

        Assertions.assertAll(() -> assertEquals(4, wordFreqMap.get(keys[0])),
            () -> assertEquals(3, wordFreqMap.get(keys[1])),
            () -> assertEquals(2, wordFreqMap.get(keys[2])),
            () -> assertEquals(1, wordFreqMap.get(keys[3])) );
    }
}