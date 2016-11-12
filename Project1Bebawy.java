import java.util.Random;
import java.util.Scanner;
/*Monica Bebawy
 * 2/24/16
 * objective is to simulate the management of OS processes in the system
 * 
 */
public class Project1Bebawy
{
	public static void main (String [] args)
	{
		String[][] pct = genProcess();
		String[][] pit = genInstruct();
		Scanner scan = new Scanner(System.in);

		System.out.println("Commands: pct \t" + "run \t" + "pit \t" + "ps \t" + "exit");
		System.out.print("Please enter any command to run: ");

		String input = scan.nextLine();

		while(!(input.equals("exit")))
		{  // while what they enter does not equal exit
			if(input.equalsIgnoreCase("pct"))
			{  //if what the user inputs is pct without looking at if it is upper or lower case
				genPCT(pct);// generate pct table
			}
			else if(input.equalsIgnoreCase("run"))
			{  //if what the user enters is run without looking at if it is upper or lower case
				genRUN(pct, pit);// generate run table
			}
			else if(input.equalsIgnoreCase("pit"))
			{  //if what the user enters is pit without looking at if it is upper or lower case
				genPIT(pit);// generate pit table
			}
			else if(input.equalsIgnoreCase("ps"))
			{  //if what the user enters is ps without looking at if it is upper or lower case
				genPS(pct);// generate pct table
			}
			System.out.println("\n\nCommands: pct \t" + "run \t" + "pit \t" + "ps \t" + "exit");
			System.out.print("Please enter any command to run: ");
			input = scan.nextLine();
		}	

	}

	public static void genRUN(String[][] pct, String[][] pit) 
	{  //function to generate run table, with pct and pit as parameters
		for(int i=0;i<pit.length;i++){ // i is equal to 0. i is less than the length of pit. i gets incremented by 1
			if(pit[i][0].equalsIgnoreCase("finish"))
			{//if the current row on the first column is finish without looking if it is upper or lower case
				pct[i][1] = "term"; //in the current row and second column gets term added in
			}
			else if(!pit[i][0].equalsIgnoreCase("finish") && !pit[i][0].equalsIgnoreCase(""))
			{ //if the current row and first column doesnt say finish or "" without looking at the case
				pct[i][2] = String.valueOf(Integer.parseInt(pct[i][2])+1);//take the current row and third column and increment by one then turn it into an int then back into a string and assign it to that row and third column
				pct[i][4] = String.valueOf(Integer.parseInt(pct[i][4])+1);// take the current tow and fifth column and increment by one then turn it into an int then back into a string and assign it to that row and fifth column
				System.out.println(pct[i][0]+ "\t"+ pit[i][0]);// print the current row and first column of the pct and pit

				if(pit[i][pit[i].length-1].equalsIgnoreCase("finish"))
				{ //if the current row of the last column says finish without looking at the case
					for(int j = 0;j < pit[i].length-1; j++)
					{ //j is equal to 0. j is less than the length of the current column in the last row, j gets incremented by one
						pit[i][j] = pit[i][j+1];//pit at the current row with an increment on the column gets assigned to pit[i][j]
					}
					pit[i][pit[i].length-1] = "";//the current row and last column of pit gets ""
				}
				else{
					for(int j = 0;j < pit[i].length-1; j++)
					{ // j is equal to 0. j is less than the current row and last column of pit,j increments by 1
						pit[i][j] = pit[i][j+1]; //the current row and current column incremented by one gets assigned to the current row and column of pit
					}
				}
			}
		}
	}

	public static void genPS(String[][] pct) 
	{ //function to generate PS table with pct as the parameter
		for(int i = 0; i < pct.length; i++)
		{ // i equals 0. i is less then the length of pct. incremented by 1
			if(pct[i][1].equalsIgnoreCase("running"))
			{ //if the current row of the second column equals running without looking at the case 
				for(int j = 0; j < pct[i].length; j++)
				{ // j equals 0, j is less than the length of the current row of pct. j is incremented by 1
					System.out.print(pct[i][j]+"\t");// print out the current row and column of pct table
				}
				System.out.println(""); //print out space to make it look nice
			}

		}
	}

