/******************* Program Identification ************************************************/
/* COURSE: CS 380		Data Structures 				                 
/* PROJECT #  : 5 					                   			       
/* DUE DATE :	April 4th, 2016							      
/* SOURCE FILE :  CS380_Project5.java            				                   
/* Instructor: Dr. Samuel Sambasivam                                                                  
/*                                                                                                                                  
/* Student Name:    Monica Bebawy                                                                                                    
/* Student ID: 		002-48-8529				       
/* ********************************************************************************************/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class SortingArray
{
	private int comparison , swap;
	
	// This method reads in the file 
	// it also calls the sorting methods and writes them to the file
	public void ReadArray(String FileIn) throws FileNotFoundException 
	{
		Scanner fscan = new Scanner(new File("sortingIn.txt"));
		while(fscan.hasNextLine())
		{
			FileOutputStream fileOut = new FileOutputStream("sortingOut.txt", true);
			PrintWriter printHead = new PrintWriter(fileOut);
			//PrintWriter print = new PrintWriter(fileOut);
			int arrayLength = 0;
			Scanner parse = new Scanner (fscan.nextLine());
			parse.useDelimiter(" ");
			arrayLength = Integer.parseInt(parse.next());

			int[] array = new int[arrayLength];

			int index = 0;
			Scanner arrayScan = new Scanner (fscan.nextLine());
			arrayScan.useDelimiter(" ");
			while(index < array.length)
			{
				array[index] = Integer.parseInt(arrayScan.next());
				index++;
			}
			// writing to the file
			printHead.println();
			printHead.println("Sorted Array of Length: " + arrayLength );
			printHead.close();
			FileOutputStream fileOut1 = new FileOutputStream("sortingOut.txt", true);
			PrintWriter print = new PrintWriter(fileOut1);
			SelectSort(array);
			InsertSort(array);
			BubbleSort(array);
			MergeSort(array);
			print.println("Merge\t\t\t\t\t" + swap + "\t\t\t\t" + comparison);
			comparison = swap = 0;
			QuickSort(array, array[0], array.length-1);
			print.println("Quick\t\t\t\t\t" + swap + "\t\t\t\t" + comparison);
			print.close();
			comparison = swap = 0;
			printHead.println();
			parse.close();
		}

	}
// This is the selection sort method 
	public void SelectSort(int [] array) throws FileNotFoundException
	{
		//Copy of the array
		int [] copyArray = new int [array.length];
		for(int index = 0; index < array.length; index++)
			copyArray[index] = array[index];
		// to write to the file
		FileOutputStream fileOut = new FileOutputStream("sortingOut.txt", true);
		PrintWriter print = new PrintWriter(fileOut);
		// to sort the array using selection
		for(int index = 0; index < copyArray.length - 1; index++)
		{
			int value = index;
			for(int secIndex = index + 1; secIndex < copyArray.length; secIndex++)
			{
				if(copyArray[secIndex] < copyArray[value])
				{
					value = secIndex;
					swap++;
				}
				comparison++;
			}
			int smallerVal = copyArray[value];
			copyArray[value] = copyArray[index];
			copyArray[index] = smallerVal;
		}
		
		//To write the sorted array to file
		for(int index = 0; index < copyArray.length; index++)
			print.print(copyArray[index] + " ");
		print.println();
		print.println("Sorting Method\t\t\tSwaps\t\t\tComparisons");
		print.println("Select\t\t\t\t\t" + swap + "\t\t\t\t" + comparison);
		print.close();
		comparison = swap = 0;
	}
	//This is the insertion sort
	public void InsertSort(int[] array) throws FileNotFoundException
	{
		// Copy of the array
		int [] copyArray = new int [array.length];
		for(int index = 0; index < array.length; index++)
			copyArray[index] = array[index];
		//to write to file
		FileOutputStream fileOut = new FileOutputStream("sortingOut.txt", true);
		PrintWriter print = new PrintWriter(fileOut);
		// Sort the array using insertion sort
		for(int index = 1; index < copyArray.length; index++)
		{
			int temp = copyArray[index];
			int secIndex;
			for(secIndex = index - 1; secIndex >= 0 && temp < copyArray[secIndex]; secIndex--)
			{
				copyArray[secIndex + 1] = copyArray[secIndex];
				copyArray[secIndex] = temp;
				if(array[secIndex + 1] < array[secIndex])
					swap++;
				comparison++;
			}
			comparison++;
		}

		print.println("Insert\t\t\t\t\t" + swap + "\t\t\t\t" + comparison);
		print.close();
		comparison = swap = 0;
	}
	//This is the bubble sort method 
	public void BubbleSort(int[] array) throws FileNotFoundException
	{
		// Copy of the array
		int [] copyArray = new int [array.length];
		for(int index = 0; index < array.length; index++)
			copyArray[index] = array[index];
		// open write to file 
		FileOutputStream fileOut = new FileOutputStream("sortingOut.txt", true);
		PrintWriter print = new PrintWriter(fileOut);

		int index;
		boolean flagIt = true;
		int temp;
		// Sorting array using bubble sort
		while(flagIt)
		{
			flagIt = false;
			for(index = 0; index < copyArray.length - 1; index++)
			{
				if(copyArray[index] > copyArray[index + 1])
				{
					temp = copyArray[index];
					copyArray[index] = copyArray[index + 1];
					copyArray[index + 1] = temp;
					swap++;
					flagIt = true;
				}
				comparison++;
			}
		}
		// Writing to file
		print.println("Bubble\t\t\t\t\t" + swap + "\t\t\t\t" + comparison);
		print.close();
		comparison = swap = 0;
	}

	// This is the merge sort
	public void MergeSort(int[] array)
	{
		// Copy of the array 
		int [] copyArray = new int [array.length];
		for(int index = 0; index < array.length; index++)
			copyArray[index] = array[index];
		// Base case for recursion 
		if(copyArray.length <= 1)
			return;
		int[] first = new int[copyArray.length/2];
		int[] second = new int[copyArray.length - first.length];
		// Calling the method recursively 
		MergeSort(first);
		MergeSort(second);
		Merge(first, second, copyArray);
	}
	// this is the Merge method
	// This method is where the actual sorting is taking place
	public void Merge(int[] first, int []second, int[]array)
	{
		int First = 0;
		int Second = 0;
		int index = 0;
		// Sorters the array using merge sort
		while(First < first.length && Second < second.length)
		{
			if(first[First] > second[Second])
			{
				array[index] = first[First];
				First++;
				comparison++;
			}
			else
			{
				array[index] = second[Second];
				Second++;
				swap++;
				comparison++;
			}
			index++;
			comparison++;
		}
	}
	
	// This is the Quick Sort
	public void QuickSort(int[] array, int first, int last) 
	{	
		// copy of the array 
		int [] copyArray = new int [array.length];
		for(int index = 0; index < array.length; index++)
			copyArray[index] = array[index];
		// calls quick sort recursively 
		if(first < last)
		{
			int index = partition(copyArray, first, last);
			QuickSort(copyArray, first, index - 1);
			QuickSort(copyArray, index + 1, last);
		}
	}
	// This is the partition 
	public int partition (int[] array, int first, int last)
	{
		int temp;
		int pivot = array[(array.length) / 2];
		int lastSort = first;
		for(int index = first + 1; index <= last; index++)
		{
			int value = array[index];
			if(value > pivot)
			{	
				++lastSort;
				temp = array[index];
				array[index] = array[lastSort];
				array[lastSort] = temp; 
				swap++;
			}			comparison++;
		}
		temp = array[first];
		array[first] = array[lastSort];
		array[lastSort] = temp;

		swap++;
		return lastSort;
	}
}
