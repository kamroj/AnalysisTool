package com.koguty.spocone;

import com.koguty.spocone.analyzing.Analizer;
import com.koguty.spocone.analyzing.DataReceiver;
import com.koguty.spocone.datamanagement.DataConsolePrinter;
import com.koguty.spocone.datamanagement.DataExcelGenerator;
import com.koguty.spocone.datamanagement.DataGenerator;
import com.koguty.spocone.pather.Pather;

import java.io.FileNotFoundException;

class Main {
	public static void main(String[] args) {

		printWelcomeLogo();
		String path = null;
		String choice = null;

		try {
			try {
				path = args[0];
			} catch (Exception e) {
			}
			choice = args[1];
			System.out.println(choice);
//			filter = args[2];

			switch (choice) {
				case "-re1": {
					DataReceiver dataReceiver = generateData(path);
					DataGenerator dataGenerator = new DataGenerator(new DataConsolePrinter(dataReceiver));
					dataGenerator.generateEmployeeBasicRaport();
					break;
				}
				case "-rp2": {
					DataReceiver dataReceiver = generateData(path);
					DataGenerator dataGenerator = new DataGenerator(new DataConsolePrinter(dataReceiver));
					dataGenerator.generateProjectBasicRaport();
					break;
				}
				case "-re3": {
					DataReceiver dataReceiver = generateData(path);
					DataGenerator dataGenerator = new DataGenerator(new DataConsolePrinter(dataReceiver));
					dataGenerator.generateEmployeeAdvancedRaport();
					break;
				}
				case "-rp4": {
					DataReceiver dataReceiver = generateData(path);
					DataGenerator dataGenerator = new DataGenerator(new DataConsolePrinter(dataReceiver));
					dataGenerator.generateProjectAdvancedRaport();
					break;
				}
				case "-h": {
					printHelp();
					break;
				}
				case "-v": {
					printVersion();
					break;
				}
				default:
					printHelp();
			}

		} catch (Exception e) {
			printHelp();
		}
	}

	public static void printVersion() {
		System.out.println("0.0.1");
	}

	public static void printHelp() {
		System.out.println("\n[-v] [-h] [-re1 <path>] [-rp2 <path>] [-re3 <path>] [-rp4 <path>] \n\n"
				+ "re1 - Tworzenie raportu 1 - Osoba+godziny pracy we wszystkich projektach \n"
				+ "rp2 - Tworzenie raportu 2 - Projekt+godziny pracy wszystkich programistów \n"
				+ "re3 - Tworzenie raportu 1+3 - Osoba+godziny pracy w danych projektach \n"
				+ "rp4 - Tworzenie raportu 4 - Szczegółowy raport dla projektówh \n"
				+ "v - Wyświetla wersję programu \n" + "h -  wyświetla pomoc \n");
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
