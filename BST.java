/******************* Program Identification ************************************************/
/* COURSE: CS 380		Data Structures 				                 
/* PROJECT #  : 6 					                   			       
/* DUE DATE :	April 18th, 2016							      
/* SOURCE FILE :  CS380_Project6.java            				                   
/* Instructor: Dr. Samuel Sambasivam                                                                  
/*                                                                                                                                  
/* Student Name:    Monica Bebawy                                                                                                    
/* Student ID: 		002-48-8529				       
/* ********************************************************************************************/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class BST
{
	private Node root;
	int count;
	int wordCount = 0;
	private void setup()
	{
		count = 0;
		root = new Node();
	}
	//Constructor calls the setup method
	public BST()
	{
		setup();
	}
	// This is the read method 
	// This method reads in from the program6In and writes out to the program6Out
	public void read(String fileIn) throws FileNotFoundException
	{
		Node newNode = new Node();
		Scanner fscan = new Scanner(new File("program6In.txt"));
		FileOutputStream fileOut = new FileOutputStream("program6Out.txt", true);
		PrintWriter print = new PrintWriter(fileOut);
		FileOutputStream fileOut1 = new FileOutputStream("program6Out.txt", true);
		PrintWriter print1 = new PrintWriter(fileOut1);
		FileOutputStream fileOut2 = new FileOutputStream("program6Out.txt", true);
		PrintWriter print2 = new PrintWriter(fileOut2);
		while(fscan.hasNextLine())
		{	
			Scanner parse = new Scanner (fscan.nextLine());
			parse.useDelimiter(" ");
			while(parse.hasNext())
			{
				String word = parse.next();
				String ignore =	word.replaceAll("[^a-zA-Z0-9]", "");
				newNode.setValue(ignore);
				insert(ignore);
			}
			print.println("In Order Traversal");
			print.close();
			inOrder(root);
			heading();
			print1.println("Pre-Order Traversal");
			print1.close();
			preOrder(root);	
			heading();
			print2.println("Post-Order Traversal");
			print2.close();
			postOrder(root);
			heading();
		}
	}
	// This is the insert method 
	// This method checks each word and it adds it in the appropriate location 
	public void insert(String value) throws FileNotFoundException
	{
		// Checks if the tree is empty and if it is it adds the first node to root
		if(root.getValue() == null)
		{
			root = new Node(value);
			count++;
		}
		Node cur = root;
		for(;;)
		{
			// checks if the word is already in the tree
			if(cur.getValue().equals(value))
				return; 
			if(cur.getValue().compareTo(value) > 0)
			{
				if(cur.getLeft() != null)
					cur = cur.getLeft();
				else
				{
					cur.setLeft(new Node (value));
					count++;
					return; 
				}
			}
			else if (cur.getValue().compareTo(value) < 0)
			{
				if(cur.getRight() != null)
					cur = cur.getRight();
				else
				{
					cur.setRight(new Node(value));
					count++;
					return; 
				}
			}
		}
	}
	// This is the pre-order traversal method
	public void preOrder(Node cur) throws FileNotFoundException
	{	
		if(cur == null)
			return;
		WriteToFile(cur.getValue());
		preOrder(cur.getLeft());
		preOrder(cur.getRight());
	}
	// This is the in-order traversal method
	public void inOrder(Node cur) throws FileNotFoundException
	{
		if(cur == null)
			return;
		inOrder(cur.getLeft());
		WriteToFile(cur.getValue());
		inOrder(cur.getRight());
	}
	// This is the post-order traversal method
	public void postOrder(Node cur) throws FileNotFoundException 
	{
		if(cur == null)
			return;
		postOrder(cur.getLeft());
		postOrder(cur.getRight());
		WriteToFile(cur.getValue());
	}
	// This is the write to file method 
	public void WriteToFile(String value) throws FileNotFoundException
	{
		int length = 0;
		int space = 0;
		FileOutputStream fileOut = new FileOutputStream("program6Out.txt", true);
		PrintWriter print = new PrintWriter(fileOut);
		wordCount++;
		if(wordCount % 5 == 0)
			print.println();
		length = value.length();
		space = 18 - length;
		for(int index = 0; index <= space; index++)
			value += " ";
		print.print(value);
		print.close();
	}
	// This method writes the word count and prints out a block of blank lines
	public void heading() throws FileNotFoundException
	{
		FileOutputStream fileOut = new FileOutputStream("program6Out.txt", true);
		PrintWriter print = new PrintWriter(fileOut);
		print.println();
		print.println("Word Count: " + wordCount);
		wordCount = 0;
		print.println("\n\n\n\n\n\n");
		print.close();

	}
}