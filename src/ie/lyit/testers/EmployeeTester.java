/**
 * Class: Computer Security & Digital Forensics
 * Instructor: Maria Boyle
 * Description: Tester for the Employee class
 * Date: 10/10/2017
 * @author Ciaran Roarty
 * @version 1.0
**/
package ie.lyit.testers;

import java.util.ArrayList;

import ie.lyit.hotel.*;

public class EmployeeTester {

	public static void main(String[] args) {
		//Create an Employee object called personA
		Employee employeeA = new Employee();
		
		employeeA.setName(new Name("Mr", "Ciaran", "Roarty"));
		employeeA.setAddress("123 Main Street, Letterkenny");
		employeeA.setPhoneNumber("087 2171717");
		employeeA.setDateOfBirth(new Date(12, 1, 1973));
		employeeA.setStartDate(new Date(05, 17, 2017));
		employeeA.setSalary(60000);
		
		System.out.println(employeeA);
		
		//Create a Name object called personB
		Employee employeeB = new Employee("Mr","John","Doe","123 High Road, Ennis","087 111 2223",23430.00, 01, 03, 2017, new Date(19, 06, 1993));
		
		//display personB's details on screen
		System.out.println(employeeB);
		
		System.out.println("IsEqual Check One: ");
		if(employeeA.equals(employeeB))
			System.out.println(employeeA + "\n is the same as \n" + employeeB);
		else
			System.out.println(employeeA + "\n is not the same as \n" + employeeB);

		// An ArrayList of Employees
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(employeeA);
		employees.add(employeeB);
		employees.add(new Employee("Mr","CM","Burns","123 High Road, Tralee","087 555 1234",23430.00, 03, 10, 2017, new Date(9, 04, 1974)));
		employees.add(new Employee("Mrs","Marge","Simpson","742 Evergreen Terrace","087 545 3210",69430.00, 05, 12, 2017, new Date(31, 07, 1951)));
		employees.trimToSize();
		
		
		for(Employee tempName:employees)
			System.out.println(tempName);
		
		if(employeesSearch(employeeA, employees))
				System.out.println("Found!");
		else
				System.out.println("Not Found!");
		
		if(employeesSearch(employeeB, employees))
			System.out.println("Found!");
		else
			System.out.println("Not Found!");
	}
	
	public static boolean employeesSearch(Employee employeesSearch, ArrayList<Employee>listOfEmployees){
			for (Employee currentEmployee:listOfEmployees)
				if(currentEmployee.equals(employeesSearch)) {
					return true;
			}
			return false;
		}
		
		
	}