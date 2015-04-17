/* Format.java
* A program that takes a designated line width, reads in a given line of text, and justifies the text
* to the left, right, or center of lines of the given width. 
*
* Written by Edward Boning
*/

import java.util.*;

class Format{ public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	Intro();
	System.out.println("Enter the desired line width:");
	int width = input.nextInt();
	System.out.println("Enter the text to be formatted::");
	String text = input.useDelimiter("\n").next();
	Run(text, width);
}

public static void Intro(){
	System.out.println("Welcome to the text formatter.");
}

public static void Run(String text, int width){
	Scanner input = new Scanner(System.in);
        String choice;
        System.out.println("Select a format: (L)eft-justified, (R)ight-justified, (C)entered, or (Q)uit");
        choice = input.next();
        if (choice.substring(0,1).equals("L") || choice.substring(0,1).equals("l")) {
                Left(text, width);
		Run(text, width);
        }
        else if (choice.substring(0,1).equals("R") || choice.substring(0,1).equals("r")) {
                Right(text, width);
		Run(text, width);
        }
	else if (choice.substring(0,1).equals("C") || choice.substring(0,1).equals("c")) {
                Center(text, width);;
		Run(text, width);
        }
	else if (choice.substring(0,1).equals("Q") || choice.substring(0,1).equals("q")) {
                return;
        }
        else {
                System.out.println("Please enter one of the choices listed");
		Run(text, width);
        }	
}

public static void ruler(int width){
	for (int i=1; i<=width; i++){
		if (i%10 == 0)
			System.out.print("+");
		else
			System.out.print(i%10);
		if (i == width)
			System.out.print("\n");
	}
}

public static void Left(String text, int width){
	StringTokenizer tk = new StringTokenizer(text);
	int count = tk.countTokens();
	int runninglength = 0;
	int wordlength = 0;
	String word;
	ruler(width);
	for (int i=0; i<count; i++){				// for each word in the line
		word = tk.nextToken();					// extract next word from the line
		wordlength = word.length();				// count that words length
		if (wordlength > (width - runninglength)){		// if the word does not fit on the new line
                        System.out.print("\n");                         	// start a new line
                        runninglength = 0;                              	// reset the running length of the line to 0
		}
                runninglength = runninglength + (wordlength + 1); 	// add that length, plus the space that will follow it, to the running length of the line
                System.out.print(word);                         	// print the word
                if (i == count-1)
                        System.out.print("\n");                 	// if the this is the last word in the line, print a linebreak
                else
                	System.out.print(" ");                  	// otherwise, follow the word with a space
	}
	System.out.print("\n");
}

public static void Right(String text, int width){
        StringTokenizer tk = new StringTokenizer(text);
        int count = tk.countTokens();
        int runninglength = 0;
        int wordlength = 0;
        String word;
	String line="";
        ruler(width);
        for (int i=0; i<count; i++){                            // for each word in the line
                word = tk.nextToken();                                  // extract next word from the line
                wordlength = word.length();                             // count that words length
                if (wordlength > (width - runninglength)){              // if the word does not fit on the new line
			for (int j=0; j<=(width - runninglength); j++)		// for each space available in the line
				System.out.print(" ");					// print a space
			System.out.print(line+"\n");				// prints the line that is determined to fit
			line = "";						// empties the line variable
                        runninglength = 0;                                      // reset the running length of the line to 0
                }
                runninglength = runninglength + (wordlength + 1);       // add that length, plus the space that will follow it, to the running length of the line
		line = line.concat(word+" ");					// adds the current word to the running line
        }
	for (int k=0; k<=(width-runninglength); k++)		// for each space available in the line
		System.out.print(" ");					// print a space
	System.out.print(line+"\n");				// prints the final line
}

public static void Center(String text, int width){
        StringTokenizer tk = new StringTokenizer(text);
        int count = tk.countTokens();
        int runninglength = 0;
        int wordlength = 0;
	int spaces=0;
        String word;
        String line="";
        ruler(width);
        for (int i=0; i<count; i++){                            // for each word in the line
                word = tk.nextToken();                                  // extract next word from the line
                wordlength = word.length();                             // count that words length
                if (wordlength > (width - runninglength)){              // if the word does not fit on the new line
                        for (int j=0; j<=spacer((width - runninglength)); j++)          // for each space available in the line
                                System.out.print(" ");                                  // print a space
                        System.out.print(line+"\n");                            // prints the line that is determined to fit
                        line = "";                                              // empties the line variable
                        runninglength = 0;                                      // reset the running length of the line to 0
                }
                runninglength = runninglength + (wordlength + 1);       // add that length, plus the space that will follow it, to the running length of the line
                line = line.concat(word+" ");                                   // adds the current word to the running line
        }
        for (int k=0; k<=spacer((width-runninglength)); k++)            // for each space available in the line
                System.out.print(" ");                                  // print a space
        System.out.print(line+"\n");                            // prints the final line
}

public static int spacer(int spaces){
	spaces = spaces/2;
	if (spaces % 2 == 1)
		return (spaces-1);
	else
		return spaces;
}

}
