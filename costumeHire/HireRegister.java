package costumeHire;

import java.util.ArrayList;
import java.util.List;

public class HireRegister {
	protected List<Hire> hireLog;
	

	public HireRegister() {
		hireLog = new ArrayList<Hire>();
	}

	/**
	 * Add a new hire to the Hire Register
	 * @param hire The new hire
	 */
	public void addHire(Hire newHire) {
		hireLog.add(newHire);
	}
	
	public void endHire(Hire existingHire)
	{
		existingHire.endHire(0);
	}

	/**
	 * Find the index of a particular hire object in the hire register
	 * @param hireID The hire ID reference for the hire
	 * @return The index of the hire object in the hire register
	 */
	public int findHireIndex(int hireID) {
		for(Hire oneHire : hireLog) {
			if(oneHire.getHireID() == hireID)
				return hireLog.indexOf(oneHire);
			}
		return -1;
	}
	
	/**
	 * Find the Hire object for a particular hireID
	 * @param hireID The hire ID reference for the hire
	 * @return The hire object
	 */
	public Hire findHire(int hireID) {
		for(Hire oneHire : hireLog) {
			if(oneHire.getHireID() == hireID)
				return oneHire;
			}
		return null;
	}
	
	
	public List<Costume> getAllCostumeHires()
	{
		List<Costume> allCostumeHires = new ArrayList<Costume>();
		for (Hire h : hireLog) {
			allCostumeHires.add(h.getCostume());
		}
		return allCostumeHires;
	}
	
	public String printHireRegister () {
		String hireList = "Hire Register: \n";
		for(Hire h : hireLog) {
			hireList = hireList + h.toString() + "\n";
			}
		
		return hireList;
	}


}
