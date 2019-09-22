package com.skilldistillery.foodtrucks;

import java.util.Scanner;

public class FoodTruck {

	private String name;
	private String type;
	private int truckID;
	private int truckRating;
	private static int nextTruckID = 110;

	public FoodTruck() {
		super();
	}

	public FoodTruck(String name, String type, int truckID, int truckRating) {
		super();
		this.name = name;
		this.type = type;
		this.truckID = nextTruckID;
		this.truckRating = truckRating;
	}

	@Override
	public String toString() {
		return String.format("FoodTruck [name = %s, type = %s, truckID = %s, truckRating = %s]", name, type, truckID,
				truckRating);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTruckID() {
		return truckID;
	}

	public void setTruckID(int truckID) {
		this.truckID = nextTruckID;
		nextTruckID++;
	}

	public int getTruckRating() {
		return truckRating;
	}

	public void setTruckRating(int truckRating) {
		this.truckRating = truckRating;
	}

	public FoodTruck[] truckInput(Scanner kb) {
		// eclipse isn't allowing the method to be non-static.

		System.out.println("Welcome to Food Truck ratings!");
		FoodTruck[] truckGroup = new FoodTruck[5];
		for (int i = 0; i < truckGroup.length; i++) {
			FoodTruck ft = new FoodTruck();

			System.out.println("Please input truck name or \"quit\" to exit:");
			String name = kb.nextLine();
			kb.nextLine();
			if (name.equalsIgnoreCase("quit")) {
				break;
			} else {
				ft.setName(name);
				ft.setTruckID(truckID);
				System.out.println("Please input food type:");
				String type = kb.nextLine();
				kb.nextLine();
				ft.setType(type);
				System.out.println("Please input rating (1-10)");
				int truckRating = kb.nextInt();
				kb.nextLine();
				ft.setTruckRating(truckRating);
				truckGroup[i] = ft;

			}

		}
		resultsMenu(kb, truckGroup);
		return truckGroup;
	}

	public void resultsMenu(Scanner kb, FoodTruck[] truckGroup) {
		boolean quit = false;
		do {
			System.out.println("Please select an option:");
			System.out.println("1. List all existing food trucks.");
			System.out.println("2. See the average rating of food trucks.");
			System.out.println("3. Display the highest-rated food truck.");
			System.out.println("4. Quit");
			int selection = kb.nextInt();

			if (selection > 4 || selection < 1) {
				System.err.println("That is not a valid selection.");
			} else if (selection == 1) {
				System.out.println();
				for (int i = 0; i < truckGroup.length; i++) {
					if (truckGroup[i] == null) {
						break;
					} else {
						System.out.println("Truck " + (i + 1) + ": " + truckGroup[i]);
					}
				}
				System.out.println();
			} else if (selection == 2) {
				int j = 0;
				int newRate = 0;
				for (int i = 0; i < truckGroup.length; i++) {
					if (truckGroup[i] == null) {
						break;
					}
					int rate = truckGroup[i].getTruckRating();
					newRate += rate;
					j = i + 1;

				}
				System.out.println("\nThe average food truck rating is: " + (newRate / j) + "\n");
			} else if (selection == 3) {
				FoodTruck highestRatedTruck = truckGroup[0];
				for (int i = 1; i < truckGroup.length; i++) {
					if (truckGroup[i] == null) {
						continue;
					} else if (highestRatedTruck.getTruckRating() < truckGroup[i].getTruckRating()) {
						highestRatedTruck = truckGroup[i];
					}
				}
				System.out.println("\nThe highest rated food truck is: " + highestRatedTruck + "\n");
			}else if( selection == 4) {
				System.out.println("\nGoodbye.");
				quit = true;
			}

		} while (quit != true);
	}
}
