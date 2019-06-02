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

    }

    @Override
    public void generateEmployeeAdvancedRaport() {
        System.out.println("GENERATING EMPLOYEE RAPORT!");
        Set<Employee> employeesData = dataReceiver.getEmployeesData();

        for (Employee employee : employeesData) {
            printEmployeeRaport(employee);
        }
    }

    @Override
    public void generateProjectBasicRaport() {

    }

    private void printEmployeeRaport(Employee employee) {
        System.out.printf("\nEmployee: %s \n", employee.getPersonalDetails());
        for (Project project : employee.getProjects()) {
            System.out.printf("Project: %s Total hours: %s\n", project.getName(),
                                                                  project.getSummaryParticipantHours(employee));
        }
    }

    @Override
    public void generateProjectAdvancedRaport() {
        System.out.println("GENERATING PROJECT RAPORT!");
        List<Project> projectData = dataReceiver.getProjectData();

        for (Project project: projectData) {
            printProjectRaport(project);
        }
    }

    private void printProjectRaport(Project project) {
        System.out.printf("\nProject: %s\n\n", project.getName());
        for (Task task : project.getTaskList()) {
            System.out.println("Task: " + task.getTaskDescription());
            System.out.println("Done by: " + task.getTaskContractor().getPersonalDetails());
            System.out.println("Date: " + task.getDate());
            System.out.printf("In %.2f hours\n\n", task.getDuration());
        }
    }
}
