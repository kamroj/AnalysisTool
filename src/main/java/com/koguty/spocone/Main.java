package com.koguty.spocone;

<<<<<<< HEAD
import java.text.SimpleDateFormat;
import java.util.Date;
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

		while (done == true) {
			System.out.println("				");
			System.out.println("Wybierz opcję:\n");
			System.out.println("1 - raport 1\n" + "2 - raport 2\n" + "v - wersja\n" + "h - help\n" + "e - exit");
			System.out.println("				");
			String choice = sc.nextLine();

			if (choice == "e") {

			} else {

				switch (choice) {
				case "1": {
					printDate();
//        				printRaport1();
					break;
				}
				case "2": {
					printDate();
//        				printRaport2();
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
				case "e": {
					done = false;
					exitpp();
					break;
				}
				default:
					System.out.println("Podałeś niepoprawną opcję! Spróbuj ponownie.");
				}
			}
		}
	}

	public static void printVersion() {
		System.out.println("0.0.1");
	}

	public static void printHelp() {
		System.out.println("help");
	}

	public static void exitpp() {
		System.out.println("Do widzenia!\n");
		System.out.println("				");
		System.exit(0);
	}

	public static void printDate() {
		SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd',' hh:mm:ss");
		Date d = new Date();
		System.out.println("Data wydruku raportu\n" + ft.format(d) + "\n");
	}
=======
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        System.out.println("hello");
        
//         Employee employee1 = new Employee("Jan Nowak");
//         Employee employee2 = new Employee("Adam Kot");
//         Employee employee3 = new Employee("Anna Waga");
//         Employee employee4 = new Employee("Karol Tur");
//         PrintReport printReport = new  PrintReport();
//        ArrayList<Employee> employees = new ArrayList<Employee>();
//        
//        employees.add(employee1);        
//        employees.add(employee2);
//        employees.add(employee3);
//        
//        printReport.printEmployeesReport(employees);
    }
>>>>>>> print
}
