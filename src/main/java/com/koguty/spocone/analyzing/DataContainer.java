package com.koguty.spocone.analyzing;

import com.koguty.spocone.Employee;
import com.koguty.spocone.Project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Kamil Rojek
 */
public class DataContainer implements DataReceiver{
    private Set<Employee> employees;
    private List<Project> projects;

    DataContainer() {
        this.employees = new HashSet<>();
        this.projects = new ArrayList<>();
    }

    void addEmployee(Employee employee) {
        employees.add(employee);
    }

    void addProject(Project project) {
        if(projects.contains(project))
            return;
        projects.add(project);
    }

    @Override
    public Set<Employee> getEmployeesData() {
        return employees;
    }

    @Override //todo zrobienie logiki
    public List<Project> getProjectData() {
        return projects;
    }

    public boolean hasProject(String sheetName) {
        return projects.stream().anyMatch(p -> p.getName().equals(sheetName));
    }

    public Project getSpecificProject(String sheetName) {
        return projects.stream().filter(p -> p.getName().equals(sheetName)).findFirst().get();
    }
}