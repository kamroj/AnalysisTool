package com.koguty.spocone.commonclasses;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Kamil Rojek
 */
public class Project {
    private String name;
    private List<Task> taskList;

    public Project(String name) {
        this.name = name;
        taskList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Set<Employee> getParticipants() {
        return taskList.stream()
                .map(Task::getTaskContractor)
                .collect(Collectors.toSet());
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public Float getSummaryParticipantHours(Employee employee) {
        float hours = 0;
        for (Task task : taskList) {
            if (task.getTaskContractor().equals(employee))
                hours += task.getDuration();
        }
        return hours;
    }

    public Float getSummaryProjectHours() {
        float hours = 0;
        for (Task task : taskList) {
            hours += task.getDuration();
        }
        return hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
