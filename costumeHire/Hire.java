package costumeHire;

import java.time.*;
import java.util.*;

public class Hire {
	private int hireID;
	private String startDate;
	private String endDate;
	private int daysHired;
	private double hireFee;
	private Customer client;
	private Costume costume;
	private boolean hireInProgress = false;
	private static int hireCounter = 1;
	
		
	public Hire(Costume costume, int numberDays, Customer client) {
		this.costume = costume;
		daysHired = numberDays;
		this.client = client;
		ZoneId zoneId = ZoneId.of("Australia/Sydney");  
		startDate = LocalDate.now(zoneId).toString();
		hireFee = daysHired*costume.getHireFee();
		costume.hire();
		hireInProgress = true;
		hireID = hireCounter;
		hireCounter += 1;
	}
	
	public int getHireID()
	{
		return hireID;
	}
	
	public void endHire(int hireIndex)
	{
		hireInProgress = false;
		costume.endHire();
		ZoneId zoneId = ZoneId.of("Australia/Sydney");  
		
		endDate = LocalDate.now(zoneId).toString();
		
	}
	
	
	public Costume getCostume() {
		return this.costume;
	}
	
	public Customer getCustomer() {
		return this.client;
	}
	
	public String getStartDate() {
		return this.startDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	public String toString() {
		String hireState = getString();

		return String.format("Hire Ref#: %d.\t%s.\tCostume %s: %s \tHire commenced: %s\tHire completed: %s.\tTotal: %d days for $%.2f.\tStatus: %s", hireID, client.toString(), costume.getId(), costume.getCharacterName(), startDate, endDate, daysHired, hireFee, hireState);
	}

	private String getString() {
		String hireState;
		if (hireInProgress)
			hireState = "On Loan";
		else
			hireState = "Hire Completed";
		return hireState;
	}
}
