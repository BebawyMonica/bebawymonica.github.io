import java.io.FileNotFoundException;
public class CS380BebawyP4 
{

	public static void main (String [] args) throws FileNotFoundException
	{
		heading();
		RecursiveFunction fun = new RecursiveFunction();
		fun.GCD("gcdin.txt");
		fun.Palindrome("palIn.txt");
		footing();

	}
	
	
	/*			FUNCTION HEADING	 	                              */
	/***********************************************************************************/
	public static void heading()
	{                         // Function heading 
		System.out.println();
		System.out.println ( "Monica Bebawy   002-48-8529     CS 380  ");
		System.out.println ( " Spring 2016   Project # 4");
		System.out.println ();
		System.out.println ();
		return;
	}   // Function heading 
	/**************************************************************************************/    

	/***********************************************************************************/
	/*			FUNCTION FOOTING	 	                              */
	/***********************************************************************************/
	public static void footing()
	{                        // Function footing 
		System.out.println ();
		System.out.println ();
		System.out.println ( "END OF OUTPUT");
		System.out.println ();
		return;
	}   // Function footing
	/*********************************************************************************/
}
