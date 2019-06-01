package com.koguty.spocone;

import java.util.ArrayList;

public class PrintReport {

	void printEmployeesReport(ArrayList<Employee> employees) {
		System.out.println("Raport liczby godzin przepracowawanych przez poszczególnych pracowników");

		for (Employee employee : employees) {
			System.out.println(employee.getPersonalDetails() + " " + employee.getWorkingData());
		}
	}

	void printProjectsReport(ArrayList<Project> projects) {
		System.out.println("Raport liczby godzin poświęconych na poszczególne projekty");

		for (Project project : projects) {
			System.out.println(project.getName() + " " + project.getWorkingData());
		}
	}
}
