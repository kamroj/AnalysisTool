package com.koguty.spocone.datamanagement;

import com.koguty.spocone.Employee;
import com.koguty.spocone.Project;
import com.koguty.spocone.Task;
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
    public void generateEmployeeRaport() {
        System.out.println("GENERATING EMPLOYEE RAPORT!");
        Set<Employee> employeesData = dataReceiver.getEmployeesData();

        for (Employee employee : employeesData) {
            printEmployeeRaport(employee);
        }
    }

    private void printEmployeeRaport(Employee employee) {
        System.out.printf("\nEmployee: %s \n", employee.getPersonalDetails());
        for (Project project : employee.getProjects()) {
            System.out.printf("Project: %s Total hours: %s\n", project.getName(),
                                                                  project.getSummaryParticipantHours(employee));
        }
    }

    @Override
    public void generateProjectRaport() {
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
            System.out.printf("In %.2f hours\n\n", task.getDuration());
        }
    }
}
