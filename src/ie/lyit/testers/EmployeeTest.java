package ie.lyit.testers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ie.lyit.hotel.*;

public class EmployeeTest {
	private Employee e1;

	@Before
	public void setUp() throws Exception {
		Employee e1=new Employee("Mr","Ciaran","Roarty","Main St, Street Town","0831111100",23430.00,1,1,2009,new Date(20,6,1983));
		
	}

	@Test
	public void testGetDateProbationEnds() {
		assertEquals(e1.getDateProbationEnds(30), new Date(31,1,2009));
		//assertEquals(e1.getDateProbationEnds(50), new Date(31,1,2009));
	}

}
