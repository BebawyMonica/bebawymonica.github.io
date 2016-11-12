/******************* Program Identification ************************************************/
/* COURSE: CS 380		Data Structures 				                 
/* PROJECT #  : 3 					                   			       
/* DUE DATE :	March 3rd, 2016							      
/* SOURCE FILE :  CS380_Project1.java            				                   
/* Instructor: Dr. Samuel Sambasivam                                                                  
/*                                                                                                                                  */
/* Student Name:    Monica Bebawy                                                                                                    */
/* Student ID: 		002-48-8529				       
/* ********************************************************************************************/

/**
 * This class defines the lined list as Coord
 *
 */
public class Coord
{
	private int m_row, m_col;
	Coord next, previous;
	public Coord(int rrow, int ccol)
	{
		m_row = rrow;
		m_col = ccol;
		next = null;
		previous = null;
	}
	public int getRow()
	{
		return m_row;
	}
	public int getCol()
	{
		return m_col;
	}
	public void setNext(Coord newNode)
	{
		next = newNode;
	}
	public Coord getNext()
	{
		return next;
	}
	public void setPrevious(Coord newNode)
	{
		previous = newNode;
	}
	public Coord getPrevious()
	{
		return previous;
	}
	public String toString() 
	{
		return "(" + m_row + "," + m_col + ")";
	}
}

