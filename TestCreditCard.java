
public class TestCreditCard 
{
	public static void main (String [] args)
	{
		CreditCard mycard = new CreditCard();
		CreditCard mycard2 = new CreditCard("Monica", 1000.00);
		CreditCard mycard3 = new CreditCard("Joe");

		System.out.println(mycard);
		System.out.println(mycard2);
		System.out.println(mycard3);

	}
}
