/**
 * Steven Ward
 * WardShip.java | Ship, CruiseShip, and CargoShip Classes Project
 *
 * This file contains the entry point for the 'Ship, CruiseShip, CargoShip' program described below.
 *
 * Due Date: October 16, 2016
 *
 */

import java.util.ArrayDeque;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


public class WardShip {

  public static void main(String[] args) {

  }


  private static int getShipType( ) {
    final String title = "Choosing the Type of Ship";
    final String content = "<font size=+2>The information required for each of type of ship is listed below:</font><br>"
        + "<ul><li><font size=+1 color=blue><i>Generic Ship:</i></font><ol><li>The ship's name"
        + "<li>The year the ship was built</ol><li><font size=+1 color=blue><i>Cruise Ship:</i></font>"
        + "<ol><li>The ship's name <li>The year the ship was built <li>The ship's maximum occupancy</ol>"
        + "<li><font size=+1 color=blue><i>Cargo Ship:</i></font><ol><li>The ship's name"
        + "<li>The year the ship was built <li>The ship's maximum cargo weight capacity (in tons)</ol>"
        + "</ul><br>Please select one of the above choices by clicking its corresponding button.";

    final int optionType = JOptionPane.DEFAULT_OPTION;
    final Object[] choices = { "Ship", "Cruise Ship", "Cargo Ship" };
    final int shipType =
        JOptionPane.showOptionDialog( null, Utility.format(Utility.WRAP, content, SwingConstants.LEFT)
                                    , title, optionType, Utility.INFO, null, choices, choices[0] );
    return shipType;
  }


  private static String getName( ) {
    final String title = "Step 1";
    final String prompt = "1. Please enter the name of the ship:";
    final String name =
        JOptionPane.showInputDialog( null, Utility.format(Utility.WRAP, prompt, SwingConstants.LEFT)
                                   , title, Utility.QUESTION );
    return name;
  }

  /**
   * Provides a namespace for certain constants and static methods, which are not directly
   * applicable to the general execution of this program.
   * A static nested class to provide the 'WardShip' class with aliases for JOptionPane constants as
   * well as some static methods that do not directly influence the "ship building" process.
   * Originally implemented as its own top-level class defined in 'src/Utility.java', it was changed
   * to a static nested class in order to better communicate intent; that this class does not represent
   * a "type" or "process" on its own, and has meaning only in the context of the 'WardShip' class.
   */
  public static class Utility {

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
      final Object[] choices = { "Quit", "Resume" };

      final int opt = JOptionPane.showOptionDialog( null, format(Utility.WRAP, prompt, SwingConstants.LEFT)
          , title, optionType, Utility.WARNING, null, choices, choices[1] );

      return (opt == Utility.YES || opt == Utility.CLOSED);
    }


    public static JLabel format(int textWidth, final String str, int orientation) {
      final String htmlTags = "<html><body style='width: " + textWidth + "px'>";
      return new JLabel(htmlTags + str, orientation);
    }
  }
}
