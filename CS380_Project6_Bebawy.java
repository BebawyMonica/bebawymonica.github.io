import java.io.FileNotFoundException;

public class CS380_Project6_Bebawy 
{
	/*			FUNCTION HEADING	 	                              */
	/*******************************************************************************/
	public static void heading()
	  {                         // Function heading 
	    System.out.println();
	    System.out.println ( "Monica Bebawy      002-48-8529      CS 380  ");
	    System.out.println ( " Spring 2016   Project # 5" );
	    System.out.println ();
	    System.out.println ();
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
	public static void main(String[] args) throws FileNotFoundException
	{
		heading();
		BST tree = new BST();
		tree.read("program6In.txt");
		footing();
	}

}
