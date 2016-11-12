//     Author:       Monica Babawy                                      		
//     Date:         4/19/2016                                                              	
//     Purpose:   To detect any deadlock in the system            
public class DeadlockDetection
{
	public static int count = 0;
	// This method is a helper method to see if there is a deadlock
	public static boolean deadlock2(char[][]input)
	{
		for(int row = 0; row < input.length; row++)
		{
			int count = 0;
			if(input[row][count] == 'w')
			{
				for(int fixCol = 0; fixCol < input.length; fixCol++)
				{
					int count2 = 0;
					if(input[fixCol][count2] == 'x')
					{
						for(int col = 0; col < input[fixCol].length; col++)
						{
							if(input[fixCol][col] == 'w')
							{
								for(int lastCheck = 0; lastCheck < input.length; lastCheck++)
								{
									if(input[lastCheck][col] == 'x')
									{
										for(int lastCol = 0; lastCol < input[lastCheck].length; lastCol++)
										{
											if(input[lastCheck][lastCol] == 'w')
												if(lastCheck == 0 && lastCol == 0)
												{
													System.out.println("Deadlock is detected.");
													return true;
												}
												else 
												{
													System.out.println("Congratulations! No deadlock is detected at this time");
													return false;
												}
										}
									}
									else 
									{
										System.out.println("Congratulations! No deadlock is detected at this time");
										return false;
									}


								}
							}
						}
					}
					count2++;
				}
			}
			count++;
		}
		return false; 
	}

	// This method prints the array
	public static void printArray(char [][] input){
		System.out.println("   C C C C C C C");
		for(int index = 0; index < input.length; index++)
		{
			System.out.print("R" + (index + 1) + " " );
			for(int col = 0; col < input[index].length; col++)
			{
				System.out.print(input[index][col] + " ");
			}
			System.out.println("");
		}
	}
	//This is the main method where i test my code.
	public static void main(String [] args)
	{
		char [][] testCase1 = {
				{'w','n','x','x','x','n','n'},
				{'x','w','n','n','n','x','n'},
				{'n','x','n','n','n','n','n'},
				{'n','n','n','n','n','n','x'},
				{'n','n','n','n','n','n','n'},
				{'n','n','w','n','n','n','w'},
				{'w','w','w','w','w','w','w'}};

		char [][] testCase2 = {
				{'w','x','x','x','x','n','n'},
				{'x','w','n','n','n','x','n'},
				{'n','x','w','n','n','n','n'},
				{'n','n','n','n','n','n','x'},
				{'n','n','n','n','n','n','n'},
				{'n','n','w','n','n','n','w'},
				{'w','w','w','w','w','w','w'}};

		char [][] testCase3 = {
				{'w','n','x','n','n','n','n'},
				{'x','n','w','n','n','n','n'},
				{'n','x','n','n','n','n','n'},
				{'n','n','n','n','n','n','x'},
				{'n','n','n','x','n','w','n'},
				{'n','n','w','n','n','n','w'},
				{'n','n','n','w','w','x','w'}};;
				printArray(testCase1);
				deadlock2(testCase1);
				System.out.println("\n\n\n");
				printArray(testCase2);
				deadlock2(testCase2);
				System.out.println("\n\n\n");
				printArray(testCase3);
				deadlock2(testCase3);

	}
}
