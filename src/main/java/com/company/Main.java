package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner optionScanner = new Scanner(System.in);
        String path = "file.csv";
        File file = new File(path);
        //Pamiętać o zmianie tablicy an uniwersalną !!!!!!!!!!!!!!!!!!!!!!
        String[][] tab = new String[5][4];

        try (Scanner fileScanner = new Scanner(file)) {
            int i = 0;
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] rows = new String[1];
                String[] temp = Arrays.copyOf(rows, tab.length);
                temp[i] = line;
                String[] words = temp[i].split(",");
                for (int j = 0; j < words.length; j++) {
                    tab[i][0] = String.valueOf(i);
                    tab[i][j + 1] = words[j];
                }
                i++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        System.out.println("Choose option:");
        System.out.println("add");
        System.out.println("remove");
        System.out.println("list");
        System.out.println("quit");
        String[][] mainData = Arrays.copyOf(tab, tab.length);
        while (true) {
            String line = optionScanner.nextLine();
            switch (line) {

                case "add":
                    mainData = Add(mainData);
                    break;
                case "remove":
                    mainData = Remove(mainData);
                    break;
                case "list":
                    List(mainData);
                    break;
                case "quit":
                    Quit(mainData, path);
                    break;
                default:
                    System.out.println("Choose correct option");
            }
        }
    }

    public static void Quit(String[][] excelData,String path) throws IOException {
        String[] excelLine = new String[excelData.length];
        Path newFile = Paths.get("file1.csv");

        for (int i = 0; i < excelData.length; i++) {
            excelLine[i] = String.join(",", excelData[i][0], excelData[i][1], excelData[i][2], excelData[i][3]);
            Files.write(newFile, Collections.singleton(excelLine[i]));
        }


        System.exit(0);
    }

    public static String[][] Remove(String[][] excelData) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer zadania do usunięcia: ");
        String numberToRemove = scanner.nextLine();
        String[] temp = new String[excelData.length];
        for (int i = 0; i < excelData.length; i++) {
            temp[i] = String.join(",", excelData[i][0], excelData[i][1], excelData[i][2], excelData[i][3]);
        }

        String[] remove = ArrayUtils.remove(temp, Integer.parseInt(numberToRemove));
        for (int i = 0; i < excelData.length - 1; i++) {
        }
        String[] words = new String[remove.length * 4];
        String[][] newTab = Arrays.copyOf(excelData, excelData.length - 1);
        for (int i = 0; i < remove.length; i++) {
            words = remove[i].split(",");
            for (int j = 0; j < words.length - 1; j++) {
                newTab[i][0] = String.valueOf(i);
                newTab[i][j + 1] = words[j + 1];
            }
        }
        System.out.println("Removed");
        return newTab;
    }

    public static void List(String[][] excelData) {
        for (int i = 0; i < excelData.length; i++) {
            System.out.println(excelData[i][0] + " " + ":" + " " + excelData[i][1] + " " + excelData[i][2] + " " + excelData[i][3]);
        }
    }

    public static String[][] Add(String[][] excelData) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add task descritpion: ");
        String description = scanner.nextLine();
        System.out.println("Add due date: ");
        String date = scanner.nextLine();
        System.out.println("Is it important: true/false ");
        String isItImportant = scanner.nextLine();

        String[][] excelData1 = new String[excelData.length + 1][excelData[0].length];
        excelData1 = Arrays.copyOf(excelData, excelData1.length);
        System.out.println(excelData1.length + " " + excelData1[0].length);

        excelData1[excelData1.length - 1] = new String[4];
        excelData1[excelData1.length - 1][0] = String.valueOf(excelData1.length - 1);
        excelData1[excelData1.length - 1][1] = description;
        excelData1[excelData1.length - 1][2] = date;
        excelData1[excelData1.length - 1][3] = isItImportant;
        System.out.println("Dodano zadanie");
        return excelData1;

    }
}

