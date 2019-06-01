package com.koguty.spocone.analyzing;

import com.koguty.spocone.Employee;
import com.koguty.spocone.InvalidWorkingDataException;
import com.koguty.spocone.Project;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author Kamil Rojek
 */
class Analizer {
    private final int WORKING_HOURS_CELL = 2;

    private DataContainer dataContainer;
    private IPather pather;
    private List<String> paths;
    private HSSFWorkbook workbook;
    private Employee employee;


    Analizer() { //todo usunąć tylko do debug
        this.dataContainer = new DataContainer();
        paths = new ArrayList<>(Arrays.asList("Kowalski_Jan.xls", "Nowak_Piotr.xls"));
    }

    Analizer(IPather pather) {
        this.dataContainer = new DataContainer();
        this.pather = pather;
    }


    void prepareData() {
        for (String path : paths) {
            initializeWorkbook(path);
            employee = new Employee(path); //todo zrobić regex który tylko zwroci imie
            iterateWorkBook();
        }
    }

    private void iterateWorkBook() {
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            getDataFromSheet(workbook.getSheetAt(i));
        }

    }

    private void getDataFromSheet(HSSFSheet sheet) {
        int lastRowNum = sheet.getLastRowNum();
        int currentRowNumber = 1;
        Project project = new Project(sheet.getSheetName());

        while(currentRowNumber <= lastRowNum) {
            float hours = (float) sheet.getRow(currentRowNumber).getCell(WORKING_HOURS_CELL).getNumericCellValue();
            try {
                employee.updateWorkingData(project, hours);
                dataContainer.updateEmplyeesData(employee);
            } catch (InvalidWorkingDataException e) {
                e.printStackTrace();
            }
            ++currentRowNumber;
        }
    }

    private void initializeWorkbook(String path) {
        try (FileInputStream file = new FileInputStream(path)) {
            workbook = new HSSFWorkbook(file);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
