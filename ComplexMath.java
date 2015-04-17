/****************************************************************
 * ComplexMath.java
 * A class that gets two complex numbers from the user and	*
 * prints their sum, product, and absolute values.		*
 * 								*
 * By Edward Boning, from skeleton code provided by Alex Pang	*
 ****************************************************************/

import tio.*;

class ComplexMath { 
    public static void main(String [] args) {
	//declaring variables
	Complex compNum1 = new Complex();
	Complex compNum2 = new Complex();

	//sets values of the Complex objects to values input by the user
	System.out.println("Enter a real and an imaginary component: ");
	compNum1.setValue(Console.in.readDouble(), Console.in.readDouble());
	System.out.println("Enter another real and an imaginary component: ");
	compNum2.setValue(Console.in.readDouble(), Console.in.readDouble());

	//calls the methods to calculate and print the sum and product
	System.out.println("\nThe sum of the two complex numbers is: ");
	compNum1.add(compNum2).print();
	System.out.println("\nThe product of the two complex numbers is: ");
	compNum1.multiply(compNum2).print();

	//prints the absiolute values of the Complex numbers, calculated by the absValue method
	System.out.println("\nThe absolute value of the first number is: " + compNum1.absValue());
	System.out.println("The absolute value of the second is: " + compNum2.absValue());
    }
}

class Complex {
    public double real, imaginary; //declaring more variables
    
    //manipulator method
    public void setValue(double x, double y){
	real = x; //setting real numbers
	imaginary = y; //setting imaginary numbers
    }
    
    //performs the addition of the implicit parameter and the argument
    public Complex add(Complex NumValue){
	Complex compSum = new Complex();
	compSum.setValue((real + NumValue.real), (imaginary + NumValue.imaginary));
	return compSum;
    }
    
    //performs the multiplication of the implicit parameter and the argument
    public Complex multiply(Complex NumValue){
	Complex compProd = new Complex();
	compProd.setValue( ((real * NumValue.real)-(imaginary * NumValue.imaginary)), ((imaginary * NumValue.real) + (real * NumValue.imaginary)) );
	return compProd;
    }
    
    //calculates the absolute value of the implicit parameter
    public double absValue(){	
	double abs;
	abs = (double)(Math.sqrt((real*real)+(imaginary*imaginary)));
	return abs;
    }
    
    //prints a line stating the two pieces of the complex number
    public void print(){
	System.out.println("Real value is: " + real + "  Imaginary value is: " + imaginary);
    }
}
