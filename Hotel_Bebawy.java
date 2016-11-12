import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * Monica Bebawy
 * Project 5 Hotels
 * This project prompts the user with 5 different hotel options 
 * It asks the user to input which hotel they want to stay in 
 * Then it asks about the check-in and check-out information
 * First the program checks if they entered different months 
 * If so it prompts them again, saying that they need to enter the same month 
 * Then when they enter the same month, it checks if someone else already had these dates reserved 
 * If so It prints out the hotel options again and asks the user for different hotel or different days
 * Then it checks until these dates are not reserved, then it prints out the price per night and the total
 * And it also saves the reservation information in a txt file. 
 * At the end it prints out that the reservation was successful!
 */
public class Hotel_Bebawy 
{
	/*
	 * Declaring Variables:
	 * First there is a scanner to let the program interfere with the user
	 * Then Decimal Format to print the price in a formal way
	 * Then there is HotelPicked which stores the number of the hotel that they picked 
	 * HotelPicked is the information of the hotel number they picked
	 * PricePerNight stores the price per night for this hotel they picked 
	 * checkInMonth stores the check in month 
	 * checkInDay stores the check in day 
	 * checkOutMonth stores the check out month 
	 * checkOutDay stores the check out day 
	 * moneyPaid calculates the total money paid 
	 * DaysStayed calculates how many night are spent in the hotel
	 */
	static double moneyPaid = 0;
	static int DaysStayed = 0;
	static Scanner scan = new Scanner (System.in);
	static DecimalFormat df = new DecimalFormat ("$#,##0.00");
	static int checkInMonth = 0;
	static int checkInDay = 0;
	static int checkOutMonth = 0;
	static int checkOutDay = 0;
	static int hotelPicked = 0;
	static String HotelPicked = null;
	static double PricePerNight = 0;

	/*
	 * This is the HotelOptions method
	 * This method prints out all the hotels 
	 * First it reads from Hotels.txt 
	 * Then it prints out what is in Hotels.txt to the user
	 */
	public static void HotelOptions()
	{
		int curLineNum = -1;
		Scanner fScan = null;
		String fileName = "Hotels.txt";
		int numHotels = 0;
		try
		{
			/* this is the try block
			 *  Try to open the file
			 *  Print out if the file was found
			 *  then it reads the number of hotels 
			 *  Then it reads in from the file and prints out all the hotel options
			 */
			fScan = new Scanner(new File(fileName));
			System.out.println(fileName + " was found.");
			// Read in number of Hotels
			numHotels = fScan.nextInt();
			fScan.nextLine(); // Clear remaining white-space characters
			// Read in from file
			for (int i =0; i < numHotels; i++)
			{
				String line = fScan.nextLine();
				curLineNum = i+1;
				System.out.println(line);
			}
		}
		catch (FileNotFoundException e) 
		{
			System.err.println(fileName + " does not exist.");
		}
		/*
		 * This is the second catch block 
		 * this block catches any other exception in the Exception class
		 * and it prints out the they was in error and it prints out which line had the error
		 */
		catch (Exception e)
		{
			System.err.println("Please check line number " 
					+ curLineNum + " in your input file for an error.");
		}
	}

	/*
	 * This is the HotePicked method
	 * This method asks the user to enter the number of the hotel
	 * Then it prints out the information for this hotel
	 */
	public static void HotelPicked()
	{
		System.out.println("\n\nPlease enter the number of the hotel you would like to stay in:");
		hotelPicked = scan.nextInt();

		if(hotelPicked == 1)
		{
			HotelPicked = "Hotel(1, Azusa Inn, 23 Main St., Azusa, CA, 159)";
			PricePerNight = 159;
		}
		else if(hotelPicked == 2)
		{
			HotelPicked = "Hotel(2, San Dimas Suits, 1456 Apollo Ave., San Dimas, CA, 129)";
			PricePerNight = 129;
		}
		else if(hotelPicked == 3)
		{
			HotelPicked = "Hotel(3, Covina Comfort, 211 Crestline St., Covina, CA, 109)";
			PricePerNight = 109;
		}
		else if(hotelPicked == 4)
		{
			HotelPicked ="Hotel(4, Hotel Glendorado, 394 W. Third St., Glendora, CA, 179)";
			PricePerNight = 179;
		}
		else if(hotelPicked == 5)
		{
			HotelPicked = "Hotel(5, Pasadena Place, 483 Florence St., Pasadena, CA, 249)";
			PricePerNight = 249;
		}
		System.out.println(HotelPicked);
	}

