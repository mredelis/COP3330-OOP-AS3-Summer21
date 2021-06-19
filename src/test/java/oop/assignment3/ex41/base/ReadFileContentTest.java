package oop.assignment3.ex41.base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ReadFileContentTest {

    @Test
    public void readContent_Test() {
        ReadFileContent reader = new ReadFileContent();
        ArrayList<String> actual = reader.readContent("src/test/resources/exercise41_input_Test.txt");
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Michelle Holmes", "Christina Haynes", "Lindsay Hagen"));

        assertEquals(expected, actual);
    }
}