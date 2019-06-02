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
        System.out.println("\nEMPLOYE NAME | TOTAL HOURS");
        Set<Employee> employeesData = dataReceiver.getEmployeesData();

        for (Employee employee : employeesData) {
            printEmployeeBasicRaport(employee);
        }
    }

    private void printEmployeeBasicRaport(Employee employee) {
        int hoursSummary = 0;

        for (Project project : employee.getProjects()) {
            hoursSummary += project.getSummaryParticipantHours(employee);
        }
        System.out.println(employee.getPersonalDetails() + " | " + hoursSummary);
    }

    @Override
    public void generateEmployeeAdvancedRaport() {
        System.out.println("GENERATING EMPLOYEE ADVANCED RAPORT!");
        System.out.println("EMPLOYEE | PROJECT | TOTAL WORKING HOURS | PERCENT");
        Set<Employee> employeesData = dataReceiver.getEmployeesData();

        for (Employee employee : employeesData) {
            printEmployeeAdvancedRaport(employee);
        }
    }

    private void printEmployeeAdvancedRaport(Employee employee) {
        for (Project project : employee.getProjects()) {
            System.out.printf("%s | %s | %.2f | %.2f\n", employee.getPersonalDetails(), project.getName(),
                    project.getSummaryParticipantHours(employee), (project.getSummaryParticipantHours(employee)/employee.getTotalHoursInAllProject()));
        }
    }

    @Override
    public void generateProjectBasicRaport() {
        System.out.println("GENERATING PROJECT BASIC RAPORT!");
        System.out.println("PROJECT | TOTAL WORKING HOURS");
        List<Project> projectData = dataReceiver.getProjectData();

        for (Project project: projectData) {
            printProjectBasicRaport(project);
        }
    }

    private void printProjectBasicRaport(Project project) {
        int hoursSummary = 0;
        for (Task task : project.getTaskList()) {
            hoursSummary += task.getDuration();
        }

        System.out.println(project.getName() + " | " + hoursSummary);
    }

    @Override
    public void generateProjectAdvancedRaport() {
        System.out.println("PROJECT | EMPLOYEE | TOTAL WORKING HOURS | PERCENT");
        List<Project> projectData = dataReceiver.getProjectData();

        for (Project project: projectData) {
            printProjectAdvancedRaport(project);
        }
    }

    private void printProjectAdvancedRaport(Project project) {
        for (Employee employee : project.getParticipants()) {
            System.out.printf("%s | %s | %.2f | %.2f\n", project.getName(), employee.getPersonalDetails(),
                    project.getSummaryParticipantHours(employee), (project.getSummaryParticipantHours(employee)/project.getSummaryProjectHours()));
        }
    }
}
