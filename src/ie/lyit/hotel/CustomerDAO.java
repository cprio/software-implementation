package ie.lyit.hotel;

import java.util.List;

public interface CustomerDAO {
	   public List<Customer> getAllCustomers();
	   public Customer getCustomer(int CustNumber);
	   public void add();
	   public void view();
	   public void edit(Customer customer);
	   public void deleteCustomer(Customer customer);
	}