	/*
	 * This is the DaysStayed method
	 * This method asks the user for the check-in and check-out info
	 * Its in a do..while loop to check and see if check-inMonth = checkOutMonth
	 */
	public static void DaysStayed()
	{
		Scanner scanIn = new Scanner (System.in);
		do
		{
			System.out.println("Please enter the check-in month.");
			checkInMonth = scanIn.nextInt();
			System.out.println("Please enter the check-in day.");
			checkInDay = scanIn.nextInt();
			System.out.println("Please enter the check-out month.");
			checkOutMonth = scanIn.nextInt();
			System.out.println("Please enter the check-out day.");
			checkOutDay = scanIn.nextInt();
			System.out.println("You entered " + checkInMonth + "/" + checkInDay +" for your check-in and "
					+ checkOutMonth + "/" + checkOutDay + " for your check-out.");	
			if(checkInMonth != checkOutMonth)
				System.out.println("Please enter same month for check-in and check-out");
		} while (checkInMonth != checkOutMonth);
	}

	/*
	 * This is the canBook method 
	 * This method checks if the reservation is already taken
	 */
	public static boolean canBook(Reservation_Bebawy nr)
	{
		for(Reservation_Bebawy reserve : Reservation_Bebawy.reservation )
		{
			boolean canBook = false;
			if((nr.getCheckInDay() >= reserve.getCheckInDay() && nr.getCheckInDay() <= reserve.getCheckOutDay()))
				canBook = false;
			if(nr.getCheckInDay()<= reserve.getCheckInDay() && nr.getCheckOutDay() >= reserve.getCheckOutDay())
				canBook = false;
			if(nr.getCheckInDay() >= reserve.getCheckInDay() && nr.getCheckOutDay() >= reserve.getCheckOutDay())
				canBook = false;
			if(nr.getCheckInDay() < reserve.getCheckInDay() && nr.getCheckOutDay() >= reserve.getCheckInDay())
				canBook = true;
			if(nr.getCheckInDay() >= reserve.getCheckOutDay())
				canBook = true;
			/**if(nr.getCheckOutDay() <= reserve.getCheckInDay() || nr.getCheckInDay() >= reserve.getCheckOutDay()
					&& reserve.getHotelName().equals(reserve.HotelName))
			canBook = true;*/
			else if(canBook == true)
				return true;
		}
		return true;
	}

	/*
	 * This is the PrintInfo
	 * This method prints it in the reservation.txt file
	 * and it is in a try..catch block 
	 */
	public static void PrintInfo()
	{

		try
		{
			FileOutputStream fos = new FileOutputStream("Reservation.txt", true);
			PrintWriter pw = new PrintWriter(fos);
			pw.println(HotelPicked + " -" + checkInMonth +"-" + checkInDay+ "-" + checkOutMonth + "-" + checkOutDay );
			pw.close();

		}
		catch (FileNotFoundException e)
		{
			System.out.println("Unable to write to objects");

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/*
	 * This is the AddInfo method 
	 * This method tells the user that the reservation was made successfully
	 * Then it prints the price per night 
	 * and the total price paid
	 */
	public static void AddInfo()
	{
		System.out.println("The reservation was successfully made");
		System.out.println("The price/night for this hotel is: " + df.format(PricePerNight));
		moneyPaid = checkOutDay - checkInDay;
		moneyPaid *= PricePerNight;
		DaysStayed = checkOutDay - checkInDay;
		System.out.println("You are staying for: " + DaysStayed + " days");
		System.out.println( "Your total money for the visit is: "+ df.format(moneyPaid));
	}

	/*
	 * This is the main method 
	 * This method makes a Hotel object 
	 * Then in a do..while loop the user checks everything is working
	 * The do..while is as long as the dates are already taken
	 */
	public static void main (String [] args) 
	{
		Hotel_Bebawy hotel = new Hotel_Bebawy();
		Reservation_Bebawy res = new Reservation_Bebawy(HotelPicked,checkInMonth, checkInDay, checkOutMonth, checkOutDay);
		do
		{
			Hotel_Bebawy.HotelOptions();
			Hotel_Bebawy.HotelPicked();	
			Hotel_Bebawy.DaysStayed();
			Hotel_Bebawy.canBook(Reservation_Bebawy.reserve);
			if (canBook(Reservation_Bebawy.reserve) == true)
			{

				Reservation_Bebawy.reservation.add(res);
				Hotel_Bebawy.AddInfo();
				Hotel_Bebawy.PrintInfo();
			}
			else if(canBook(Reservation_Bebawy.reserve) == false)
			{
				System.out.println("These dates are already reserved!");
				System.out.println("Please enter a different hotel or a different time range");
			}
		}while (canBook(res) == false);
	}
}
