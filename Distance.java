/*Distance.java
*A program to calculate the Manhattan and Euclidean distances between
*two points entered by the user.
*
*Written by Edward Boning
*/

import java.util.*;
import java.text.DecimalFormat;

class Distance {
public static void main (String[] args) {
// declare and initialize all objects and variables
	Scanner userInput = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("#.##");
	double point1x, point1y, point2x, point2y, leg1, leg2, sum, euc, 
absX, absY, man;
// get input coordinates from users
	System.out.println("Enter coordinates for point 1:");
	point1x = userInput.nextDouble();
	point1y = userInput.nextDouble();
	System.out.println("Enter coordinates for point 2:");
	point2x = userInput.nextDouble();
        point2y = userInput.nextDouble();
// perform distance calculations for both values
	leg1 = point1x - point2x;
	absX = Math.abs(leg1);
	leg1 = leg1 * leg1;
	leg2 = point1y - point2y;
	absY = Math.abs(leg2);
	leg2 = leg2 * leg2;
	sum = leg1 + leg2;
	euc = Math.sqrt(sum);
	man = absX + absY;
// print calculated values, using DecimalFormat object to format output
	System.out.println("The Euclidean distance between the two points is:");
	System.out.println(df.format(euc));
	System.out.println("The Manhattan distance between the two points is:");
	System.out.println(df.format(man));
}
}
