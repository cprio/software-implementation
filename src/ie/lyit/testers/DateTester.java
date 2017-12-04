/**
 * Class: Computer Security & Digital Forensics
 * Instructor: Maria Boyle
 * Description: Tester for the Date class
 * Date: 26/09/2017
 * @author Ciaran Roarty
 * @version 1.0
**/
package ie.lyit.testers;

import ie.lyit.hotel.Date;
import java.util.*;

public class DateTester{
	public static void main(String[] args) {
		Date d1 = new Date();
        System.out.println(d1);
        Scanner keyboard = new Scanner(System.in);

	    d1.setDay(4);
		d1.setMonth(6);
		d1.setYear(1941);
		
		System.out.println(d1);
      
		Date d2 = new Date(28, 12, 1982);
        System.out.println(d2);
      
		if(d1.equals(d2))
			System.out.println("Dates are equal.");
		else
			System.out.println("Dates are not equal.");
		
		Date myDate1 = new Date();
		boolean goodInput = false;
		int setDayTo=15;int setMonthTo=33; int setYearTo=2017;
		do {
			try {
				myDate1.setDay(setDayTo);
				myDate1.setMonth(setMonthTo);
				myDate1.setYear(setYearTo);
				goodInput=true;
			}
			catch(IllegalArgumentException iAE) {
				System.out.println("Incorrect date.");
				System.out.print("RE-ENTER VALID ARGUMENT FOR Day: ");
				setDayTo = keyboard.nextInt();
				System.out.print("RE-ENTER VALID ARGUMENT FOR Month: ");
				setDayTo = keyboard.nextInt();
				System.out.print("RE-ENTER VALID ARGUMENT FOR Year: ");
				setDayTo = keyboard.nextInt();
				keyboard.close();
			}
		}while(!goodInput);
		
		Date myDate2 = new Date();
		try {
			myDate2.setDay(4);
			myDate2.setMonth(10);
			myDate2.setYear(2009);
		}
		catch(IllegalArgumentException iAE) {
			System.out.println("Incorrect day, month or year.");
		}
   }
}

