package com.koguty.spocone;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		System.out.println("*************************");
		System.out.println("*****   Welcome in  *****");
		System.out.println("***** Analysis Tool *****");
		System.out.println("*************************");
		Scanner sc = new Scanner(System.in);
		String path = args[0];

		boolean done = true;

		do {
			System.out.println("Wybierz opcję:\n");
			System.out.println("1 - raport 1\n" + "2 - raport 2\n" + "v - wersja\n" + "h - help\n" + "e - exit");
			System.out.println("				");
			String choice = sc.nextLine();

			if (choice == "e") {
				done = false;
				break;
			} else {
				switch (choice) {
				case "1": {
//        	printRaport1();
					break;
				}
				case "2": {
//        	printRaport2();
					break;
				}
				case "h": {
					printHelp();
					break;
				}
				case "v": {
					printVersion();
					break;
				}
				}
			}
		} while (done == false);
		exit();
	}

	public static void printVersion() {
		System.out.println("0.0.1");
	}

	public static void printHelp() {
		System.out.println("help");
	}

	public static void exit() {
		System.out.println("Do widzenia!\n");
		System.out.println("				");
		System.exit(0);
	}
}
