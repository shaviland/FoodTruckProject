
package com.skilldistillery.foodtrucks;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		FoodTruckMenu truckInfo = new FoodTruckMenu();

		truckInfo.truckInput(kb);

	}

}
