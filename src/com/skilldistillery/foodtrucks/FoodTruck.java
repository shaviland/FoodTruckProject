package com.skilldistillery.foodtrucks;

import java.util.Scanner;

public class FoodTruck {

	private String name;
	private String type;
	private static int truckID = 1300;
	private int truckRating;

	public FoodTruck() {
		super();
	}

	public FoodTruck(String name, String type, int truckID, int truckRating) {
		super();
		this.name = name;
		this.type = type;
		FoodTruck.truckID = truckID;
		this.truckRating = truckRating;
	}

	@Override
	public String toString() {
		return String.format("FoodTruck [name=%s, type=%s, truckID=%s, truckRating=%s]", name, type, truckID,
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
		truckID++;
		FoodTruck.truckID = truckID;
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
				truckGroup[i].setTruckID(truckID);

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
				for (int i = 0; i < truckGroup.length; i++) {
					if (truckGroup[i] == null) {
						break;
					} else {
						System.out.println("Truck " + (i + 1) + ": " + truckGroup[i]);
					}
				}
			} else if (selection == 2) {
				int j = 0;
				int newRate = 0;
				for (int i = 0; i < truckGroup.length; i++) {
					if (truckGroup[i].getTruckRating() == 0) {
						break;
					}
					int rate = truckGroup[i].getTruckRating();
					System.out.println(rate);
					newRate += rate;
					j = i + 1;

				}
				System.out.println("The average food truck rating is: " + (newRate / j));
			} else if (selection == 3) {
				FoodTruck highestRatedTruck = truckGroup[0];
				for (int i = 1; i < truckGroup.length; i++) {
					if (truckGroup[i].getTruckRating() == 0) {
						break;
					} else if (highestRatedTruck.getTruckRating() < truckGroup[i].getTruckRating()) {
						highestRatedTruck = truckGroup[i];
					}
				}
				System.out.println("The highest rated food truck is: " + highestRatedTruck);
			}else if( selection == 4) {
				System.out.println("Goodbye.");
				quit = true;
			}

		} while (quit != true);
	}
}
