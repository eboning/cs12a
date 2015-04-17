/* Doubles.java
* A program that reads an input file line and prints the elements in a 4x4 matrix. The program then calculates the sum of the elements 
* in a line from the top-left corner to the bottom-right corner and prints, then transposes the matrix and repeats this process.
*
* By Edward Boning
*/


import java.util.*;
import java.io.*;

class Doubles{
public static void main(String[] args){
// declares the arrays to be used in the methods, and calls the methods that print the matrices.
	int[][] array1 = new int[4][4];
	int[][] array2 = new int[4][4];
	original(array1);
	transpose(array1, array2);
}

// method to read the input file and display the first matrix and sum
public static void original(int[][] array){
	try {	// try block to avoid exceptions
		Scanner input = new Scanner(new File("input.txt")); // creates a Scanner object to read through input.txt
		System.out.println("Here is the original matrix:"); // prints a heading above the first matrix
		for (int i=0; i<array.length; i++){		// nested for loops to walk through each element of the array
			for (int j=0; j<array.length; j++){
				array[i][j] = input.nextInt();  // assigns each line of the input file to each element of the array
			}
		}
  	     	for (int k=0; k<array.length; k++){	// nested for loops to walk through each element of the array
        	       for (int l=0; l<array.length; l++){
                	        System.out.print(array[k][l]+" "); // prints each element of the array
     	        	        if (l==(array.length -1)) // prints a newline character at the end of each row of the matrix
        	                System.out.print("\n");
      		       }
		}
		System.out.println("The sum of the diagonal is: " + Diag(array) + "\n"); // prints a statement to accompany the sum, and calls the method to calculate it
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
}

// method to transpose the first matrix and display the sum of its diagonal
public static void transpose(int[][] array, int[][] trans){
	System.out.println("Here is the transpose of the  matrix:"); // prints a heading above the transposed matrix
	for (int i=0; i<trans.length; i++){		// nested for loops walk through each element of the array
		for (int j=0; j<trans.length; j++){
			trans[j][i] = array[i][j];	// to each element of the new array, assigns the proper element from the old array
		}
	}
        for (int k=0; k<trans.length; k++){	// nested for loops walk through each element of the array
                for (int l=0; l<trans.length; l++){
                        System.out.print(trans[k][l]+" "); // prints each element of the array
                        if (l==(trans.length -1))	// prints a newline character at the end of each row of the matrix
                        System.out.print("\n");
                }
        }
        System.out.println("The sum of the diagonal is: " + Diag(trans) + "\n"); // prints a statement to accompany the sum, and calls the methodd to calculate it
}

// method to calculate the sum of the necessary elements in the arrays
public static int Diag(int[][] array){
	int sum=0; // declares and initializes the variable that holds the sum
	for (int i=0; i<array.length; i++){ // for loop to walk through the proper elements of the array
		sum = (sum + array[i][i]); // adds each element to the running total
	}
	return sum; // returns the required sum
}

}
