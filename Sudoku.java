/////////////////////////////////////////////////////////////////////////////////
// CS 430 - Artificial Intelligence
// Project 4 - Sudoku Solver w/ Variable Ordering and Forward Checking
// File: Sudoku.java
//
// Group Member Names:
// Due Date:
// 
//
// Description: A Backtracking program in Java to solve the Sudoku problem.
// Code derived from a C++ implementation at:
// http://www.geeksforgeeks.org/backtracking-set-7-suduku/
/////////////////////////////////////////////////////////////////////////////////

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Sudoku
{
	// Constants
	final static int UNASSIGNED = 0; //UNASSIGNED is used for empty cells in sudoku grid	
	final static int N = 9;//N is used for size of Sudoku grid. Size will be NxN
	static int numBacktracks = 0;
	static int [] domain = {1,2,3,4,5,6,7,8,9};
	static SudokuCoord [][] sGrid = new SudokuCoord [N][N]; // DTG

	/////////////////////////////////////////////////////////////////////
	// Main function used to test solver.
	public static void main(String[] args) throws FileNotFoundException
	{
		// Reads in from TestCase.txt (sample sudoku puzzle).
		// 0 means unassigned cells - You can search the internet for more test cases.
		Scanner fileScan = new Scanner(new File("Case1.txt"));
		Scanner scan = new Scanner( System.in);
		System.out.println("Please choose the number to the method you want to use:\n"
				+ "1) Defaut Static Ordering \n"
				+ "2) Original Static Ordering \n"
				+ "3) Original Random Ordering\n"
				+ "4) Min Remaining Value Ordering\n"
				+ "5) Max Remaining Value Ordering");
		int  choice = scan.nextInt(); 


		Scanner scanMethod = new Scanner (System.in);
		System.out.println("Please choose an inference method:\n"
				+ "1.) None (basically running standard backtracking search)\n"
				+ "2.) Forward checking");
		int method = scanMethod.nextInt();
		// Reads case into grid 2D int array
		int grid[][] = new int[9][9];
		for (int r = 0; r < 9; r++)
		{
			String row = fileScan.nextLine();
			String [] cols = row.split(",");
			for (int c = 0; c < cols.length; c++)
				grid[r][c] = Integer.parseInt(cols[c].trim());
		}

		// DTG - Initialize Sudoku Cell 2D array as a 1-time action
		for (int row = 0; row < N; row++)
			for (int col = 0; col < N; col++)
				sGrid[row][col] = new SudokuCoord(row,col);

		// Prints out the unsolved sudoku puzzle (as is)
		System.out.println("Unsolved sudoku puzzle:");
		printGrid(grid);

		// Setup timer - Obtain the time before solving
		long stopTime = 0L;
		long startTime = System.currentTimeMillis();

		// Attempts to solve and prints results
		if (method == 1)
		{
			if (SolveSudoku(grid, choice) == true)
			{
				// Get stop time once the algorithm has completed solving the puzzle
				DecimalFormat df = new DecimalFormat("#,###");
				stopTime = System.currentTimeMillis();
				System.out.println("Algorithmic runtime: " + df.format(stopTime - startTime) + "ms");
				System.out.println("Number of backtracks: " + df.format(numBacktracks));

				// Sanity check to make sure the computed solution really IS solved
				if (!isSolved(grid))
				{
					System.err.println("An error has been detected in the solution.");
					System.exit(0);
				}
				System.out.println("\n\nSolved sudoku puzzle:");
				printGrid(grid);
			}
			else
				System.out.println("No solution exists");
		}
		else if (method == 2)
		{
			if (ForwardSudoku(grid, choice) == true)
			{
				// Get stop time once the algorithm has completed solving the puzzle
				DecimalFormat df = new DecimalFormat("#,###");
				stopTime = System.currentTimeMillis();
				System.out.println("Algorithmic runtime: " + df.format(stopTime - startTime) + "ms");
				System.out.println("Number of backtracks: " + df.format(numBacktracks));

				// Sanity check to make sure the computed solution really IS solved
				if (!isSolved(grid))
				{
					System.err.println("An error has been detected in the solution.");
					System.exit(0);
				}
				System.out.println("\n\nSolved sudoku puzzle:");
				printGrid(grid);
			}
			else
				System.out.println("No solution exists");
		}
	}

	/////////////////////////////////////////////////////////////////////
	// Write code here which returns true if the sudoku puzzle was solved
	// correctly, and false otherwise. In short, it should check that each
	// row, column, and 3x3 square of 9 cells maintain the ALLDIFF constraint.
	private static boolean isSolved(int[][] grid)
	{
		int startR = 0, startC = 0;   // variables for setting the starting row and column for checking box
		for (int r = 0; r < grid.length; r++)
		{
			for(int c = 0; c < grid[r].length; c++)
			{
				if(r<4)
					startR =1;
				else if(r>=4 && r<7)
					startR = 4;
				else if(r>= 7)
					startR = 7;
				if(c<4)
					startC =1;
				else if(c>=4 && c<7)
					startC = 4;
				else if(c>= 7)
					startC = 7;
				if(!UsedInRow(grid, r, grid[r][c]) || !UsedInCol(grid, c, grid[r][c]) || !UsedInBox(grid, startR, startC, grid[r][c]))
					return true;
			} // end of second for loop
		} // end of first for loop
		System.out.println("TODO: Update the code here to complete the method.");
		System.out.println("The default test case in TestCase.txt IS valid and this method should return true for it.");
		System.out.println("It is currently hardcoded to return false just so that it compiles.");
		return false; 
	}

	/////////////////////////////////////////////////////////////////////
	// Takes a partially filled-in grid and attempts to assign values to
	// all unassigned locations in such a way to meet the requirements
	// for Sudoku solution (non-duplication across rows, columns, and boxes)
	/////////////////////////////////////////////////////////////////////
	static boolean SolveSudoku(int grid[][], int choice)
	{
		// Select next unassigned variable
		SudokuCoord variable;

		// TODO: Here, you will create an IF-ELSEIF-ELSE statement to select 
		// the next variables using 1 of the 5 orderings selected by the user.
		// By default, it is hardcoded to the method FindUnassignedVariable(), 
		// which corresponds to the "1) Default static ordering" option.

		//Scanner scan = new Scanner(System.in);
		variable = null;

		if(choice == 1)
			variable = FindUnassignedVariable(grid);
		else if (choice == 2)
			variable = MyOriginalStaticOrderingOpt2(grid);
		else if (choice == 3)
			variable = MyOriginalRandomOrderingOpt3(grid);
		else if (choice == 4)
			variable = MyMinRemainingValueOrderingOpt4(grid);
		else if (choice == 5)
			variable = MyMaxRemainingValueOrderingOpt5(grid);



		// If there is no unassigned location, we are done
		if (variable == null)
			return true; // success!

		int row = variable.row;
		int col = variable.col;

		// consider digits 1 to 9
		for (int num = 1; num <= 9; num++)
		{
			// if looks promising
			if (isSafe(grid, row, col, num))
			{
				// make tentative assignment
				grid[row][col] = num;

				// return, if success, yay!
				if (SolveSudoku(grid, choice))
					return true;

				// failure, un-assign & try again
				grid[row][col] = UNASSIGNED;
			}
		}

		// Increment the number of backtracks
		numBacktracks++;
		if(numBacktracks % 210000 == 1)
			informationList();
		return false; // This triggers backtracking
	}

	static boolean ForwardSudoku(int grid[][], int choice)
	{
		// Select next unassigned variable
		SudokuCoord variable;

		// TODO: Here, you will create an IF-ELSEIF-ELSE statement to select 
		// the next variables using 1 of the 5 orderings selected by the user.
		// By default, it is hardcoded to the method FindUnassignedVariable(), 
		// which corresponds to the "1) Default static ordering" option.

		//Scanner scan = new Scanner(System.in);
		variable = null;

		if(choice == 1)
			variable = FindUnassignedVariable(grid);
		else if (choice == 2)
			variable = MyOriginalStaticOrderingOpt2(grid);
		else if (choice == 3)
			variable = MyOriginalRandomOrderingOpt3(grid);
		else if (choice == 4)
			variable = MyMinRemainingValueOrderingOpt4(grid);
		else if (choice == 5)
			variable = MyMaxRemainingValueOrderingOpt5(grid);

		for (int row = 0; row < N; row++)
		{
			for (int col = 0; col < N; col++)
			{
				// This row/col variable has been assigned....remove it from appropriate variables
				if (grid[row][col] != UNASSIGNED)//create array of the unassigned variables 
				{
					int asn = grid[row][col];

					// Remove from all variable domains in row
					for(int c =0; c<N; c++)
						if(c != col)
						{
							sGrid[row][c].removeFromDomain(asn);
							if(sGrid[row][c].getDomainSize() == 0)
								return false;
						}

					// Remove from all variable domains in col
					for(int r =0; r<N; r++)
						if(r != row)
						{
							sGrid[r][col].removeFromDomain(asn);
							if(sGrid[r][col].getDomainSize() == 0)
								return false;
						}
					// Remove from all variable domains in 3x3 square
					int startR = 0, startC = 0; 
					if(row<4)
						startR =1;
					else if(row>=4 && row<7)
						startR = 4;
					else if(row>= 7)
						startR = 7;
					if(col<4)
						startC =1;
					else if(col>=4 && col<7)
						startC = 4;
					else if(col>= 7)
						startC = 7;

					for (int r = 0; r < 3; r++)
					{
						for (int c = 0; c < 3; c++)
						{
							int newR = r + (startR-1); 
							int newC = c + (startC-1);

							if(newC != col && newR != row)
							{
								sGrid[newR][newC].removeFromDomain(asn);
								if(sGrid[newR][newC].getDomainSize() == 0)
									return false;
							}
						}
					}
				}
			}
		}


		// If there is no unassigned location, we are done
		if (variable == null)
			return true; // success!

		int row = variable.row;
		int col = variable.col;

		// consider digits 1 to 9
		for (int num = 1; num <= 9; num++)
		{
			// if looks promising
			if (isSafe(grid, row, col, num))
			{
				// make tentative assignment
				grid[row][col] = num;

				// return, if success, yay!
				if (ForwardSudoku(grid, choice))
					return true;

				// failure, un-assign & try again
				grid[row][col] = UNASSIGNED;
			}
		}

		// Increment the number of backtracks
		numBacktracks++;
		if(numBacktracks % 210000 == 1)
			informationList();
		return false; // This triggers backtracking
	}

	static void informationList()
	{
		String [] information = {"Be completely humble and gentle; be patient, bearing with one another in love. (Ephesians 4:2)",
				"Whoever is patient has great understanding, but one who is quick-tempered displays folly.(Proverbs 14:29)",
				"Let us not become weary in doing good, for at the proper time we will reap a harvest if we do not give up. (Galatians 6:9)",
				"Therefore, as God’s chosen people, holy and dearly loved, clothe yourselves with compassion, kindness, humility, gentleness and patience. (Colossians 3:12)",
				"May the God who gives endurance and encouragement give you the same attitude of mind toward each other that Christ Jesus had.(Romans 15:5)",
				"For his anger lasts only a moment, but his favor lasts a lifetime; weeping may stay for the night, but rejoicing comes in the morning. (Psalm 30:5) ",
				"BE PATIENT",
				"God loves you",
				"We deserve a good grade :)",
				"Thank you for all the help <3",
				"Trust the code, it knows what to do"};
		
		Random rand = new Random();
		int i = rand.nextInt(11);
		System.out.println(information[i]+ "\n");
		
	}

	/////////////////////////////////////////////////////////////////////
	// Searches the grid to find an entry that is still unassigned. If
	// found, the reference parameters row, col will be set the location
	// that is unassigned, and true is returned. If no unassigned entries
	// remain, null is returned.
	/////////////////////////////////////////////////////////////////////
	static SudokuCoord FindUnassignedVariable(int grid[][])
	{
		for (int row = 0; row < N; row++)
			for (int col = 0; col < N; col++)
				if (grid[row][col] == UNASSIGNED)
					return new SudokuCoord(row, col);
		return null;
	}

	/////////////////////////////////////////////////////////////////////
	// TODO: Implement the following orderings, as specified in the
	// project description. You MAY feel free to add extra parameters if
	// needed (you shouldn't need to for the first two, but it may prove
	// helpful for the last two methods).
	/////////////////////////////////////////////////////////////////////
	static SudokuCoord MyOriginalStaticOrderingOpt2(int grid[][])
	{
		for (int row = 8; row >= 0; row--)
			for (int col = 8; col >= 0; col--)
				if (grid[row][col] == UNASSIGNED)
					return new SudokuCoord(row, col);
		return null;
	}
	static SudokuCoord MyOriginalRandomOrderingOpt3(int grid[][])
	{
		ArrayList <SudokuCoord> unassigned = new ArrayList <SudokuCoord> ();
		for (int row = 0; row < N; row++)
		{
			for (int col = 0; col < N; col++)
			{
				if (grid[row][col] == UNASSIGNED)
					unassigned.add(new SudokuCoord(row,col));
			}
			//informationList();
		}
		Random rNum = new Random ();
		//System.out.println(rNum.nextInt(unassigned.size()-0));
		if (unassigned.size() != 0)
		{
			SudokuCoord randCoord = unassigned.get(rNum.nextInt(unassigned.size()-0));
			return new SudokuCoord(randCoord.row,randCoord.col);
		}
		return null;

	}
	static SudokuCoord MyMinRemainingValueOrderingOpt4(int grid[][])
	{
		
		for (int row = 0; row < N; row++)
		{
			for (int col = 0; col < N; col++)
			{
				if (grid[row][col] == UNASSIGNED)//create array of the unassigned variables
				{
					sGrid[row][col].setDomain(domain); // DTG
				}
				else //create array of the assigned variables
				{
					sGrid[row][col].setDomain(grid[row][col]); // DTG
				}
			}
		}

		// At this point, all assigned and unassigned variables are in sgrid
		for (int row = 0; row < N; row++)
		{
			for (int col = 0; col < N; col++)
			{
				// This row/col variable has been assigned....remove it from appropriate variables
				if (grid[row][col] != UNASSIGNED)//create array of the unassigned variables 
				{
					int asn = grid[row][col];

					// Remove from all variable domains in row
					for(int c =0; c<N; c++)
						if(c != col)
							sGrid[row][c].removeFromDomain(asn);

					// Remove from all variable domains in col
					for(int r =0; r<N; r++)
						if(r != row)
							sGrid[r][col].removeFromDomain(asn);
					// Remove from all variable domains in 3x3 square
					int startR = 0, startC = 0; 
					if(row<4)
						startR =1;
					else if(row>=4 && row<7)
						startR = 4;
					else if(row>= 7)
						startR = 7;
					if(col<4)
						startC =1;
					else if(col>=4 && col<7)
						startC = 4;
					else if(col>= 7)
						startC = 7;

					for (int r = 0; r < 3; r++)
					{
						for (int c = 0; c < 3; c++)
						{
							int newR = r + (startR-1); 
							int newC = c + (startC-1);

							if(newC != col && newR != row)
								sGrid[newR][newC].removeFromDomain(asn);
						}
					}
				}
			}
		}

		// At this point, the domains should all be correct....so search through them one more time
		// return the SudokuCoord with the min size
		int min = 10;
		SudokuCoord mrvCoord = null;

		for (int row = 0; row < N; row++)
		{
			for (int col = 0; col < N; col++)
			{
				if (grid[row][col] == UNASSIGNED) // DTG - THIS WAS THE MAIN ISSUE!! YOU WERE MISSING THIS IF...don't want to select assigned variable
				{
					int domSize = sGrid[row][col].getDomainSize();
					if (domSize < min)
					{
						min = domSize;
						mrvCoord = sGrid[row][col];
					}
				}
			}
		}

		return mrvCoord;
	}

	static SudokuCoord MyMaxRemainingValueOrderingOpt5(int grid[][])
	{
		for (int row = 0; row < N; row++)
		{
			for (int col = 0; col < N; col++)
			{
				if (grid[row][col] == UNASSIGNED)//create array of the unassigned variables
				{
					sGrid[row][col].setDomain(domain); // DTG
				}
				else //create array of the assigned variables
				{
					sGrid[row][col].setDomain(grid[row][col]); // DTG
				}
			}
			//informationList();
		}

		// At this point, all assigned and unassigned variables are in sgrid
		for (int row = 0; row < N; row++)
		{
			for (int col = 0; col < N; col++)
			{
				// This row/col variable has been assigned....remove it from appropriate variables
				if (grid[row][col] != UNASSIGNED)//create array of the unassigned variables 
				{
					int asn = grid[row][col];

					// Remove from all variable domains in row
					for(int c =0; c<N; c++)
						if(c != col)
							sGrid[row][c].removeFromDomain(asn);

					// Remove from all variable domains in col
					for(int r =0; r<N; r++)
						if(r != row)
							sGrid[r][col].removeFromDomain(asn);
					// Remove from all variable domains in 3x3 square
					int startR = 0, startC = 0; 
					if(row<4)
						startR =1;
					else if(row>=4 && row<7)
						startR = 4;
					else if(row>= 7)
						startR = 7;
					if(col<4)
						startC =1;
					else if(col>=4 && col<7)
						startC = 4;
					else if(col>= 7)
						startC = 7;

					for (int r = 0; r < 3; r++)
					{
						for (int c = 0; c < 3; c++)
						{
							int newR = r + (startR-1); 
							int newC = c + (startC-1);

							if(newC != col && newR != row)
								sGrid[newR][newC].removeFromDomain(asn);
						}
						//informationList();
					}
				}
			}
			//informationList();
		}

		// At this point, the domains should all be correct....so search through them one more time
		// return the SudokuCoord with the min size
		int max = -1;
		SudokuCoord mrvCoord = null;

		for (int row = 0; row < N; row++)
		{
			for (int col = 0; col < N; col++)
			{
				if (grid[row][col] == UNASSIGNED) // DTG - THIS WAS THE MAIN ISSUE!! YOU WERE MISSING THIS IF...don't want to select assigned variable
				{
					int domSize = sGrid[row][col].getDomainSize();
					if (domSize > max)
					{
						max = domSize;
						mrvCoord = sGrid[row][col];
					}
				}
			}
			//informationList();
		}

		return mrvCoord;
	}

	/////////////////////////////////////////////////////////////////////
	// Returns a boolean which indicates whether any assigned entry
	// in the specified row matches the given number.
	/////////////////////////////////////////////////////////////////////
	static boolean UsedInRow(int grid[][], int row, int num)
	{
		for (int col = 0; col < N; col++)
			if (grid[row][col] == num)
				return true;
		return false;
	}

	/////////////////////////////////////////////////////////////////////
	// Returns a boolean which indicates whether any assigned entry
	// in the specified column matches the given number.
	/////////////////////////////////////////////////////////////////////
	static boolean UsedInCol(int grid[][], int col, int num)
	{
		for (int row = 0; row < N; row++)
			if (grid[row][col] == num)
				return true;
		return false;
	}

	/////////////////////////////////////////////////////////////////////
	// Returns a boolean which indicates whether any assigned entry
	// within the specified 3x3 box matches the given number.
	/////////////////////////////////////////////////////////////////////
	static boolean UsedInBox(int grid[][], int boxStartRow, int boxStartCol, int num)
	{
		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++)
				if (grid[row+boxStartRow][col+boxStartCol] == num)
					return true;
		return false;
	}

	/////////////////////////////////////////////////////////////////////
	// Returns a boolean which indicates whether it will be legal to assign
	// num to the given row, col location.
	/////////////////////////////////////////////////////////////////////
	static boolean isSafe(int grid[][], int row, int col, int num)
	{
		// Check if 'num' is not already placed in current row,
		// current column and current 3x3 box
		return !UsedInRow(grid, row, num) &&
				!UsedInCol(grid, col, num) &&
				!UsedInBox(grid, row - row%3 , col - col%3, num);
	}

	/////////////////////////////////////////////////////////////////////
	// A utility function to print grid
	/////////////////////////////////////////////////////////////////////
	static void printGrid(int grid[][])
	{
		for (int row = 0; row < N; row++)
		{
			for (int col = 0; col < N; col++)
			{
				if (grid[row][col] == 0)
					System.out.print("- ");
				else
					System.out.print(grid[row][col] + " ");

				if ((col+1) % 3 == 0)
					System.out.print(" ");
			}	    	   
			System.out.print("\n");
			if ((row+1) % 3 == 0)
				System.out.println();
		}
	}
}