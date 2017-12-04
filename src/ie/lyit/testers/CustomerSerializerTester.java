/**
 * Class: Computer Security & Digital Forensics - software implementation
 * Instructor: Maria Boyle
 * Description: Tester for the CustomerSerializer class
 * Date: 14/11/2017
 * @author Ciaran Roarty
 * @version 1.0
**/

package ie.lyit.testers;

import ie.lyit.hotel.Menu;
import ie.lyit.serialize.CustomerSerializer;

public class CustomerSerializerTester {

	public static void main(String[] args) {
		CustomerSerializer customerSerializer = new CustomerSerializer();

		customerSerializer.readRecordsFromFile();

		//customerSerializer.writeRecordsToFile();
		
		//Create a menu object
		Menu menuObj = new Menu();
		do{
			//Call the display method
			menuObj.display();
			// Call the readOption() method
			menuObj.readOption();
			//switch on the option and call the appropriate method
				switch(menuObj.getOption()) {
					case 1:customerSerializer.add();
						break;
					case 2:customerSerializer.list();
						break;
					case 3:customerSerializer.view();
						break;
					case 4:customerSerializer.edit();
						break;
					case 5:customerSerializer.delete();
						break;
					case 6: break;
					default:System.out.println("INVALID OPTION...");
				}
		}
		while(menuObj.getOption() != 6);
		
		// write arrayList to file
		customerSerializer.writeRecordsToFile();

	}
}

