/************************************************************************
 * Program: ImageProc.java; class ImageProc				
 * Authors: Patrick Au (xxxxx@ucsc.edu)
 * 	    Dave Rajczyk (xxxxxx@ucsc.edu)
 * Modified by: Alex Gainer, 2/13/11
 * Modified by: Alex Pang,   2/19/11
 * Modified by: Edward Boning, 2/24/11
 *
 * CMP 12A/L: Winter 2011
 * Lab Assignment #6
 * 							
 *									
 * This is an image processing program. It has 5 basic functionalities	
 * for the user: 1. Read 2. Edge Detection 3. Smooth 4. Save 5. Quit
 * You will need to provide an edge detection method, as well as
 * the method to save your file.   For bonus credit, you must add a GUI
 * that allows users to click a button for each of the above functionality-items.
 *									
 * Input:								
 * Filename to read from. Filename to write to.				
 * (r)ead, (E)dge detection, (S)mooth, (s)ave, (q)uit
 *									
 * Output:								
 * It will create pgm files in the working directory.			
 **************************************************************************/

import tio.*;

class ImageProc {
 private static int width;	// These are all global variables, a very useful tool.
 private static int height;
 private static int scale;

 public static void main(String[] args) {

	System.out.println("Welcome to the CMPS 12L Basic Image Processing Program." + "\n");

	boolean   	run           = true,	// true if not ready to quit
	          	fileRead      = false,	// true if a file has been read
	                imageModified = false;	// true if a file has been smoothed or edged
	ReadInput       inFile;			// Create a new readInput object to read from
	PrintFileWriter outFile;		// Create a new PrintFileWriter object to write to
	int[][]         pictureArray = null;	// Points to image data. Initially empty (i.e. null).

	do {
	  System.out.print("What would you like to do: (r)ead, (E)dge detection, (S)mooth, (s)ave, (q)uit: ");
	  char userSelection = (char)Console.in.readCharNonwhite();
	  switch(userSelection) {

	    case 'r':

	      /******************************************************************************************
	       * This case switch will read in a PGM file to the array pictureArray. It checks if	*
	       * there has already been a file read in, in which case it will prompt the user if they	*
	       * wish to overwrite the file. It also handles IO exceptions, where the file the user	*
	       * tries to read in cannot be found or may not exist.					*
	       ******************************************************************************************/

	      try {
	        if(fileRead) {
	          System.out.print("Do you want to overwrite the file (y/n)? ");
                  //if you want to make a GUI, you will need to set the keyboard input
                  //to a char, for this switch.
	    	  char choice = (char)Console.in.readCharNonwhite();
	    	  if(choice == 'n')
	    	    break;
	        }

                System.out.print("Enter the file to read: ");
	        String filename = Console.in.readLineNonwhite();
	        inFile = new ReadInput(filename);
	        pictureArray = readInFile(inFile);

                System.out.print(filename + " is ");
	        System.out.print(pictureArray[0].length + " by ");
	        System.out.println((pictureArray.length) + ".");
	        fileRead = true;
	      }
	      catch(Exception e) {
	        System.out.println("Sorry; file wasn't found.");
	      }

	      break;

	    case 's':

	      /******************************************************************************************
	       * This case switch will write out to a file the array pictureArray. It checks if		*
	       * there is a picture in the array to save first.						*
	       ******************************************************************************************/

	      if(fileRead) {
	        try {
	          System.out.print("Save as: ");
	          String newFilename = Console.in.readLineNonwhite();

	          outFile = new PrintFileWriter(newFilename);
	          writeOutFile(outFile, pictureArray);
	          System.out.println(newFilename + " saved.");
	          imageModified = false;
	        }
	        catch(Exception e) {
	          System.out.println("Sorry; file wasn't found.");
	        }
	      }
	      else {
	        System.out.println("Sorry; there is no file to save.");
	      }
	      break;

	    case 'S':

	      /******************************************************************************************
	       * This case switch smooths an image that is read in. It does so by going to each pixel	*
	       * in the image and replacing the value there with the average of the 3x3 square around	*
	       * it. This case switch checks to see if an image has been read in first.			*
	       ******************************************************************************************/

	      if(fileRead) {
	        pictureArray = smooth(pictureArray);
	        System.out.println("The image has been smoothed.");
	        imageModified = true;
	      }
	      else {
	        System.out.println("Sorry; there is no image to smooth.");
	      }

	      break;

	    case 'q':

	      /******************************************************************************************
	       * This case switch will quit the program. It checks if an image has been modified	*
	       * first, in which case it asks the user if they want to save the image before exiting.	*
	       ******************************************************************************************/

	      if(imageModified) {
	        System.out.print("Do you want to save the modified image (y/n)? ");
	    	char choice = (char)Console.in.readCharNonwhite();

	    	if(choice == 'n');				//Null statement; will do the else if not n.
	    	else {
	    	  try {
	    	    System.out.print("Save as: ");
	            String newFilename = Console.in.readLineNonwhite();

	            outFile = new PrintFileWriter(newFilename);
	            writeOutFile(outFile, pictureArray);
	            System.out.println(newFilename + " saved.");
	            imageModified = false;
	          }
	          catch(Exception e) {
	            System.out.println("Sorry; there is no file to save.");
	          }
	        }
	      }

	      System.out.println("The program is ending. Bye.");
	      run = false;
	      break;

            case 'E':

              /******************************************************************************************
               * This case detects edges in  image that is read in. It does so by going to each pixel   *
               * in the image and convolving it with two orientations of the sobel operator, and then   *
               * calculates final edges using a nother operation. This case switch checks to see if an  *
	       * image has been read in first.     					                *
               ******************************************************************************************/

	      if(fileRead) {
	        pictureArray = edge(pictureArray);
	        System.out.println("Edges have been detected using the sobel operator.");
	        imageModified = true;
	      }
	      else {
	        System.out.println("Sorry; there is no image to detect edges on.");
	      }
	      break;

	    default:
	      System.out.println("That is not an option. Try again.");
	      break;

	  }

	} while(run);

 }

/********************************************************************************
 * This method is called to read an image file to an array.
 * It reads from a PGM file in the working directory.
 *										
 * Input: A PGM file found in the working directory.
 * Output: An instance of a ReadInput object.
 ********************************************************************************/

