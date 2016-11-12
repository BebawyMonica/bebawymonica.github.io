/**
 * This is the Maze Queue class
 */
public class MazeQueue 
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
	public MazeQueue()
	{
		setup();
	}
	//Removes the coordinate from linked list and returns it to the user
	//If the list is empty, it returns the dummy head
	public Coord dequeue()
	{
		if(!isEmpty())
		{
			Coord dequeueCoord = start.getNext();
			start.setNext(dequeueCoord.getNext());
			dequeueCoord.getNext().setPrevious(start);
			return dequeueCoord;
		}
		System.out.println("Stack is empty");
		return start;
	}
	//Adds a new coordinate to the end of the list
	public void enqueue(Coord newCoord)
	{
		Coord temp = start.getNext();
		while(temp != start)
			temp = temp.getNext();
		newCoord.setPrevious(temp);
		newCoord.setNext(start);
		start.getPrevious().setNext(newCoord);
		start.setPrevious(newCoord);
		return;
	}
	//Checks with coordinate is at the beginning of the list (the coordinate that would get removed next)
	public Coord peek()
	{
		if(isEmpty())
		{
			System.out.println("The Queue is empty");
			return start;
		}
		return start.getNext();
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
		enqueue(startCoord);
		//Updating the maze
		genericMaze[startCoord.getRow()][startCoord.getCol()] = 'O';
		/**PRINTING MAZE*/
		printMaze(genericMaze);

		while(!isEmpty())
		{
			Coord dequeueCoord = dequeue();
			if(dequeueCoord.getRow() == endCoord.getRow() && dequeueCoord.getCol() == endCoord.getCol())
			{
				System.out.println("Path is Found");
				return true;
			}
			//checks if NORTH is open to visit
			if(genericMaze[dequeueCoord.getRow()-1][dequeueCoord.getCol()] == '.')
			{
				Coord newCoord = new Coord (dequeueCoord.getRow()-1, dequeueCoord.getCol());
				enqueue(newCoord);
				//Updating the maze
				genericMaze[newCoord.getRow()][newCoord.getCol()] = 'O';
				/**PRINTING MAZE*/
				printMaze(genericMaze);
			}
			//checks if EAST is open to visit
			if(genericMaze[dequeueCoord.getRow()][dequeueCoord.getCol()+1] == '.')
			{
				Coord newCoord = new Coord (dequeueCoord.getRow(), dequeueCoord.getCol()+1);
				enqueue(newCoord);
				//Updating the maze
				genericMaze[newCoord.getRow()][newCoord.getCol()] = 'O';
				/**PRINTING MAZE*/
				printMaze(genericMaze);
			}
			//checks if SOUTH is open to visit
			if(genericMaze[dequeueCoord.getRow()+1][dequeueCoord.getCol()] == '.')
			{
				Coord newCoord = new Coord (dequeueCoord.getRow()+1, dequeueCoord.getCol());
				enqueue(newCoord);
				//Updating the maze
				genericMaze[newCoord.getRow()][newCoord.getCol()] = 'O';	
				/**PRINTING MAZE*/
				printMaze(genericMaze);
			}
			//checks if WEST is open to visit
			if(genericMaze[dequeueCoord.getRow()][dequeueCoord.getCol()-1] == '.')
			{
				Coord newCoord = new Coord (dequeueCoord.getRow(), dequeueCoord.getCol()-1);
				enqueue(newCoord);
				//Updating the maze
				genericMaze[newCoord.getRow()][newCoord.getCol()] = 'O';
				/**PRINTING MAZE*/
				printMaze(genericMaze);
				
			}
		}
		if(isEmpty())		
			System.out.println("Queue is empty.. No solution found!");
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
