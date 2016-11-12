/* CS 225 - Fund of Computer Science
 * File Name: P3_Bebawy_Animal.java
 * Java Programming
 * Project 3 - Due 2/27/2015
 * Instructor: Dan Grissom
 * 
 * Name 1: Monica Bebawy
 * Description: This file contains the source code for Project 3...
 */
public class P3_Bebawy_Animal
{
	// Declaring Variables 
	protected int numberOfFeedings;
	private int numberOfRequiredFeedings;
	
	// Constructor sets numberOfRequiredFeedings to feedingsRequired 
	// and then sets numberOfFeedings to zero
	public P3_Bebawy_Animal(int feedingsRequired) 
	{
		numberOfRequiredFeedings = feedingsRequired;
		numberOfFeedings = 0;
	}
	
	// These two methods are to be overridden by the subclasses
	// they just return an error message 
	// The first one is for the food type
	public void feed(FoodType ft)
	{
		System.err.println();
	}
	// This second method is for the voice they make
	public String speak()
	{ 
		System.err.println();
		return "You have an error";
	}
	// This method checks if the animal is still hungry 
	// Returns TRUE if animal has received a number of feedings less than 
	// its required number of feedings and FALSE otherwise
	public boolean isStillHungry()
	{
		if(numberOfFeedings < numberOfRequiredFeedings)
			return true;
		else 
			return false;
	}
	

}
