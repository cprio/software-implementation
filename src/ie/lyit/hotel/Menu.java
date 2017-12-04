/**
 * Class: Computer Security & Digital Forensics - software implementation
 * Instructor: Maria Boyle
 * Description: Menu class for the CustomerSerializer
 * Date: 13/11/2017
 * @author Ciaran Roarty
 * @version 1.0
**/

package ie.lyit.hotel;

import java.util.*;

public class Menu {
	
	private int option;
	
	public Menu() {
		option=0;	
	}
	
	public void display() {
		System.out.println("Menu");
		System.out.println("\t1. Add");
		System.out.println("\t2. List");
		System.out.println("\t3. View");
		System.out.println("\t4. Edit");
		System.out.println("\t5. Delete");
		System.out.println("\t6. Quit");
	}
	
	
	public void readOption() {
		Scanner kbInt = new Scanner(System.in);
		System.out.println("Enter Option: " + "[1|2|3|4|5|6]");
		option=kbInt.nextInt();
	}
	
	public int getOption() {
		return option;
	}
	
	/*
	public static void Main(String [] args) {

		String menu = JOptionPane.showInputDialog(null, "Book Menu\r\n" + "\r\n" + "1.	Add\r\n" +"2.	List\r\n" +"3.	View\r\n" +"4.	Edit\r\n" +"5.	Delete\r\n" +"6.	Quit\r\n");
		//Attempt to convert the String to an Int
		int selection = Integer.parseInt(menu);
		//Test this out
		System.out.println("Selection made: " + selection);
	}*/
		

}
