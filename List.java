
/******************* Program Identification ************************************************/
/* COURSE: CS 380		Data Structures 				                   
/* PROJECT # : 			2		                   			        
/* DUE DATE :			2/18/2016						        
/* SOURCE FILE :  CS380_Project1.java            				                    
/* Instructor: Dr. Samuel Sambasivam                                                                       
/*                                                                                                                                  
/* Student Name: Monica Bebawy                                                                                                       
/* Student ID: 	002-48-8529				        
/* ********************************************************************************************/

/*
 * This is the List class 
 * This class sets the credit card list 
 * First in the list constructor I setup and make sure that the dummy header points to itself
 */
public class List 
{
	private int size;
	private Node head;

	private void setup()
	{
		size = 0;
		head = new Node();
		head.setPrev(head);
		head.setNext(head);
		return;
	}

	public List()
	{
		setup();
	}

	/*
	 * The append method adds a new node to the list
	 */
	public void append(Node newNode)
	{
		newNode.setNext(head);
		newNode.setPrev(head.getPrev());
		head.getPrev().setNext(newNode);
		head.setPrev(newNode);
		size++;
		return;
	}

	/*
	 * the clear method clears the list 
	 */
	public void clear()
	{
		setup();
	}

	/*
	 * isEmpty method checks if the list is empty
	 */
	public boolean isEmpty()
	{	
		if(head == head.getNext())
			return true;
		return false;
	}

	/*
	 * isFull method checks if the list is full
	 */
	public boolean isFull()
	{
		Node temp = new Node();
		if (temp == null)
			return true;
		return false;
	}

	/*
	 * The show structure method prints out the list 
	 */
	public void showStructure()
	{
		if(size == 0)
			System.out.println("Empty List");
		else
		{
			System.out.println("size: " + size);
			for (Node temp = head.getNext(); temp != head; temp = temp.getNext())
				System.out.println(temp.toString());
		}
	}

	/*
	 * The insert beginning method adds a new node to the beginning of the list
	 */
	public void insertBeginning (Node newNode)
	{
		newNode.setNext(head.getNext());
		newNode.setPrev(head);
		newNode.getNext().setPrev(newNode);
		head.setNext(newNode);
		size ++;	
	}

	/*
	 * The insert before method looks through the list
	 * once it finds the node with name 'name' 
	 * it adds a new node after that node.
	 */
	public boolean insertAfter(String name, Node newNode)
	{
		Node temp = head.getNext();
		if(isFull())
		{
			System.out.println("List is already full");
			return false;
		}
		if(!contains(newNode.getName()))
			while(temp.getNext() != head)
			{
				if(temp.getName().equals(name))
				{
					temp.getNext().setPrev(newNode);
					newNode.setNext(temp.getNext());
					newNode.setPrev(temp);
					temp.setNext(newNode);	
					size++;
					return true;
				}
				temp = temp.getNext();
			}
		return false;
	}

	/*
	 * The insert before method looks through the list
	 * once it finds the node with name 'name' 
	 * it adds a new node before that node.
	 */
	public boolean insertBefore(String name, Node newNode)
	{
		Node temp = head.getNext();
		if(isFull())
		{
			System.out.println("List is already full");
			return false;
		}
		if(!contains(newNode.getName()))
			while(temp.getNext() != head)
			{
				if(temp.getName().equals(name))
				{
					temp.getPrev().setNext(newNode);
					newNode.setNext(temp);
					newNode.setPrev(temp.getPrev());
					temp.setPrev(newNode);	
					size++;
					return true;
				}
				temp = temp.getNext();
			}
		return false;
	}

	/*
	 * The update method checks the name and if matches a node 
	 * then it updates the balance.
	 */
	public boolean update(String name, double balance)
	{
		Node temp = head.getNext();
		if(!isEmpty())
			while(temp.getNext() != head)
			{
				if(temp.getName().equals(name))
				{
					temp.setBalance(balance);
					return true;
				}
				temp = temp.getNext();
			}
		return false;
	}

	/*
	 * The erase method checks the name given 
	 * if it matches a name in the list
	 * then it erases this node
	 * if the name does not match 
	 * then it does not change anything 
	 */
	public boolean erase(String name)
	{
		Node temp = head.getNext();
		if(!isEmpty())
			if(head == head.getNext())
				return true;
			else
			{
				if(head.getName().equals(name))
				{
					temp.setPrev(head.getPrev());
					head = temp.getNext();
					size--;
					return true;
				}
				else
				{
					while (temp.getNext() != head)
					{
						if(temp.getNext().getName().equals(name))
						{
							temp.setPrev(temp.getPrev());
							temp.setNext(temp.getNext().getNext());
							size--;
							return true;
						}
						temp = temp.getNext();
					}
				}
			}
		return false;		
	}

	/*
	 * The contains method checks is the name that is passed in is already in the list. 
	 * it returns true if it is, otherwise it returns false
	 */
	public boolean contains(String name)
	{
		Node temp = head.getNext();
		while(temp != head)
		{
			if(temp.getName().equals(name))
			{
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}

	/*
	 * The get method checks if the name that is passed in 
	 * matches any name in the list; if yes, it returns that node 
	 * otherwise it returns an empty node 
	 */
	public Node get(String name)
	{
		Node emptyNode = new Node();
		Node temp = head.getNext();
		if(!isEmpty())
		{
			while (temp != head)
			{
				if(temp.getName().equals(name))
					return temp;
				temp = temp.getNext();
			}
			return emptyNode;
		}
		return null;
	}
}