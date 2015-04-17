/* Triangle.java
* A program that will print an ASCII-art image of an equilateral
* triangle with sides of a length given by the user.
*
* Written by Edward Boning
*/

import java.util.*;

class Triangle {
	public static void main (String[] args) {
// Declare and initialize objects and variables, print introduction statement.
	Scanner input = new Scanner(System.in);
	int sideLength, currentRow, spaces=0;
	System.out.println("Welcome to the equilateral triangle drawing program!");
	System.out.println("Enter an integer for the length of the side:");
// Receive user input, assigning to the two separate variables that will control the iterative statements.
	sideLength = input.nextInt();
	currentRow = sideLength;
	if (sideLength <= 1) { // if statement to prevent illegal input
		System.out.println("You must input a side length of 2 or higher.");
	}
	else {
		for (int i=0; i<sideLength; i++) { // for loop that will print each row of the triangle.
			for (int j=1; j<=currentRow; j++) { // for loop that will print the number of asterisks in each new row.
                                if (j == 1) {
                                        for (int k=0; k<spaces; k++) { // before printing the first asterisk of a new line, offsets it by the proper number of spaces.
                                                System.out.print(" ");
                                        }
                                }
				System.out.print("* ");
				if (j == currentRow) { // after the last asterisk in a row is printed, appends line break and increments number of spaces to be printed.
					System.out.print("\n");
					spaces = spaces + 1;
				}
			}
			currentRow = currentRow - 1 ; // decrements the number of asterisks to be printed.
		}
	}		
	}
}
