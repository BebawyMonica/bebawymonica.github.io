
import java.util.ArrayList;

/////////////////////////////////////////////////////////////////////////////////
// CS 430 - Artificial Intelligence
// Project 4 - Sudoku Solver w/ Variable Ordering and Forward Checking
// File: SudokuCoord.java
//
// Description: This class represents a Sudoku coordinate (square), which acts
// as a variable for our constraint satisfaction problem (CSP)
/////////////////////////////////////////////////////////////////////////////////
public class SudokuCoord
{
	public int row;
	public int col;
	public ArrayList<Integer> domain;
	
	SudokuCoord()
	{
		row = 0;
		col = 0;
	}
	
	SudokuCoord(int r, int c, int [] d)
	{
		row = r;
		col = c;
		setDomain(d);
	}
	SudokuCoord(int r, int c)
	{
		row = r;
		col = c;
		domain = null;
	}

	public ArrayList<Integer> getDomain()
	{
		return domain;
	}

	public void setDomain(int[] d)
	{
		domain = new ArrayList<Integer>();
		for (int i = 0; i < d.length; i++)
			domain.add(d[i]); 
	}
	
	// DTG - To set domain to single value
	public void setDomain(int d)
	{
		domain = new ArrayList<Integer>();
		domain.add(d);
	}
	
	public int getDomainSize(){ return domain.size(); }
	
	public void removeFromDomain(int i)
	{
		Integer rem = i;
		if (domain != null)
			domain.remove(rem);
	}

}
