package com.koguty.spocone;

public class Task {
    private String description;
    private Employee contractor;
    private float duration;

    public  Task(String description, Employee contractor, float duration) {
        this.description = description;
        this.contractor = contractor;
        this.duration = duration;
    }

    public String getTaskDescription() {
        return description;
    }

    public Employee getTaskContractor() {
        return contractor;
    }

    public float getDuration() {
        return duration;
    }
}
