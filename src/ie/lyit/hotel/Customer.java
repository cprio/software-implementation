/**
 * Class: Computer Security & Digital Forensics - software implementation
 * Instructor: Maria Boyle
 * Description: Customer Class for the Hotel package
 * Date: 13/11/2017
 * @author Ciaran Roarty
 * @version 1.0
**/

package ie.lyit.hotel;

import java.io.*;
import java.util.*;

public class Customer extends Person implements Serializable {//INHERITANCE - Customer IS-A Person
	// Customer has a name, address, & phoneNumber from Person
	private String emailAddress;	// AND emailAddress
	private static int CustNumber;				// AND number
		
	//private static int nextNumber=500001;// static for a unique number - starts off at 500001
	
	// Default Constructor
	// Called when object is created like this ==>
	// 	Customer cObj = new Customer();
	public Customer() {
		super();		// NOTE: Don't need to call super() explicitly
		emailAddress=null;
		//CustNumber=nextNumber++;
	}
	
	// Initialization Constructor
	// Called when object is created like this ==>
	//	Customer cObj = new Customer("Mr","John","Doe","123 High Road, Ennis","087 111 2223","jdoe@fakemail.com",);
	public Customer(String t, String fN, String sN, String address, String pNo, String emailAddress) {
		//Call super class constructor - Passing parameters required by Person 
		super(t, fN, sN, address, pNo); 
		//and then initialize Customers own instance variables
		this.emailAddress=emailAddress;
		//And finally set number to static nextNumber before incrementing nextNumber
		//CustNumber=nextNumber++;
	}
	
	// OVERRIDING the Person toString() method
	// Calling Persons toString() method
	@Override
	public String toString() {
		return super.toString() + ", " + emailAddress + ", " + CustNumber;
	}
	
	// equals() method
	// ==> Called when comparing an object with another object,
	//		e.g. - if(c1.equals(c2))
	// ==> Probably sufficient to compare customer numbers as they're unique
	@Override
	public boolean equals(Object obj) {
		Customer cObject;
		if(obj instanceof Customer)
			cObject = (Customer)obj;
		else
			return false;
		
		return(this.CustNumber==cObject.CustNumber);
	}
	
	// set() and get() methods for e-mail address
	public void setEmailAddress(String emailAddress) {
		this.emailAddress=emailAddress;

	}
	public String getEmailAddress() {
		return emailAddress;
	}
	// You shouldn't be able to setNumber() as it is unique,
	// so don't provide a setNumber method
	public static void setCustNumber(int custNumber) {
		CustNumber = custNumber;
	}
	
	public int getCustNumber() {
		return CustNumber;
	}
	
	//////////////////////////////////////////////
	// Method Name : read()					    //
	// Return Type : void		 		        //
	// Parameters : None					    //
	// Purpose : Reads a Customer from the user //
	//////////////////////////////////////////////	
   public void read(){
	   //create a string for the e-mail address input
	   String emailAddressIn="";
	   //call the super class' read methods - Person & Name classes
	   super.read();
	   //scanner to read user e-mail input
	   Scanner kb2 = new Scanner(System.in);
	   //user instruction
	   System.out.println("Enter e-mail: ");
	   //read the user input and assign to email address input variable
	   emailAddressIn = kb2.nextLine();
	   //create boolean as false - until good input is received
	   boolean goodInput = false;
	   //do this loop until input is good
	   do{		
			try{
				//call the setEmailAddress method using the user input data
				setEmailAddress(emailAddressIn);
				//set goodInput to true if this is accepted
				goodInput = true;
			}
			//catch any Illegal Argument Exception - this won't be hit as all input are strings
			catch(IllegalArgumentException e){
				//let the user know about it and offer change to re-enter the e-mail address
			   System.out.println("RE-ENTER VALID ARGUMENT FOR E-MAIL: ");
			   emailAddressIn = kb2.nextLine();		
			}
	   }
	   //once goodInput is true the loop will break
	   while(!goodInput);
   	}
}

