/**
 * Class: Computer Security & Digital Forensics - software implementation
 * Instructor: Maria Boyle
 * Description: Tester for the Customer class
 * Date: 17/10/2017
 * @author Ciaran Roarty
 * @version 1.0
**/

package ie.lyit.hotel;

public interface Payable {
		public abstract double calculateWage(double taxPercentage);
		double incrementSalary(double incrementAmount);
		// Don’t need to include public & abstract as all methods in an interface are public & abstract
}
