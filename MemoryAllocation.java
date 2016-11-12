//  Author:       Monica Babawy                                      		
//  Date:         4/27/2016                                                              	
//  Purpose:  	  Memory Allocation     
import java.util.ArrayList;
import java.util.Scanner;
public class MemoryAllocation 
{
	// Declaring Variables
	public static ArrayList<Integer> array = new ArrayList<Integer>();
	public static ArrayList<Integer> firstArray = new ArrayList<Integer>();
	public static ArrayList<Integer> bestArray = new ArrayList<Integer>();
	public static ArrayList<Integer> worstArray = new ArrayList<Integer>();
	public static int seg = 0;
	public static int time = 1;
	public static int memseg = 1;
	public static int firstV = 0;
	public static int bestV = 0;
	public static int worstV = 0;
	public static int tempTime;
	// Main method
	public static void main(String[] args) 
	{
		// Scanner
		Scanner scan = new Scanner(System.in);	
		// Prompting the user
		System.out.print("Please enter an integer between 5-20 for memory segments ");
		int num1 = scan.nextInt();
		System.out.print("Please enter "+ num1 + " integers");
		// For loop to add the numbers in the array
		for(int i = 0; i < num1; i++)
		{
			int num2 = scan.nextInt();
			array.add(num2);
		}
		// For loop to print the array
		for (int i = 0; i < array.size() ; i++)
			System.out.print(array.get(i) + " ");
		System.out.println();
		// Setting the copies of the array 
		firstArray.addAll(array);
		bestArray.addAll(array);
		worstArray.addAll(array);
		// calling first fit
		for (int i = 0; i < 4; i ++)
			FirstFit();
		firstV = ((tempTime/2) + (3 * memseg));
		System.out.println();
		System.out.println("First-Fit took time of " + tempTime + " with result of " 
				+ memseg + " memory segments. " + " v = " + firstV);
		time = 1;
		memseg = 1;
		tempTime = 0;
		// Calling best fit
		for (int i = 0; i < array.size() ; i++)
			System.out.print(array.get(i) + " ");
		System.out.println();
		for (int i = 0; i < 4; i ++)
			BestFit();
		bestV = ((tempTime/2) + (3 * memseg));
		System.out.println();
		System.out.println("Best-Fit took time of " + tempTime + " with result of "
				+ memseg + " memory segments. " + " v = " + bestV);
		time = 1;
		memseg = 1;
		tempTime = 0;
		// Calling worst Fit
		for (int i = 0; i < array.size() ; i++)
			System.out.print(array.get(i) + " ");
		System.out.println();
		for (int i = 0; i < 4; i ++)
			WorstFit();
		worstV = ((tempTime/2) + (3 * memseg));
		System.out.println();
		System.out.println("Worst-Fit took time of " + tempTime + " with result of " 
				+ memseg + " memory segments. " + " v = " + worstV);
		time = 1;
		memseg = 1;
		tempTime = 0;

		print();
	}
	// The print method checks to see which method is the best for the given test case.
	public static void print()
	{

		String first = "";
		String second = "";
		String third = "";

		if(firstV < bestV && firstV < worstV)
			if(bestV < worstV)
			{
				first = "First-Fit";
				second = "Best-Fit";
				third = "Worst-Fit";
			}
			else 
			{
				first = "First-Fit";
				second = "Worst-Fit";
				third = "Best-Fit";
			}
		else if(bestV < firstV && bestV < worstV)
			if( firstV < worstV)
			{
				first = "Best-Fit";
				second = "First-Fit";
				third = "Worst-Fit";
			}
			else
			{
				first = "Best-Fit";
				second = "Worst-Fit";
				third = "First-Fit";
			}
		else if(worstV < bestV && worstV < firstV)
			if( firstV < bestV)
			{
				first = "Worst-Fit";
				second = "First-Fit";
				third = "Best-Fit";
			}
			else
			{
				first = "Worst-Fit";
				second = "Best-Fit";
				third = "First-Fit";
			}
		System.out.println("Conclusion: #1 is " + first + ", #2 is " + second + ", #3 is " + third + ".");
	}
	// This is the first fit method
	public static void FirstFit()
	{	
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter an integer for the size of memory segment requested by OS>  ");
		seg = scan.nextInt();
		int abs;
		int temp;
		for(int i = 0; i < firstArray.size(); i++)
		{
			// Checks if the number inputed is smaller than or equal to the value at each index
			if (seg <= firstArray.get(i))
			{
				temp = firstArray.get(i);
				abs = firstArray.get(i) - seg;
				firstArray.add(i, seg);
				firstArray.remove(i + 1);
				firstArray.add(i + 1, abs);
				break;
			}
			time++;
		}
		// Printing the array 
		memseg = firstArray.size();
		System.out.print("First-Fit algorithm found the segment "+ seg +" using time "+ time + ".  Result: "+ memseg + " memory segments:  ");
		for (int i = 0; i < firstArray.size() ; i++)
			System.out.print(firstArray.get(i) + " ");
		System.out.println();	
		tempTime += time;
		time = 1;
	}
	// This is the best fit method 
	public static void BestFit()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter an integer for the size of memory segment requested by OS>  ");
		seg = scan.nextInt();
		int abs;
		int temp;
		int min = 10000;
		time = 0;
		for(int i = 0; i < bestArray.size(); i++)
		{
			if (seg <= bestArray.get(i) && bestArray.get(i) < min)
				min = bestArray.get(i);	
			time ++;
		}
		temp = min;
		abs = temp - seg;
		bestArray.add(bestArray.indexOf(min), seg);
		bestArray.remove(bestArray.get(bestArray.indexOf(seg) + 1));
		if(abs != 0)
			bestArray.add(bestArray.indexOf(seg) + 1, abs);
		memseg = bestArray.size();
		System.out.print("Best-Fit algorithm found the segment "+ seg +" using time "+ time + ".  Result: "+ memseg + " memory segments:  ");
		for (int i = 0; i < bestArray.size() ; i++)
			System.out.print(bestArray.get(i) + " ");
		System.out.println();	
		tempTime += time;
		time = 0;
	}
	// Worst fit method 
	public static void WorstFit()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter an integer for the size of memory segment requested by OS>  ");
		seg = scan.nextInt();
		int abs;
		int temp;
		int max = 0;
		time = 0;

		for(int i = 0; i < worstArray.size(); i++)
		{
			if (seg <= worstArray.get(i) && worstArray.get(i) > max)
				max = worstArray.get(i);	
			time ++;
		}
		temp = max;
		abs = temp - seg;
		worstArray.add(worstArray.indexOf(max), seg);
		worstArray.remove(worstArray.get(worstArray.indexOf(seg) + 1));
		if(abs != 0)
			worstArray.add(worstArray.indexOf(seg) + 1, abs);
		memseg = worstArray.size();
		System.out.print("Worst-Fit algorithm found the segment "+ seg +" using time "+ time + ".  Result: "+ memseg + " memory segments:  ");
		for (int i = 0; i < worstArray.size() ; i++)
			System.out.print(worstArray.get(i) + " ");
		System.out.println();	
		tempTime += time;
		time = 0;
	}
}