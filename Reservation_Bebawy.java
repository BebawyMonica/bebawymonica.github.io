import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * This is the Reservation Class
 * This class it holds the data of reservations dates
 */
public class Reservation_Bebawy
{
	/*
	 * Declaring variables 
	 * reservation is the arraylist that hold the reservations
	 */
	static ArrayList<Reservation_Bebawy> reservation = new ArrayList <Reservation_Bebawy>();
	String HotelName = "";
	int checkInMonth = 0;
	int checkInDay = 0;
	int checkOutMonth = 0;
	int checkOutDay = 0;
	static Reservation_Bebawy reserve;
	Hotel_Bebawy h1 = new Hotel_Bebawy();

	// Default Constructor 
	Reservation_Bebawy ()
	{
		HotelName = "";
		checkInMonth = 0;
		checkInDay = 0;
		checkOutMonth = 0;
		checkOutDay = 0;
	}

	// Overloaded constructor 
	Reservation_Bebawy (String HotelN, int checkInM, int checkInD,int checkOutM, int checkOutD)
	{
		HotelName = HotelN;
		checkInMonth = checkInM;
		checkInDay = checkInD;
		checkOutMonth = checkOutM;
		checkOutDay = checkOutD;
	}

	// Getters and Setters
	public String getHotelName() 
	{
		return HotelName;
	}
	public void setHotelName(String hotelN) 
	{
		HotelName = hotelN;
	}
	public int getCheckInMonth() 
	{
		return checkInMonth;
	}

	public void setCheckInMonth(int checkInM)
	{
		checkInMonth = checkInM;
	}

	public int getCheckInDay()
	{
		return checkInDay;
	}

	public void setCheckInDay(int checkInD) 
	{
		checkInDay = checkInD;
	}

	public int getCheckOutMonth() 
	{
		return checkOutMonth;
	}

	public void setCheckOutMonth(int checkOutM) 
	{
		checkOutMonth = checkOutM;
	}

	public int getCheckOutDay() 
	{
		return checkOutDay;
	}

	public void setCheckOutDay(int checkOutD)
	{
		checkOutDay = checkOutD;
	}

	/*
	 * This is the addReservation method 
	 * This method adds the reservation to the arraylist
	 * By using a demiliter and parsing strings
	 */
	public static void addReservation(Reservation_Bebawy re)
	{
		reserve = re;
		try 
		{
			Scanner fscan = new Scanner(new File("Reservation.txt"));
			while (fscan.hasNextLine())
			{

				String h = "";
				int cim = 0;
				int cid = 0;
				int com = 0;
				int cod = 0;
				String stringRead = fscan.nextLine();
				Scanner parse = new Scanner (stringRead); 
				parse.useDelimiter("-");
				h = parse.next();
				reserve.setHotelName(h);
				System.out.println(reserve.getHotelName());
				cim = Integer.parseInt(parse.next());
				reserve.setCheckInMonth(cim);
				System.out.println(reserve.getCheckInMonth());
				cid = Integer.parseInt(parse.next());
				reserve.setCheckInDay(cid);
				System.out.println(reserve.getCheckInDay());
				cod = Integer.parseInt(parse.next());
				reserve.setCheckOutMonth(com);
				System.out.println(reserve.getCheckOutMonth());
				com = Integer.parseInt(parse.next());
				reserve.setCheckOutDay(cod);
				System.out.println(reserve.getCheckOutDay());
				reservation.add(reserve);
				parse.close();
			}
		} 
		catch (FileNotFoundException e) 
		{

			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}	
	}
}

