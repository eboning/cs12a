import tio.*;
import java.util.*;

/********************************************************/
/*  The Deck class is a new type that represents a deck	*/
/*  of cards.  It should have methods that have anything*/
/*  to do with a deck of cards.  A constructor and a	*/
/*  shuffle method are provided to get you started.	*/
/*  Written by:	Alex Pang				*/
/*  Date:	Feb 21, 2011				*/
/********************************************************/

class Deck
{
    public int[]	deck;
    private int remain;


    // -------------------
    // constructor
    // -------------------
    public Deck()
    {
	deck = new int[52];
	for( int i=0; i<52; i++ )
		deck[i] = i;
    }

    // -------------------
    // instance method
    // -------------------
    public void print()
    {
	for( int i=0; i<52; i++ )
		System.out.printf( "%3d", deck[i] );
	System.out.println();
    }

    // -------------------
    // instance method
    // -------------------
    public void shuffle()
    {
	int     i, j, tmp;
	int     seed;
	Random  r;

	System.out.print( "Enter your lucky number: " );
	seed = Console.in.readInt();
	tmp  = Console.in.readChar();// get rid of carriage return!
	r    = new Random(seed);            // initialize random # generator
     	remain = 52;

	for(i=0; i<52; i++ )                // shuffle deck of cards
	{
	    j       = r.nextInt(52);        // randomly pick a card
	    tmp     = deck[j];              // swap with i-th card
	    deck[j] = deck[i];
	    deck[i] = tmp;                                              
	}
    }

    public int[] draw(int number)
    {
	int[] pull = new int[number];

	if (remain >= number && number > 0){
            for (int i=0; i<number; i++){
		pull[i] = deck[52-remain];
		remain --;
		System.out.println(remain + " cards remain.");
	    }
	}
	else if (remain < number && number > 0){
	    System.out.println("Out of cards, shuffling a new deck.");
	    this.shuffle();
	    return this.draw(number);
	}
	return pull;
    }

}



