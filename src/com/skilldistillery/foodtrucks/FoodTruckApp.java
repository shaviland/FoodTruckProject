package com.skilldistillery.foodtrucks;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		menu(kb);
		

	}

	public static void menu(Scanner kb) {
		
		System.out.println("Welcome to Food Truck ratings!");
		FoodTruck[] truckGroup = new FoodTruck[5];
		for (int i = 0; i < truckGroup.length; i++) {
			FoodTruck ft = new FoodTruck();

			System.out.println("Please input truck name or \"quit\" to exit:");
			String name = kb.nextLine();
			kb.hasNextLine();
			if (name.equalsIgnoreCase("quit")) {
				break;
			} else {
				ft.setName(name);
				System.out.println("Please input food type:");
				String type = kb.nextLine();
				kb.nextLine();
				ft.setType(type);
				System.out.println("Please input rating (1-10)");
				int truckRating = kb.nextInt();
				kb.nextLine();
				ft.setTruckRating(truckRating);
//				System.out.println(ft);
				truckGroup[i] = ft;
			}
//			System.out.println(truckGroup[i]);
		}
		
			
			

	}

}
