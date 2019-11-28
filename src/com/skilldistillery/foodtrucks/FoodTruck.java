package com.skilldistillery.foodtrucks;

public class FoodTruck {
// F I E L D
	private int id;
	private String name;
	private int rate;

	private String food;
	private static int nextId = 1;

// C O N S T R U C T O R

	public FoodTruck(String name, int rate, String food) {
		super();
		this.id = nextId;
		nextId++;
		this.name = name;
		this.rate = rate;
		this.food = food;
	}

// M E T H O D
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Truck ID-" + id + "\tname-" + name + "\tfood-" + food + "\trate-" + rate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

}
