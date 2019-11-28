package com.skilldistillery.foodtrucks;

import java.util.*;

public class FoodTruckApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		FoodTruckApp app = new FoodTruckApp();

		FoodTruck[] trucks = new FoodTruck[5];

		app.Welcome();

		int i = 0;

		while (i < 6) {
			trucks[i] = new FoodTruck("name", 0, "food");

			System.out.println(
					"Please enter the name of your next FoodTruck, enter \"quit\" to if don't have another truck to enter");
			trucks[i].setName(input.nextLine());
			if (trucks[i].getName().equalsIgnoreCase("quit")) {
				trucks[i] = null;
				break;
			}

			System.out.println("Please enter the food this truck serves: ");
			trucks[i].setFood(input.nextLine());

			while (trucks[i].getRate() > 5 || trucks[i].getRate() < 1) {
				System.out.println("Please enter your rate (1-5) for this truck");
				trucks[i].setRate(input.nextInt());
				input.nextLine();
			}

			System.out.println("FoodTruck " + trucks[i].getName() + " created!\n");
			i++;
		}
		if (trucks[0] != null) {
			app.PrintTrucks(trucks);

			int j = 0;
			while (j != 4) {
				app.Menu();
				j = input.nextInt();
				switch (j) {
					case 1:

						app.PrintTrucks(trucks);
						break;
					case 2:

						System.out.println("The average rating for these foodtrucks is " + app.AverageRate(trucks));
						System.out.println();
						break;
					case 3:
						System.out.println("Truck with highest rate is: ");
						System.out.println(app.HighestRate(trucks).toString());
						System.out.println();
						break;
					case 4:

						app.PrintGoodbye();
						System.out.println();
						break;
					default:
						System.out.println("Wrong option, please choose again");
						System.out.println();
				}
			}
		} else {
			System.out.println("You entered 0 truck, goodbye");
		}
		input.close();
	}

	public void Welcome() {
		System.out.println("Welcome to the best foodtruck review site");
	}

	public void Menu() {
		System.out.println("1.List all existing food trucks." + "\n2.See the average rating of food trucks"
				+ "\n3.Display the highest-rated food truck." + "\n4.Quit the program.\nChoose your option");
		System.out.println();
	}

	public void PrintTrucks(FoodTruck trucks[]) {

		int i = 0;
		while (trucks[i] != null && i < 6) {
			System.out.println(trucks[i].toString());
			i++;
		}
		System.out.println();
	}

	public void PrintGoodbye() {
		System.out.println("Thank you for using this app, goodbye");
	}

	public FoodTruck HighestRate(FoodTruck trucks[]) {

		int i = 0;
		int index = 0;
		int rate = trucks[0].getRate();
		while (trucks[i] != null && i < 6) {
			if (trucks[i].getRate() > rate) {
				rate = trucks[i].getRate();
				index = i;
			}
			i++;

		}
		return trucks[index];
	}

	public double AverageRate(FoodTruck trucks[]) {
		int i = 0;

		int totalRate = 0;
		while (trucks[i] != null && i < 6) {

			totalRate += trucks[i].getRate();
			i++;
		}
		double averageRate = (double) (totalRate) / i;
		return averageRate;
	}
}
