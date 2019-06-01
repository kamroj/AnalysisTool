package com.koguty.spocone;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		System.out.println("*** Analysis Tool ***");
		System.out.println("Wpisz scieżkę");
		Scanner sc = new Scanner(System.in);
		String path = sc.nextLine();
		System.out.println("Wybierz opcję\n");
		System.out.println("1 - raport 1\n" + "2 - raport 2\n" + "v - wersja\n" + "h - help");
		String choice = sc.nextLine();
		switch (choice) {
		case "1": {
//        	printRaport1();
			break;
		}
		case "2": {
//        	printRaport2();
			break;
		}
		case "3": {
//        	printRaport3();
			break;
		}
		case "4": {
//        	printRaport4();
			break;
		}
		case "5": {
//        	printRaport5();
			break;
		}
		case "h": {
//        	printHelp();
			break;
		}
		case "v": {
//        	printVersion();
			break;
		}

		}

	}
}
