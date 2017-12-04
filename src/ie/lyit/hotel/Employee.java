/**
 * Class: Computer Security & Digital Forensics - software implementation
 * Instructor: Maria Boyle
 * Description: Employee Class for the Hotel package
 * Date: 03/10/2017
 * @author Ciaran Roarty
 * @version 1.0
**/

package ie.lyit.hotel;

public class Employee extends Person implements Payable{//INHERITANCE - Employee IS-A Person
	// Employee has a name, address, & phoneNumber from Person
	private Date startDate;			// AND startDate
	private Date dateOfBirth;		// AND dateOfBirth
	private double salary;			// AND salary
	private int number;				// AND number
	
	private static int nextNumber=500001;// static for a unique number - starts off at 500001
	private final double MAX_SALARY = 150000.00; //final for a constant
	
	// Default Constructor
	// Called when object is created like this ==>
	// 	Customer cObj = new Customer();
	public Employee() {
		super();		// NOTE: Don't need to call super() explicitly
		salary=0.00;
		number=nextNumber++;
	}
	
	// Initialization Constructor
	// Called when object is created like this ==>
	//	Employee eObj = new Employee("Mr","John","Doe","123 High Road, Ennis","087 111 2223",23430.00, 01, 03, 2017, new Date(19, 06, 1993));
	// NOTE: For dob and startDate you can either pass in a d,m,y OR a date object
	//		To show this, I have done startDate as d,m,y, and dateOfBirth as a Date object
	public Employee(String t, String fN, String sN, String address, String pNo, double salary, int d, int m, int y, Date dateOfBirth) {
		super(t, fN, sN, address, pNo);
		this.salary=salary;
		this.startDate= new Date(d,m,y);
		this.dateOfBirth=dateOfBirth;
		number = nextNumber++;
	}

	// OVERRIDING the Person toString() method
	// Calling Persons toString() method
	@Override
	public String toString() {
		return super.toString() + " Employee number: " + number;
	}
	
	// equals() method
	// ==> Called when comparing an object with another object,
	//		e.g. - if(c1.equals(c2))
	// ==> Probably sufficient to compare employee numbers as they're unique
	@Override
	public boolean equals(Object obj) {
		Employee eObject;
		if(obj instanceof Employee)
			eObject = (Employee)obj;
		else
			return false;
		
		return(this.number==eObject.number);
	}
	
	// set() and get() methods for Start Date
	public void setStartDate(Date startDate) {
		this.startDate=startDate;

	}
	public Date getStartDate() {
		return startDate;
	}
	
	// set() and get() methods for Date of Birth
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth=dateOfBirth;

	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	// set() and get() methods for Salary
	public void setSalary(double salary) {
		this.salary=salary;

	}
	public double getSalary() {
		return salary;
	}	
	
	// You shouldn't be able to setNumber() as it is unique,
	// so don't provide a setNumber method
	public int getNumber() {
		return number;
	}

	public Date getDateProbationEnds(int noDaysProbation) {
		Date dateProbationEnds = startDate;
		
		dateProbationEnds.setDay(dateProbationEnds.getDay()+noDaysProbation);
		
		return dateProbationEnds;
	}
	
	@Override
	public double calculateWage(double taxPercentage) {
		// TODO Auto-generated method stub
		double wage = (salary / 12) * ((100-taxPercentage)/100);
		return wage;
	}

	@Override
	public double incrementSalary(double incrementAmount) {
		// TODO Auto-generated method stub
		if(salary+incrementAmount > MAX_SALARY) {
			return salary;
		}
		else {
			return salary+=incrementAmount;
		}
		
	}
	
}