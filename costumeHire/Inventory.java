package costumeHire;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

	protected List<Costume> costumesForHire;


	public Inventory() {
		costumesForHire = new ArrayList<Costume>();
	}

	/**
	 * Add a new costume to the Costume Register
	 * @param id The costume's ID
	 * @param name The costume character's name
	 * @param size The size of the costume. Options are PRESCHOOL, CHILD, TWEEN, TEEN, ADULT.
	 * @param hireFee The cost of hiring the costume for one day 
	 */
	public void addCostume(String id, String name, int size, double hireFee) {
		Costume c = new Costume();

		c.setId(id);
		c.setCharacterName(name);
		c.setSize(size);
		c.setHireFee(hireFee);

		costumesForHire.add(c);
	}

	/**
	 * Find the Costume object for a particular id, name and size
	 * @param id The costume's id
	 * @param name The costume's name
	 * @param size The costume's size
	 * @return A Costume, or null
	 */
	public Costume findCostume(String id, String name, int size) {
		for(Costume c : costumesForHire) {
			if((c.getId() == id) && (c.getCharacterName() == name) && c.getSize() == size) {
				return c;
			}
		}
		return null;
	}
	
	
	/**
	 * Find all costumes of a specified size
	 * @param size The costume's size
	 * @return A list of Costumes of the same size, or null
	 */
	public List<Costume> findCostumesBySize(int size) {
		List<Costume> sizeCostume = new ArrayList<Costume>();
		for(Costume c : costumesForHire) {
			if(c.getSize() == size) {
				sizeCostume.add(c);
			}
		}
		return sizeCostume;
	}
	
	public String printInventory () {
		String inventoryList = "Costume Inventory: \n";
		for(Costume c : costumesForHire) {
			inventoryList = inventoryList + c.toString() + "\n";
			}
		
		return inventoryList;
	}
	



}

