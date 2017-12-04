package ie.lyit.hotel;

public class DaoPatternDemo {
	   public static void main(String[] args) {
		      CustomerDAO customerDao = new CustomerDaoImpl();

		      //print all students
		      for (Customer customer : customerDao.getAllCustomers()) {
		         System.out.println("Customer: [CustomerNo : " + customer.getCustNumber() + ", Name : " + customer.getName() + " ]");
		      }


		      //update Customer
		      Customer customer =customerDao.getAllCustomers().get(0);
		      customer.read();
		      customerDao.updateCustomer(customer);

		      //get the student
		      customerDao.getCustomer(0);
		      System.out.println("Student: [RollNo : " + customer.getCustNumber() + ", Name : " + customer.getName() + " ]");		
		   }
}
