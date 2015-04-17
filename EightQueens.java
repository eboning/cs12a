/* EightQueens.java
* A logic puzzle which asks the user to place eight queen pieces
* on a chess board in such a fashion that no queen can be captured
* by another in one move.
*
* Written by Edward Boning
*/

import java.util.*;

class EightQueens{

private static int queenCount=0;
private static boolean[][] board = new boolean [8][8];
private static String space = null;
private static boolean running = true;

public static void main(String[] args){
    int[] arrayPos = {0,0};

    while (running){
	place(parse());
    }
}


/************************************************************
* This method takes the given coordinate, checks the current*
* status of that position on the board, and places the queen*
* if it is a legal move. Otherwise, it returns an error to  *
* the user.						    *
*************************************************************/

public static void place(int[] pos){
    int num = pos[0];
    int let = pos[1];
    
    if (queenCount<8){
       if (board[num][let]) {
	    System.out.println("There is already a queen at " + space + ". Removing this queen.\n");
	    board[num][let] = false;
	    queenCount--;
	    place(parse());
        }
        else if (check(num, let)){
	    System.out.println(space + " is an illegal move. Please try again.");
	    place(parse());
        }
        else{
	    board[num][let] = true;
	    queenCount++;
	    place(parse());
        }
    }
}

/****************************************************************
* This method takes the coordinate for a given space and checks	*
* all of the spaces a queen in that space could move to. If it  *
* finds a queen in any of those spaces, it returns a "true"	*
* value. Otherwise, it returns "false"				*
*****************************************************************/

public static boolean check(int num, int let){
    int row, col;

    for (row=0; row<board.length; row++){
	if (board[row][let])
	    return true;
    }

    for (col=0; col<board[num].length; col++){
	if (board[num][col])
	    return true;
    }

    row = num;
    col = let;
    while (row>=0 && col>= 0){
	if (board[row][col])
	    return true;
	row--;
	col--;
    }

    row = num;
    col = let;
    while (row<board.length && col<board[let].length){
	if (board[row][col])
	    return true;
	row++;
	col++;
    }

    row = num;
    col = let;
    while (row<board.length && col>=0){
	if (board[row][col])
	    return true;
	row++;
	col--;
    }

    row = num;
    col = let;
    while (row>=0 && col<board[let].length){
	if (board[row][col])
	    return true;
	row--;
	col++;
    }

    return false;
}


/********************************************************************************
 * This method reads an input from the user and translates it into a set of	*
 * useful coordinates to be used in an array. First it gets a string from the	*
 * user, then uses switches to assign the associated row/column to an integer	*
 * array, which is returned to the calling environment.				*
 ********************************************************************************/

public static int[] parse(){
    int[] coords = new int[2];
    Scanner read = new Scanner(System.in);
    
    display(board);
    if (queenCount == 8) {
        System.out.println("\nGreat Job! You solved the puzzle!");
        running = false;
    }
    else {
        System.out.println("\nPlease enter a coordinate, of the form X# or x#:");
        space = read.next();
        if (space.length()==2){
            switch(space.charAt(0)){
	        case 'A':
       	        case 'a':
	        coords[1] = 0;
	        break;

       	        case 'B':
	        case 'b':
	        coords[1] = 1;
	        break;

	        case 'C':
	        case 'c':
	        coords[1] = 2;
	        break;

	        case 'D':
		case 'd':
	    	coords[1] = 3;
	    	break;

	    	case 'E':
	    	case 'e':
	    	coords[1] = 4;
	    	break;

	    	case 'F':
	    	case 'f':
	    	coords[1] = 5;
	    	break;

	    	case 'G':
	    	case'g':
	    	coords[1] = 6;
	    	break;

	    	case 'H':
	    	case'h':
	    	coords[1] = 7;
	    	break;

	    	default:
	    	System.out.println("This is not a valid entry, please try again.");
	    	return parse();
		}
    
            switch(space.charAt(1)){
            	case '1':
            	coords[0] = 7;
            	break;  
        
            	case '2':
            	coords[0] = 6;
            	break; 
        
            	case '3':
            	coords[0] = 5;
            	break; 
        
            	case '4':
            	coords[0] = 4;
            	break;
        
            	case '5':
            	coords[0] = 3;
            	break;

            	case '6':
            	coords[0] = 2;
            	break;

            	case '7':
            	coords[0] = 1;
            	break;

            	case '8':
            	coords[0] = 0;
            	break;

            	default: 
            	System.out.println("This is not a valid entry, please try again."); 
	    	return parse();

	    }
        }
        else{
	    System.out.println("This is not a valid entry, please try again.");
    	    return parse();
        }
    }
    return coords;
}


/************************************************************************
 * Displays the current status of the board. Walks through each element	*
 * of the array, printing whitespace if there is no Queen present and a	*
 * "Q" if a Queen is found. Also prints coordinate labels around the 	*
 * board for reference.							*
 ************************************************************************/ 

public static void display(boolean [][] b){
    System.out.println("  a b c d e f g h ");
    for (int row=0; row<b.length; row++){
	System.out.print(8-row+" ");
	for (int col=0; col<b[row].length; col++){
	    if (b[row][col])
		System.out.print("Q");
	    else
		System.out.print(" ");
	    System.out.print(" ");
	}
	System.out.println(8-row);
    }
    System.out.println("  a b c d e f g h ");
}

} //end of class
