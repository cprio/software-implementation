/**
* Class: B.Sc. in CSDF
* Instructor:Maria Boyle
* Description: 
* Date:19/09/2017
* @author Ciaran Roarty
* @version 0.1
*/

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
import java.util.*;

public class Name implements Serializable{
	private String title;
	private String firstName;
	private String surname;
		
	public Name (){
		title=firstName=surname=null;
	}
	
	public Name(String t, String fN, String sN) {
		this.title=t;
		this.firstName=fN;
		this.surname=sN;
	}
	
	//toString method
	//==> Called when a String of the class is used, e.g. -
	//	System.out.print(n1);
	//	or System.out.print(n1.toString());
	public String toString() {
		return title + ". " + firstName + " " + surname;
	}
	
	//equals() method
	//==> Called when comparing an object with another object, e.g. - 
	//	if(n1.equals(n2))
	@Override
	public boolean equals(Object obj) {
		Name nObject;
		if (obj instanceof Name)
			nObject = (Name)obj;
		else
			return false;
		
		return this.title.equals(nObject.title)
				&& this.firstName.equals(nObject.firstName)
				&& this.surname.equals(nObject.surname);
	}
	
	//get methods -- Accessor Methods
	//==> Called when retrieving part of an object, e.g. - 
	//	if(n1.getSurname().equals(n2.getSurname())
	public String getTitle() {
		return title;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getSurname() {
		return surname;
	}
	
	
	//set methods -- Mutator Methods -- void where nothing to return
	//==> Called when setting part of an object to a value, e.g. - 
	// 	n1.setTitle("Mrs");
	//	n1.setFirstName("Marge");
	//	n1.setSurname("Simpson");
	public void setTitle(String setTitleTo) {
		title=setTitleTo;
	}
	
	public void setFirstName(String setFirstNameTo) {
		firstName = setFirstNameTo;
	}
	
	public void setSurname(String setSurnameTo) {
		surname = setSurnameTo;
	}
	
	public boolean isFemale() {
		if(title.equalsIgnoreCase("Miss") || 
			title.equalsIgnoreCase("Ms") || 
			title.equalsIgnoreCase("Mrs"))
			return true;
		else
			return false;
	}
	
	public void read(){
		Scanner kb1 = new Scanner(System.in);//call the scanner for input
		String titleIn, firstNameIn, surNameIn;//create string variables for input data
		do{ 
			System.out.println("NAME ==> ");	
			System.out.println("TITLE: "); 
			titleIn = kb1.nextLine();
			System.out.println("FIRST NAME : ");
			firstNameIn = kb1.nextLine();
			System.out.println("SURNAME : ");
			surNameIn = kb1.next();
		}
		while(!kb1.hasNextLine());
		
		boolean goodInput = false;
			do{		
				try{//call the set methods to assign the input to the Name variables
					setTitle(titleIn);
					setFirstName(firstNameIn);
					setSurname(surNameIn);								
					goodInput = true;
				}
				//these are not going to be hit as everything entered by the user is treated as a String
				catch(IllegalArgumentException e){
				   System.out.println("INVALID ARGUMENT PASSED FOR NAME");
				   System.out.println(e);
				   System.out.println("RE-ENTER VALID ARGUMENT FOR TITLE : ");
				   titleIn = kb1.nextLine();
				   System.out.println("RE-ENTER VALID ARGUMENT FOR FIRST NAME : ");
				   firstNameIn = kb1.nextLine();
				   System.out.println("RE-ENTER VALID ARGUMENT FOR SURNAME : ");
				   surNameIn = kb1.nextLine();				
				}
			}while(!goodInput);

		}
}
