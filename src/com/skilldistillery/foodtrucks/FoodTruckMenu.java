package com.skilldistillery.foodtrucks;

import java.util.Scanner;

public class FoodTruckMenu {
	public FoodTruck[] truckInput(Scanner kb) {
		// eclipse isn't allowing the method to be non-static.

		System.out.println("Welcome to Food Truck ratings!");
		System.out.println();
		int j = 0;
		System.out.println("How many trucks would you like to rate?");
		j = kb.nextInt();
		kb.nextLine();
		FoodTruck[] truckGroup = new FoodTruck[j];
		for (int i = 0; i < truckGroup.length; i++) {
			FoodTruck ft = new FoodTruck();

			System.out.println("\nPlease input truck name or \"quit\" to exit:");
			String name = kb.nextLine();
			kb.nextLine();
			if (name.equalsIgnoreCase("quit")) {
				break;
			} else {
				int truckID = ft.getTruckID();
				ft.setName(name);
				ft.setTruckID(truckID);
				System.out.println("\nPlease input food type:");
				String type = kb.nextLine();
				kb.nextLine();
				ft.setType(type);
				System.out.println("\nPlease input rating (1-10)");
				int truckRating = kb.nextInt();
				kb.nextLine();
				ft.setTruckRating(truckRating);
				System.out.println();
				truckGroup[i] = ft;

			}

		}
		resultsMenu(kb, truckGroup);
		return truckGroup;
	}

	public void resultsMenu(Scanner kb, FoodTruck[] truckGroup) {
		boolean quit = false;
		do {
			System.out.println("*********************************************");
			System.out.println("*********************************************");
			System.out.println("|         Please select an option:          |");
			System.out.println("| 1. List all existing food trucks.         |");
			System.out.println("| 2. See the average rating of food trucks. |");
			System.out.println("| 3. Display the highest-rated food truck.  |");
			System.out.println("| 4. Quit                                   |");
			System.out.println("*********************************************");
			System.out.println("*********************************************");
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

