package com.koguty.spocone.analyzing;

import com.koguty.spocone.Employee;
import com.koguty.spocone.Project;

import java.util.List;
import java.util.Set;

/**
 * @author Kamil Rojek
 */
public interface DataReceiver {
    Set<Employee> getEmployeesData();
    List<Project> getProjectData();
}
