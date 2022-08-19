package com.skilldistillery.app;

import java.util.Scanner;

public class MakeChange {

	/**
	 * User will be prompted for the price of an item and how much they gave.
	 * User will then be given (sysout) their change and how it breaks down
	 * by denomination. Will output to the user that they did not provide
	 * enough money if they are short from the total.
	 * Will err if the user inputs a price or tendered that is not a number.
	**/
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		//variables that will hold user input for the price of an item and
		//how much money they gave the cashier
		double price, tendered;
		
		//mainLoop determines if the program repeats itself
		//transaction loop will be true until the user inputs a correct value after being asked
		//if they want to continue conducting transactions
		boolean mainLoop = true, transactionLoop;
		
		//String used to ask the user if they want to keep conducting transactions
		String keepRunning;
		
		//main loop of the program
		while(mainLoop) {
			//reset the value of transactionLoop so the next time the user gets to 
			//transaction loop it doesn't quit automatically
			transactionLoop = true;
			
			System.out.println("Please enter the the price of the item you are buying: ");
			price = kb.nextDouble();
			
			System.out.println("Please enter the amount given to the cashier: ");
			tendered = kb.nextDouble();
			
			calculateChange(price, tendered);
			
			while(transactionLoop) {
				System.out.println("Would you conduct another transaction? Y/N");
				keepRunning = kb.next();
				
				switch (keepRunning) {
					//probably excessive TODO: maybe change to if(keepRunning.equals(...).caseInsensitive statement?
					case "Y":
					case "y":
					case "yes":
					case "Yes":
					case "YES":
					case "YeS":
					case "yEs":
					case "YEs":
					case "yES":
						transactionLoop = false;
						break;
					case "N":
					case "n":
					case "No":
					case "no":
					case "NO":
					case "nO":
						System.out.println("Thank you! Good bye!");
						mainLoop = false;
						transactionLoop = false;
						break;
					default:
						System.err.println("Please type y, yes, n, or no (non-case-sensitive)");
						break;
				}
			}
		}
		kb.close();
	}
	
	public static double calculateChange(double price, double tendered) {
		double changeTotal = 0;
		System.out.println(price - tendered);
		return changeTotal;
	}
}
