package oop.assignment3.ex41.base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class WriteToFile {

    public int numberOfNames(ArrayList<String> namesList){
        return namesList.size();
    }


    public String sortContent(ArrayList<String> namesList){
        Collections.sort(namesList);
        String delimiter = "\n";
        return String.join(delimiter, namesList);
    }


    public void writeToFile(String content, String outputPath){
        try {
            File writeFileObj = new File(outputPath);

            // If file does not exist, then create the file
            if(!writeFileObj.exists())
                writeFileObj.createNewFile();

            FileWriter fw = new FileWriter(writeFileObj.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            fw.write(content);
            bw.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