 public static int[][] readInFile(ReadInput file) {

	String imageFormat = file.readWord();			//Stores picture format ID; not used
	width              = file.readInt();			//Stores picture width
	height             = file.readInt();			//Stores picture height
	scale              = file.readInt();			//Stores scale value

	int[][] pictureArray = new int[height][width];

	// Assumes a rectangular image.  Read pixel values in row-wise order 

	for(int i = 0; i < height; i++) {
	  for(int j = 0; j < width; j++)
	    pictureArray[i][j] = file.readInt();
	}

	return pictureArray;
 }

/********************************************************************************
 * This method is called to save an image in an array to a file.
 * It outputs to a PGM file in the working directory.
 *
 * Input: A referenced data array and an instance of a PrintFileWriter file.
 * Output: A PGM file created in the working directory.				
 ********************************************************************************/

 public static void writeOutFile(PrintFileWriter newFile, int[][] pictureArray) {

        newFile.println("P2");
        newFile.print(width + " " + height + "\n" + scale + "\n");
        for (int i=0; i<pictureArray.length; i++){
          for (int j=0; j<pictureArray[i].length; j++){
            if (j>0){
              newFile.print(" ");
              if (pictureArray[i][j]<10)
                newFile.print(" ");
            }
            newFile.print(pictureArray[i][j]);
          }
          newFile.print("\n");
        }
        newFile.close();

 }

/********************************************************************************
* This method will apply a simple averaging operation to each input pixel.
* Image is assumed to have a zero-boundary.
* First, we create a copy of the input image into a larger array with zero-boundaries.
* Then, we apply the smoothing template to the non-boundary pixels.
* Finally, we prepare the smoothed, non-boundary pixels to be returned.
* Smoothing is done by simple averaging of the 9 original pixels.
* Note: not as efficient, but hopefully, more understandable.
*
* Input:  The referenced data array.
* Output: A smoothed image file/data array.
********************************************************************************/

