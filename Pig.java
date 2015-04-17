/* Pig.java
* A basic English -> Pig Latin translator program written in Java.
* Contains rules for words starting with vowels, consonants, and the diphthong "qu."
* Also capitalizes the first letter of the first word of each rearranged sentence.
*
* Writtten by Edward Boning
*/

import java.util.*;

class Pig {
public static void main (String[] args) {
	Scanner input = new Scanner(System.in);
	String sentence, first, choice;
	boolean running=true;
	System.out.println("Welcome to the Pig Latin translator.");
	while (running==true){
		System.out.println("Please enter a sentence:");
		sentence = input.nextLine();
		String[] words = sentence.split(" ");
		for (int i=0; i<words.length; i++){
			words[i] = words[i].toLowerCase();
			String[] word = words[i].split("");
			if(word[1].equals("a") || word[1].equals("e") || word[1].equals("i") || word[1].equals("o") || word[1].equals("u")){
		                if (i==0){
	        	                word[1] = word[1].toUpperCase();  
	               		 }
				for (int h=0; h<word.length; h++){
					System.out.print(word[h]);
				}
				System.out.print("ay ");
			}
			else if(word[1].equals("q") && word[2].equals("u")){
	                        first = word[1].concat(word[2]);
	                        for (int j=1; j<word.length-1; j++){
	                                word[j] = word[j+1];
	                        }
	                        word[word.length-1] = first;
       		                 if (i==0){
	      		                word[2] = word[2].toUpperCase();  
	              		  }
				for (int k=2; k<word.length; k++){
	                                System.out.print(word[k]);
	                        }
	                        System.out.print("ay ");
			}
			else {
				first = word[1];
				for (int j=1; j<word.length-1; j++){
					word[j] = word[j+1];
				}
				word[word.length-1] = first;
        		        if (i==0){
        		                word[1] = word[1].toUpperCase();  
     		   	        }
				for (int k=0; k<word.length; k++){
					System.out.print(word[k]);
				}
				System.out.print("ay ");
			}
		}
		System.out.println("");
		System.out.println("Would you like to run again?");
		choice = input.nextLine();
		choice = choice.substring(0,1);
		if (choice.equals("Y") || choice.equals("y")){
			running = true;
		}
		else if (choice.equals("N") || choice.equals("n")){
			running = false;
			System.out.println("Thank you, goodbye!");
		}
		else {
			System.out.println("Please enter Y/N next time.");
		}
	}
}
}
