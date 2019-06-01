package com.koguty.spocone;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		System.out.println("*********************");
		System.out.println("***   Welcome in  ***");
		System.out.println("*** Analysis Tool ***");
		System.out.println("*********************");
		System.out.println("Podaj ścieżkę do danych: ");
		Scanner sc = new Scanner(System.in);
		String path = sc.nextLine();
		System.out.println("Wybierz opcję:\n");
		System.out.println("1 - raport 1\n" + "2 - raport 2\n" + "v - wersja\n" + "h - help\n"+ "e - exit");
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
		case "h": {
//        	printHelp();
			break;
		}
		case "v": {
//        	printVersion();
			break;
		}
		case "e": {
//        	printVersion();
			break;
		}

		}

	}
}
