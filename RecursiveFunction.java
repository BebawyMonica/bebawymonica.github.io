/******************* Program Identification ************************************************/
/* COURSE: CS 380		Data Structures 				                 
/* PROJECT #  : 4 					                   			       
/* DUE DATE :	March 15th, 2016							      
/* SOURCE FILE :  CS380_Project4.java            				                   
/* Instructor: Dr. Samuel Sambasivam                                                                  
/*                                                                                                                                  
/* Student Name:    Monica Bebawy                                                                                                    
/* Student ID: 		002-48-8529				       
/* ********************************************************************************************/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RecursiveFunction 
{
	/**
	 *This is the GCD function
	 *In this function we read from the gcdin.txt file and parse the line into two integers
	 *Then using the SolveGCD method we solve the GCD and LCM using recursion. 
	 *Finally, this method writes the output to a new file.
	 */
	public void GCD(String FileIn) throws FileNotFoundException 
	{
		Scanner fscan = new Scanner(new File("gcdin.txt"));
		FileOutputStream fileOut = new FileOutputStream("gcdout.txt", true);
		PrintWriter printHead = new PrintWriter(fileOut);
		printHead.println("A			B			GCD(A,B)			LCM(A,B)" + "\n" +
				"———————————————————————————————————————————————————————————————————————————————————————————");
		printHead.close();
		while(fscan.hasNextLine())
		{
			int firstNum, secondNum;
			String line = fscan.nextLine();
			Scanner parse = new Scanner (line);
			parse.useDelimiter(" ");
			firstNum = Integer.parseInt(parse.next());
			secondNum = Integer.parseInt(parse.next());
			parse.close();
			int GCDSolver = solveGCD(firstNum, secondNum);
			int LCMSolver = 01;
			if(GCDSolver == 0)
				LCMSolver = 0;
			else
				LCMSolver = (firstNum * secondNum) / GCDSolver;
			writeToFileGCD(firstNum, secondNum, GCDSolver, LCMSolver);
		}
	}	
	 //This method writes the GCD and LCM to a new file called gcdout.txt 
	public void writeToFileGCD(int firstNum, int secondNum, int GCD, int LCM)
	{
		try
		{
			FileOutputStream fileOut = new FileOutputStream("gcdout.txt", true);
			PrintWriter print = new PrintWriter(fileOut);
			print.println();
			print.println(firstNum + "\t\t\t" + secondNum + "\t\t\t\t" + GCD + "\t\t\t\t" + LCM);	
			print.close();
		}
		catch(IOException inputOutputE)
		{
			inputOutputE.printStackTrace();
		}
	}
	 // This method solved the GCD using recursion  
	public int solveGCD(int firstNum, int secondNum)
	{
		if(secondNum == 0)
			return firstNum;
		if(secondNum != 0)
			return solveGCD(secondNum, firstNum % secondNum);

		return 0;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////Palindrome//////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	//This method reads in form the file and calls the writeMethod to write it to the output file
	 
	public void Palindrome(String FileIn) throws FileNotFoundException 
	{
		Scanner fscan = new Scanner(new File("palin.txt"));
		while(fscan.hasNextLine())
		{
			String line = fscan.nextLine();
			Scanner parse = new Scanner (line);
			line = parse.nextLine();
			writeToFilePAL(line);
			parse.close();
		}
	}
	// This method checks if the word that is passed in is a Palindrome. 
	public boolean isPal(String word)
	{   
		String ignore =	word.toLowerCase().replaceAll(" ", "").replaceAll("[^a-zA-Z0-9]", "");
		if(ignore.length() == 0 || ignore.length() == 1)
			return true; 
		if(ignore.charAt(0) == ignore.charAt(ignore.length()-1))
			if(isPal(ignore.substring(1, ignore.length()-1)) == true)
				return true;
		return false;
	}
	// This method writes the word the new word (without the space and characters) and if it's a Palindrome to the output file 
	public void writeToFilePAL(String word) 
	{
		try
		{
			FileOutputStream fileOut = new FileOutputStream("palout.txt", true);
			PrintWriter print = new PrintWriter(fileOut);
			String ignore =	word.toLowerCase().replaceAll(" ", "").replaceAll("[^a-zA-Z0-9]", "");
			print.print(word + "\t\t\t");
			print.print(ignore + "\t\t\t");
			if(isPal(word))
				print.println("Yes");
			else
				print.println("No");
			print.println();
			print.close();
		}
		catch(IOException inputOutputE)
		{
			inputOutputE.printStackTrace();
		}
	}
}