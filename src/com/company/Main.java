package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner optionScanner = new Scanner(System.in);
        String path = "@file.csv";
        File file = new File(path);
        Strin
        try(Scanner fileScanner = new Scanner(file)){
            String line = fileScanner.nextLine();
            while(fileScanner.hasNextLine()){


            }



        }catch(FileNotFoundException ex){
            System.out.println("Exception: "+ex.getMessage());
        }

        System.out.println("Choose option:");
        System.out.println("add");
        System.out.println("remove");
        System.out.println("list");
        System.out.println("quit");
        while(true){
            String line = optionScanner.nextLine();
            switch(line){
                case "add":
                   Add();
                    break;
                case "remove":
                    System.out.println("remove");
                    break;
                case "list":
                    System.out.println("list");
                    break;
                case "quit":
                    System.out.println("koniec");
                    break;
                default:
                        System.out.println("Choose correct option");
            }
        }
    }
    public static void Add(){
        System.out.println("add");
    }
}
