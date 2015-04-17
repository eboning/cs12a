/* Tester.java
* A simple math quiz, with two different difficulty levels.
*
* Written by Edward Boning, utilizing a number generator class
* written by Alex Pang.
*/

import java.util.*;

class Tester {
public static void main (String[] args)
{
// declare objects and variables, print introduction
SuperRandom randomNumberGenerator = new SuperRandom();
Scanner userInput = new Scanner(System.in);
final int numberOfQuestions = 5;
int choice, correct = 0, count = 0, numA, numB, evenOdd, answer, solution;
float guess, productQuotient, numC, numD;
boolean finished = false;
System.out.println("Welcome to my Math Quiz program!");

// while loop to repeat quiz until exited	
while (finished == false) {
	System.out.println("Please choose an option:\n1. Addition/Subtraction\n2. Multiplication/Division\n3. Exit Program");
	choice = userInput.nextInt();
// each if statement provides instructions to run the quiz levels
	if (choice == 1) {
		count = 0;
		correct = 0;
		while (count < numberOfQuestions) {
// generate random numbers for each question, with a modulo assignment and if-else statement to determine a random operator for each question
			numA = randomNumberGenerator.getNextRandom(numberOfQuestions);
			numB = randomNumberGenerator.getNextRandom(numberOfQuestions);
			evenOdd = randomNumberGenerator.getNextRandom(numberOfQuestions);
			evenOdd = evenOdd % 2;
			if (evenOdd == 0) {
				solution = numA - numB;
				System.out.println("What is " + numA + "-" + numB + "?");
			}
			else {
				solution = numA + numB;
				System.out.println("What is " + numA + "+"  + numB + "?");
			}
			answer = userInput.nextInt();
			if (answer == solution) {
				correct = correct + 1;
			}
			count = count + 1;
		}
		System.out.println("You got " + correct + "/" + numberOfQuestions + " correct!");
	}

// if statement representing quiz level 2, designed similarly to level 1
	if (choice == 2) {
		count = 0;
		correct = 0;
        	while (count < numberOfQuestions) {
        		numC = randomNumberGenerator.getNextRandom(numberOfQuestions);
        		numD = randomNumberGenerator.getNextRandom(numberOfQuestions);
        		evenOdd = randomNumberGenerator.getNextRandom(numberOfQuestions);
       			evenOdd = evenOdd % 2;   
        		if (evenOdd == 0) {
                		productQuotient = numC / numD;
                		System.out.println("What is " + numC + " / " + numD + "?");
        		}
        		else {
                		productQuotient = numC * numD;
                		System.out.println("What is " + numC + " * "  + numD + "?");
			}
        		guess = userInput.nextFloat();
			if (guess == productQuotient) {
                		correct = correct + 1;
        		}
        		count = count + 1;
        	}
	System.out.println("You got " + correct + "/" + numberOfQuestions + " correct!");
	}

// when choice 3 is selected, while loop is exited and the program finishes
	if (choice == 3) {
		finished = true;
	}
}
System.out.println("Thanks for playing!");
}
}
