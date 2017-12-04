package ie.lyit.hotel;

import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDAO{
	//list is working as a database
	List<Customer> customers;
	
	   public CustomerDaoImpl(){
		      customers = new ArrayList<Customer>();
		      Customer customer1 = new Customer("Mr", "Robert", "Mugabe", "123 Low Road, Zimbabwe","087 111 2223","jdoe@fakemail.com");
		      Customer customer2 = new Customer("Mr","John","Doe","123 High Road, Ennis","087 111 2223","jdoe@fakemail.com");
		      customers.add(customer1);
		      customers.add(customer2);		
		   }
	   
	   @Override
	   public void deleteCustomer(Customer customer) {
		   customers.remove(customer.getCustNumber());
	      System.out.println("Student: Roll No " + customer.getCustNumber() + ", deleted from database");
	   }

	   //retrieve list of students from the database
	   @Override
	   public List<Customer> getAllCustomers() {
	      return customers;
	   }

	   @Override
	   public Customer getCustomer(int custNo) {
	      return customers.get(custNo);
	   }

	   @Override
	   public void updateCustomer(Customer customer) {
		   customers.get(customer.getCustNumber()).setName(customer.getName());
	      System.out.println("Student: Roll No " + customer.getCustNumber() + ", updated in the database");
	   }
	}   

