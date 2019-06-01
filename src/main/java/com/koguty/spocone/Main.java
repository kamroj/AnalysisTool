package com.koguty.spocone;

import com.koguty.spocone.analyzing.Analizer;
import com.koguty.spocone.analyzing.DataContainer;
import com.koguty.spocone.analyzing.DataReceiver;
import com.koguty.spocone.pather.Pather;

import java.text.SimpleDateFormat;
import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.println("*************************");
        System.out.println("*****   Welcome in  *****");
        System.out.println("***** Analysis Tool *****");
        System.out.println("*************************");

        String path = "/home/kamil/Kod/AnalysisTool";
        printRaport(path);
        //printRaport(args[0]);
    }

    private static void printRaport(String path) {
        Pather pather = new Pather(path);
        Analizer analizer = new Analizer(pather);
        DataReceiver container = analizer.prepareData();

        for (Employee employee : container.getEmployeesData()) {
            System.out.println("\nEMPLOYEE NAME:: " + employee.getPersonalDetails());
            Map<Project, Float> summaryHoursPerProject = employee.getSummaryHoursPerProject();

            for (Project project : summaryHoursPerProject.keySet()) {
                System.out.println("PROJECT NAME:: " + project.getName());
                System.out.println("SUMMARY HOURS:: " + summaryHoursPerProject.get(project));
            }
        }

        List<Project> projectData = container.getProjectData();
        for (Project project : projectData) {
            for (Task task : project.getTaskList()) {
                System.out.println(project.getName() + " " + task.getTaskDescription());
            }
        }


    }



//        String path = args[0];
//
//        boolean done = true;
//
//        while (done) {
//            System.out.println("				");
//            System.out.println("Wybierz opcję:\n");
//            System.out.println("1 - raport 1\n" + "2 - raport 2\n" + "v - wersja\n" + "h - help\n" + "e - exit");
//            System.out.println("				");
//            String choice = sc.nextLine();
//
//            if (choice == "e") {
//
//            } else {
//
//                switch (choice) {
//                    case "1": {
//                        printDate();
//                        printRaport(path);
////        				printRaport1();
//                        break;
//                    }
//                    case "2": {
//                        printDate();
////        				printRaport2();
//                        break;
//                    }
//                    case "h": {
//                        printHelp();
//                        break;
//                    }
//                    case "v": {
//                        printVersion();
//                        break;
//                    }
//                    case "e": {
//                        done = false;
//                        exitpp();
//                        break;
//                    }
//                    default:
//                        System.out.println("Podałeś niepoprawną opcję! Spróbuj ponownie.");
//                }
//            }
//        }
//    }
//
//
//    public static void printVersion() {
//        System.out.println("0.0.1");
//    }
//
//    public static void printHelp() {
//        System.out.println("help");
//    }
//
//    public static void exitpp() {
//        System.out.println("Do widzenia!\n");
//        System.out.println("				");
//        System.exit(0);
//    }
//
//    public static void printDate() {
//        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd',' hh:mm:ss");
//        Date d = new Date();
//        System.out.println("Data wydruku raportu\n" + ft.format(d) + "\n");
}
