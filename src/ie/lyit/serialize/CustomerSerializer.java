/**
 * Class: Computer Security & Digital Forensics - software implementation
 * Instructor: Maria Boyle
 * Description: Customer Class for the Hotel package
 * Date: 14/11/2017
 * @author Ciaran Roarty
 * @version 1.0
**/

package ie.lyit.serialize;

import java.util.*;
import ie.lyit.hotel.Customer;
import java.io.*;

public class CustomerSerializer implements CustomerDAO{
	ArrayList<Customer> customerList;
	public int customerNumber;
	
	//Default Constructor
	public CustomerSerializer() {
		//Construct customerList ArrayList
		customerList = new ArrayList<Customer>();
	}	
	
	public void add() {
		// Create a Customer object
		Customer customer = new Customer();
		customer.read();
		// Add it to the customerList
		customerList.add(customer);
	}
	
	public Customer view(){
		Scanner keyboard = new Scanner(System.in);
		
		//Read the number of the customer to be viewed from the user
		System.out.println("Enter the Customer Number: ");
		int custToView=keyboard.nextInt();
		
		//for every customer object in customerList
		for(Customer tmpCust:customerList) {
			//if its number equals the number of the customer to view
			if(tmpCust.getCustNumber() == custToView) {
				//display it and...
				System.out.println(tmpCust);
				//...return it
				return tmpCust;
			}
		}
		return null;
	}
	
	public void writeRecordsToFile() {
		ObjectOutputStream os = null;
		try {
			FileOutputStream filestream = new FileOutputStream("customers.bin");
			os = new ObjectOutputStream(filestream);
			os.writeObject(customerList);
			os.close();
		}
		catch(FileNotFoundException fnfe) {
			System.out.println("Cannot create file to store customers.");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
				try {
					os.close();
				}
				catch(IOException ioe) {
					System.out.println(ioe.getMessage());
				}
		}
	}
	
	public void readRecordsFromFile() {
		ObjectInputStream is = null;
		try {
			FileInputStream filestreamin = new FileInputStream("customers.bin");
			is = new ObjectInputStream(filestreamin);
			customerList = (ArrayList)is.readObject();
			
		}
		catch(FileNotFoundException fNFE) {
				System.out.println("Cannot find customers file.");
			}	
		catch(Exception e) {
				System.out.println(e.getMessage());
		}
		finally {
			try {
				is.close();
			}
			catch(IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		}
	}

	//////////////////////////////////////////////////////////
	// Method Name: delete()								//
	// Return Type: void									//
	// Parameters: None										//
	// Purpose: Deletes the required Book record from books //
	//////////////////////////////////////////////////////////
	@Override
	public void delete() {
		// Call the view() method to find, display and return the book to delete
		Customer tempCust = view();
		
		// If the book != null, i.e. it was found, then...
		if(tempCust != null)
			//...remove it from books
			customerList.remove(tempCust);
	}
	
	//////////////////////////////////////////////////////////
	// Method Name: edit()									//
	// Return Type: void									//
	// Parameters: None										//
	// Purpose: Edits the required Book record in books 	//
	//////////////////////////////////////////////////////////
	public void edit() {
		// Call the view() method to find, display and return the book to edit
		Customer tempCust = view();
		
		// If the customer != null, i.e. it was found, then...
		if(tempCust != null) {
			// get it's index
			int index = customerList.indexOf(tempCust);
			tempCust.read();
			//reset the object in customerList
			customerList.set(index, tempCust);
			//...remove it from customers
			//customerList.remove(tempCust);
		}
	}
	
	public void list() {
		// for every customer in customer list
		for(Customer cst:customerList) 
			//display it
			System.out.println(cst);
	}
	
	//getNewCustNumber: iterate through the arrayList and check the customer number of each
	//and return the highest number/last number used. 
	public int getNewCustNumber(){
		int newCustNumber = 0;
		for(Customer tmpCustomer:customerList){
			if (tmpCustomer.getCustNumber() > newCustNumber){
				newCustNumber = tmpCustomer.getCustNumber();
			}
		}
		return newCustNumber;
	}
	
}
