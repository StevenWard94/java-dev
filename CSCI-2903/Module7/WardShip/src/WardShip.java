/**
 * Steven Ward
 * WardShip.java | Ship, CruiseShip, and CargoShip Classes Project
 *
 * This file contains the entry point for the 'Ship, CruiseShip, CargoShip' program described below.
 *
 * Due Date: October 16, 2016
 *
 */

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


public class WardShip {

  public static final int BASIC_SHIP = 1001;
  public static final int CRUISE_SHIP = 1010;
  public static final int CARGO_SHIP = 1011;

  public static void main(String[] args) {
    JOptionPane.showConfirmDialog( null,
      Utility.format(400, "Welcome to ShipBuilder! Please press the button below to get started!", SwingConstants.CENTER),
      "Welcome!", JOptionPane.OK_OPTION, Utility.INFO );

    final String numTitle = "How Many?";
    final String numText = "Please enter the number of ships you would like to \"build\" today:";
    String nShipsStr =
      JOptionPane.showInputDialog( null, Utility.format(Utility.WRAP, numText, SwingConstants.LEFT)
                                 , numTitle, Utility.QUESTION );

    while (!Utility.tryParseInt(nShipsStr) || Integer.parseInt(nShipsStr) <= 0) {
      final String errTitle = "Invalid Quantity!";
      final String errText = "The value you entered for \"number of ships\" was invalid!<br>"
          + "You entered: <font color=red>" + nShipsStr + "</font><br><p>" + numText;
      nShipsStr =
        JOptionPane.showInputDialog( null, Utility.format(Utility.WRAP, errText, SwingConstants.LEFT)
                                   , errTitle, Utility.ERROR );
    }
    final int nShips = Integer.parseInt(nShipsStr);
    BlockingQueue<Ship> shipQueue = new ArrayBlockingQueue<Ship>(nShips, true);

    for (int i = 0; i < nShips; i++) {
      final int shipType;
      switch ( getShipType() ) {
        case Utility.CLOSED: // fall through
        case 0:
          shipType = BASIC_SHIP;
          break;
        case 1:
          shipType = CRUISE_SHIP;
          break;
        case 2:
          shipType = CARGO_SHIP;
          break;
        default:
          shipType = Utility.CLOSED;
      }
      final String[] generalInfo = getYear( getName() );
      final String name = generalInfo[0];
      final String year = generalInfo[1];
      Ship ship = ( shipType == BASIC_SHIP ) ?
          new Ship( name, year ) : ( shipType == CRUISE_SHIP ) ?
          new CruiseShip( name, year, getCapacity(shipType) )  :
          new CargoShip( name, year, getCapacity(shipType) );
      if ( !shipQueue.offer(ship) ) {
        break;
      }
    }
    final String outTitle = "Your Ships!";
    final String header = "<font size=+2>Here are your ships!</font><p>";
    String shipList = "<ol>";

    Iterator<Ship> it = shipQueue.iterator();
    while ( it.hasNext() ) {
      shipList += "<li>" + it.next().toString();
    }
    shipList += "</ol>";
    final String outText = header + shipList;

    JOptionPane.showMessageDialog( null, Utility.format(Utility.WRAP, outText, SwingConstants.LEFT)
                                 , outTitle, Utility.INFO );
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


  private static String[] getYear(final String name) {
    final String title = "Step 2";
    final String prompt = "2. Please enter the year in which the " + name + " was built:";
    String year =
        JOptionPane.showInputDialog( null, Utility.format(Utility.WRAP, prompt, SwingConstants.LEFT)
                                   , title, Utility.QUESTION );

    while ( year == null || "".equals(year) || !Utility.isValidYear(year) ) {
      if (year == null || "".equals(year)) {
        if (Utility.confirmExit()) {
          System.exit(131);
        }
        else {
          return getYear(name);
        }
      }
      final String errTitle = "Whoops!";
      final String errPrompt = "The year you entered was invalid!<br>"
          + "You entered: <font color=red>" + year + "</font><br><p>" + prompt;

      year = JOptionPane.showInputDialog( null
                                        , Utility.format(Utility.WRAP, errPrompt, SwingConstants.LEFT)
                                        , errTitle, Utility.ERROR );
    }
    return new String[] { name, year };
  }


  private static int getCapacity(int shipType) {
    final String title = "Step 3";
    final String prompt = shipType == CRUISE_SHIP ?
        "3. Please enter the ship's maximum passenger capacity:" :
        "3. Please enter the ship's maximum cargo weight capacity (in tons):";

    String capacity =
        JOptionPane.showInputDialog( null, Utility.format(Utility.WRAP, prompt, SwingConstants.LEFT)
                                   , title, Utility.QUESTION );

    while ( capacity == null || "".equals(capacity) || !Utility.tryParseInt(capacity) ) {
      if (capacity == null || "".equals(capacity)) {
        if (Utility.confirmExit()) {
          System.exit(141);
        }
        else {
          return getCapacity(shipType);
        }
      }
      final String errTitle = "Whoops!";
      final String errPrompt = "The capacity you entered was invalid!<br>"
          + "You entered: <font color=red>" + capacity + "</font><br><p>" + prompt;

      capacity = JOptionPane.showInputDialog( null
                                            , Utility.format(Utility.WRAP, errPrompt, SwingConstants.LEFT)
                                            , errTitle, Utility.ERROR );
    }
    return Integer.parseInt(capacity);
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
