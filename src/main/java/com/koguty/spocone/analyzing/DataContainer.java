package com.koguty.spocone.analyzing;

import com.koguty.spocone.Employee;
import com.koguty.spocone.Project;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Kamil Rojek
 */
class DataContainer implements DataReceiver{
    private Set<Employee> employees;
    private Set<Project> projects;

    DataContainer() {
        this.employees = new HashSet<>();
        this.projects = new HashSet<>();
    }

    void updateEmplyeesData(Employee employee) {
        employees.add(employee);
    }

    @Override
    public Set<Employee> getEmployeesData() {
        return employees;
    }

    @Override //todo zrobienie logiki
    public Set<Project> getProjectData() {
        return projects;
    }
}