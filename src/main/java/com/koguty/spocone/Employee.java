package com.koguty.spocone;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kamil Rojek
 */
public class Employee {
    private String personalDetails;
    private Map<Project, Float> workingData;

    public Employee(String personalDetails) {
        this.personalDetails = personalDetails;
        workingData = new HashMap<>();
    }

    public String getPersonalDetails() {
        return personalDetails;
    }

    public void updateWorkingData(Project project, float workedHours) throws InvalidWorkingDataException {
        if (project == null || workedHours <= 0)
            throw new InvalidWorkingDataException("Invalid working Data");

        if (workingData.containsKey(project)) {
            Float hours = workingData.get(project);
            hours += workedHours;
            workingData.put(project, hours);
        } else {
            workingData.put(project, workedHours);
        }
    }

    public Map<Project, Float> getWorkingData() {
        return workingData;
    }
}
