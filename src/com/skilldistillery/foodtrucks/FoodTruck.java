package com.skilldistillery.foodtrucks;


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
		return String.format("Name = %s, Type = %s, Truck ID = %s, Truck Rating = %s", name, type, truckID,
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
		FoodTruck.nextTruckID++;
	}

	public int getTruckRating() {
		return truckRating;
	}

	public void setTruckRating(int truckRating) {
		this.truckRating = truckRating;
	}


	
}