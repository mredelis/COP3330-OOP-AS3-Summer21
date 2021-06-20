package oop.assignment3.ex44.base;


import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class ProductSearchApplication {

    private final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        ProductSearchApplication app = new ProductSearchApplication();

        // Read JSON from file // consider moving to a method
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/exercise44_input.json"));
        String line;
        StringBuilder strBuilderObj = new StringBuilder();
        while ((line = br.readLine()) != null){
            strBuilderObj.append(line);
        }

        String originalJson = strBuilderObj.toString();
        System.out.println("Original JSON: " + originalJson);

        // Gson Object
        Gson gson = new Gson();
        GeneralInfo generalInfoObject = gson.fromJson(originalJson, GeneralInfo.class);

//        for(int i = 0; i < generalInfoObject.products.size(); i++)
//            System.out.println(generalInfoObject.products.get(i).name);


        boolean isOnTheList;
        String product;
        do {
            System.out.print("What is the product name? ");
            product = in.nextLine();
            isOnTheList = app.isProductOnTheList(product, generalInfoObject);
        } while (!isOnTheList);








    }


    public boolean isProductOnTheList(String product, GeneralInfo generalInfoObject) {
        for (int i = 0; i < generalInfoObject.products.size(); i++) {
            if (generalInfoObject.products.get(i).name.equals(product)) {
                return true;
            }
        }
        System.out.println("Sorry, that product was not found in our inventory.");
        return false;
    }

    public String printProductInformation(String product, GeneralInfo generalInfoObject){
        for(int i = 0; i<generalInfoObject.products.size(); i++){
            if(generalInfoObject.products.get(i).name.equals(product))
                return String.format("Name: %s\nPrice: %f\nQuantity: %d", generalInfoObject.products.get(i).name,
                                                                          generalInfoObject.products.get(i).price,
                                                                          generalInfoObject.products.get(i).quantity);
        }
    }






}





