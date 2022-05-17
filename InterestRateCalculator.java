import java.util.Scanner;

/**
 * @author Arash
 *
 *Write a program that reads a bank account balance and an interest rate and 
 *displays the value of the account in ten years. 
 *
 *The output should show the value of the account for 
 *three different methods of compounding interest: annually, monthly, and daily. 
 *
 *When compounded annually, the interest is added once per year at the end of the year.
 *When compounded monthly, the interest is added 12 times per year. 
 *When computed daily, the interest is added 365 times per year. 
 *
 *You do not have to worry about leap years; assume that all years have 365 days. For
 *annual interest, you can assume that the interest is posted exactly one year from the date of
 *deposit. In other words, you do not have to worry about interest being posted on a specific day
 *of the year, such as December 31. Similarly, you can assume that monthly interest is posted
 *exactly one month after it is deposited. Since the account earns interest on the interest, it
 *should have a higher balance when interest is posted more frequently. Be sure to adjust the
 *interest rate for the time period of the interest. 
 *
 *If the rate is 5 percent, you use 5/12 percent when posting monthly interest 
 *and 5/365 percent when posting daily interest. 
 *Perform this calculation using a loop that adds in the interest for each time period, 
 *that is, do not use some sort of algebraic formula. 
 *Your program should have an outer loop that allows the user to repeat this 
 *calculation for a new balance and interest rate. The calculation is repeated 
 *until the user asks to end the program.
 */
public class InterestRateCalculator 
{
	public static void main(String[] args) 
	{
		while (true)
		{
		
		//variables
		double accountBalance, interestRate;
		int year;
		
		//input
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter the starting account balance or enter 0 to quit: ");		
		accountBalance = keyboard.nextDouble();
		
			//exit the program
			if (accountBalance == 0)
			{
				System.out.println("Goodbye.");
				break;
				//System.exit(0);
			}
		
		//gets interest from user and converts to decimal
		System.out.print("Please enter the percent interest rate: ");	
		interestRate = keyboard.nextDouble();
		interestRate /= 100;
		
		//gets year from user
		System.out.print("Please enter the number of years: ");	
		year = keyboard.nextInt();
		
		//output
		System.out.printf("After %d years, your original balance of %.2f compound annually will be %.2f.\n"
				,year,  accountBalance, compoundAnnually(accountBalance, interestRate, year));
		
		System.out.printf("After %d years, your original balance of %.2f compound monthly will be %.2f.\n"
				,year,  accountBalance, compoundMonthly(accountBalance, interestRate, year));
		
		System.out.printf("After %d years, your original balance of %.2f compound daily will be %.2f.\n\n"
				,year,  accountBalance, compoundDaily(accountBalance, interestRate, year));
		}
	}
	
	/**
	 * interest compounded yearly
	 * @param balance
	 * @param interest
	 * @param year
	 * @return
	 */
	static double compoundAnnually(double balance, double interest, int year)
	{
		for (int counter=0; counter<year; counter++)
			balance *= (1 + interest);
		return balance;
	}
	
	/**
	 * interest compounded monthly
	 * @param balance
	 * @param interest
	 * @param year
	 * @return
	 */
	static double compoundMonthly(double balance, double interest, int year)
	{
		for (int counter=0; counter<year*12; counter++)
			balance *= (1 + interest/12);
		return balance;
	}
	
	/**
	 * interest compounded daily
	 * @param balance
	 * @param interest
	 * @param year
	 * @return
	 */
	static double compoundDaily(double balance, double interest, int year)
	{
		for (int counter=0; counter<year*365; counter++)
			balance *= (1 + interest/365);
		return balance;
	}
}
