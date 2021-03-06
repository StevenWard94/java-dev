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


/**
 * Outlines the general procedure for this program including necessary methods and constants.
 * Contains the entry point of this program, namely its 'main(String[])' method, which serves as the
 * top-level "controller" for execution. Apart from the 'main' method, a number of other methods are
 * defined to handle specific pieces of input (and output) within the overall user experience. In
 * addition, contains the static nested 'Utility' class, which defines a number of constants and
 * a few methods not directly included in the user's normal interface.
 *
 * @see            #Utility
 */
public class WardShip {

  /** 3 constants for identifying ship types consistently (without using type-traits) */
  public static final int BASIC_SHIP = 1001;
  public static final int CRUISE_SHIP = 1010;
  public static final int CARGO_SHIP = 1011;

  /**
   * Serves as this program's entry point and top-level "controller" method.
   * Manages the "outline" of this program's execution pattern through a primary loop to collect
   * information, within which this class's other methods are implemented at the proper points. Its
   * behavior, generally, also demonstrates the behavior of the program as a whole. First, the user
   * is presented with a splash dialog to welcome them to the program. Then, the user is prompted
   * for the number of ships they would like to "build"; in other words, the number of iterations
   * they will complete and the size of the resulting 'ArrayBlockingQueue' of ships. Once a valid
   * number is received, the core loop of this program is executed, which follows this general
   * pattern:
   *     1. Present the user with information about "types" of ships and have him/her select one
   *     2. Get the ship's name (no validation on this string because a name could be anything)
   *     3. Get the year in which the ship was built (must be at least 1000 and no more than 2016)
   *     4. If the user selected a "type" other than 'Ship', prompt the user for the ship's capacity
   * These 3 to 4 steps repeat for the number of times specified by the user. Once the desired
   * number of ships have been "built" by the user, the list ('ArrayBlockingQueue<Ship>') is output
   * back to the user by calling each 'Ship' object's respective 'toString()' overload. This
   * program's execution terminates when this final window is closed in any way.
   *
   * @param  args  String array containing any commandline arguments passed to the 'java' command
   *
   * @see          #getShipType( )
   * @see          #getName( )
   * @see          #getYear(String)
   * @see          WardShip.Utility
   * @see          Ship#toString( )
   * @see          CruiseShip#toString( )
   * @see          CargoShip#toString( )
   * @see          java.util.Iterator#hasNext( )
   * @see          java.util.Iterator#next( )
   * @see          java.util.concurrent.BlockingQueue
   * @see          java.util.concurrent.ArrayBlockingQueue
   */
  public static void main(String[] args) {
    JOptionPane.showConfirmDialog( null,
      Utility.format(400, "Welcome to ShipBuilder! Please press the button below to get started!", SwingConstants.CENTER),
      "Welcome!", JOptionPane.DEFAULT_OPTION, Utility.INFO );

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


  /**
   * Provides the user with the necessary information and interface to select a "type" of ship.
   * Generates a single dialog window, which lists the 3 supported "types" of ships and the
   * information that will be needed to "build" them. The list uses a 'JLabel' to enable use of HTML
   * for formatting [@see WardShip.Utility#format(int,String,int)]. The HTML is primarily used to
   * generated an unordered list of 3 bullets, each of which containing the "type" of ship as well
   * as a nested, ordered list of the respective requirements for that "type". All HTML tags used
   * here will be listed below this description text. At the bottom of the dialog are 3 buttons,
   * each of which corresponding to one of the 3 "types" described, displayed below a line of text
   * prompting the user to select one of the buttons. The user's selection is returned by the
   * 'showOptionDialog' method as its subscript in the array of choices passed to the function. For
   * example, given { "A", "B", "1", "2" }, clicking the button labeled with "1" would return an int
   * value of '2'.
   *
   * HTML Tags Used:
   *     <br>      defines a line break ('\n' not supported) - no closing tag
   *     <font>    defines font attributes - attributes used: 'size', 'color'
   *     </i>      defines italicized text
   *     <li>      defines a list item for both an ordered and unordered list
   *     <ol>      defines an ordered list
   *     <ul>      defines an unordered list
   *
   * @return       int corresponding to the user's "type" selection
   * @see          #main(String[])
   * @see          WardShip.Utility
   */
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


  /**
   * Generates the dialog to get the name of a ship from the user.
   * Presents the user with an input dialog asking for the name of a ship. There are no validation
   * checks in this method because it is too difficult to define what is or is not a valid ship name.
   *
   * @return       String containing the name entered by the user
   * @see          Ship#name_
   * @see          Ship#name( )
   * @see          Ship#Ship(String,String)
   */
  private static String getName( ) {
    final String title = "Step 1";
    final String prompt = "1. Please enter the name of the ship:";
    final String name =
        JOptionPane.showInputDialog( null, Utility.format(Utility.WRAP, prompt, SwingConstants.LEFT)
                                   , title, Utility.QUESTION );
    return name;
  }


  /**
   * Prompts the user for the year the ship was built and validates the resulting input.
   * Shows a dialog similar to that of 'getName()', in which it encorporates the ship's name
   * (received as the argument) into the prompt. If the year given is invalid, the user is
   * repeatedly prompted for a valid one. If they close the window without entering a year, they are
   * shown the 'confirmExit()' dialog and, if they resume, control is handed back to the start of
   * the method's execution. When a valid year has been acquired, it is packaged into a String array
   * with the 'name' argument as its first element, followed by the 'year' String.
   *
   * @param  name  String containing the 'name' of the ship in question
   * @return       String array containing the 'name' and 'year' of the ship, in that order
   *
   * @see          WardShip.Utility#format(int,String,int)
   * @see          WardShip.Utility#isValidYear(String)
   * @see          WardShip.Utility#confirmExit( )
   * @see          Ship#year_
   * @see          Ship#year( )
   * @see          Ship#Ship(String,String)
   */
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


  /**
   * Prompts the user to enter the ship's corresponding capacity and validates the input.
   * Behaves in a similar manner to 'getYear()', except that it determines the prompt based on ship
   * type; since both the 'CruiseShip' and 'CargoShip' classes have a field for "capacity" of some
   * sort. The input is validated to ensure that it represents a value which can safely be expressed
   * as an 'int'.
   *
   * @param  shipType  int value designating the "type" of ship - one of this class's constants
   * @return           int value representing the "capacity" entered by the user
   *
   * @see              WardShip.Utility#tryParseInt(String)
   * @see              CruiseShip#passengerCap_
   * @see              CargoShip#cargoCap_
   * @see              CruiseShip#capacity
   * @see              CargoShip#capacity
   * @see              CruiseShip#CruiseShip(String,String,int)
   * @see              CargoShip#CargoShip(String,String,int)
   */
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

    public static final int WRAP = 800;

    /** Aliases for several constants defined in the 'javax.swing.JOptionPane' class. */
    public static final int QUESTION = JOptionPane.QUESTION_MESSAGE;
    public static final int ERROR = JOptionPane.ERROR_MESSAGE;
    public static final int INFO = JOptionPane.INFORMATION_MESSAGE;
    public static final int WARNING = JOptionPane.WARNING_MESSAGE;

    public static final int YES = JOptionPane.YES_OPTION;  // same value as 'OK_OPTION', 0
    public static final int NO = JOptionPane.NO_OPTION;
    public static final int CANCEL = JOptionPane.CANCEL_OPTION;
    public static final int CLOSED = JOptionPane.CLOSED_OPTION;


    /**
     * Allows for exception-safe testing of Strings that may not be valid representations of an int.
     * Simple method to determine whether or not a String can be parsed to an int value, while
     * simultaneously handling a (possibly) resulting exception by using it to return a useful
     * value.
     *
     * @see        java.lang.Integer#parseInt(String)
     */
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
