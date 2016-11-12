/*-----------------------------------------*
 * Monica Bebawy                           *
 * 23 March 2016                           *
 * this program simulates Defragmentation  *
 ------------------------------------------*/

public class Defragmentation
{	 
	static String  Pages [][] = new String [10][40];
	public static void memory()
	{
		//nested for loop to build pages. 
		for(int i = 0; i< 10; i++)
			for(int j = 0; j < 40; j++)
				Pages[i][j] = "_";
		//Where the memory is located
		Pages[0][3] = "A";
		Pages[0][23] = "B";
		Pages[1][6] = "CD";
		Pages[2][0] = "G";
		Pages[2][36] = "X";
		Pages[3][30] = "IVY";
		Pages[4][5] = "LING";
		Pages[5][11] ="PAGE";
		Pages[6][38] = "U";
		Pages[7][10] = "S";
		Pages[7][23] = "Z";
		Pages[8][14] = "DR";    
		printmemory();
	}
	public static  void printmemory()
	{
		//nested for loop to print pages
		for(int i= 0; i< 10; i++)
			for(int j= 0; j< 40; j++)
			{
				//to print pages
				System.out.print(Pages[i][j] );
				//if statment to create new line
				if( j == 39)
					System.out.println();	
			}
		System.out.println("\n\n");
	}
	public static  void defrag()
	{
		//for loop to go through array
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 40; j++)
			{
				//iff statements to switch the memory and free space.
				if(Pages[i][j] == "A")
				{
					Pages[0][0] = "A";
					Pages[i][j] = "_";
				}
				if(Pages[i][j] == "B")
				{
					Pages[0][1] = "_";
					Pages[0][2] = "B";
					Pages[i][j] = "_";
				}
				if(Pages[i][j] == "CD")
				{
					Pages[0][3] = "_";
					Pages[0][4] = "CD";
					Pages[i][j] = "_";
				}
				if(Pages[i][j] == "G")
				{
					Pages[0][5] = "_";
					Pages[0][6] = "G";
					Pages[i][j] = "_";
				}
				if(Pages[i][j] == "X")
				{
					Pages[0][7] = "_";
					Pages[0][8] = "X";
					Pages[i][j] = "_";
				}
				if(Pages[i][j] == "IVY")
				{
					Pages[0][9] = "_";
					Pages[0][10] = "IVY";
					Pages[i][j] = "_";
				}
				if(Pages[i][j] == "LING")
				{
					Pages[0][11] = "_";
					Pages[0][12] = "LING";
					Pages[i][j] = "_";
				}
				if(Pages[i][j] == "PAGE")
				{
					Pages[0][13] = "_";
					Pages[0][14] = "PAGE";
					Pages[i][j] = "_";
				}
				if(Pages[i][j] == "U")
				{
					Pages[0][15] = "_";
					Pages[0][16] = "U";
					Pages[i][j] = "_";
				}
				if(Pages[i][j] == "S")
				{
					Pages[0][17] = "_";
					Pages[0][18] = "S";
					Pages[i][j] = "_";
				}
				if(Pages[i][j] == "Z")
				{
					Pages[0][19] = "_";
					Pages[0][20] = "Z";
					Pages[i][j] = "_";
				}
				if(Pages[i][j] == "DR")
				{
					Pages[0][21] = "_";
					Pages[0][22] = "DR";
					Pages[0][23] = "_______";
					Pages[i][j] = "_";
				}
				if(i == 0)
					Pages[i][j] = "";
			}
		printmemory();
	}
	public static void main(String[] args) 
	{	
		memory();
		defrag();
	}
}
