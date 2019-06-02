package com.koguty.spocone;

import com.koguty.spocone.analyzing.Analizer;
import com.koguty.spocone.analyzing.DataReceiver;
import com.koguty.spocone.datamanagement.DataConsolePrinter;
import com.koguty.spocone.datamanagement.DataExcelGenerator;
import com.koguty.spocone.datamanagement.IDataGenerator;
import com.koguty.spocone.datamanagement.PdfCreator;
import com.koguty.spocone.pather.Pather;

import java.io.FileNotFoundException;
import java.io.IOException;

class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            printHelp();
        } else {
            printWelcomeLogo();
            DataReceiver dataReceiver = generateData(args[0]);

            switch (args[1]) {
                case "-c":
                    generate(args[2], new DataConsolePrinter(dataReceiver));
                    break;
                case "-xls":
                    generate(args[2], new DataExcelGenerator(dataReceiver));
                    break;
                case "-p":
                    generatePdf(args[2], new DataExcelGenerator(dataReceiver));
                default:
                    break;
            }
        }
    }

    private static void generatePdf(String arg, IDataGenerator dataGenerator) {
        switch (arg) {
            case "-re1":
                dataGenerator.generateEmployeeBasicRaport();
                PdfCreator pdfCreator = new PdfCreator();
                try {
                    pdfCreator.createPDF("basic_employee_raport.xls");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "-rp2":
                dataGenerator.generateProjectBasicRaport();
                pdfCreator = new PdfCreator();
                try {
                    pdfCreator.createPDF("basic_project_raport.xls");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "-re3":
                dataGenerator.generateEmployeeAdvancedRaport();
                pdfCreator = new PdfCreator();
                try {
                    pdfCreator.createPDF("advanced_employee_raport.xls");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "-rp4":
                dataGenerator.generateProjectAdvancedRaport();
                dataGenerator.generateEmployeeAdvancedRaport();
                pdfCreator = new PdfCreator();
                try {
                    pdfCreator.createPDF("advanced_project_raport.xls");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

    private static void generate(String arg, IDataGenerator dataGenerator) {
        switch (arg) {
            case "-re1":
                dataGenerator.generateEmployeeBasicRaport();
                break;
            case "-rp2":
                dataGenerator.generateProjectBasicRaport();
                break;
            case "-re3":
                dataGenerator.generateEmployeeAdvancedRaport();
                break;
            case "-rp4":
                dataGenerator.generateProjectAdvancedRaport();
                break;
            default:
                break;
        }
    }

    public static void printHelp() {
        System.out.println("\nExamples: [<path> -c -re1] [<path> -xls -rp2] [<path> -c -re3] [<path> -xls -rp4] \n\n"
                + "-c - Tworzenie raportu w konsoli \n"
                + "-xls - Tworzenie raportu do pliku Excel \n\n"
                + "-re1 - Tworzenie raportu 1 - Osoba + godziny pracy we wszystkich projektach \n"
                + "-rp2 - Tworzenie raportu 2 - Projekt + godziny pracy wszystkich programistów \n"
                + "-re3 - Tworzenie raportu 1+3 - Osoba + godziny pracy w danych projektach \n"
                + "-rp4 - Tworzenie raportu 2+4 - Szczegółowy raport dla projektówh \n");
    }

    private static DataReceiver generateData(String path) {
        Pather pather = null;
        try {
            pather = new Pather(path);
        } catch (FileNotFoundException e) {
            System.err.println(".xls files not found !");
        }
        Analizer analizer = new Analizer(pather);
        return analizer.prepareData();
    }

    private static void printWelcomeLogo() {
        System.out.println("*************************");
        System.out.println("*****   Welcome in  *****");
        System.out.println("***** Analysis Tool *****");
        System.out.println("*************************");
    }
}
