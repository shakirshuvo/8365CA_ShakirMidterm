package design;

import javafx.scene.layout.Priority;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestingEmployeeInfo {
//    public static void main(String[] args) {
//        //Write Unit Test for all the methods has been implemented in this package.
//        System.out.println("Test Notes: " +
//                "Saw some mistakes in the code so fixed it with after running test. ");
//    }

//    @Test (priority = 0, description = "Testing to see if the constructor is working properly!")
//    public Object testConstructor(){
//        Employee testEmployee = new EmployeeInfo(12, "Namine", 1224.32);
//        Assert.assertEquals(((EmployeeInfo) testEmployee).getEmployeeID(), 12);
//        Assert.assertEquals(testEmployee.employeeName(), "Namine");
//        Assert.assertEquals(testEmployee.calculateSalary(), 1224.32);
//        System.out.println("Test Passed!");
//        return testEmployee;
//    }

    @Test
    public void testingDemo(){
        Employee testEmployeeInfo = new EmployeeInfo(123, "Shakir", 1234.12);
        Assert.assertEquals(testEmployeeInfo.employeeName(),"Shakir");



    }    }
