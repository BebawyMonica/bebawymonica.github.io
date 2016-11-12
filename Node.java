/* 
 * This class is the Node class,
 * this class sets the structure of the node of a single linked list. 
 * with only two variables, getters/setters and an overloaded constructor. 
 * Finally, the toString method.
 */
public class Node
{
	private String name;
	private double balance;
	private Node prev, next;
	
	public Node() 
	{
		this.name = "";
		this.balance = 0.0;
		this.prev = null;
		this.next = null;
	}

	public Node(String newName, double newBalance) {
		this.name = newName;
		this.balance = newBalance;
		this.prev = null;
		this.next = null;
	}
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public double getBalance() 
	{
		return balance;
	}

	public void setBalance(double balance) 
	{
		this.balance = balance;
	}

	public Node getPrev()
	{
		return prev;
	}

	public void setPrev(Node prev) 
	{
		this.prev = prev;
	}

	public Node getNext()
	{
		return next;
	}

	public void setNext(Node next) 
	{
		this.next = next;
	}

	public String toString() 
	{
		return "Node (name: " + name + ", balance: $" + balance + ")";
	}
	
	
	
	
	
	
}
