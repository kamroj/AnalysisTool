package com.koguty.spocone.datamanagement;

import com.koguty.spocone.analyzing.DataReceiver;
import com.koguty.spocone.commonclasses.Employee;
import com.koguty.spocone.commonclasses.Project;
import com.koguty.spocone.commonclasses.Task;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author Kamil Rojek
 */
public class DataExcelGenerator implements IDataGenerator {
    private DataReceiver dataReceiver;
    private int rowCounter = 1;

    public DataExcelGenerator(DataReceiver dataReceiver) {
        this.dataReceiver = dataReceiver;
    }

    @Override
    public void generateEmployeeBasicRaport() {
        System.out.println("GENERATING EMPLOYEE BASIC XLS RAPORT!");
        HSSFWorkbook workbook = prepareWorkBook("Basic employee raport");
        HSSFSheet sheet = workbook.getSheetAt(0);
        Set<Employee> employeesData = dataReceiver.getEmployeesData();

        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("EMPLOYEE");
        row.createCell(1).setCellValue("TOTAL WORKING HOURS");

        rowCounter = 1;

        for (Employee employee : employeesData) {
            fillBasicEmployeeRaport(employee, sheet);
            rowCounter++;
        }
        saveWoorkbook(workbook, "basic_employee_raport");
    }

    private void fillBasicEmployeeRaport(Employee employee, HSSFSheet sheet) {
        int hoursSummary = 0;

        for (Project project : employee.getProjects()) {
            hoursSummary += project.getSummaryParticipantHours(employee);
        }

        HSSFRow row = sheet.createRow(rowCounter);
        row.createCell(0).setCellValue(employee.getPersonalDetails());
        row.createCell(1).setCellValue(hoursSummary);
    }

    @Override
    public void generateEmployeeAdvancedRaport() {
        System.out.println("GENERATING EMPLOYEE ADVANCED XLS RAPORT!");
        HSSFWorkbook workbook = prepareWorkBook("Advanced employee raport");
        HSSFSheet sheet = workbook.getSheetAt(0);
        Set<Employee> employeesData = dataReceiver.getEmployeesData();

        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("EMPLOYEE");
        row.createCell(1).setCellValue("PROJECT");
        row.createCell(2).setCellValue("TOTAL HOURS");
        row.createCell(3).setCellValue("PERCENT");

        for (Employee employee : employeesData) {
            fillAdvancedEmployeeRaport(employee, sheet);
            rowCounter++;
        }

        saveWoorkbook(workbook, "advanced_employee_raport");
    }

    private void fillAdvancedEmployeeRaport(Employee employee, HSSFSheet sheet) {
        for (Project project : employee.getProjects()) {
            HSSFRow row = sheet.createRow(rowCounter);
            row.createCell(0).setCellValue(employee.getPersonalDetails());
            row.createCell(1).setCellValue(project.getName());
            row.createCell(2).setCellValue(project.getSummaryParticipantHours(employee));
            row.createCell(3).setCellValue(project.getSummaryParticipantHours(employee)/employee.getTotalHoursInAllProject());
            rowCounter++;
        }
    }

    @Override
    public void generateProjectBasicRaport() {
        System.out.println("GENERATING PROJECT BASIC XLS RAPORT!");
        List<Project> projectData = dataReceiver.getProjectData();
        HSSFWorkbook workbook = prepareWorkBook("Basic project raport");

        HSSFSheet sheet = workbook.getSheetAt(0);

        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("PROJECT");
        row.createCell(1).setCellValue("TOTAL WORKING HOURS");

        rowCounter = 1;

        for (Project project: projectData) {
            fillBasicProjectRaport(project, sheet);
            rowCounter++;
        }

        saveWoorkbook(workbook, "basic_project_raport");
    }

    private void fillBasicProjectRaport(Project project, HSSFSheet sheet) {
        int hoursSummary = 0;
        for (Task task : project.getTaskList()) {
            hoursSummary += task.getDuration();
        }

        HSSFRow row = sheet.createRow(rowCounter);
        row.createCell(0).setCellValue(project.getName());
        row.createCell(1).setCellValue(hoursSummary);
    }

    @Override
    public void generateProjectAdvancedRaport() {
        System.out.println("GENERATING PROJECT ADVANCED XLS RAPORT!");
        List<Project> projectData = dataReceiver.getProjectData();
        HSSFWorkbook workbook = prepareWorkBook("Basic project raport");

        HSSFSheet sheet = workbook.getSheetAt(0);

        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("PROJECT");
        row.createCell(1).setCellValue("EMPLOYEE");
        row.createCell(2).setCellValue("TOTAL HOURS");
        row.createCell(3).setCellValue("PERCENT");

        rowCounter = 1;

        for (Project project: projectData) {
            fillAdvancedProjectRaport(project, sheet);
            rowCounter++;
        }

        saveWoorkbook(workbook, "advanced_project_raport");
    }

    private void fillAdvancedProjectRaport(Project project, HSSFSheet sheet) {
        Set<Employee> participants = project.getParticipants();

        for (Employee employee : participants) {
            HSSFRow row = sheet.createRow(rowCounter);
            row.createCell(0).setCellValue(project.getName());
            row.createCell(1).setCellValue(employee.getPersonalDetails());
            row.createCell(2).setCellValue(project.getSummaryParticipantHours(employee));
            row.createCell(3).setCellValue((project.getSummaryParticipantHours(employee)/project.getSummaryProjectHours()));
            rowCounter++;
        }
    }

    private HSSFWorkbook prepareWorkBook(String name) {
        HSSFWorkbook newWorkBook = new HSSFWorkbook();
        newWorkBook.createSheet(name);
        return newWorkBook;
    }

    private void saveWoorkbook(HSSFWorkbook workbook, String workbookName) {
        FileOutputStream output;
        try {
            output = new FileOutputStream(workbookName + ".xls");
            workbook.write(output);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
