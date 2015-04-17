/**
 *
 * @author Super
 */
public class SuperRandom {

    int offSet = 0;
    //random number list
    int[] randomers = {12,23,83,-200,-833,86,-100000000,2000000,60000000,0,0,7,
    77,62,34,76,22,-97,83,-200,-833,86,-100000000,12,23,83,-200,-833,86,-100000000,
    2000000,60000000,0,0,7,77,62,34,76,22,-97,83,-200,-833,86,-100000000,
    12,23,83,-200,-833,86,-100000000,2000000,60000000,0,0,7,
    77,62,34,76,22,-97,83,-200,-833,86,-100000000,12,23,83,-200,-833,86,-100000000,
    2000000,60000000,0,0,7,77,62,34,76,22,-97,83,-200,-833,86,-100000000};
    SuperRandom()
    {}

    //returns a random integer based on the numberOfQuestions...not very saavy.
    public int getNextRandom(int numberOfQuestions)
    {
        //increment and go go go...
        offSet +=1;
        return (randomers[(numberOfQuestions + offSet)]) ;
    }
}
