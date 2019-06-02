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
import java.util.Scanner;

class Main {
	public static void main(String[] args) {

		printWelcomeLogo();
		String path = null;

		Scanner scanner = new Scanner(System.in);
		System.out.print("Give path: ");
		String userInput = scanner.nextLine();
		String[] s = userInput.split(" ");
		path = s[0];

		String choice = null;

		try {
			try {
				path = args[1];
			} catch (Exception e) {
			}
			choice = s[1];
			System.out.println(choice);
//			filter = args[2];

			switch (choice) {
				case "-re1": {
					DataReceiver dataReceiver = generateData(path);
					DataGenerator dataGenerator = new DataGenerator(new DataExcelGenerator(dataReceiver));
					dataGenerator.generateEmployeeBasicRaport();
					break;
				}
				case "-rp2": {
					DataReceiver dataReceiver = generateData(path);
					DataGenerator dataGenerator = new DataGenerator(new DataExcelGenerator(dataReceiver));
					dataGenerator.generateProjectBasicRaport();
					break;
				}
				case "-re3": {
					DataReceiver dataReceiver = generateData(path);
					DataGenerator dataGenerator = new DataGenerator(new DataExcelGenerator(dataReceiver));
					dataGenerator.generateEmployeeAdvancedRaport();
					break;
				}
				case "-rp4": {
					DataReceiver dataReceiver = generateData(path);
					DataGenerator dataGenerator = new DataGenerator(new DataExcelGenerator(dataReceiver));
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
//		String filter = null;

//		try {
//			try {
//				path = args[1];
//			} catch (Exception e) {
//			}
//			choice = args[0];
////			filter = args[2];
//
//			switch (choice) {
//			case "-re1": {
//				DataReceiver dataReceiver = generateData(path);
//				DataGenerator dataGenerator = new DataGenerator(new DataConsolePrinter(dataReceiver));
//				dataGenerator.generateEmployeeBasicRaport();
//				break;
//			}
//			case "-rp2": {
//				DataReceiver dataReceiver = generateData(path);
//				DataGenerator dataGenerator = new DataGenerator(new DataConsolePrinter(dataReceiver));
//				dataGenerator.generateProjectBasicRaport();
//				break;
//			}
//			case "-re3": {
//				DataReceiver dataReceiver = generateData(path);
//				DataGenerator dataGenerator = new DataGenerator(new DataConsolePrinter(dataReceiver));
//				dataGenerator.generateEmployeeAdvancedRaport();
//				break;
//			}
//			case "-rp4": {
//				DataReceiver dataReceiver = generateData(path);
//				DataGenerator dataGenerator = new DataGenerator(new DataConsolePrinter(dataReceiver));
//				dataGenerator.generateProjectAdvancedRaport();
//				break;
//			}
//			case "-h": {
//				printHelp();
//				break;
//			}
//			case "-v": {
//				printVersion();
//				break;
//			}
//			default:
//				printHelp();
//			}
//
//		} catch (Exception e) {
//			printHelp();
//		}
	}

	public static void printVersion() {
		System.out.println("0.0.1");
	}

	public static void printHelp() {
		System.out.println("\nExamples: [-v] [-h] [<path> -c -re1] [<path> -xls -rp2] [<path> -c -re3] [<path> -xls -rp4] \n\n"
				+ "-c - Tworzenie raportu w konsoli \n"
				+ "-xls - Tworzenie raportu do pliku Excel \n\n"
				+ "-re1 - Tworzenie raportu 1 - Osoba+godziny pracy we wszystkich projektach \n"
				+ "-rp2 - Tworzenie raportu 2 - Projekt+godziny pracy wszystkich programistów \n"
				+ "-re3 - Tworzenie raportu 1+3 - Osoba+godziny pracy w danych projektach \n"
				+ "-rp4 - Tworzenie raportu 4 - Szczegółowy raport dla projektówh \n"
				+ "-v - Wyświetla wersję programu \n" + "-h -  wyświetla pomoc \n");
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
