/* CS 225 - Fund of Computer Science
 * File Name: P3_Bebawy_MacD_Client.java
 * Java Programming
 * Project 3 - Due 2/27/2015
 * Instructor: Dan Grissom
 * 
 * Name 1: Monica Bebawy
 * Description: This file contains the source code for Project 3...
 */

// Imports
import java.text.DecimalFormat; 
import java.util.ArrayList;
import java.util.Random;

// Enum type for food
enum FoodType { BONE, SALMON, GRASS }


public class P3_Bebawy_MacD_Client
{
	// Constants for food costs
	final static double grassCost = 1.0;
	final static double boneCost = 3.0;
	final static double salmonCost = 5.0;

	public static void main(String[] args)
	{
		// Your program should always output your name and the lab/problem
		// number. DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
		System.out.println("Monica Bebawy");
		System.out.println("Project #3");
		System.out.println("");
		
		// Decimal format class for printing out any prices
		DecimalFormat df = new DecimalFormat("$0.00");		
		
		// Use this test case to reproduce the output in the Project writeup
		//ArrayList<P3_Bebawy_Animal> stalls = generateDogCatCow5ServingArrangement();
		
		int numAnimals = 6;
		// Use this test case (comment out line above) to generate random test cases
		ArrayList<P3_Bebawy_Animal> stalls = generateRandomStallArrangement(numAnimals);
		
		
		// TODO: Insert your code here which causes Old MacDonald (this client code) to
		// visit each of the stalls. Old MacDonald should speak to each animal to determine
		// what type of food to feed it. All along the way, he keeps track of what types 
		// of animals and how much of each type of food he is using. See the project
		// PDF for specific output expectations.
		
		// Declaring Variables 
		// TotalCost is to keep track of the total amount of money spent
		// cowCost/catCost/dogCost is to keep track of how much money is spend for each animal
		// cow/cat/dogFeeding is to keep track of how many feeding each animal used
		double TotalCost = 0.0;
		double cowCost = 0.0;
		double catCost = 0.0;
		double dogCost = 0.0;
		int cowFeeding = 0;
		int catFeeding = 0;
		int dogFeeding = 0;
		String animal = " ";
		DecimalFormat df2 = new DecimalFormat ("$0.00");
		
		// This for loop is to go through all the stalls and make which animal is there 
		// and depending on the sound the animal makes macDonald feeds them 
		for(int i = 0; i < stalls.size(); i++)
		{
			
			String s = stalls.get(i).speak();
			double cost = 0.0;
			DecimalFormat df1 = new DecimalFormat ("$0.00");
			// this do... while loop checks which animal it is in each stall 
			// and then it increments the cost and the number of feedings accordingly 
			do
			{
				if (s == "MOO")
				{
					stalls.get(i).feed(FoodType.GRASS);
					cost += 1.0;
					TotalCost += 1.0;
					cowCost += 1.0;
					animal = "Cow";
					cowFeeding++;
				}
				else if (s == "MEOW")
				{
					stalls.get(i).feed(FoodType.SALMON);
					cost += 5.0;
					TotalCost += 5.0;
					catCost += 5.0;
					animal = "Cat";
					catFeeding++;
				}
				else if (s == "WOOF")
				{
					stalls.get(i).feed(FoodType.BONE);
					cost +=3.0;
					TotalCost += 3.0;
					dogCost += 3.0;
					animal = "Dog";
					dogFeeding++;
				}
			} while (stalls.get(i).isStillHungry() == true );
			
			System.out.println("Stall " + (i+1) + " of " + stalls.size() + " contains a " + animal + " who had " + stalls.get(i).numberOfFeedings 
			     	+ " feedings, which cost " + df1.format(cost) + ".");
		}

		
		// Exiting program
		//System.out.println("E-I-E-I-O!");
		System.out.println("\n\nOld MacDonald's total expenses: ");
		System.out.println(df2.format(cowCost) + " spent feeding 1 cow(s) " + cowFeeding + " total feedings");
		System.out.println(df2.format(catCost) + " spent feeding 1 cat(s) " + catFeeding + " total feedings");
		System.out.println(df2.format(dogCost) + " spent feeding 1 dog(s) " + dogFeeding + " total feedings");
		System.out.println("\t Total Cost: " + df2.format(TotalCost));
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	// DO NOT EDIT
	// This method generates a stall with numAnimals which are generated randomly.
	// In addition, the number of feedings required per animal are set randomly as
	// a number between 1 and 10.
	/////////////////////////////////////////////////////////////////////////////////
	private static ArrayList<P3_Bebawy_Animal> generateRandomStallArrangement(int numAnimals)
	{
		// Create new stall (ArrayList) of animals
		ArrayList<P3_Bebawy_Animal> newStallArrangement = new ArrayList<P3_Bebawy_Animal>();
		 
		// Generate random animal  numbers of feedings required
		// AND random number of feedings required per animal
		Random r = new Random();
		
		// Generate numAnimals new animals
		for (int i = 0; i < numAnimals; i++)
		{
			int randAnimal = r.nextInt(3); // (Dog = 0, Cat = 1, Dog = 2)
			int numFeedings = r.nextInt(10)+1; // 1-10 feedings required per animal
			
			if (randAnimal == 0)
				newStallArrangement.add(new P3_Bebawy_Dog(numFeedings));
			else if (randAnimal == 1)
				newStallArrangement.add(new P3_Bebawy_Cat(numFeedings));
			else
				newStallArrangement.add(new P3_Bebawy_Cow(numFeedings));
		}
		
		return newStallArrangement;
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	// DO NOT EDIT
	// This method generates a stall with a dog, cat and cow, which each need five
	// servings of food.
	/////////////////////////////////////////////////////////////////////////////////
	private static ArrayList<P3_Bebawy_Animal> generateDogCatCow5ServingArrangement()
	{
		// Create new stall (ArrayList) of animals containing a Dog, Cat & Cow, each with a requirement of 5 servings
		ArrayList<P3_Bebawy_Animal> newStallArrangement = new ArrayList<P3_Bebawy_Animal>();
		newStallArrangement.add(new P3_Bebawy_Dog(5));
		newStallArrangement.add(new P3_Bebawy_Cat(5));
		newStallArrangement.add(new P3_Bebawy_Cow(5));
		return newStallArrangement;
	}
}
