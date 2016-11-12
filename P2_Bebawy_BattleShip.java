/* 
 * Monica Bebawy 
 * Program 2 BattleShips
 * This program asks the user to input the ships 
 * Then it asks the user to input coordinates to guess where the ships are 
 * while keeping track of how many attempts the user tries to sink all the ships
 * If the user hit a ship it will tell the user 
 * And if it was a miss then again it will tell the user 
 * At the end it will tell the user how many attempts took the user to sink all the ships
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class P2_Bebawy_BattleShip
{
	//Declaring Variables
	// Shiplength is just to set how long each ship is
	// board is the game board
	// shoot is were the user input where they want to shoot
	// attempts is to keep track of how many attempts the user made
	// ships is to store the rows and columns 
	// shothit is when the user hit a ship
	// shipindex is to store the ship coordinates 
	
	static int [] shiplength = {2,3,4};
	private static int[][] board = new int[7][7];
	private static int[] shoot = new int[2];
    private static int attempts = 0;
    private static int [][] ships = new int [3][2];
    private static int   shotHit = 0;
    private static ArrayList <int[]> shipIndex = new ArrayList <int[]>();

    
    // The main method 
    // This method starts with a do.. while 
    // This method runs the program 
    // First we start with the empty board 
    // Then every time the user shoots the attempts go up 
    // Then it checks if the hit was for a ship and if it was 
    // It returns a new board with a hit
    // If if hits the water then it returns a miss
    // And it keeps doing that until all the ships sink
    public static void main (String[] args) 
    {    
        initBoard(board);
        initShips(ships);
        
        System.out.println();
       
        // the do...while loop starts here 
        do
        {
            showBoard(board);
            shoot(shoot);
            attempts++;
            
            if(hit(shoot[0],shoot[1]))
            {
                hint(shoot,ships,attempts);
                shotHit++;
            }                
            else
                hint(shoot,ships,attempts);
            
            changeboard(shoot,ships,board);
            

        }
        while(shotHit!=9);
        
        System.out.println("\n\n\nBattleship Java game finished! You hit 3 ships in " + attempts +" attempts");
        showBoard(board);
    }
   
    // This method initializes the board 
    // The board is 7x7 
    // it starts from 0 
    // And ends at 6
    // both vertically and horizontally 
    public static void initBoard(int[][] board)
    {
        for(int row = 0 ; row < board.length; row++ )
            for(int column = 0 ; column < board[row].length; column++ )
                board[row][column]=-1;
    }
    
    // This method is to show the board 
    // In a nested for loop I checked every element 
    // all the water is '-' 
    // all the misses are 'm'
    // all the hits are 'X'
    // all the ships are 'S'
    public static void showBoard(int[][] board)
    {
        System.out.println("\t0 \t1 \t2 \t3 \t4 \t5 \t6");
        System.out.println();
        
        for(int row = 0 ; row < board.length ; row++ )
        {
            System.out.print((row) + "");
            for(int column = 0 ; column < board[row].length; column++ )
            {
                if(board[row][column]== -1)
                    System.out.print("\t"+"-");
                else if(board[row][column]== 0)
                    System.out.print("\t"+"m");
                else if(board[row][column]== 1)
                    System.out.print("\t"+"X");
                else if(board[row][column] == 2)
                	System.out.print("\t"+"S");
            }
            System.out.println();
        }
    }

    // This method is to initialized ships 
    // Which just add the ships to the board
    // In this method i had 3 do...while loops in one big for loop
    // To make sure the user adds what they are suppose to add it
    // The fist one is for rows 
    // The second one is for columns
    // the third one is for the orientation
    // The for loop goes through each element 
    // And prints the ships 2, 3, and 4
    public static void initShips(int[][] ships)
    {
 
    	Scanner scan = new Scanner (System.in);
    	int row = 0;
    	int column = 0;
    	
    		for(int ship = 0; ship < shiplength.length; ship++)
    		{
    			showBoard(board);
    			// The first do... while loop is for the row 
    			// The user has to enter a number between 0-6
    			do
    			{
	    			System.out.println("Please enter the top-left coordinate ");
	    			System.out.println("Please enter the row number: ");
	    			
	    			row = scan.nextInt();
	    			
    			}
    			while ( row < 0 || row > 6 );
    			// The second do... while loop is for the column 
    			// The user has to enter a number between 0-6
    			do
    			{
	    			System.out.println("Please enter the column number: ");
	    			column = scan.nextInt();
    			}
    			while (column < 0 || column > 6);
    			
    			shipIndex.add(shoot);
    			
    	    	int orient = 0;
    	    	// The third do...while loop is for the orientation
    	    	// The user has to enter -1 or 1
    			do
    			{
    				if(orient == -1)
        			{
    					for (int i = 0; i < shiplength[ship]; i++)
    					{
    						board[row][column + i] = 2;
    					}
    					break;
        			}
    				
        			else if(orient == 1)
        			{
        				for (int i = 0; i <shiplength[ship]; i++)
    					{
    						board[row + i][column] = 2;
    					}
        				break;
        			}
        			else 
        			{
        				System.out.println("Please enter the orientation: ('-1' for 'Horizontal' and '1' for 'Vertical')");
        				orient = scan.nextInt();
        			}
    			}
    			while (orient != -1 || orient != 1);	
    		}	
    }

    // This method is to allow the user to guess where the ships are 
    // I used scanner to allow the user to enter the guess
    public static void shoot(int[] shoot)
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Row: ");
        shoot[0] = scan.nextInt();
        
        System.out.print("Column: ");
        shoot[1] = scan.nextInt();
    }
 
   // This method is to know if the user guessed where a ship was 
    // If the board has 2 or a ship 
    // Then it is a hit
    // Else, it is a miss
 public static boolean hit(int row, int col)
 {
	
	 if(board[row][col]==2)
	 	{
		 System.out.printf("You hit a ship located in (%d,%d)\n",shoot[0],shoot[1]);	
		 return true;
	 	}
	 	else 
	 		return false;
    }


 // This method is to keep track of how many moves the user made to hit all the ships
 // Then it prints it
public static void hint(int[] shoot, int[][] ships, int attempt)
{
    int row=0,
        column=0;
    
    for(int line = 0 ; line < ships.length ; line++)
    {
        if(ships[line][0]==shoot[0])
            row++;
        if(ships[line][1]==shoot[1])
            column++;
    }
    
    System.out.printf("\nHint %d: \nRow %d -> %d ships\n" +
                             "Column %d -> %d ships\n",attempt,shoot[0],row,shoot[1],column);
}

// This method is to change the board 
// If there was a ship then it becomes a hit
// If there was no ships then it becomes a miss
public static void changeboard(int[] shoot, int[][] ships, int[][] board)
    {
        if(hit(shoot[0], shoot[1]))
            board[shoot[0]][shoot[1]] = 1;
        else
            board[shoot[0]][shoot[1]] = 0;
    }
}