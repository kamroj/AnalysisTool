package com.koguty.spocone.commonclasses;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EmployeeTest {
    private Employee employee;

    @BeforeMethod
    private void setUp() {
        employee = new Employee("Zbyszek Pal");
    }

    @Test
    public void testCreatingEmployee_nameKamilRojek_returnEqual(){
        //Arrange
        Employee employee = new Employee("Kamil Rojek");
    
        //Act
        String personalDetails = employee.getPersonalDetails();

        //Assert
        assertEquals(personalDetails, "Kamil Rojek");
    }

    @Test
    public void testUpdateProject_WhenProjectIsValid_getProjectsReturn1() throws InvalidWorkingDataException {
        //Arrange
        Project project = new Project("ALFA");

        //Act
        employee.updateProject(project);

        //Assert
        assertEquals(1, employee.getProjects().size());
    }

    @Test(expectedExceptions = InvalidWorkingDataException.class)
    public void testUpdateProject_whenProjectIsNull_throwException() throws InvalidWorkingDataException {
        //Arrange
        Project project = null;

        //Act
        employee.updateProject(project);
    }
}