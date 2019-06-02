package com.koguty.spocone.datamanagement;

import com.koguty.spocone.commonclasses.Employee;
import com.koguty.spocone.commonclasses.Project;
import com.koguty.spocone.commonclasses.Task;
import com.koguty.spocone.analyzing.DataReceiver;

import java.util.List;
import java.util.Set;

/**
 * @author Kamil Rojek
 */
public class DataConsolePrinter implements IDataGenerator {
    private DataReceiver dataReceiver;

    public DataConsolePrinter(DataReceiver dataReceiver) {
        this.dataReceiver = dataReceiver;
    }

    @Override
    public void generateEmployeeBasicRaport() {
        System.out.println("GENERATING EMPLOYEE BASIC RAPORT!");
        Set<Employee> employeesData = dataReceiver.getEmployeesData();

        for (Employee employee : employeesData) {
            printEmployeeBasicRaport(employee);
        }
    }

    private void printEmployeeBasicRaport(Employee employee) {
        System.out.printf("\nEmployee: %s \n", employee.getPersonalDetails());
        int hoursSummary = 0;

        for (Project project : employee.getProjects()) {
            hoursSummary += project.getSummaryParticipantHours(employee);
        }

        System.out.println("Total working hours: " + hoursSummary);
    }

    @Override
    public void generateEmployeeAdvancedRaport() {
        System.out.println("GENERATING EMPLOYEE ADVANCED RAPORT!");
        Set<Employee> employeesData = dataReceiver.getEmployeesData();

        for (Employee employee : employeesData) {
            printEmployeeAdvancedRaport(employee);
        }
    }

    private void printEmployeeAdvancedRaport(Employee employee) {
        System.out.printf("\nEmployee: %s \n", employee.getPersonalDetails());
        for (Project project : employee.getProjects()) {
            System.out.printf("Project: %s Total hours: %s\n", project.getName(),
                    project.getSummaryParticipantHours(employee));
        }
    }

    @Override
    public void generateProjectBasicRaport() {
        System.out.println("GENERATING PROJECT BASIC RAPORT!");
        List<Project> projectData = dataReceiver.getProjectData();

        for (Project project: projectData) {
            printProjectBasicRaport(project);
        }
    }

    private void printProjectBasicRaport(Project project) {
        System.out.printf("\nProject: %s\n\n", project.getName());
        int hoursSummary = 0;
        for (Task task : project.getTaskList()) {
            hoursSummary += task.getDuration();
        }

        System.out.println("Total hours: " + hoursSummary);
    }

    @Override
    public void generateProjectAdvancedRaport() {
        System.out.println("GENERATING PROJECT ADVANCED RAPORT!");
        List<Project> projectData = dataReceiver.getProjectData();

        for (Project project: projectData) {
            printProjectAdvancedRaport(project);
        }
    }

    private void printProjectAdvancedRaport(Project project) {
        System.out.printf("\nProject: %s\n\n", project.getName());
        for (Task task : project.getTaskList()) {
            System.out.println("Task: " + task.getTaskDescription());
            System.out.println("Done by: " + task.getTaskContractor().getPersonalDetails());
            System.out.println("Date: " + task.getDate());
            System.out.printf("In %.2f hours\n\n", task.getDuration());
        }
    }
}
