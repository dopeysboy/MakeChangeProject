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
	
	static Scanner kb = new Scanner(System.in);
	
	//variables that will hold user input for the price of an item,
	//how much money they gave the cashier, and how much change they
	//are due
	static double price, tendered, change;
	
	//mainLoop determines if the program repeats itself
	//transaction loop will be true until the user inputs a correct value after being asked
	//if they want to continue conducting transactions
	static boolean mainLoop = true, transactionLoop;
	
	//String used to ask the user if they want to keep conducting transactions
	static String keepRunning;
	
	public static void main(String[] args) {
		cashierInteraction();
		kb.close();
	}
	
	public static void cashierInteraction() {
		while(mainLoop) {
			//reset the value of transactionLoop so the next time the user gets to 
			//transaction loop it doesn't quit automatically
			transactionLoop = true;
			
			System.out.println("Please enter the the price of the item you are buying: ");
			price = kb.nextDouble();
			
			System.out.println("Please enter the amount given to the cashier: ");
			tendered = kb.nextDouble();
			
			change = Math.round(calculateChange(price, tendered) * 100.0) / 100.0;
			
			//this will not run if they did not provide enough change
			if(change >= 0) {
				System.out.println("Your change is: " + change);
				calculateBiggestChange(change);
			}
			
			while(transactionLoop) {
				System.out.println("Would you conduct another transaction? Y/N");
				keepRunning = kb.next();
				
				
				if(keepRunning.equalsIgnoreCase("Y") || keepRunning.equalsIgnoreCase("yes")) {
					transactionLoop = false;
				}
				else if(keepRunning.equalsIgnoreCase("n") || keepRunning.equalsIgnoreCase("no")) {
					mainLoop = false;
					transactionLoop = false;
					System.out.println("Thank you! Good bye!");
				}
				else {
					System.err.println("Please type y, yes, n, or no (non-case-sensitive");
				}
			}
		}
	}
	
	//Given an input of double price and double tendered, will return the total change required
	public static double calculateChange(double price, double tendered) {
		if(price - tendered > 0) {
			System.err.println("You did not provide enough change!");
			return -1;
		}
		else {
			return tendered - price;
		}
	}
	
	/**
	 * Given an input of double change, will sysout the denominations for that change in the biggest
	 * possible way (i.e. change = 1.69 will sysout: 
	 * $1 - 1
	 * $.25 - 2
	 * $.10 - 1
	 * $.05 - 1
	 * $.01 - 4
	**/
	public static void calculateBiggestChange(double change) {
		//amtToTender is just a running total of how much change is left to tender, the rest are counters
		//for the rest of the denominations
		double twenty = 0, ten = 0, five = 0, one = 0, quarter = 0, dime = 0, nickel = 0, penny = 0; 
		double amtToTender = change;
		
		//provided exact change for their purchase
		if(change == 0) {
			System.out.println("You provided the exact amount! Congrats!");
			return;
		}
		else if(change < 0) {
			return;
		}
		
		//there may be a better way to do this, but I can't think of one right now
		while(amtToTender / 20 >= 1) {
			twenty ++;
			amtToTender -= 20;
		}
		while(amtToTender / 10 >= 1) {
			ten ++;
			amtToTender -= 10;
		}
		while(amtToTender / 5 >= 1) {
			five ++;
			amtToTender -= 5;
		}
		while(amtToTender / 1 >= 1) {
			one ++;
			amtToTender -= 1;
		}
		while(amtToTender / .25 >= 1) {
			quarter ++;
			amtToTender -= .25;
		}
		while(amtToTender / .1 >= 1) {
			dime ++;
			amtToTender -= .1;
		}
		while (amtToTender / .05 >= 1) {
			nickel ++;
			amtToTender -= .05;
		}
		while(amtToTender > 0.005) {
			penny ++;
			amtToTender -= .01;
		}
		
		if(twenty != 0) {
			System.out.println("$20 - " + twenty);
		}
		if(ten != 0) {
			System.out.println("$10 - " + ten);
		}
		if(five != 0) {
			System.out.println("$5 - " + five);
		}
		if(one != 0) {
			System.out.println("$1 - " + one);
		}
		if(quarter != 0) {
			System.out.println("$.25 - " + quarter);
		}
		if(dime != 0) {
			System.out.println("$.10 - " + dime);
		}
		if(nickel != 0) {
			System.out.println("$.05 - " + nickel);
		}
		if(penny != 0) {
			System.out.println("$.01 - " + penny);
		}
	}
}
