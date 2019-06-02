package com.koguty.spocone.commonclasses;

import java.util.*;

/**
 * @author Kamil Rojek
 */
public class Employee {
    private String personalDetails;
    private Set<Project> projects;

    public Employee(String personalDetails) {
        this.personalDetails = personalDetails;
        projects = new HashSet<>();
    }

    public String getPersonalDetails() {
        return personalDetails;
    }

    public void updateProject(Project project) throws InvalidWorkingDataException {
        if (project == null)
            throw new InvalidWorkingDataException("Invalid working Data");
        projects.add(project);
    }

    public Set<Project> getProjects() {
        return projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(personalDetails, employee.personalDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personalDetails);
    }
}
