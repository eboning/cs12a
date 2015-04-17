/* ComplexMathApp.java
* A web applet that will create a container filled with buttons that can calculate the sum or
* product of any two complex numbers of the form a + bi, or the absolute values of the two numbers.
* 
* Written by Edward Boning
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComplexMathApplet extends JApplet{

//declaring container, labels, buttons, and text fields
private Container contents;
private JLabel actionLabel, outLabel;
private JButton addButton, multButton, absButton;
private JTextField real1text, imag1text, real2text, imag2text;

    public void init(){

	//initializing container
        contents = getContentPane();

	//initializing labels to inform the user
        actionLabel = new JLabel( "Action: " );
	outLabel = new JLabel( "Output" );

	//initializing the buttons to operate the applet
        addButton = new JButton( "Add" );
        absButton = new JButton( "Absolute Value" );
        multButton = new JButton ( "Multiply" );

	//initalizing text fields to enter numbers
        real1text = new JTextField();
        imag1text = new JTextField();
        real2text = new JTextField();
        imag2text = new JTextField();

	//adding components to container
        contents.add( actionLabel );
        contents.add( outLabel );
        contents.add( real1text );
        contents.add( imag1text );
        contents.add( real2text );
        contents.add( imag2text );
        contents.add( addButton );
        contents.add( multButton );
        contents.add( absButton );

	//setting container layout
        contents.setLayout(new GridLayout(9,1));

	//implementing a ButtonHandler object
        ButtonHandler bh = new ButtonHandler();

	//adding buttons to ActionListener
        addButton.addActionListener(bh);
        multButton.addActionListener(bh);
        absButton.addActionListener(bh);

    }

    //ButtonHandler class, which uses ActionListener
    private class ButtonHandler implements ActionListener{

	//checks which button is pressed
	public void actionPerformed(ActionEvent ae){

	    //if "Add" button is pressed, performs the arithmetic necessary to add the numbers, and changes the JLabels to output the data
	    if(ae.getSource() == addButton){
		double realOut = Double.parseDouble(real1text.getText()) + Double.parseDouble(real2text.getText());
		double imagOut = Double.parseDouble(imag1text.getText()) + Double.parseDouble(imag2text.getText());
		actionLabel.setText("Sum of the two complex numbers:");
		outLabel.setText("Real: " + realOut + " Imaginary: " + imagOut);
	    }

	    //if "Multiply" button is pressed, multiplys the numbers and changes labels
	    if(ae.getSource() == multButton){
		double realOut = (Double.parseDouble(real1text.getText()) * Double.parseDouble(real2text.getText())) - (Double.parseDouble(imag1text.getText()) * Double.parseDouble(imag2text.getText()));
		double imagOut = (Double.parseDouble(imag1text.getText()) * Double.parseDouble(real2text.getText())) + (Double.parseDouble(real1text.getText()) * Double.parseDouble(imag2text.getText()));
		actionLabel.setText("Product of the two complex numbers:");
                outLabel.setText("Real: " + realOut + " Imaginary: " + imagOut);
	        
	    }

	    //if "Absolute Value" button is pressed, calculates the absolute values and changes labels
	    if(ae.getSource() == absButton){
		double abs1Out = (double)(Math.sqrt( (Double.parseDouble(real1text.getText()) * Double.parseDouble(real1text.getText())) + (Double.parseDouble(imag1text.getText()) * Double.parseDouble(imag1text.getText())) ));
                double abs2Out = (double)(Math.sqrt( (Double.parseDouble(real2text.getText()) * Double.parseDouble(real2text.getText())) + (Double.parseDouble(imag2text.getText()) * Double.parseDouble(imag2text.getText())) ));
                actionLabel.setText("Absolute value of the two complex numbers:");
                outLabel.setText("Value  of #1: " + abs1Out + " Value of #2: " + abs2Out);
	    }
	}
    }

}
