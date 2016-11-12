

/*//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 Monica Bebawy  
 * Programming Assignment 1
 * Letter Grades Client
 * This program takes all the methods in the other class and tests it
 * Here we enter the number of students and we check how many grades we get
 * We then see that the toString method, the getA, getStudents, getGrades, and getMoney work 
 * Then we print the result in a user friendly way
 *//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//import javax.swing.JOptionPane;
//import java.util.Scanner;

public class bebawyProject1Client
{

	public static void main(String[] args)
	{
		bebawyProject1 g1 = new bebawyProject1 (20);
		
		g1.getGrades();
		g1.getA();
		g1.getStudent();
		System.out.println(g1.toString());
		System.out.println(g1.getMoney());
		
	}

}
