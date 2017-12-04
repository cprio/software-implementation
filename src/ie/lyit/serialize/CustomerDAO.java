package ie.lyit.serialize;

import java.util.List;
import ie.lyit.hotel.*;

public interface CustomerDAO {
	public void add();
	public void list();
	public Customer view();
	public void edit();
	public void delete();
	public int getNewCustNumber();
	public void writeRecordsToFile();
	public void readRecordsFromFile();
	}