/**
 * Steven Ward
 * Utilities.java | Ship, CruiseShip, and CargoShip Classes Program
 *
 * This file defines a Utility class with a number of static methods for the program.
 *
 * Due Date: October 16, 2016
 *
 */

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 * TODO: WRITE BRIEF DESCRIPTION OF UTILITY CLASS.
 * TODO: WRITE DETAILED DESCRIPTION OF UTILITY CLASS.
 *
 * TODO: COMPLETE CLASS DOCUMENTATION and TAGS.
 */
public class Utility {

  public static final int WRAP = 650;

  /** Aliases for several constants defined in the 'javax.swing.JOptionPane' class. */
  public static final int QUESTION = JOptionPane.QUESTION_MESSAGE;
  public static final int ERROR = JOptionPane.ERROR_MESSAGE;
  public static final int INFO = JOptionPane.INFORMATION_MESSAGE;
  public static final int WARNING = JOptionPane.WARNING_MESSAGE;

  public static final int YES = JOptionPane.YES_OPTION;  // same value as 'OK_OPTION', 0
  public static final int NO = JOptionPane.NO_OPTION;
  public static final int CANCEL = JOptionPane.CANCEL_OPTION;
  public static final int CLOSED = JOptionPane.CLOSED_OPTION;


  public static boolean tryParseInt(final String value) {
    try {
      Integer.parseInt(value);
      return true;
    }
    catch (NumberFormatException nfe) {
      return false;
    }
  }


  public static boolean isValidYear(final String yearStr) {
    try {
      int year = Integer.parseInt(yearStr);  // a valid yearStr can be parsed as an int value
      return ( year > 999 && year < 2017 ) ? true : false;  // a valid yearStr satisfies: 999 < year < 2017
    }
    catch (NumberFormatException nfe) {
      return false;
    }
  }


  public static boolean confirmExit() {
    final int optionType = JOptionPane.OK_CANCEL_OPTION;
    final String prompt = "Are you sure you want to quit?";
    final String title = "Exit?";
    Object[] choices = { "Quit", "Resume" };

    final int opt = JOptionPane.showOptionDialog( null, format(Utility.WRAP, prompt, SwingConstants.LEFT)
        , title, optionType, Utility.WARNING, null, choices, choices[1] );

    return (opt == Utility.YES || opt == Utility.CLOSED);
  }


  public static JLabel format(int textWidth, final String str, int orientation) {
    final String htmlTags = "<html><body style='width: " + textWidth + "px'>";
    return new JLabel(htmlTags + str, orientation);
  }
}
