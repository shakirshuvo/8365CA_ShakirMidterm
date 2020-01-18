package math.problems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestingMath {
    //in testing class a main method is unnecessary...testing class will run without main()
//    public static void main(String[] args) {
//        //Apply Unit testing into each classes and methods in this package.
//    }

    //creating a testing space <----------- Unnecessary but wanted to do it for future reference
    //the @Test is a testng keyword used to say its a testing field
    //the lower priority = seniority when running <--- can have negative value
    ///description is used to show tell us the description of the test
    @Test(priority = -1, description = "description of the package")
    public void testMessage() {
        System.out.println("This is testing class for the package math.problems");
    }
    //Testing Factorial
    @Test(priority = 1, description = "testing the findFactorial() from Factorial class")
    public void testFactorial() {
        Assert.assertEquals(Factorial.findFactorialUsingRecursion(5), 120);
    }
    //Testing FindMissingNumber
    @Test(priority = 2, description = "testing the missingNum() from FindMissingNumber class")
    public void testFindMissingNumber() {
        //Testing FindMissingNumber <--- should be 10
        int[] array = new int[]{9, 2, 1, 4, 5, 3, 7, 8, 6};
        Assert.assertEquals(FindMissingNumber.findMissingNumber(array), 10);
    }


}
