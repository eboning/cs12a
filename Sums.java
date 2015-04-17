/* Sums.java
* Using input n from user, calculates j = 1/1 + 1/2 + 1/3 + ... + 1/n, and
* calculates and prints 1 + 4 + 6 + 8 + ... + 2j. Calculations are performed using recursive methods.
*
* Written by Edward Boning
*/

import java.util.*;

class Sums{
public static void main (String[] args){
//declare variables used in the main method
	Scanner input = new Scanner(System.in);
	boolean running = true;
	float number;
	Intro(); // call method "Intro" to print a user greeting
	while (running == true) { // while loop that repeats main calculations as long as the user desires
		System.out.println("Please input a number:");
		number = input.nextFloat();
// passes user input to the first function, rounds the result, passes number to the second function, then prints the result
		System.out.println("The sum of sums is  " + Multiple(Math.round(Ratio(number))));
		running = Check(); // calls method "Check" to get decision from user, sets while loop exit condition accordingly
	}
}

// method for printing user greeting
public static void Intro(){
	System.out.println("Welcome to the sum of sums program!");
}

// method to recursively calculate the first sequence
public static float Ratio(float x){
	if (x == 1){
		return 1;
	}
	else {
		return (1/x)  + Ratio(x-1);		
	}
}

// method to recursively calculate the second sequence
public static int Multiple(int y){
	if (y == 1){
		return 1;
	}
	else {
		return (2*y) + Multiple(y-1);
	}
}

// method to get Y/N input from user. Called recursively if an incorrect input is entered.
public static boolean Check(){
	Scanner input = new Scanner(System.in);
	String choice;
	System.out.println("Would you like to compute another sum? Y/N:");
	choice = input.next();
	if (choice.substring(0,1).equals("Y") || choice.substring(0,1).equals("y")) {
		return true;
	}
	else if (choice.substring(0,1).equals("N") || choice.substring(0,1).equals("n")) {
		return false;
	}
	else {
		return Check();
	}
}

}
