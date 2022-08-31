package hireEngine;
import java.util.ArrayList;
import java.util.List;

import costumeHire.*;

public class Main {

	private static Inventory costumeInventory;
	private static HireRegister hireLog;
	public final static int PRESCHOOL = 1;
	public final static int CHILD = 2;
	public final static int TWEEN = 3;
	public final static int TEEN = 4;
	public final static int ADULT = 5;

	public static void main(String args[]) {

		List<Costume> preschoolCostumes = getCostumes();
		for(Costume c : preschoolCostumes) {
			System.out.println(c.toString());
		}

		System.out.println("\nAll Costumes By Size: CHILD");
		List<Costume> childCostumes = new ArrayList<Costume>();
		childCostumes = costumeInventory.findCostumesBySize(CHILD);
		for(Costume c : childCostumes) {
			System.out.println(c.toString());
		}

		System.out.println("\nAll Costumes By Size: TWEEN");
		List<Costume> tweenCostumes = new ArrayList<Costume>();
		tweenCostumes = costumeInventory.findCostumesBySize(TWEEN);
		for(Costume c : tweenCostumes) {
			System.out.println(c.toString());
		}
		System.out.println("\nAll Costumes By Size: TEEN");
		List<Costume> teenCostumes = new ArrayList<Costume>();
		teenCostumes = costumeInventory.findCostumesBySize(TEEN);
		for(Costume c : teenCostumes) {
			System.out.println(c.toString());
		}

		System.out.println("\nAll Costumes By Size: ADULT");
		List<Costume> adultCostumes = new ArrayList<Costume>();
		adultCostumes = costumeInventory.findCostumesBySize(ADULT);
		for(Costume c : adultCostumes) {
			System.out.println(c.toString());
		}

		// Return some costumes
		Hire oldHire = hireLog.findHire(1);
		hireLog.endHire(oldHire);
		oldHire = hireLog.findHire(3);
		hireLog.endHire(oldHire);


		// Reprint hire log and inventory report
		System.out.println("\n\nFull register of costume hires: ");
		System.out.println(hireLog.printHireRegister());
		System.out.println("\n\nFull costume inventory: ");
		System.out.println(costumeInventory.printInventory());


		// Reprint reports showing all costumes by size
		System.out.println("\nAll Costumes By Size: PRESCHOOL");
		for(Costume c : preschoolCostumes) {
			System.out.println(c.toString());
		}

		System.out.println("\nAll Costumes By Size: CHILD");
		for(Costume c : childCostumes) {
			System.out.println(c.toString());
		}

		System.out.println("\nAll Costumes By Size: TWEEN");
		for(Costume c : tweenCostumes) {
			System.out.println(c.toString());
		}
		System.out.println("\nAll Costumes By Size: TEEN");
		for(Costume c : teenCostumes) {
			System.out.println(c.toString());
		}

		System.out.println("\nAll Costumes By Size: ADULT");
		for(Costume c : adultCostumes) {
			System.out.println(c.toString());

		}
	}

	private static List<Costume> getCostumes() {
		Customer a1;
		Customer a2;
		Customer a3;
		Hire newHire;
		costumeInventory = new Inventory();
		hireLog = new HireRegister();

		setupInventory();

		// add some customers
		a1 = new Customer("Maddy", "ABC123");
		a2 = new Customer("Emily", "ABC124");
		a3 = new Customer("Aaron", "ABC125");

		//hire some costumes
		newHire = new Hire(costumeInventory.findCostume("00001", "Elsa", CHILD), 3, a1);
		hireLog.addHire(newHire);
		newHire = new Hire(costumeInventory.findCostume("00002", "Shrek", CHILD), 2, a1);
		hireLog.addHire(newHire);
		newHire = new Hire(costumeInventory.findCostume("00003", "Superman", ADULT), 6, a3);
		hireLog.addHire(newHire);
		newHire = new Hire(costumeInventory.findCostume("00009", "Peppa Pig", CHILD), 4, a2);
		hireLog.addHire(newHire);
		newHire = new Hire(costumeInventory.findCostume("00005", "Fennec Shand", TEEN), 1, a2);
		hireLog.addHire(newHire);

		// print some data reports
		// Print a report of all current costume hires.
		System.out.println("Full register of costume hires: ");
		System.out.println(hireLog.printHireRegister());

		// Print reports showing all costumes by size
		System.out.println("\nAll Costumes By Size: PRESCHOOL");
		List<Costume> preschoolCostumes = new ArrayList<Costume>();
		preschoolCostumes = costumeInventory.findCostumesBySize(PRESCHOOL);
		return preschoolCostumes;
	}

	public static void setupInventory() {

		// Add some costumes
		costumeInventory.addCostume("00001", "Elsa", CHILD, 25.00);
		costumeInventory.addCostume("00002", "Shrek", CHILD, 32.00);
		costumeInventory.addCostume("00003", "Superman", ADULT, 42.50);
		costumeInventory.addCostume("00004", "Batman", PRESCHOOL, 15.00);
		costumeInventory.addCostume("00005", "Fennec Shand", TEEN, 52.00);
		costumeInventory.addCostume("00006", "Merida", TWEEN, 35.50);
		costumeInventory.addCostume("00007", "Spot", PRESCHOOL, 25.00);
		costumeInventory.addCostume("00008", "Dorothy the Dinosaur", PRESCHOOL, 32.00);
		costumeInventory.addCostume("00009", "Peppa Pig", CHILD, 49.00);
	}
}
