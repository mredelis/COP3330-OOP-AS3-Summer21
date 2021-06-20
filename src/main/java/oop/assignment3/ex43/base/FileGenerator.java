package oop.assignment3.ex43.base;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Edelis Molina
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {

    public void createFiles(String path, String siteName, String author, String js, String css){

        String htmlContent =
            "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta name=\"author\" content=\"" + author + "\">\n" +
            "    <title>" + siteName + "</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1>Java Assignment 3</h1>\n" +
            "</body>\n" +
            "</html>";

        // Path of the index.html file
        String filePathStr = path + siteName + "/index.html";

        File f = new File(filePathStr);

        // Create parent directory aka Folder with Website Name
        if(!f.getParentFile().exists()){
            boolean dirSuccess = f.getParentFile().mkdirs();
            if(!dirSuccess)
                System.out.println("Error creating the Website Directory!");
            else
                System.out.println("Created " + f.getParentFile().getPath());
        }
        else {
            System.out.println("Directory " + f.getParentFile() + " already exists!");
        }

        // Create index.html file
        if(!f.exists()){
            try {
                boolean fileSuccess = f.createNewFile();
                if(!fileSuccess)
                    System.out.println("Error creating the index.html file!");
                else
                    System.out.println("Created " + f.getPath());

                // Write to html file once created
                FileWriter fw = new FileWriter(f.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                fw.write(htmlContent);
                bw.close();

            } catch (IOException e) {
                System.out.println("Error creating index.html file!");
                e.printStackTrace();
            }
        }


        // Create js directory if required
        if(js.equalsIgnoreCase("y")){
            String jsDir = path + siteName + "/js";
            File fJS  = new File(jsDir);

            if(fJS.getParentFile().exists())
                if(fJS.mkdir())
                    System.out.println("Created " + fJS.getPath());
                else
                    System.out.println("Directory " + fJS.getPath() + " already exists!");
        }

        // Create css directory if required
        if(css.equalsIgnoreCase("y")){
            String cssDir = path + siteName + "/css";
            File fCSS = new File(cssDir);

            if(fCSS.getParentFile().exists())
                if(fCSS.mkdir())
                    System.out.println("Created " + fCSS.getPath());
                else
                    System.out.println("Directory " + fCSS.getPath() + " already exists!");
        }
    }
}
