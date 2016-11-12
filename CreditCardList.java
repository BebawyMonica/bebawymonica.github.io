/*
 * This class defines the credit card list and defines all the methods
 * Jesse helped me on a lot of these methods
 */
public class CreditCardList 
{
	private static final int MaxSize = 100;
	private int size;
	private int cursor;
	private CreditCard [] cardList;


	// This method sets up the the length of the credit card list array 
	// then, it sets the size to 0 and the cursor to -1
	private void setup (int number)
	{
		cardList = new CreditCard [number];
		size = 0;
		cursor = -1;
	}
	// This is the default constructor 
	public CreditCardList()
	{ 
		setup(MaxSize); 
	}
	// This is the overloaded constructor
	public CreditCardList(int maxNumber)
	{ 
		setup(maxNumber); 
	}
	// This method checks if the array is empty
	public boolean isEmpty()
	{ 
		return size == 0; 
	}
	// This method checks if the array is full
	public boolean isFull()
	{
		return (size >= cardList.length); 
	}
	// This method shows the structure of the array 
	// it checks if the array is empty first
	// if its not, then it prints out the size, the cursor, and the information
	public void showStructure()
	{
		if (isEmpty())
			System.out.println("Empty List");
		else
		{
			System.out.println("size: " + size + " Cursor: " + cursor);
			System.out.println();

			for(int index = 0; index < size; index++)
				System.out.println("(" + cardList[index].getName() + ", "
						+ cardList[index].getBalance() + ")");
			System.out.println();
		}
	}
	// This method appends the credit card list if its not empty
	public void append (CreditCard newCard)
	{
		if (isFull())
		{
			System.out.println("The list is full");
			return;
		}
		else
		{
			cursor = size++;
			cardList[cursor] = newCard;
		}	
	}
	// This method clears the array
	public void clear()
	{
		size =0;
		cursor = -1;
	}
	// This method goes to the beginning and returns true if it wasn't empty 
	// if it's empty it would return false.
	public boolean gotoBeginning()
	{
		if (!isEmpty())
		{
			cursor = 0;
			cardList[0] = cardList[cursor];
			return true;
		}
		else
		{
			System.out.println("Empty List");
			return false;
		}
	}
	// This method goes to the end of the array. 
	public boolean gotoEnd()
	{
		if (isEmpty())
			return false;
		else 
		{
			cursor = 0;
			for(int index = 0; index < size -1; index++)
				cursor++;

			return true;
		}
	}
	// This method moves the cursor to the next element
	public boolean gotoNext()
	{
		if(isEmpty())
			return false;
		else
		{
			if(cursor == cardList.length -1 )
				return false;
			else
			{
				cursor++;
				return true;
			}
		}
	}
	// This method moves the cursor to the previous element
	public boolean gotoPrior()
	{
		if(isEmpty())
			return false;
		else
		{
			if(cursor == 0)
				return false;
			else
			{
				cursor--;
				return true;
			}
		}
	}
	// This method gets the information the cursor is pointing
	public CreditCard getCursor()
	{
		if(!isEmpty())
		{
			if(isFull())
				return cardList[cursor-1];
			else
				return cardList[cursor];		
		}
		else
		{
			System.out.println("List is empty");
			return null;
		}
	}
	// This method shifts all the elements in the array to the right 
	// and insert the new card in the beginning of the list
	public void insertBeginning ( CreditCard newCreditCard)
	{
		if (!isFull())
		{
			if(!isEmpty())
			{
				for(int index = size -1; index >= 0; index--)
					cardList[index + 1] = cardList[index];	
				size ++;
				cardList[0] = newCreditCard;
			}
			else 
			{
				size ++;
				cursor = 0;
				cardList[0] = newCreditCard;
			}
		}
	}
	// This method inserts the new credit card where the cursor is located 
	// if the list is not full. 
	public boolean insert (String name, double balance)
	{
		if(isFull())
		{
			System.out.println("List is full");
			return false;
		}
		else
		{
			for (int index = 0; index < size -1; index++)
				if (name.equals(cardList[index].getName()) )
				{
					System.out.println("Name is already in list");
					return false;
				}	
			for (int index = size -1; index >= cursor; index--)
			{
				cardList[index + 1] = cardList[index];
				System.out.println(index);

			}
			CreditCard card1 = new CreditCard(name,balance);
			cardList[cursor] = card1;
			System.out.println("Name added successfully");
			cursor++;
			size++;
			return true;
		}
	}
	// This method checks if a credit card is in the list 
	// if yes, it updates the balance
	public boolean update (String name, double balance)
	{
		for (int index = 0; index < size -1; index++)
		{
			if (name.equals(cardList[index].getName()) )
			{
				cardList[index].setBalance(balance);
				System.out.println("Name updated successfully");
				return true;
			}
		}
		System.out.println("Name is not in the List");
		return false;
	}
	// This method deletes a specific credit card  
	public boolean erase (String name, double balance)
	{
		for (int index = 0; index < size -1; index++)
		{
			if (name.equals(cardList[index].getName()))
			{
				for(int index1 = index; index1 < size - 1; index1++ )
					cardList[index1] = cardList[index1 + 1];
				size --;
				cursor --;
				System.out.println("Credit Card erased successfully");
				return true;
			}
		}
		System.out.println("Credit Card is not in the list");

		return false;
	}
	// This method checks if the card list has a specific name  
	public boolean contains (String name, double balance)
	{
		for (int index = 0; index < cardList.length; index++)

			if(name == cardList[index].getName())
				return true;

		return false;
	}
	// This method gets the credit card information for a specific name.
	public CreditCard get (String name, double balance)
	{
		for (int index = 0; index < size -1; index++)
		{
			if(name == cardList[index].getName())
				return cardList[index];
		}
		cursor = size++;
		return cardList[cursor];
	}
}
