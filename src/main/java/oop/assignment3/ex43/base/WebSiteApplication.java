package oop.assignment3.ex43.base;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Edelis Molina
 */

import java.util.Scanner;

public class WebSiteApplication {
    private final static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        WebSiteApplication app = new WebSiteApplication();
        FileGenerator fileApp = new FileGenerator();

        // Prompt to get user input to create directories
        String name = app.getUserInput("Site name: ");
        String author = app.getUserInput("Author: ");
        String js = app.getUserInput("Do you want a folder for JavaScript? (y/n) ");
        String css = app.getUserInput("Do you want a folder for CSS? (y/n) ");

        // Path of the working directory of my program
        String path = "src/main/java/oop/assignment3/ex43/base/website/";
        fileApp.createFiles(path, name, author, js, css);

    }

    public String getUserInput(String prompt){
        System.out.print(prompt);
        return input.nextLine();
    }
}
