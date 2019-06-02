package com.koguty.spocone.analyzing;

import com.koguty.spocone.commonclasses.Employee;
import com.koguty.spocone.commonclasses.Project;

import java.util.List;
import java.util.Set;

/**
 * @author Kamil Rojek
 */
public interface DataReceiver {
    Set<Employee> getEmployeesData();
    List<Project> getProjectData();
}
