/*
 *
 * @author: superrawr: AG
 */
package guis;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIAttack extends JFrame {
    //every GUI must have a container
    private Container contents;
    private JLabel actionLabel;
    private JButton readButton, edgeButton, smoothButton, saveButton, quitButton;

    private static int width;	// These are all global variables, a very useful tool.
    private static int height;
    private static int scale;

    public GUIAttack() {
        super( "Example GUI Layout" ); //program title at top of GUI window
        contents = getContentPane();
        contents.setLayout( new FlowLayout() );

        // instantiate buttons
        readButton   = new JButton( "Read" );
        edgeButton   = new JButton( "Edge" );
        smoothButton = new JButton( "Smooth" );
        saveButton   = new JButton( "Save" );
        quitButton   = new JButton( "Quit" );

        //label indicating what action you have pressed
        actionLabel = new JLabel( "Action: " );

        // add components to the Contained 'contents'
        contents.add( actionLabel );
        contents.add( readButton );
        contents.add( edgeButton );
        contents.add( smoothButton );
        contents.add( saveButton );
        contents.add( quitButton );

        // Start up our button handler
        ButtonHandler bh = new ButtonHandler( );

        // Add the buttons to our Action listener
        // using our previously-defined Button Handler
        readButton.addActionListener( bh );
        edgeButton.addActionListener( bh );
        smoothButton.addActionListener( bh );
        saveButton.addActionListener( bh );
        quitButton.addActionListener( bh );

        setSize( 700, 90 );
        setVisible( true );
    }

    // Our ButtonHandler uses some tools from ActionListener
    private class ButtonHandler implements ActionListener {

        // Check to see which action is performed
        public void actionPerformed( ActionEvent ae ) {

                //read is pressed.
                if ( ae.getSource() == readButton )
                {
                    //do your reading code here
                    //very similar to case 'r'
                    actionLabel.setText("I just read!");
                }
                //Edge is pressed
                else if ( ae.getSource() == edgeButton )
                {
                    //do your edge detection code here
                    //very similar to case 'E'
                    actionLabel.setText("Edge!");
                }
                //smooth is pressed
                else if ( ae.getSource() == smoothButton )
                {
                    //do your smoothing code here
                    //very similar to case 'S'
                    actionLabel.setText("Smooth!");
                }
                //save is pressed
                else if ( ae.getSource() == saveButton )
                {
                    //save code goes here
                    //similar to case 's'
                    actionLabel.setText("Save!");
	        }
                //quit is pressed
                else if ( ae.getSource( ) == quitButton)
                {
                    //quit code goes here.
                    //similar to case 'q'
                    actionLabel.setText("Quitting!");
                    //exits the program!
                    System.exit(0);
                }

            }
        }

    //very small compared to what it used to be, no?
    public static void main( String [] args )
    {
        //initialize the GUI and set the closing operation
        GUIAttack gui = new GUIAttack( );
        gui.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
}
