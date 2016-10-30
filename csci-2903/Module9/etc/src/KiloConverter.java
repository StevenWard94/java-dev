/*
 * Code Listing 12-5/6  |  KiloConverter.java
 *     Chapter 12.2: Creating Windows
 *     (pg. 772-774 & 779-782)
 */

import javax.swing.*;
import java.awt.event.*;

/**
 * The KiloConverter class displays a JFrame that
 * lets the user enter a distance, which is converted
 * to miles when the "Calculate" button is clicked,
 * and displayed in a new dialog box.
 */

public class KiloConverter extends JFrame
{
    private JPanel panel;                   // To reference a panel
    private JLabel messageLabel;            // To reference a label
    private JTextField kiloTextField;       // To reference a text field
    private JButton calcButton;             // To reference a button
    private final int WINDOW_WIDTH = 930;   // Window width
    private final int WINDOW_HEIGHT = 300;  // Window height

    /**
     * Constructor
     */

    public KiloConverter( )
    {
        // Set the window title.
        setTitle("Kilometer Converter");

        // Set the size of the window.
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // Specift what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Build the panel.
        buildPanel();

        // Add the panel to the frame's content pane.
        add(panel);

        // Display the window.
        setVisible(true);
    }

    /**
     * The buildPanel method adds a label, a text field,
     * and a button to a panel.
     */

    private void buildPanel( )
    {
        // Create a label to display instructions.
        messageLabel = new JLabel("Enter a distance in kilometers");

        // Create a text field 10 characters wide.
        kiloTextField = new JTextField(10);

        // Create a button with the label "Calculate".
        calcButton = new JButton("Calculate");

        // Add an action listener to the button.
        calcButton.addActionListener(new CalcButtonListener());

        // Create a JPanel instance.
        panel = new JPanel();

        // Add the label, text field, and button
        // components to the panel.
        panel.add(messageLabel);
        panel.add(kiloTextField);
        panel.add(calcButton);
    }


    /**
     * CalcButtonListerner is an action listener class for
     * the "Calculate" button.
     */

    private class CalcButtonListener implements ActionListener
    {
        /**
         * The 'actionPerformed' method executes when the user
         * clicks on the "Calculate" button.
         * @param e  The event object
         */

        public void actionPerformed(ActionEvent e)
        {
            final double CONVERSION = 0.6214;
            String input;
            double miles;

            // Get the text entered by the user into the
            // text field.
            input = kiloTextField.getText();

            // Convert the input to miles.
            miles = Double.parseDouble(input) * CONVERSION;

            // Display the result.
            JOptionPane.showMessageDialog(null, input +
                    " kilometers is " + miles + " miles.");
        }
    }


    /**
     * 'main' method
     */

    public static void main(String[] args)
    {
        new KiloConverter();
    }
}
