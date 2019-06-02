package com.koguty.spocone;

import com.koguty.spocone.analyzing.Analizer;
import com.koguty.spocone.analyzing.DataContainer;
import com.koguty.spocone.analyzing.DataReceiver;
import com.koguty.spocone.datamanagement.DataConsolePrinter;
import com.koguty.spocone.datamanagement.DataExcelGenerator;
import com.koguty.spocone.datamanagement.DataGenerator;
import com.koguty.spocone.datamanagement.IDataGenerator;
import com.koguty.spocone.pather.Pather;

import java.io.FileNotFoundException;

class Main {
    public static void main(String[] args) {
        printWelcomoLogo();

        String path = "/home/kamil/Kod/AnalysisTool/reporter-dane/";
        DataReceiver dataReceiver = generateData(path);
        //DataReceiver dataReceiver = new Analizer().prepareData();

        DataGenerator dataGenerator = new DataGenerator(new DataExcelGenerator(dataReceiver));
        dataGenerator.generateProjectAdvancedRaport();

        //printRaport(path);
        //printRaport(args[0]);
    }

    private static DataReceiver generateData(String path) {
        Pather pather = null;
        try {
            pather = new Pather(path);
        } catch (FileNotFoundException e) {
            System.err.println(".xls files not found !");;
        }
        Analizer analizer = new Analizer(pather);
        return analizer.prepareData();
    }

    private static void printWelcomoLogo() {
        System.out.println("*************************");
        System.out.println("*****   Welcome in  *****");
        System.out.println("***** Analysis Tool *****");
        System.out.println("*************************");
    }
}
