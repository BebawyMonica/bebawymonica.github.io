/*
 * This class tests all the methods that were created in CreditCardList
 */
public class TestCreditCardList 
{

	/*			FUNCTION HEADING	 	                                  */
	/**********************************************************************/
	public static void heading()
	{                         // Function heading 
		System.out.println();
		System.out.println ( "Monica Beabwy     002-48-8529      CS 380  ");
		System.out.println ( "  Spring 2016   Project # 1");
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

	public static void main(String[] args)  {
		/* Initialize variables if needed */

		heading ();

		CreditCardList theList= new CreditCardList(19);


		CreditCard Monica = new CreditCard("Monica", 123.45);
		CreditCard Ali = new CreditCard("Ali", 12.32);
		CreditCard Sarah = new CreditCard("Sarah", 12332.45);
		CreditCard Joe = new CreditCard("Joe", 40123.45);
		CreditCard person = new CreditCard("person ", 445324123.45);

		
		System.out.println("Is the list empty? " + theList.isEmpty());
		System.out.println("appending a new card to the list");
		theList.append(Ali);
		theList.showStructure();
		theList.append(Joe);
		theList.append(Sarah);
		theList.showStructure();
		System.out.println("appended all cards to the cardList");
		System.out.println("Is the list empty? " + theList.isEmpty());
		

		System.out.println("Is the list full? " + theList.isFull());

		theList.gotoBeginning();
		theList.getCursor();

		System.out.println("Checks if the list contains 'Ali'" + theList.contains("Ali" , 1234.65));

		System.out.println(theList.get("Joe",40123.45 ).toString());


		System.out.println("gotoPrior");
		theList.gotoPrior();
		theList.showStructure();


		theList.append(person);
		System.out.println("gotoNext");
		theList.gotoNext();
		//theList.showStructure();

		System.out.println("insert");
		theList.insert("Caroline", 12343.48);
		theList.showStructure();

		System.out.println("getCursor");
		theList.getCursor();
		theList.showStructure();

		System.out.println("insertBeginning");
		theList.insertBeginning(Monica);
		theList.showStructure();



		System.out.println("update");
		theList.update("Joe", 123456.43);
		theList.showStructure();

		System.out.println("erase");
		theList.erase("Sarah", 12332.45);
		theList.showStructure();

		System.out.println("gotoEnd");
		theList.gotoEnd();
		theList.showStructure();

		System.out.println("clear");
		theList.clear();
		theList.showStructure();

		theList.append(Sarah);
		theList.showStructure();


		footing ();

		return;
	}



}
