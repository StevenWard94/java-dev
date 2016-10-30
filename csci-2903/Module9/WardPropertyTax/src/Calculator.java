/**
 * Steven Ward
 * Calculator.java | Property Tax Project
 *
 * This file contains the Calculator GUI class, which is described below.
 *
 * Due Date: October 30, 2016
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame {

  public static final double ASSESSMENT_RATE = 0.4;
  public static final double TAX_RATE = 0.0064;

  private static final long serialVersionUID = 0L;

  private static final int WINDOW_WIDTH = 930;
  private static final int WINDOW_HEIGHT = 600;
  private static final String WINDOW_TITLE = "Property Tax Calculator";

  private JPanel textPanel, buttonPanel;
  private JLabel promptLabel, errorLabel, resultLabel;
  private JTextField userInputField;
  private JButton assessmentValueButton, propertyTaxButton, helpButton;
  private WindowListener closedListener = new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent we) {
      int confirmExit =
              JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?",
                                            WINDOW_TITLE, JOptionPane.YES_NO_OPTION,
                                            JOptionPane.WARNING_MESSAGE);
      if (confirmExit == JOptionPane.YES_OPTION || confirmExit == JOptionPane.CLOSED_OPTION) {
        System.exit(0);
      }
    }
  };
  private ButtonListener buttonListener;

  public Calculator( ) {

    setTitle(WINDOW_TITLE);

    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    addWindowListener(closedListener);

    generateContent();
    add(textPanel);
    add(buttonPanel);

    setVisible(true);
  }

  private void generateContent( ) {

    promptLabel = new JLabel("Enter the property's actual value:", JLabel.LEFT);
    errorLabel  = new JLabel("Error! Please enter a valid property value", JLabel.LEFT);

    userInputField = new JTextField(10);

    buttonListener = new ButtonListener();

    assessmentValueButton = new JButton("Calculate Assessment Value");
    assessmentValueButton.addActionListener(buttonListener);

    propertyTaxButton = new JButton("Calculate Property Tax");
    propertyTaxButton.addActionListener(buttonListener);

    helpButton = new JButton("Help?");
    helpButton.addActionListener(buttonListener);

    textPanel = new JPanel();
    buttonPanel = new JPanel();

    textPanel.add(promptLabel);
    textPanel.add(userInputField);

    buttonPanel.add(assessmentValueButton);
    buttonPanel.add(propertyTaxButton);
    buttonPanel.add(helpButton);
  }


  private class ButtonListener implements ActionListener {

    public void actionPerformed(ActionEvent ae) {
      Object source = ae.getSource();

      if (source == assessmentValueButton) {
        try {
          calculateAssessmentValue(userInputField.getText());
        }
        catch (IllegalArgumentException iae) {

        }
      }
      else if (source == propertyTaxButton) {
        try {
          calculatePropertyTax(userInputField.getText());
        }
        catch (IllegalArgumentException iae) {

        }
      }
      else {
        showHelpDialog();
      }
    }
  }


  private void calculateAssessmentValue(String input) throws IllegalArgumentException {
    if (input == null) {
      throw new IllegalArgumentException();
    }
  }


  private void calculatePropertyTax(String input) throws IllegalArgumentException {
    if (input == null) {
      throw new IllegalArgumentException();
    }
  }


  private void showHelpDialog() {

  }


  private double assessmentValue(double actualValue) {
    return actualValue * ASSESSMENT_RATE;
  }

  private double propertyTax(double actualValue) {
    return assessmentValue(actualValue) * TAX_RATE;
  }


  private boolean tryParseDouble(String value) {
    try {
      Double.parseDouble(value);
      return true;
    }
    catch (NumberFormatException nfe) {
      return false;
    }
  }
}
