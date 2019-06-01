package com.koguty.spocone.analyzing;

import com.koguty.spocone.Employee;
import com.koguty.spocone.InvalidWorkingDataException;
import com.koguty.spocone.Project;
import com.koguty.spocone.Task;
import com.koguty.spocone.pather.IPather;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Kamil Rojek
 */
public class Analizer {
    private final int WORKING_HOURS_CELL = 2;
    private final int TASK_DESCRIPTION_CELL = 1;

    private DataContainer dataContainer;
    private List<String> paths;
    private HSSFWorkbook workbook;
    private Employee employee;


    Analizer() { //todo usunąć tylko do debug
        this.dataContainer = new DataContainer();
        paths = new ArrayList<>(Arrays.asList("Kowalski_Jan.xls", "Nowak_Piotr.xls", "target/Kowalski_Jan.xls"));
    }

    public Analizer(IPather pather) {
        this.dataContainer = new DataContainer();
        paths = pather.getPatchList();
    }

    public DataContainer prepareData() {
        for (String path : paths) {
            initializeEmployee(path);
            initializeWorkbook(path);
        }
        return dataContainer;
    }

    private void initializeEmployee(String path) {
        File file = new File(path);
        String[] split = file.getName().split("\\.");
        String fullName = split[0].replace("_", " ");
        employee = new Employee(fullName);
    }

    private void iterateWorkbook() {
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            getDataFromSheet(workbook.getSheetAt(i));
        }
    }

    private void getDataFromSheet(HSSFSheet sheet) {
        int lastRowNum = sheet.getLastRowNum();
        int currentRowNumber = 1;

        Project project = generateProject(sheet.getSheetName());
        iterateThroughSheet(sheet, lastRowNum, currentRowNumber, project);

        try {
            updateData(project);
        } catch (InvalidWorkingDataException e) {
            e.printStackTrace();
        }
    }

    private Project generateProject(String sheetName) {
        return dataContainer.hasProject(sheetName) ?
                dataContainer.getSpecificProject(sheetName) : new Project(sheetName);
    }

    private void updateData(Project project) throws InvalidWorkingDataException {
        employee.updateWorkingData(project);
        dataContainer.addEmployee(employee);
        dataContainer.addProject(project);
    }

    private void iterateThroughSheet(HSSFSheet sheet, int lastRowNum, int currentRowNumber, Project project) {
        while (currentRowNumber <= lastRowNum) {
            if (!isRowCorrect(sheet, currentRowNumber)) {
                ++currentRowNumber;
                continue;
            }

            try {
                float hours = (float) sheet.getRow(currentRowNumber).getCell(WORKING_HOURS_CELL).getNumericCellValue();
                String taskDescription = sheet.getRow(currentRowNumber).getCell(TASK_DESCRIPTION_CELL).getStringCellValue();
                Task task = new Task(taskDescription, employee, hours);
                project.addTask(task);
                ++currentRowNumber;
            } catch (IllegalStateException e) {
                System.out.println("Dupa");
                ++currentRowNumber;
                continue;
            }
        }
    }

    private boolean isRowCorrect(HSSFSheet sheet, int currentRowNumber) {
        return sheet.getRow(currentRowNumber) != null &&
                sheet.getRow(currentRowNumber).getCell(WORKING_HOURS_CELL) != null &&
                sheet.getRow(currentRowNumber).getCell(TASK_DESCRIPTION_CELL) != null;
    }

    private void initializeWorkbook(String path) {
        try (FileInputStream file = new FileInputStream(path)) {
            workbook = new HSSFWorkbook(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        iterateWorkbook();
    }

    public static void main(String[] args) {
        Analizer analizer = new Analizer();
        DataContainer container = analizer.prepareData();
        for (Employee employee : container.getEmployeesData()) {
            System.out.println("\nEMPLOYEE NAME:: " + employee.getPersonalDetails());
            Map<Project, Float> summaryHoursPerProject = employee.getSummaryHoursPerProject();

            for (Project project : summaryHoursPerProject.keySet()) {
                System.out.println("PROJECT NAME:: " + project.getName());
                System.out.println("SUMMARY HOURS:: " + summaryHoursPerProject.get(project));
            }
        }

        List<Project> projectData = container.getProjectData();
        for (Project project : projectData) {
            for (Task task : project.getTaskList()) {
                System.out.println(project.getName() + " " + task.getTaskDescription());
            }
        }
    }
}
