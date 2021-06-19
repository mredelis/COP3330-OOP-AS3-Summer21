package oop.assignment3.ex42.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReadFileTest {

    @Test
    void readContent_Test() {
        ReadFile reader = new ReadFile();

        List<String[]> actual = reader.readContent("src/test/resources/exercise42_input_Test.txt");

        String[] line1 = {"Holmes", "Michelle", "55900"};
        String[] line2 = {"Haynes", "Christina", "56500"};
        String[] line3 = {"Hagen", "Lindsay", "46000"};
        List<String[]> expected = new ArrayList<>();
        expected.add(line1);
        expected.add(line2);
        expected.add(line3);

        assertArrayEquals(expected.get(0), actual.get(0));
        assertArrayEquals(expected.get(1), actual.get(1));
        assertArrayEquals(expected.get(2), actual.get(2));

    }

    @Test
    void createFormattedString_Test() {
        ReadFile reader = new ReadFile();
        List<String[]> actualListArray = reader.readContent("src/test/resources/exercise42_input_Test.txt");
        String actual = reader.createFormattedString(actualListArray);

        String exp1 = String.format("%-10s%-10s%-10s\n", "Holmes", "Michelle", "55900");
        String exp2 = String.format("%-10s%-10s%-10s\n", "Haynes", "Christina", "56500");
        String exp3 = String.format("%-10s%-10s%-10s\n", "Hagen", "Lindsay", "46000");
        String expected = exp1 + exp2 + exp3;

        assertEquals(expected, actual);
    }
}