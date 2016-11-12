import java.util.Scanner;
public class Main 
{
	/*			FUNCTION HEADING	 	                              */
	/***********************************************************************************/
	public static void heading()
	{                         // Function heading 
		System.out.println();
		System.out.println ( "Monica Bebawy   002-48-8529     CS 380  ");
		System.out.println ( " Spring 2016   Project # 3");
		System.out.println ();
		System.out.println ();
		return;
	}   // Function heading 
	/**************************************************************************************/    

	/***********************************************************************************/
	/*			FUNCTION FOOTING	 	                              */
	/***********************************************************************************/
	public static void footing()
	{                        // Function footing 
		System.out.println ();
		System.out.println ();
		System.out.println ( "END OF OUTPUT");
		System.out.println ();
		return;
	}   // Function footing
	/*********************************************************************************/

	public static char[][] maze1 = {
		{'X','X','X','X','X','X','X','X','X','X'},
		{'X','.','.','.','.','.','.','.','.','X'}, 
		{'X','X','.','X','.','X','X','X','X','X'},
		{'X','.','.','X','.','X','.','.','.','X'},
		{'X','.','.','X','.','.','.','X','.','X'},
		{'X','X','X','X','.','X','X','X','.','X'},
		{'X','.','X','.','.','.','.','X','X','X'},
		{'X','.','.','X','X','.','X','X','.','X'},
		{'X','.','.','.','X','.','.','.','.','X'},
		{'X','X','X','X','X','X','X','X','X','X'}};


	public static char[][] maze2 = {
		{'X','X','X','X','X','X','X','X','X','X'},
		{'X','X','.','.','.','.','.','X','.','X'},
		{'X','X','.','X','X','.','X','X','.','X'},
		{'X','X','.','.','X','.','.','.','.','X'},
		{'X','X','.','X','.','X','X','X','X','X'},
		{'X','X','.','X','.','X','X','X','X','X'},
		{'X','.','.','X','X','.','.','X','.','X'},
		{'X','.','X','X','.','X','.','X','.','X'},
		{'X','.','.','.','.','.','.','.','.','X'},
		{'X','X','X','X','X','X','X','X','X','X'}};

	public static char[][] maze3 = {
		{'X','X','X','X','X','X','X','X','X','X'},
		{'X','X','X','X','X','.','.','X','.','X'},
		{'X','X','X','X','.','X','X','X','X','X'},
		{'X','X','.','.','.','.','.','.','.','X'},
		{'X','.','.','X','X','.','.','X','.','X'},
		{'X','X','.','X','X','.','X','X','.','X'},
		{'X','X','X','X','.','.','.','X','.','X'},
		{'X','.','.','X','.','X','.','X','.','X'},
		{'X','X','.','X','.','.','X','X','X','X'},
		{'X','X','X','X','X','X','X','X','X','X'}};

	public static void main(String[] args) 
	{
		heading();
		Scanner mazeNum = new Scanner(System.in);
		Scanner method = new Scanner(System.in);

		System.out.println("Please select a maze:    maze1 --> 1"
				+ "\n\t\t\t maze2 --> 2"
				+ "\n\t\t\t maze3 --> 3");
		int maze = mazeNum.nextInt();
		System.out.println("Please select a method:    Stack --> 1"
				+ "\n\t\t\t   Queue --> 2");
		int methodNum = method.nextInt();

		MazeStack stackMaze = new MazeStack();
		MazeQueue queueMaze = new MazeQueue();	
		if(maze == 1)
		{
			Coord startCoord = new Coord(7,8);
			Coord endCoord = new Coord(1,8);
			System.out.println("Starting Point: " + startCoord.toString() );
			System.out.println("Ending Point: " + endCoord.toString());
			if(methodNum == 1)
				stackMaze.pathExists(maze1, startCoord, endCoord);
			if(methodNum == 2)
				queueMaze.pathExists(maze1, startCoord, endCoord); 

		}
		else if(maze == 2)
		{
			Coord startCoord = new Coord(7,1);
			Coord endCoord = new Coord(6,2);
			System.out.println("Starting Point: " + startCoord.toString());
			System.out.println("Ending Point: " + endCoord.toString());
			if(methodNum == 1)
				stackMaze.pathExists(maze2, startCoord, endCoord);
			if(methodNum == 2)
				queueMaze.pathExists(maze2, startCoord, endCoord); 
		}
		else if(maze == 3)
		{
			Coord startCoord = new Coord(8,4);
			Coord endCoord = new Coord(8,2);
			System.out.println("Starting Point: " + startCoord.toString());
			System.out.println("Ending Point: " + endCoord.toString());
			if(methodNum == 1)
				stackMaze.pathExists(maze3, startCoord, endCoord);
			if(methodNum == 2)
				queueMaze.pathExists(maze3, startCoord, endCoord); 
		}
		footing();
	}
}
