package oop.assignment3.ex43.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FileGeneratorTest {

    @Test
    @DisplayName("Check if the following dir were created: website name; js and css")
    void createFiles_Test() {
        FileGenerator fgenApp = new FileGenerator();

        String path = "src/test/resources/website/";
        String parentDir = "src/test/resources/website/awesomeco/";
        String htmlFile = "src/test/resources/website/awesomeco/index.html";
        String jsDir = "src/test/resources/website/awesomeco/js";
        String cssDir = "src/test/resources/website/awesomeco/css";

        fgenApp.createFiles(path, "awesomeco", "Max Power", "Y", "Y");

        Assertions.assertAll(() -> assertTrue(new File(parentDir).exists()),
                             () -> assertTrue(new File(htmlFile).exists()),
                             () -> assertTrue(new File(jsDir).exists()),
                             () -> assertTrue(new File(cssDir).exists()) );
    }
}