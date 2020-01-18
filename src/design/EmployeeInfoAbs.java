package design;

import java.util.Scanner;

public abstract class EmployeeInfoAbs implements Employee{
    @Override
    public int employeeId() {
        return 0;
    }

    @Override
    public String employeeName() {
        return "Azelf";
    }
    //assignDepartment() will assign employee to departments
    @Override
    public void assignDepartment() {
        System.out.println("What is the job position for this employee?");
        Scanner sc = new Scanner(System.in);
        String position = sc.nextLine();
    }

    @Override
    public double calculateSalary() {
        return 0;
    }

    public void  goodBye(){
        System.out.println("We hope you have a wonderful future. Please visit our website to get updates on the company!");
    }

}
