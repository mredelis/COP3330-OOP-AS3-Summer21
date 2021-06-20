package oop.assignment3.ex44.base;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Edelis Molina
 */

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ProductSearchApplication {

    private final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        ProductSearchApplication app = new ProductSearchApplication();

        // Read JSON from file
        BufferedReader br = new BufferedReader(new FileReader("InputFiles/exercise44_input.json"));
        String line;
        StringBuilder strBuilderObj = new StringBuilder();
        while ((line = br.readLine()) != null){
            strBuilderObj.append(line);
        }

        String originalJson = strBuilderObj.toString();

        // Gson Object
        Gson gson = new Gson();
        GeneralInfo generalInfoObject = gson.fromJson(originalJson, GeneralInfo.class);

        boolean isOnTheList = false;
        int productIdx;
        String product;
        do {
            System.out.print("What is the product name? ");
            product = in.nextLine();

            productIdx = app.getProductIndexOnTheList(product, generalInfoObject);
            if(productIdx < 0)
                System.out.println("Sorry, that product was not found in our inventory.");
            else
                isOnTheList = true;

        } while (!isOnTheList);

        String output = app.printProductInformation(productIdx, generalInfoObject);
        System.out.println(output);
    }

    // Return the index of the Product Object on the array
    // If product name is not on the List return -1
    public int getProductIndexOnTheList(String product, GeneralInfo generalInfoObject) {
        for (int idx = 0; idx < generalInfoObject.products.size(); idx++) {
            if (generalInfoObject.products.get(idx).name.equals(product)) {
                return idx;
            }
        }
        return -1;
    }

    public String printProductInformation(int productIdx, GeneralInfo generalInfoObject){
        return String.format("Name: %s\nPrice: %.2f\nQuantity: %d", generalInfoObject.products.get(productIdx).name,
                                                                    generalInfoObject.products.get(productIdx).price,
                                                                    generalInfoObject.products.get(productIdx).quantity);
    }

}





