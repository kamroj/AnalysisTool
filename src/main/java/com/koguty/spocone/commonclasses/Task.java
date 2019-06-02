package com.koguty.spocone.commonclasses;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private String description;
    private Employee contractor;
    private float duration;
    private String date;

    public  Task(String description, Employee contractor, float duration, Date date) {
        this.description = description;
        this.contractor = contractor;
        this.duration = duration;
        this.date = convertDateToProperString(date);
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

    public String getDate() {
        return date;
    }

    private String convertDateToProperString(Date date) {
        if (date == null)
            return "";
        SimpleDateFormat convert = new SimpleDateFormat("MM/dd/yyyy");
        return convert.format(date);
    }
}
