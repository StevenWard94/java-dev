/**
 * Steven Ward
 * WardPropertyTax.java | Property Tax Project
 *
 * This file contains the WardPropertyTax GUI class, which is described below.
 *
 * Due Date: October 30, 2016
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WardPropertyTax extends JFrame {

  public static final double ASSESSMENT_RATE = 0.4;
  public static final double TAX_RATE = 0.0064;

  private static final long serialVersionUID = 0L;

  private static final int WINDOW_WIDTH = 930;
  private static final int WINDOW_HEIGHT = 600;
  private static final String WINDOW_TITLE = "Property Tax WardPropertyTax";

  private final JLabel promptLabel = new JLabel("Enter the property's actual value:", JLabel.LEFT);
  private final JLabel errorLabel = new JLabel("Please enter a valid property value:", JLabel.LEFT);
  private final JTextField userInputField = new JTextField(10);

  private final JButton assessmentValueButton = new JButton("Calculate Assessment Value");
  private final JButton propertyTaxButton = new JButton("Calculate Property Tax");
  private final JButton helpButton = new JButton("Help?");

  private JLabel resultLabel;
  private JPanel textPanel, buttonPanel;
  private ActionListener buttonListener;

  private WindowListener closedListener = new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent we) {
      int confirmExit =
              JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?",
                                            WINDOW_TITLE, JOptionPane.YES_NO_OPTION,
                                            JOptionPane.WARNING_MESSAGE);
      if (confirmExit == JOptionPane.YES_OPTION) {
        System.exit(0);
      }
    }
  };


  public static void main(String[] args) {
    JFrame mainFrame = new WardPropertyTax();
  }


  public WardPropertyTax( ) {

    setTitle(WINDOW_TITLE);

    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    addWindowListener(closedListener);

    generateContent();
    add(textPanel, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);

    setVisible(true);
  }


  private void generateContent( ) {

    buttonListener = new ButtonListener();

    assessmentValueButton.addActionListener(buttonListener);
    propertyTaxButton.addActionListener(buttonListener);
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
          String resultMessage
                  = calculateAssessmentValue(userInputField.getText());

          WardPropertyTax.this.remove(textPanel);

          resultLabel = new JLabel(resultMessage, JLabel.CENTER);
          textPanel.add(resultLabel);

          textPanel.validate();
          textPanel.repaint();
          WardPropertyTax.this.add(textPanel, BorderLayout.CENTER);
          WardPropertyTax.this.validate();
          WardPropertyTax.this.pack();
          WardPropertyTax.this.setVisible(true);
        }
        catch (IllegalArgumentException assessValE) {
          JLabel infoLabel = WardPropertyTax.makeErrorLabel(assessValE);
          WardPropertyTax.this.remove(textPanel);
          textPanel.add(infoLabel);
          textPanel.validate();
          textPanel.repaint();
          WardPropertyTax.this.add(textPanel, BorderLayout.CENTER);
          WardPropertyTax.this.validate();
          WardPropertyTax.this.pack();
          WardPropertyTax.this.setVisible(true);
        }
      }
      else if (source == propertyTaxButton) {
        try {
          String resultMessage
                  = calculatePropertyTax(userInputField.getText());
          WardPropertyTax.this.remove(textPanel);

          resultLabel = new JLabel(resultMessage, JLabel.CENTER);
          textPanel.add(resultLabel);

          textPanel.validate();
          textPanel.repaint();
          WardPropertyTax.this.add(textPanel, BorderLayout.CENTER);
          WardPropertyTax.this.validate();
          WardPropertyTax.this.pack();
          WardPropertyTax.this.setVisible(true);
        }
        catch (IllegalArgumentException propertyTaxE) {
          JLabel infoLabel = WardPropertyTax.makeErrorLabel(propertyTaxE);
          WardPropertyTax.this.remove(textPanel);
          textPanel.add(infoLabel);
          textPanel.validate();
          textPanel.repaint();
          WardPropertyTax.this.add(textPanel, BorderLayout.CENTER);
          WardPropertyTax.this.validate();
          WardPropertyTax.this.pack();
          WardPropertyTax.this.setVisible(true);
        }
      }
      else {
        showHelpDialog();
      }
    }
  }


  private String calculateAssessmentValue(final String input) throws IllegalArgumentException {
    if (input == null) {
      throw new IllegalArgumentException("Error! No input provided.");
    }
    else if (!tryParseDouble(input)) {
      throw new IllegalArgumentException("Error! Non-numeric input received: " + input);
    }
    else {
      final double propertyValue = Double.parseDouble(input);
      if (propertyValue > 0) {
        return "<html><body><b>The property's assessment value is $" + assessmentValue(propertyValue) + "</b>";
      }
      else {
        throw new IllegalArgumentException("Error! Property value cannot be negative or zero: " + input);
      }
    }
  }


  private String calculatePropertyTax(final String input) throws IllegalArgumentException {
    if (input == null) {
      throw new IllegalArgumentException("Error! No input provided.");
    }
    else if (!tryParseDouble(input)) {
      throw new IllegalArgumentException("Error! Non-numeric input received: " + input);
    }
    else {
      final double propertyValue = Double.parseDouble(input);
      if (propertyValue > 0) {
        final String assessValStr = calculateAssessmentValue(input);
        final String propTaxStr = "<b>The property tax on that value is $" + propertyTax(propertyValue)+ "</b>";
        return assessValStr + "<br>" + propTaxStr;
      }
      else {
        throw new IllegalArgumentException("Error! Property value cannot be negative or zero: " + input);
      }
    }
  }


  private static JLabel makeErrorLabel(final RuntimeException runtimeErr) {
    final String errMessage = runtimeErr.getMessage();
    final String labelText = "<html><body><font color=red><b>" + errMessage + "</b></font>";

    return new JLabel(labelText, JLabel.CENTER);
  }


  private void showHelpDialog() {
    final String helpContent = "<html><body style='width: 800px'>" +
        "<font size=+2><u>Assessment Value</u></font><div style='margin-left: 1em;'>" +
        "A property's assessment value is determined at 40% (percent) of its" +
        " \"actual\" value. So, for example, if an acre of land is valued at $10,000," +
        " its assessment value would be $4,000. The assessment value is what is" +
        " considered for determining property tax.</div><hr><font size=+2><u>" +
        "Property Tax</u></font><div style='margin-left: 1em;'>For any size of land," +
        " the property tax is assessed at $0.64 for every $100 of its assessment value." +
        " This rate is equivalent to a 0.64% (percent) tax on a property's assessment" +
        " value. So, if an acre of land is assessed at $4,000, then its property tax" +
        " would be $25.60.</div><hr><font size=+2><u>The WardPropertyTax</u></font>" +
        "<div style='margin-left: 1em;'>This calculator has been provided to assist" +
        " you in determining the assessment value of your property, as well as the" +
        " property tax owed on it. Just enter the \"actual\" value of your property" +
        " and click one of the two buttons, marked \"Calculate Assessment Value\" and" +
        " \"Calculate Property Tax\". The desired result will be calculated for you" +
        " and displayed above the buttons in the calculator window. Clicking the \"Help?\"" +
        " button will display this window again.</div><hr><b>NOTE: input must be numeric" +
        " (no letters or symbols - including '$' - decimal, '.', is ok) and cannot be zero" +
        " or a negative number.</b>";

    final int msgType = JOptionPane.INFORMATION_MESSAGE;
    JOptionPane.showMessageDialog(null, helpContent, "WardPropertyTax Help", msgType);
  }


  public static double assessmentValue(double actualValue) {
    return actualValue * ASSESSMENT_RATE;
  }

  public static double propertyTax(double actualValue) {
    return assessmentValue(actualValue) * TAX_RATE;
  }


  public static boolean tryParseDouble(String value) {
    try {
      Double.parseDouble(value);
      return true;
    }
    catch (NumberFormatException nfe) {
      return false;
    }
  }
}
