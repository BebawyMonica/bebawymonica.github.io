/* CS 225 - Fund of Computer Science
 * File Name: P3_Bebawy_Dog.java
 * Java Programming
 * Project 3 - Due 2/27/2015
 * Instructor: Dan Grissom
 * 
 * Name 1: Monica Bebawy
 * Description: This file contains the source code for Project 3...
 */
public class P3_Bebawy_Dog extends P3_Bebawy_Animal
{
	// Constructor simply call the animal super constructor
	// passing through feedingsRequired
	public P3_Bebawy_Dog(int feedingsRequired) 
	{
		super(feedingsRequired);
	}
	// This method passes in an enum
	// If it is the food that the animal likes
	// Then increments number of feedings
	public void feed (FoodType ft)
	{
		if (ft == FoodType.BONE)
			super.numberOfFeedings++;			
	}
	// This method returns the sound the this animal does 
	public String speak()
	{
		return "WOOF";
	}
}