 public static int[][] smooth(int[][] a) {

        int[][] b = new int[height+2][width+2];		// larger array with zero boundaries
        int[][] f = new int[height  ][width  ];		// will contain the final smoothed image
	int[][] s = { {1,1,1},				// smoothing is equivalent to using
		      {1,1,1},				// this 3x3 template
		      {1,1,1} };
	int	row, col;

	// initialize the larger array to all zeroes
        for (row = 0; row < height+2; row++)
            for (col = 0; col < width+2; col++)
		b[row][col] = 0;

	// copy the input array and center it within the larger array
        for (row = 0; row < height; row++)
            for (col = 0; col < width; col++)
		b[row+1][col+1] = a[row][col];

	// now calculate the average of every pixel in b
        for (row = 0; row < height; row++)
            for (col = 0; col < width; col++)
		f[row][col] = convolve( s, b, row+1, col+1 );		// apply the 3x3 template

        return f;
    }

/*******************************************************************************
* This method will apply the template to the data array and calculate a
* weighted sum, divide by 9, and rounded to the closest integer.
*
* Input:  A 3x3 template, the image array with zero-boundaries, the row and col
*	  where to center the template
* Output: The convolved (weighted) value rounded to an integer
********************************************************************************/

 public static int convolve( int[][] template, int[][] data, int row, int col ) {

	int	r, c, sum = 0;

        for (r = -1; r <= +1; r++)
            for (c = -1; c <= +1; c++)
		sum = sum +
			data[row+r][col+c] *		// goes through points around row,col
			template[r+1][c+1];		// pair with corresponding elements of template

	return (int) Math.round( sum / 9.0 );
 }


/*******************************************************************************
* Your method for edge detection (sobel) should be here.
* Note: you can use the convolve method above by passing it the appropriate
* parameters.
********************************************************************************/

 public static int[][] edge(int[][] a) {

        int[][] b = new int[height+2][width+2];		// larger array with zero boundaries
        int[][] h = new int[height  ][width  ];		// will contain horizontal edges
        int[][] v = new int[height  ][width  ];		// will contain vertical edges
        int[][] f = new int[height  ][width  ];		// will contain the final edge image
	int[][] gx= { {-1,0,1},				// Gx template
		      {-2,0,2},				// used to find vertical edges
		      {-1,0,1} };
	int[][] gy= { {-1,-2,-1},			// Gy template
		      { 0, 0, 0},			// used to find horizontal edges
		      { 1, 2, 1} };
	int	row, col;

	// initialize the larger array to all zeroes
        for (row = 0; row < height+2; row++)
            for (col = 0; col < width+2; col++)
		b[row][col] = 0;

	// copy the input array and center it within the larger array
        for (row = 0; row < height; row++)
            for (col = 0; col < width; col++)
		b[row+1][col+1] = a[row][col];

	// now convolve each pixel with the sobel mask for the proper direction
        for (row = 0; row < height; row++)
            for (col = 0; col < width; col++){
		h[row][col] = convolve( gy, b, row+1, col+1 );		// apply the 3x3 template
		v[row][col] = convolve( gx, b, row+1, col+1 );		// apply the 3x3 template
	    }

	// calculate the final edge value for each pixel of the image
	for (row = 0; row < height; row++)
	    for (col = 0; col< width; col++)
		f[row][col] = Math.round((float)Math.sqrt( (h[row][col]*h[row][col]) + (v[row][col]*v[row][col]) ) );  // for each pixel in each array; squares the values, adds them together, takes their root, and rounds the result

	// return the final edge image
	return f;


}

} //end of class

