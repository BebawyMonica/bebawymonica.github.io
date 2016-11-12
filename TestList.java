
public class TestList 
{
	/*			FUNCTION HEADING	 	                                  */
	/**********************************************************************/
	public static void heading()
	{                         // Function heading 
		System.out.println();
		System.out.println ( "Monica Bebawy     002-48-8529      CS 380  ");
		System.out.println ( "  Spring 2016   Project # 2");
		System.out.println ();
		System.out.println ();
		return;
	}   // Function heading 
	/*************************************************************************/    
	/*************************************************************************/
	/*			FUNCTION FOOTING	 	                                     */
	/*************************************************************************/
	public static void footing()
	{                        // Function footing 
		System.out.println ();
		System.out.println ();
		System.out.println ( "END OF OUTPUT");
		System.out.println ();
		return;
	}   // Function footing
	/***************************************************************************/


	/***************************************************************************/
	/* 				MAIN PROGRAM				                               */
	/***************************************************************************/

	public static void main(String[] args) 
	{
		heading();
		
		List testList = new List();
		System.out.println("Testing the append method");
		testList.append(new Node("Monica", 1234.34));
		testList.append(new Node("Sarah", 86346.36));
		testList.append(new Node("Jonell", 19507.64));
		testList.append(new Node("Ali", 273578.95));
		testList.append(new Node("Joe", 6734.08));
		
		testList.showStructure();
		
		System.out.println("\n\n");
		System.out.println("Testing the insertBeginning method");
		testList.insertBeginning(new Node("Natalie", 2342));
		testList.showStructure();
		
		System.out.println("\n\n");
		System.out.println("Testing the insertBefore method");
		testList.insertBefore("Ali", new Node ("Caroline", 12034.23));
		testList.showStructure();
		
		System.out.println("\n\n");
		System.out.println("Testing the erase method");
		testList.erase("Ali");
		testList.showStructure();
		
		System.out.println("\n\n");
		System.out.println("Testing the insertAfter method");
		testList.insertAfter("Jonell", new Node ("Val", 12034.23));
		testList.showStructure();
		
		System.out.println("\n\n");
		System.out.println("Testing the update method");
		testList.update("Sarah", 1234567.45);
		testList.showStructure();
		
		System.out.println("\n\n");
		System.out.println("Testing the clear method");
		testList.clear();
		testList.showStructure();
		
		System.out.println("\n\n");
		System.out.println("Testing the append method after the list has been cleared");
		testList.append(new Node("Sophie", 54.34));
		testList.showStructure();
		
		System.out.println("\n\n");
		System.out.println("Testing the get method");
		testList.get("Sophie");
		System.out.println(testList.get("Sophie").toString());

		footing();
	}
}
