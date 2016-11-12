import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class APU_CS400 {
	static String[] Keyword = {"Integer", "Float", "Function", "If", "Else", "Return", "Write", "DOWhile"};
	static String[] Integer = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	static String[] Operators = {"+", "-", "*", "/", "<=", ">=", "=", "++"};
	static String[] Separators = {"{", "}", "(", ")", ",", ";"};
	static char[] special = {'+', '-', '*', '/', '<', '>', '=', '{', '}', '(', ')', ',', ';'};
	public static void main(String[] args) throws FileNotFoundException 
	{
		FileInputStream fis = new FileInputStream("APU_CS400_Test3.txt");
		Scanner fs = new Scanner(fis);

		FileOutputStream fos = new FileOutputStream("APU_CS400_Output3.txt", true);
		PrintStream out = new PrintStream(fos);
		out.println("Group Name: Group X" + "\n" + "Members: Ali Citta, Sarah Harkin, Monica Bebawy" + "\n");
		out.println("Lexeme" + "\t\t\t\t" + "Token" + "\n");

		while(fs.hasNextLine()){
			String strLex = fs.nextLine();
			Scanner lexeme = new Scanner(strLex);
			lexeme.useDelimiter(" ");
			while(lexeme.hasNext())
			{
				String tempLex = lexeme.next().trim();
				split(tempLex);
			}
		}
	}
	static public String compareLexeme(String input) throws FileNotFoundException
	{
		String output;
		for(int i = 0; i < Keyword.length; i ++)
			if(input.equals(Keyword[i]))
			{
				output = "Keyword";
				writeToFile(input + "\t\t\t " + output);
				return null;
			}		
		for(int i = 0; i < Integer.length; i ++)
			if(input.startsWith(Integer[i])&& input.contains("."))
			{
				output = "Float";
				writeToFile(input + "\t\t\t " + output);
				return null;
			}

		for(int i = 0; i < Integer.length; i ++)
			if(input.startsWith(Integer[i]))
			{
				output = "Integer";
				writeToFile(input + "\t\t\t\t " + output);
				return null;
			}

		for(int i = 0; i < Operators.length; i ++)
			if(input.equals(Operators[i]))
			{
				output = "Operators";
				writeToFile(input + "\t\t\t\t " + output);
				return null;
			}
		for(int i = 0; i < Separators.length; i ++)
			if(input.equals(Separators[i]))
			{
				output = "Separators";
				writeToFile(input + "\t\t\t\t " + output);
				return null;
			}

		output = "Identifier";
		writeToFile(input + "\t\t\t\t " + output);
		return null;

	}
	static public void writeToFile(String output) throws FileNotFoundException
	{
		FileOutputStream fos = new FileOutputStream("APU_CS400_Output3.txt", true);
		PrintStream out = new PrintStream(fos);
		out.println(output);
	}
	static public void split (String input) throws FileNotFoundException
	{
		if(input.length() == 1)
		{
			compareLexeme(input);
			return;
		}
		else
		{
			for(int c = 0; c < input.length(); c++ ){
				for(int s = 0; s < special.length; s++)
				{
					if(input.charAt(c) == special[s] && c == 0)
					{
						if(special[s] == '<' || special[s] == '>')
							if(input.charAt(c+1) == '=')
							{
								String split1 = input.substring(0,2);
								compareLexeme(split1);
								split (input.substring(2));
								return; 
							}
						if(special[s] == '+')
						{
							if(input.charAt(c+1) == '+')
							{
								String split1 = input.substring(0,2);
								compareLexeme(split1);
								split (input.substring(2));
								return; 
							}
							else
							{
								String split1 = input.substring(0,1);
								compareLexeme(split1);
								split (input.substring(1));
								return; 
							}
						}
						else
						{
							String split1 = input.substring(0,1);
							compareLexeme(split1);
							split (input.substring(1));
							return; 
						}
					}
					else if(input.charAt(c) == special[s] && c != 0)
					{
						if(special[s] == '<' || special[s] == '>')
						{
							if(input.charAt(c+1) == '=')
							{
								String split1 = input.substring(0,c);
								compareLexeme(split1);
								String split2 = input.substring(c,c+2);
								compareLexeme(split2);
								String split3 = input.substring(c+2);
								split (split3);
								return; 
							}
						}
						if(special[s] == '+')
						{
							if(input.charAt(c+1) == '+')
							{
								String split1 = input.substring(0,c);
								compareLexeme(split1);
								String split2 = input.substring(c,c+2);
								compareLexeme(split2);
								String split3 = input.substring(c+2);
								split (split3);
								return; 
							}
							else
							{
								String split1 = input.substring(0,c);
								compareLexeme(split1);
								String split2 = input.substring(c,c+1);
								compareLexeme(split2);
								String split3 = input.substring(c+1);
								split (split3);
								return;
							}
						}
						else
						{
							String split1 = input.substring(0,c);
							compareLexeme(split1);
							String split2 = input.substring(c,c+1);
							compareLexeme(split2);
							String split3 = input.substring(c+1);
							split (split3);
							return;
						}
					}	
				}
			}
			if(input.length() > 1)
			{
				compareLexeme(input);
				return; 
			}
		}
	}
}