	public static void genPIT(String[][] pit) 
	{// function to generate pit table 
		System.out.println("Inst#1\tInst#2\tInst#3\tInst#4\tInst#5\tInst#6\tInst#7\tInst#8\tInst#9\tInst#10\tInst#11\tInst#12");// print out the intruction numbers
		for(int i=0; i<pit.length; i++)
		{//i equals 0, i is less than the length of pit, i get incremented by 1
			for (int j=0; j < pit[i].length; j++)
			{//j equals 0, j is less than the length of the current row, j gets incremented by one
				System.out.print(pit[i][j] +"\t");//prints out the current row and column of pit
			}
			System.out.println("");//prints out a blank space to make it look nice
		}
	}

	public static void genPCT(String[][] pCT)
	{//function to generate pct table
		System.out.println("P ID\tStatus\tCPU Time\tPriority\tInstruction Counter");//prints out the column names for the table
		for(int i=0; i<pCT.length; i++)
		{//i equals 0, i is less than the length of pct, i gets incremented by one
			for (int j=0; j < pCT[i].length; j++)
			{//j equals 0, j is less then the length of the current row of pct,j gets incremented by one
				System.out.print(pCT[i][j] +"\t");//prints out the current row and column of pct
			}
			System.out.println("");
		}
	}

	public static String[][] genProcess()
	{//function to generate proccess table with no parameters
		String[][] output = new String[7][5];//the double string array has 7 rows and five columns and is named output

		String[] stat = {"running", "waiting", "ready", "term"};//array of different waiting statuses
		String[] JobPri = {"top", "high", "medium", "low"};//array of different levels of job priority

		for(int i=0;i<output.length;i++)
		{//i equals 0, i is less than the length of the output array, i gets incremented by one
			for(int j=0;j<output[i].length;j++)
			{//j equals 0, j is less than the length of the current row if output array, j gets incremented by one
				Random rand = new Random();//initializes the random class to generate random numbers
				switch(j){//switch statements for the column j
				case 0://first case
					output[i][j] = String.valueOf(rand.nextInt(9999));//take a random 4 digit integer and turn it into a string and assign it to the current row and column of output
					break;//break so that the case wont bleed into the other ones
				case 1://second case
					output[i][j] = stat[rand.nextInt(stat.length)];//randomly picks out of the statuses and assigns it to the current row and column of output
					break;//break so that the case wont bleed into the other ones
				case 2://third case
					output[i][j] = String.valueOf((0));//takes the value of 0 and turns it into a string and assigns it to the current row and column of output
					break;//break so that the case wont bleed into the other ones
				case 3://fourth case
					output[i][j] = JobPri[rand.nextInt(JobPri.length)];//takes a random job priority and assigns it to the current row and column of output
					break;//break so that the case wont bleed into the other ones
				case 4://fifth case
					output[i][j] = String.valueOf(0);//takes the value of 0 and turns it into a string and assigns it to the current row and column of output
					break;//break so that the case wont bleed into the other ones
				}	
			}
		}
		return output;//return the output array
	}

	public static String[][] genInstruct()
	{//function to generate instruction table
		String[][] output = new String[7][12];//double string array with 7 rows and 12 columns
		String[] diffJobs = {"calc","output","input"};// array of different jobs

		for(int i=0;i<output.length;i++)
		{//i equals 0, i is less than the length of the output array, i gets incremented by one
			Random rand = new Random();//random class to make random numbers
			int finishAt = rand.nextInt(output[i].length);//take the length of the current row of output and assign a random number to finishAt

			for(int j=0;j<output[i].length;j++)
			{//j equals 0, j is less than the length of the current row of output, j is incremented by 1
				if(j < finishAt)
				{//if j is less than finishAt number
					output[i][j] = diffJobs[rand.nextInt(diffJobs.length)];//randomly assign different job types in the current row and column of output array
				}
				if(j == finishAt)
				{//if j is equal to finishAt number
					output[i][j] = ("finish");//the current row and column gets the word finish in it
				}
				if(j > finishAt)
				{//if j is greater than finishAt
					output[i][j] = ("");//assign a blank space to that current row and column 
				}
			}
		}
		return output;
	}
}