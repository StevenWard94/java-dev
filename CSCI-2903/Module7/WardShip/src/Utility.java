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

  public static final int ALIGN_L = SwingConstants.LEFT;
  public static final int ALIGN_C = SwingConstants.CENTER;

  public static final int MESSAGE_Q = JOptionPane.QUESTION_MESSAGE;
  public static final int MESSAGE_E = JOptionPane.ERROR_MESSAGE;
  public static final int MESSAGE_I = JOptionPane.INFORMATION_MESSAGE;

  public static final int OPT_DEFAULT = JOptionPane.DEFAULT_OPTION;
  public static final int OPT_YNC = JOptionPane.YES_NO_CANCEL_OPTION;
  public static final int YES_OPT = JOptionPane.YES_OPTION;
  public static final int NO_OPT = JOptionPane.NO_OPTION;
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


  public static JLabel format(int textWidth, final String str, int orientation) {
    final String htmlTags = "<html><body style='width: " + textWidth + "px'>";
    return new JLabel(htmlTags + str, orientation);
  }
}
