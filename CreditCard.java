/******************* Program Identification ************************************************/
/* COURSE: CS 380		Data Structures 				                   
/* PROJECT # : 	1				                   			        
/* DUE DATE :	2/3/16								        
/* SOURCE FILE :  CS380_Project1.java            				                    
/* Instructor: Dr. Samuel Sambasivam                                                                       
/*                                                                                                                                  
/* Student Name:  Monica Bebawy                                                                                                      
/* Student ID: 	  002-48-8529				        
/* ********************************************************************************************/
/*
 * This class defines credit card. 
 * first it declares the variables 
 * then, it defines the constructors. 
 * and finally the getters and setters and the to string method
 */
public class CreditCard
{
	private String name;
	private double balance;
	
	// Constructors
	// Default Constructor
	public CreditCard()
	{
		name = "";
		balance = 0.0;
	}
	// Overloaded constructor 
	public CreditCard(String newName) 
	{
		name = newName;
		balance = balance;
	}
	public CreditCard(String newName, double newBalance) 
	{
		name = newName;
		balance = newBalance;
	}
	// Getters and Setters 
	// Name
	public String getName() 
	{
		return name;
	}
	public void setName(String cusName) 
	{
		name = cusName;
	}
	//Balance
	public double getBalance() 
	{
		return balance;
	}
	public void setBalance(double cusBalance) 
	{
		balance = cusBalance;
	}
	// ToString method
	public String toString() 
	{
		return "Credit Card Information [name: " + name 
				+ ", balance: $" + balance + "]";
	}	
}
