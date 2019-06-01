package com.koguty.spocone.analyzing;

import com.koguty.spocone.Employee;
import com.koguty.spocone.Project;

import java.util.Set;

/**
 * @author Kamil Rojek
 */
public interface DataReceiver {
    Set<Employee> getEmployeesData();
    Set<Project> getProjectData();
}
