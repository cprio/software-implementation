/**
 * Class: Computer Security & Digital Forensics
 * Instructor: Maria Boyle
 * Description: Tester for the Name class
 * Date: 28/09/2017
 * @author Ciaran Roarty
 * @version 1.0
**/

package ie.lyit.testers;
import ie.lyit.hotel.*;
import java.util.*;

public class NameTester {
	public static void main(String[] args) {
		//Create a name object called personA
		Name personA = new Name();
		
		// display personA's details on screen
		System.out.println(personA);
		
		personA.setTitle("Mr");
		personA.setFirstName("Ciaran");
		personA.setSurname("Roarty");
		
		System.out.println(personA);
		
		//Create a Name object called personB
		Name personB = new Name("Ms", "Jane", "Doe");
		
		//display personB's details on screen
		System.out.println(personB);

		System.out.println("IsEqual Check One: ");
		if(personA.equals(personB))
			System.out.println(personA + "is the same as " + personB);
		else
			System.out.println(personA + "is not the same as " + personB);
		
		System.out.println("Check person B is female:");
				if(personB.isFemale())
					System.out.println(personB + " is female.");
				else
					System.out.println(personB + " is not female.");
		
		personB.setTitle("Mr");
		personB.setFirstName("Joe");
		personB.setSurname("Bloggs");
		
		System.out.println("IsEqual Check Two:");
		if(personA.equals(personB))
			System.out.println(personA + "is the same as " + personB);
		else
			System.out.println(personA + "is not the same as " + personB);

		System.out.println("Check person B is female:");
		if(personB.isFemale())
			System.out.println(personB + " is female.");
		else
			System.out.println(personB + " is not female.");
		
		ArrayList<Name> names = new ArrayList<Name>();
		names.add(new Name("Mr","Charles","Dickens"));
		names.add(personA);
		names.add(personB);
		names.trimToSize();
		
		for(Name tempName:names)
			System.out.println(tempName);
		
		if(nameSearch(personA, names))
				System.out.println("Found!");
		else
				System.out.println("Not Found!");
	}
		
	public static boolean nameSearch(Name nameSearch, ArrayList<Name>listOfNames) {
			for (Name currentName:listOfNames) {
				if(currentName.equals(nameSearch))
					return true;
			}
			return false;
		}
		
}
