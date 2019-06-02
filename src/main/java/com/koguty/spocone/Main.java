package com.koguty.spocone;

import com.koguty.spocone.analyzing.Analizer;
import com.koguty.spocone.analyzing.DataContainer;
import com.koguty.spocone.analyzing.DataReceiver;
import com.koguty.spocone.datamanagement.DataConsolePrinter;
import com.koguty.spocone.datamanagement.DataGenerator;
import com.koguty.spocone.datamanagement.IDataGenerator;
import com.koguty.spocone.pather.Pather;

import java.io.FileNotFoundException;

class Main {
	public static void main(String[] args) {

		printWelcomeLogo();
		String choice = null;
		String path = null;

		try {
			try {
				path = args[1];
			} catch (Exception e) {
				System.out.println("Specify path");
			}

			choice = args[0];

			switch (choice) {
			case "-re1": {
				DataReceiver dataReceiver = generateData(path);
				DataGenerator dataGenerator = new DataGenerator(new DataConsolePrinter(dataReceiver));
				dataGenerator.generateEmployeeAdvancedRaport();
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
			}

		} catch (Exception e) {
			printHelp();
		}
	}

	public static void printVersion() {
		System.out.println("0.0.1");
	}

	public static void printHelp() {
		System.out.println("[-v] [-h] [-re1] [-rp2] [-re3] [-rp4]");
	}

	private static DataReceiver generateData(String path) {
		Pather pather = null;
		try {
			pather = new Pather(path);
		} catch (FileNotFoundException e) {
			System.err.println(".xls files not found !");
			;
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
