package oop.assignment3.ex45;

import oop.assignment3.ex41.base.ReadFileContent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FileProcessingTest {

    @Test
    void readFileAsString_Test() {
        FileProcessing fp = new FileProcessing();

        String actual = fp.readFileAsString("src/test/resources/exercise45_input_Test.txt");

        assertEquals("She is kind. She is brave", actual);
    }

    @Test
    void replaceText_Test() {
        FileProcessing fp = new FileProcessing();
        String originalText = "She is kind. She is brave";
        String actualModText = fp.replaceText("is", "was", originalText);

        assertEquals("She was kind. She was brave", actualModText);
    }

    @Test
    void writeModStringToFile() {
        FileProcessing fp = new FileProcessing();

        // String to write to the file
        String content = "She was kind. She was brave and smart";

        String dirPath = "src/test/resources";

        // In the application class the .txt is appended to the file name entered by the user
        String fileName = "exercise45_output_Test.txt";

        // Write string to the file (this name was supposed to be entered by the user)
        fp.writeModStringToFile(dirPath, fileName, content);

        // Read in content written into the file and compare with String content
        String contentRead = "";
        try {
            contentRead = new String(Files.readAllBytes(Paths.get("src/test/resources/exercise45_output_Test.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(content, contentRead);

    }

    @Test
    @DisplayName("Test if file exists")
    public void Test_if_File_was_Created(){
        File file = new File("src/test/resources/exercise45_output_Test.txt");
        assertTrue(file.exists());
    }
}