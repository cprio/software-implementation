/**
 * Class: Computer Security & Digital Forensics - software implementation
 * Instructor: Maria Boyle
 * Description: Tester for the Customer class
 * Date: 13/11/2017
 * @author Ciaran Roarty
 * @version 1.0
**/

package ie.lyit.hotel;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Person implements Serializable{
	protected Name name;
	protected String address;
	protected String phoneNumber;
	
	// Default Constructor
	// Called when object is created like this
	//	==> Person pObj = new Person();
	//	NOTE-This won't work because person is abstract
	public Person() {
		name=new Name();
		address=phoneNumber=null;
	}
	
	// Initialization Constructor
	// Called when object would have been created like this (not possible because abstract)
	//	++> Person pObj = new Person("Mr","John","Doe","2 High Road, Ennis","087 1231223")
	public Person(String t, String fN, String sN, String address, String phoneNumber) {
		name=new Name(t, fN, sN); //Calls name initialization constructor
		this.address=address;
		this.phoneNumber=phoneNumber;
	}
	
	// toString() method
	// ==> Calls Name's toString() to display name and
	//		then displays address and phoneNumber
	public String toString() {
		return name + ", " + address + ", " + phoneNumber;
	}
	
	//equals() method
	//==> Called when comparing an object with another object, e.g. - 
	//	if(p1.equals(p2))
	// ==> Calls Name's equals() to compare name to personIn's name, and
	//		compares phoneNumber to personIn's phoneNumber
	@Override
	public boolean equals(Object obj) {
		Person pObject;
		if (obj instanceof Person)
			pObject = (Person)obj;
		else
			return false;
	
		return(name.equals(pObject.name) &&
				address.equals(pObject.address) &&
				phoneNumber.equals(pObject.phoneNumber));
	}
	
	// set() and get() methods
	public void setName(Name nameIn) {
		name = nameIn;
	}
	
	public Name getName() {
		return name;
	}
	
	public void setAddress(String addressIn) {
		address = addressIn;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setPhoneNumber(String phoneNumberIn) {
		phoneNumber = phoneNumberIn;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	////////////////////////////////////////////
	// Method Name : read()				      //
	// Return Type : void	 		          //
	// Parameters : None					  //
	// Purpose : Reads a Person from the user //
	////////////////////////////////////////////	
   public void read(){
	   String addressIn, phoneNumberIn;
	   name.read();//call the Name class' read method
	   Scanner kb3 = new Scanner(System.in);
	   System.out.println("Enter Address: ");
	   addressIn = kb3.nextLine();
	   System.out.println("Enter Phone Number: ");
	   phoneNumberIn = kb3.nextLine();

	   boolean goodInput = false;
	   do{		
			try{
				//call the set methods to assign the input to the Person variables
				setAddress(addressIn);
				setPhoneNumber(phoneNumberIn);
				goodInput = true;
			}
			//these won't be hit as the input is treated as Strings
			catch(IllegalArgumentException e){
			   System.out.println("RE-ENTER VALID ARGUMENT FOR Address: ");
			   addressIn = kb3.nextLine();		
			   System.out.println("RE-ENTER VALID ARGUMENT FOR Phone Number: ");
			   phoneNumberIn = kb3.nextLine();	
			}
	   }
	   while(!goodInput);
	}   
	
}
