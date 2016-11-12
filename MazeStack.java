 
public class MazeStack 
{
	private Coord start;
	//Sets up the circular double linked list
	private void setup()
	{
		start = new Coord(0,0);
		start.setPrevious(start);
		start.setNext(start);
		return;
	}
	//Constructor calls the setup method
	public MazeStack()
	{
		setup();
	}
	//Removes the coordinate from linked list and returns it to the user
	//If the list is empty, it returns the dummy head
	public Coord pop()
	{
		Coord temp = start.getNext();
		if(!isEmpty())
		{	
			Coord newCoord = start.getPrevious();
			start.setPrevious(start.getPrevious().getPrevious());
			start.getPrevious().setNext(start);
			return newCoord;
		}
		System.out.println("Stack is empty");
		return start;
	}
	//Adds a new coordinate to the end of the list
	public void push(Coord newCoord)
	{
		newCoord.setNext(start);
		newCoord.setPrevious(start.getPrevious());
		start.getPrevious().setNext(newCoord);
		start.setPrevious(newCoord);
		return;
	}
	//Checks with coordinate is at the end of the list (the coordinate that would get removed next)
	public Coord peek()
	{
		if(isEmpty())
		{
			System.out.println("The Queue is empty");
			return start;
		}

		Coord temp = start.getNext();
		while(temp != start)
		{
			if(temp.getNext() == start)
				return temp;
			temp = temp.getNext();
		}
		return start;
	}
	//This method checks if the list is empty 
		public boolean isEmpty()
		{
			if(start == start.getNext())
				return true;
			return false;
		}
		//This method checks if the list is full
		public boolean isFull()
		{
			Coord temp = new Coord(-1,-1);
			if (temp == null)
				return true;
			return false;
		}
		//This method checks if there is a valid path for the given maze
	public boolean pathExists(char[][] genericMaze, Coord startCoord, Coord endCoord)
	{
		/**PRINTING MAZE*/
		printMaze(genericMaze);
		push(startCoord);
		//Updating maze
		genericMaze[startCoord.getRow()][startCoord.getCol()] = 'O';
		/**PRINTING MAZE*/
		printMaze(genericMaze);

		while(!isEmpty())
		{
			Coord popCoord = pop();
			if(popCoord.getRow() == endCoord.getRow() && popCoord.getCol() == endCoord.getCol())
			{
				System.out.println("Path is Found");
				return true;
			}
			//checks if NORTH is open to visit
			if(genericMaze[popCoord.getRow()-1][popCoord.getCol()] == '.')
			{
				Coord newCoord = new Coord (popCoord.getRow()-1, popCoord.getCol());
				push(newCoord);
				//Updating maze
				genericMaze[newCoord.getRow()][newCoord.getCol()] = 'O';
				/**PRINTING MAZE*/
				printMaze(genericMaze);
			}
			//checks if EAST is open to visit
			if(genericMaze[popCoord.getRow()][popCoord.getCol()+1] == '.')
			{
				Coord newCoord = new Coord (popCoord.getRow(), popCoord.getCol()+1);
				push(newCoord);
				//Updating maze
				genericMaze[newCoord.getRow()][newCoord.getCol()] = 'O';
				/**PRINTING MAZE*/
				printMaze(genericMaze);
			
			}
			//checks if SOUTH is open to visit
			if(genericMaze[popCoord.getRow()+1][popCoord.getCol()] == '.')
			{
				Coord newCoord = new Coord (popCoord.getRow()+1, popCoord.getCol());
				push(newCoord);
				//Updating maze
				genericMaze[newCoord.getRow()][newCoord.getCol()] = 'O';
				/**PRINTING MAZE*/
				printMaze(genericMaze);
				
			}
			//checks if WEST is open to visit
			if(genericMaze[popCoord.getRow()][popCoord.getCol()-1] == '.')
			{
				Coord newCoord = new Coord (popCoord.getRow(), popCoord.getCol()-1);
				push(newCoord);
				//Updating maze
				genericMaze[newCoord.getRow()][newCoord.getCol()] = 'O';
				/**PRINTING MAZE*/
				printMaze(genericMaze);
				
			}
		}
		if(isEmpty())
		{
			System.out.println("Stack is empty.. No solution found!");
		}
		return false;
	}
	//This method prints the maze
	public void printMaze(char[][] genericMaze)
	{
		for(int row = 0; row <= genericMaze.length-1; row++)
		{
			for(int col = 0; col <= genericMaze[row].length-1; col++)
				System.out.print(genericMaze[row][col]);
			System.out.println();
		}
		try {
			Thread.sleep(1500);
			System.out.println("\n\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
