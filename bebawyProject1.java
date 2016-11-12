/*//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
 * Monica Bebawy   
 * Programming Assignment 1
 * Letter Grades
 * This program converts integer grades to letter grades
 * The grades are generated randomly 
 * Then the grades are converted from integers between 0 to 100 
 * To a letter grade: A, B, C, D, or F
 * Then depending on how many students got A's, B's, and C's 
 * There is going to be a party thrown by the teacher
 * $20 for each A; $10 for each B; and $5 for each C
 * There is a method that counts and adds these numbers up
 * First I import Arrays, and Random
 * Then I declare private variables, and instantiate random
 * Then I added the default constructor with no arguments 
 * and I set it to zero students and an array of no grades
 * Then I added the overloaded constructor with one argument
 * and I set the students to 's' and the array of grades
 * to 's' so that the array of grades will be as big as the number of students
 * Then I added the accessors to access them in the client class
 * I added an accessor for grades so that in the client class the user can get grades
 * Then I added an accessor for money so that in the client class the user can get how much money is needed
 * Then I added an accessor for student so that in the client class the user can get the students
 * Then I added the mutators to set thing to different values in the client class if needed
 * I added a mutator which takes a separate array of integer grades and overwrites the class array 
 * Then I finally added the toString method so that the results would be user friendly and easier to be read
 *//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Arrays;  
import java.util.Random;

public class bebawyProject1 
{
//////////Declaring Variables\\\\\\\\\\
	Random rand = new Random();
		private int [] grades;
		private int student;
	
////////// Default Constructor\\\\\\\\\\
	public bebawyProject1()
		{
		student = 0;
		grades = new int[0];
		}

//////////Overloaded Constructor\\\\\\\\\\	
	public bebawyProject1(int s)
		{
		student = s;
		grades = new int [s]; 
		
//////////This For loop is to generate grades randomly\\\\\\\\\\	
		//////////in this loop random integers between 0 and 100 will be selected\\\\\\\\\\
		//////////and assigned to each element of array grades\\\\\\\\\\
		//////////Then I printed the array to check the grades with the toString method\\\\\\\\\\	
		for(int i = 0; i< s; i++)
		{
			if (i == 0) 
				System.out.print("The grades are: ");  
			int random = rand.nextInt(100) + 1;
			grades[i] = (int) random;	
			System.out.print(grades[i] + " ");
			
		}
		System.out.println();
		}

//////////Accessors\\\\\\\\\\
	//////////Accessor to access grades\\\\\\\\\\
	public int [] getGrades () 
	{
		int [] gradeCounter = new int [5];
//////////This For loop is to count how many A's, B's, C's, D's, and F's are in the class\\\\\\\\\\	
		//////////With if, else statements i check each element in array grades\\\\\\\\\\
		//////////If the element in array grades is grader than 90, then it's an A\\\\\\\\\\
		//////////and so I increment array gradeCounter, the element that reflects the A's\\\\\\\\\\
		//////////And so on with all the other grades\\\\\\\\\\
		for(int i = 0; i < grades.length; i++)
		{
			if(grades[i] >= 90 )
				gradeCounter[0]++;
			else if(grades[i] >= 80 )
				gradeCounter[1]++;
			else if(grades[i] >= 70 )
				gradeCounter[2]++;
			else if(grades[i] >= 60 )
				gradeCounter[3]++;
			else
				gradeCounter[4]++;
					
		}
		return gradeCounter;
		}
	
	//////////Accessor to access money\\\\\\\\\\
	public int getMoney ()
	{
		int sum = 0;
//////////This For loop is to calculate how much money is needed for that party\\\\\\\\\\	
		//////////With if, else statements i check each element in array grades\\\\\\\\\\
		//////////If the element in array grades is grader than 90, and then it's an A\\\\\\\\\\
		//////////I add $20 to each A, and $10 to each B, and $5 to each C\\\\\\\\\\
		//////////Then i finally return the total amount of money\\\\\\\\\\
		for(int i = 0; i < grades.length; i++)
		{
			if(grades[i]>= 90)
				sum += 20;
			else if(grades[i]>= 80)
				sum += 10;
			else if(grades[i]>= 70)
				sum += 5;
		}
		System.out.print("The money needed for this party is $" );
		return (sum);
	}	
	
	//////////Accessor to access students\\\\\\\\\\
	public int getStudent() 
		{
		return student;
		}
	
	//////////Accessor to access the array of grades\\\\\\\\\\
	public int[] getA()
		{
		return grades;
		}
	
//////////Mutators\\\\\\\\\\
	//////////This method helps the user change the value of the array grades\\\\\\\\\\
	public void setA(int[] a)
		{
		this.grades = a;
		}

//////////ToString Method\\\\\\\\\\
	//////////The toString method allows the user to output the result as he/she wishes\\\\\\\\\\
	public String toString() 
	{
		int [] gradeCounter = getGrades();	
		return "The grade counter is [A:" + gradeCounter[0] + " B:" + gradeCounter[1] + " C:" 
				+ gradeCounter[2] + " D:" + gradeCounter[3] + " F:" + gradeCounter[4] +"]";
	}	
	
}


