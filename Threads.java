import java.util.Random;
import java.util.Scanner;
/*Monica Bebawy
 * 2/24/16
 * objective is to simulate the management of OS processes in the system
 * 
 */
public class Threads
{
	public static void main (String [] args)
	{
		String[][] pct = genProcess();
		String[][] pit = genInstruct();
		Scanner scan = new Scanner(System.in);

		System.out.println("Commands: pct \t" + "run \t" + "pit \t" + "ps \t" + "kill \t" + "exit");
		System.out.print("Please enter any command to run: ");

		String input = scan.nextLine();

		while(!(input.equals("exit")))
		{  
			if(input.equalsIgnoreCase("pct"))
				genPCT(pct);
			else if(input.equalsIgnoreCase("run"))
				genRUN(pct, pit);
			else if(input.equalsIgnoreCase("pit"))
				genPIT(pit);
			else if(input.equalsIgnoreCase("ps"))
				genPS(pct);
			else if(input.equalsIgnoreCase("kill"))
			{
				int pID = scan.nextInt();
				genKill(pID);
			}
			System.out.println("\n\nCommands: pct \t" + "run \t" + "pit \t" + "ps \t" + "exit");
			System.out.print("Please enter any command to run: ");
			input = scan.nextLine();
		}	
	}
	public static void genRUN(String[][] pct, String[][] pit) 
	{ 
		for(int i=0;i<pit.length;i++)
		{
			if(pit[i][0].equalsIgnoreCase("finish"))
				pct[i][1] = "term"; 
			else if(!pit[i][0].equalsIgnoreCase("finish") && !pit[i][0].equalsIgnoreCase(""))
			{
				pct[i][3] = String.valueOf(Integer.parseInt(pct[i][3])+1);
				pct[i][5] = String.valueOf(Integer.parseInt(pct[i][5])+1);
				System.out.println(pct[i][0]+ "\t"+ pit[i][0]);

				if(pit[i][pit[i].length-1].equalsIgnoreCase("finish"))
				{ 
					for(int j = 0;j < pit[i].length-1; j++)
						pit[i][j] = pit[i][j+1];
					pit[i][pit[i].length-1] = "";
				}
				else
					for(int j = 0;j < pit[i].length-1; j++)
						pit[i][j] = pit[i][j+1]; 
			}
		}
	}

	public static void genPS(String[][] pct) 
	{ 
		for(int i = 0; i < pct.length; i++)
			if(pct[i][1].equalsIgnoreCase("running"))
			{ 
				for(int j = 0; j < pct[i].length; j++)
					System.out.print(pct[i][j]+"\t");
				System.out.println(""); 
			}
	}

	public static void genPIT(String[][] pit) 
	{
		System.out.println("Inst#1\t\tInst#2\t\tInst#3\t\tInst#4\t\tInst#5\t\tInst#6\t\tInst#7\t\tInst#8\t\tInst#9\t\tInst#10\t\tInst#11\t\tInst#12\n"
				+ "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for(int i=0; i<pit.length; i++)
		{
			for (int j=0; j < pit[i].length; j++)
				System.out.print(pit[i][j] +"\t\t");
			System.out.println("");
		}
	}

	public static void genPCT(String[][] pCT)
	{
		System.out.println("P ID\t\tT ID\t\tStatus\t\tCPU Time\tPriority\tInstruction Counter\n"
				+ "---------------------------------------------------------------------------------------------------");
		for(int i=0; i<pCT.length; i++)
		{
			for (int j=0; j < pCT[i].length; j++)
				System.out.print(pCT[i][j] +"\t\t");
			System.out.println("");
			}
	}

	public static String[][] genProcess()
	{
		String[][] output = new String[16][6];

		String[] stat = {"running", "waiting", "ready", "term"};
		String[] JobPri = {"top", "high", "medium", "low"};

		for(int i = 0; i < output.length; i++)
			for(int j = 0; j <output[i].length; j++)
			{
				Random rand = new Random();
				switch(j)
				{
				case 0:
					output[i][j] = String.valueOf(rand.nextInt(9999));
					break;
				case 1:
					output[i][j] = String.valueOf(i+1);
					break;
				case 2:
					output[i][j] = stat[rand.nextInt(stat.length)];
					break;
				case 3:
					output[i][j] = String.valueOf((0));
					break;
				case 4:
					output[i][j] = JobPri[rand.nextInt(JobPri.length)];
					break;
				case 5:
					output[i][j] = String.valueOf(0);
					break;
				}	
			}
		return output;
	}
	//function to generate instruction table
	public static String[][] genInstruct()
	{
		String[][] output = new String[16][12];
		String[] diffJobs = {"calc","output","input"};

		for(int i=0;i<output.length;i++)
		{
			Random rand = new Random();
			int finishAt = rand.nextInt(output[i].length);
			for(int j=0;j<output[i].length;j++)
			{
				if(j < finishAt)
					output[i][j] = diffJobs[rand.nextInt(diffJobs.length)];
				if(j == finishAt)
					output[i][j] = ("finish");
				if(j > finishAt)
					output[i][j] = ("");
			}
		}
		return output;
	}
	public static void genKill(int pid)
	{
		
	}
}