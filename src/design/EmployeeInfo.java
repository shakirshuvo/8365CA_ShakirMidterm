package design;

import java.util.Scanner;

public class EmployeeInfo extends EmployeeInfoAbs{

	/*This class can be implemented from Employee interface then add additional methods in EmployeeInfo class.
	 * Also, Employee interface can be implemented into an abstract class.So create an Abstract class
	 * then inherit that abstract class into EmployeeInfo class.Once you done with designing EmployeeInfo class,
	 * go to FortuneEmployee class to apply all the fields and attributes.
	 *
	 * Important: YOU MUST USE the
	 * OOP(abstraction,Encapsulation, Inheritance and Polymorphism) concepts in every level possible.
	 * Use all kind of keywords(super,this,static,final........)
	 * Implement Nested class.
	 * Use Exception Handling.
	 *
	 */

	/*
	 * declare few static and final fields and some non-static fields
	 */

	public final static String companyName = "ShakSoft";
	private static double salary;
	private int employeeID;
	private  String employeeName;
	private int yearsWorked;

	//overriding the abs method
	@Override
	public String employeeName() {
		return this.employeeName;
	}
	//overridding abs salary
	@Override
	public double calculateSalary() {
		return this.salary;
	}

	public int getEmployeeID(){
		return this.employeeID;
	}

	public static double getSalary() {
		return salary;
	}

	public void updateSalary(double newSalary) {
		this.salary = newSalary;
	}

	/*
	 * You must implement the logic for below 2 methods and
	 * following 2 methods are prototype as well for other methods need to be design,
	 * as you will come up with the new ideas.
	 */

	/*
	 * you must have multiple constructor.
	 * Must implement below constructor.
	 */
	//Must use this constructor
	public EmployeeInfo(int employeeId, String name, double salary){
		this.employeeID = employeeId;
		this.employeeName = name;
		this.salary = salary;
		System.out.println("Welcome to "+ companyName +" " + name +"!");
	}

	/*
	 * This methods should calculate Employee bonus based on salary and performance.
	 * Then it will return the total yearly bonus. So you need to implement the logic.
	 * Hints: 10% of the salary for best performance, 8% of the salary for average performance and so on.
	 * You can set arbitrary number for performance.
	 * So you probably need to send 2 arguments.
	 *
	 */
	public double calculateEmployeeBonus(double salary, String performance){
		double total=0;
		if(performance.equalsIgnoreCase( "best")){
			total = (salary * .1) + salary;
			System.out.println("Amazing! Keep up the fantastic work!.");
			System.out.println("Your total salary with bonus this year is: " + total);
			return total;
		}else if(performance.equalsIgnoreCase("average")){
			total = (salary * .08) + salary;
			System.out.println("Great JOb this year.");
			System.out.println("Your total salary with bonus this year is: " + total);
			return total;
		}else if(performance.equalsIgnoreCase("good")){
			total = (salary * .05) + salary;
			System.out.println("Good JOb this year.");
			System.out.println("Your total salary with bonus this year is: " + total);
			return total;
		}else{
			total += salary;
			System.out.println("Try harder next year!");
			System.out.println("Your total salary this year is: " + total);
			return total;
		}
	}

	/*
	 * This methods should calculate Employee Pension based on salary and numbers of years with the company.
	 * Then it will return the total pension. So you need to implement the logic.
	 * Hints: pension will be 5% of the salary for 1 year, 10% for 2 years with the company and so on.
	 *
	 */
	public double calculateEmployeePension(double salary){
		double total=0;
		Scanner sc  = new Scanner(System.in);
		System.out.println("Please enter start date in format (example: May,2015): ");
		String joiningDate = sc.nextLine();
		System.out.println("Please enter today's date in format (example: August,2017): ");
		String todaysDate = sc.nextLine();
		String convertedJoiningDate = DateConversion.convertDate(joiningDate);
		String convertedTodaysDate = DateConversion.convertDate(todaysDate);

		//implement numbers of year from above two dates
		String startYear = convertedJoiningDate.substring(convertedJoiningDate.length()-4);
		String endYear = convertedTodaysDate.substring(convertedTodaysDate.length() -4);
		int yearsInTotal = Integer.parseInt(endYear) - Integer.parseInt(startYear);
		yearsWorked = yearsInTotal;
		//Calculate pension 1 -5, 2- 10, 3-15, 4- 20,
		if(yearsInTotal>=5){
			total = salary + (salary * (.25));
		}else if(salary ==4){
			total = salary + (salary * (.15));
		}else if(salary ==3){
			total = salary + (salary * (.10));
		}else if(salary ==2){
			total = salary + (salary * (.5));
		}
		return salary;
	}

	@Override
	public void yearsWorked() {
		String yearsWorked = String.valueOf(this.yearsWorked);
	}

	@Override
	public void benefitLayout() {
		int yearsWorked = this.yearsWorked;

		if (yearsWorked < 3) {
			System.out.println("Sorry you don't get benefits, not enough years worked in our company.");
		} else {
			System.out.println("You will get benefits for the years of services in our company!");
		}
	}

	private static class DateConversion {
		//constructor
		public DateConversion(Months months){}
		//return format ex: 1/2019
		public static String convertDate(String date) {
			String [] extractMonth = date.split(",");
			String givenMonth = extractMonth[0];
			int monthDate = whichMonth(givenMonth);
			String actualDate = monthDate + "/" + extractMonth[1];
			return actualDate;
		}
		//months converted to month value
		public static int whichMonth(String givenMonth) {
			Months months = Months.valueOf(givenMonth);
			int date;
			switch (months) {
				case January:
					date = 1;
					break;
				case February:
					date = 2;
					break;
				case March:
					date = 3;
					break;
				case April:
					date = 4;
					break;
				case May:
					date = 5;
					break;
				case June:
					date = 6;
					break;
				case July:
					date = 7;
					break;
				case August:
					date = 8;
					break;
				case September:
					date = 9;
					break;
				case October:
					date = 10;
					break;
				case November:
					date = 11;
					break;
				case December:
					date = 12;
					break;
				default:
					date = 0;
					break;
			}
			return date;

		}
	}
}
