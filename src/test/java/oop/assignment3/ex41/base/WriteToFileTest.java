package oop.assignment3.ex41.base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WriteToFileTest {

    ReadFileContent readApp = new ReadFileContent();
    ArrayList<String> testNameList = readApp.readContent("src/test/resources/exercise41_input_Test.txt");

    WriteToFile writeApp = new WriteToFile();

    @Test
    void numberOfNames() {
        int actual = writeApp.numberOfNames(testNameList);
        assertEquals(3, actual);
    }

    @Test
    void sortContent() {
        String expected = "Christina Haynes\nLindsay Hagen\nMichelle Holmes";
        String actual = writeApp.sortContent(testNameList);
        assertEquals(expected, actual);
    }


    @Test
    void writeToFile_Test(){

        // Create String content to write to the file
        String contentToWrite = "Total of " + writeApp.numberOfNames(testNameList) + " names\n-----------------\n" + writeApp.sortContent(testNameList);

        // Write String content to the file
        writeApp.writeToFile(contentToWrite, "src/test/resources/exercise41_output_Test.txt");

        // Read in content written into an String and compare with String contentToWrite
        String contentRead = "";
        try {
            contentRead = new String(Files.readAllBytes(Paths.get("src/test/resources/exercise41_output_Test.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println("Read from test file\n" + contentRead);
        assertEquals(contentToWrite, contentRead);
    }

    @Test
    @DisplayName("Test if file exists")
    public void writeFile_TestExists(){
        File file = new File("src/test/resources/exercise41_output_Test.txt");
        assertTrue(file.exists());
    }
}