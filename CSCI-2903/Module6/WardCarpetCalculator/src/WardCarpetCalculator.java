/**
 * Steven Ward
 * WardCarpetCalculator.java | Carpet Calculator Project
 *
 * This file contains the entry point for the 'Carpet Calculator' program, which is described below.
 *
 * Due Date: October 09, 2016
 *
 * TODO:
 *       WRITE METHOD TO PERFORM CALCULATIONS AND HANDLE PROGRAM LOOP CONTROL
 *       WRITE main(String[] args) (should be only a few lines after all the other methods)
 */

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 * WardCarpetCalculator class to define the general procedure of this program.
 * The 'WardCarpetCalculator' class acts as the "controller" component of this (Carpet Calculator)
 * program. It contains the program's entry point (the 'main' method) and defines the general
 * procedure for the program's execution. The program itself (and by extension, this class) is
 * intended to demonstrate the 'RoomCarpet' and 'RoomDimension' classes (defined in
 * 'RoomCarpet.java' and 'RoomDimension.java', respectively). It does this by, first, prompting the
 * user for the dimensions (length and width, given in feet) of a room they would like to carpet, as
 * well as the unit price (given in USD per square foot) of his/her desired carpeting. Then, the
 * program uses this information to instantiate a 'RoomCarpet' object, with which it calculates the
 * total cost of the carpeting, based on the user's input, and displays it for the user. This
 * process is repeated as long as the user would like to calculate total costs.
 *
 */
public class WardCarpetCalculator {

  // String constant for use in showXxxDialog(..) methods
  public static final String DIALOG_TITLE = "Carpet Calculator! courtesy of Westfield Carpet Company";
  // String constant to fill showInputDialog's lack of 'CLOSED_OPTION' return value
  public static final String CLOSED_DIALOG = "USER CLOSED INPUT DIALOG";
  // constant for the value used in 'width' attribute of <body ..> HTML tags
  public static final int TEXT_WIDTH = 500;

  /**
   * Main execution process.
   * Displays the help dialog once and then gives control to applicationController().
   *
   * @param args    String[] of command-line arguments passed to java command
   *
   * @see           #showHelpDialog( )
   * @see           #applicationController( )
   *
   */
  public static void main(String[] args) {
    showHelpDialog();
    applicationController();
  }

  /**
   * Controls the loop in which the "calculation process" is defined.
   * As the larger of the two statements in the main(..) function, it is the highest-order function
   * of the "calculation process". It consists of a single 'do..while' loop, which defines the
   * process of getting data from the user, calculating total cost, and prompting the user to
   * continue or exit. The loop will execute at least once and will continue to do so until the user
   * specifies that they would like to exit the application.
   *
   * @see       #main(String[])
   * @see       #buildRoomCarpetObj(double[])
   * @see       #getDimensions( )
   * @see       #wrapMessage(int, String)
   * @see       #showContinuePrompt( )
   * @see       RoomCarpet
   * @see       RoomDimension
   *
   */
  public static void applicationController () {
    do {
      RoomCarpet currentCalculation = buildRoomCarpetObj( getDimensions() );
      String currentCalcStr = currentCalculation.toString();

      String resultTitle = "Result | " + DIALOG_TITLE;
      JOptionPane.showMessageDialog(null, wrapMessage(TEXT_WIDTH, currentCalcStr),
          resultTitle, JOptionPane.INFORMATION_MESSAGE);
    } while( showContinuePrompt() );
  }


  /**
   * Handles invalid arguments to Double.parseDouble(String).
   * Allows this program to gracefully handle NumberFormatException objects thrown by the function,
   * Double.parseDouble(String), when it is passed a String that does not represent a double value.
   * Returns a boolean value corresponding to the success of a call to Double.parseDouble with the
   * argument supplied.
   *
   * @param value  String to be tested for its validity as a parsed double value
   * @return       'false' if NumberFormatException is thrown; otherwise 'true'
   *
   * @see          java.lang.Double.parseDouble(String)
   * @see          java.lang.NumberFormatException
   *
   */
  private static boolean tryParseDouble(String value) {
    try {
      Double.parseDouble(value);
      return true;
    }
    catch (NumberFormatException nfe) {
      return false;
    }
  }


  /**
   * Aquires carpet's unit cost and constructs the RoomCarpet object for the current calculation.
   * Takes over requisition of user data once the length and width measurements have been received.
   * Prompts the user to enter the cost, in dollars per square foot, of his/her carpets. Invalid
   * input or closing of window are handled to prevent using problematic or 'null' values. Once
   * a valid, non-null String has been received, it is parsed into a double value. Along with
   * a RoomDimension object constructed from the array parameter's values, this double value is used
   * to initialize a RoomCarpet object having the attributes specified by the user.
   *
   * @param dimensions  double[] with at least two elements, representing the room's length and
   *                    width; trailing elements are ignored when length exceeds 2
   * @return            RoomCarpet object initialized with the values supplied by the user
   *
   * @see               #getDimensions( )
   * @see               #showExitPrompt( )
   * @see               #wrapMessage(int, String)
   * @see               RoomCarpet#size
   * @see               RoomCarpet#carpetCost
   * @see               RoomCarpet#RoomCarpet(RoomDimension, double)
   * @see               RoomDimension#length
   * @see               RoomDimension#width
   * @see               RoomDimension#RoomDimension(double, double)
   *
   */
  private static RoomCarpet buildRoomCarpetObj(final double[] dimensions) {
    final int msg_t = JOptionPane.QUESTION_MESSAGE;
    // First, extract length and width values from 'double[] dimensions' parameter...
    final double length = dimensions[0];
    final double width = dimensions[1];

    // Next, get the price per sq ft of the user's carpet...
    final String costMsg = "length:  " + length + "<br>width:  " + width + "<br><br>Please enter the "
      + "PRICE of your new Westfield Carpets in DOLLARS PER SQUARE FOOT:";
    final String costTitle = "Price | " + DIALOG_TITLE;

    String costStr = JOptionPane.showInputDialog(null, wrapMessage(TEXT_WIDTH, costMsg)
        , costTitle, msg_t);

    if (costStr == null || "".equals(costStr)) {
      if (showExitPrompt()) {
        System.exit(141);
      }
      else {
        costStr = CLOSED_DIALOG;
      }
    }
    while (costStr.equals(CLOSED_DIALOG) || !tryParseDouble(costStr) || Double.parseDouble(costStr) <= 0.0) {
      if (costStr.equals(CLOSED_DIALOG)) {
        costStr = JOptionPane.showInputDialog(null, wrapMessage(TEXT_WIDTH, costMsg), costTitle, msg_t);
      }
      else {
        String errmsg = "Invalid Unit Price: " + costStr + "<br><br>Please enter the PRICE, in "
          + "DOLLARS PER SQUARE FOOT, provided to you by Westfield Carpet Company:";
        costStr = showInvalidInputPrompt(errmsg);
      }

      if (costStr == null || "".equals(costStr)) {
        if (showExitPrompt()) {
          System.exit(142);
        }
        else {
          costStr = CLOSED_DIALOG;
        }
      }
    }
    final double cost = Double.parseDouble(costStr);
    return new RoomCarpet( new RoomDimension(length, width), cost );
  }


  /**
   * Recieve length and width measurements from user.
   * Retrieves the room's 'length' and 'width' measurements for the current calculation. This is
   * accomplished in a manner very similar to that used in the 'buildRoomCarpetObj' function. Once
   * 2 acceptable double values have been acquired, the function returns them in a double[].
   *
   * @return    double[] containing two values representing the 'length' and 'width', in that order
   *
   * @see       #buildRoomCarpetObj(double[])
   * @see       #wrapMessage(int, String)
   * @see       #showExitPrompt( )
   * @see       RoomDimension#RoomDimension(double length, double width)
   * @see       RoomCarpet#RoomCarpet(RoomDimension size, double cost)
   *
   */
  private static double[] getDimensions() {
    // Constant for 'int messageType' parameter of 'JOptionPane.showInputDialog' function.
    final int msg_t = JOptionPane.QUESTION_MESSAGE;

    // First, get the length of the user's room...
    final String lengthMsg = "length:<br>width:<br><br>Please enter the LENGTH of your room in FEET:";
    final String lengthTitle = "Length | " + DIALOG_TITLE;

    String lengthStr = JOptionPane.showInputDialog(null, wrapMessage(TEXT_WIDTH, lengthMsg)
        , lengthTitle, msg_t);

    if (lengthStr == null || "".equals(lengthStr)) {
      if (showExitPrompt()) {
        System.exit(121);
      }
      else {
        lengthStr = CLOSED_DIALOG;
      }
    }

    while (lengthStr.equals(CLOSED_DIALOG) || !tryParseDouble(lengthStr) || Double.parseDouble(lengthStr) <= 0.0) {
      if (lengthStr.equals(CLOSED_DIALOG)) {
        lengthStr = JOptionPane.showInputDialog(null, wrapMessage(TEXT_WIDTH, lengthMsg)
            , lengthTitle, msg_t);
      }
      else {
        String errmsg = tryParseDouble(lengthStr) ?
          "Invalid Length Measurement!<br><br>Please enter a NON-ZERO LENGTH for your room, in FEET:" :
          ( "Invalid Length Measurement:  " + lengthStr + "<br><br>Please enter a valid LENGTH for your room, in FEET:" );
        lengthStr = showInvalidInputPrompt(errmsg);
      }

      if (lengthStr == null || "".equals(lengthStr)) {
        if (showExitPrompt()) {
          System.exit(122);
        }
        else {
          lengthStr = CLOSED_DIALOG;
        }
      }
    }
    final double length = Double.parseDouble(lengthStr);  // Complete length retrieval.
    // Next, get the width of the user's room...
    final String widthMsg = "length:  " + length + "<br>width:<br><br>Please enter the WIDTH of your room in FEET:";
    final String widthTitle = "Width | " + DIALOG_TITLE;

    String widthStr = JOptionPane.showInputDialog(null, wrapMessage(TEXT_WIDTH, widthMsg)
        , widthTitle, msg_t);

    if (widthStr == null || "".equals(widthStr)) {
      if (showExitPrompt()) {
        System.exit(131);
      }
      else {
        widthStr = CLOSED_DIALOG;
      }
    }

    while (widthStr.equals(CLOSED_DIALOG) || !tryParseDouble(widthStr) || Double.parseDouble(widthStr) <= 0.0) {
      if (widthStr.equals(CLOSED_DIALOG)) {
        widthStr = JOptionPane.showInputDialog(null, wrapMessage(TEXT_WIDTH, widthMsg)
            , widthTitle, msg_t);
      }
      else {
        String errmsg = tryParseDouble(widthStr) ?
          "Invalid Width Measurement!<br><br>Please enter a NON-ZERO WIDTH for your room, in FEET:" :
          ( "Invalid Width Measurement:  " + widthStr + "<br><br>Please enter a valid WIDTH for your room, in FEET:" );
        widthStr = showInvalidInputPrompt(errmsg);
      }

      if (widthStr == null || "".equals(widthStr)) {
        if (showExitPrompt()) {
          System.exit(132);
        }
        else {
          widthStr = CLOSED_DIALOG;
        }
      }
    }
    final double width = Double.parseDouble(widthStr); // Complete width retrieval.

    return new double[] { length, width };
  }




  /**
   * Provides HTML formatting for messages in JOptionPane dialogs.
   * Prevents inconsistencies in JOptionPane dialogs' wrapping of messages. Generates a String
   * containing a 'body' HTML tag, which has an inline CSS 'style' attribute. The attribute's value
   * is determined from the 'width' argument, in pixels (px). The 'message' argument is then
   * appended to the resulting String of HTML and passed to a JLabel constructor. This JLabel object
   * can be passed to any 'JOptionPane.showXxxDialog' as the 'message' parameter because these
   * methods specify its type as 'Object'. The final result is text wrapping at the specified width
   * in JOptionPane dialogs.
   *
   * @param width    the desired text-width of the message
   * @param message  the message to be displayed with text wrapping
   * @return         JLabel object with the given text and "leading-edge" horizontal alignment
   *
   * @see            javax.swing.JLabel#JLabel(String, int)
   * @see            javax.swing.SwingConstants#LEADING
   *
   */
  private static JLabel wrapMessage(int width, final String message) {
    final String preHtml = "<html><body style='width: ";
    final String postHtml = "px'>";
    return new JLabel(preHtml + width + postHtml + message, SwingConstants.LEADING);
  }


  private static void showHelpDialog() {
    final String helpMessage =
      "This application is here to help you determine the total cost of your new Westfield Carpets. " +
      "First, it will ask you to input the length and width of your room. Please ensure that you " +
      "specify these measurements in FEET. Next, you will be asked to input the price per square " +
      "foot of your new Westfield Carpets. After you have entered the requested information, just " +
      "sit back and let the Westfield Carpet Calculator do the rest of the work! If you are buying " +
      "carpeting for more than one room, you may optionally repeat this process as necessary.";

    final String helpTitle = "Help | " + DIALOG_TITLE;

    JOptionPane.showMessageDialog(null, wrapMessage(TEXT_WIDTH, helpMessage), helpTitle, JOptionPane.INFORMATION_MESSAGE);
  }


  private static String showInvalidInputPrompt(final String errorMsg) {
    final String errorTitle = "Invalid Input! | " + DIALOG_TITLE;
    return JOptionPane.showInputDialog(null, wrapMessage(TEXT_WIDTH, errorMsg), errorTitle, JOptionPane.ERROR_MESSAGE);
  }


  /**
   * Prompts the user to either "continue" or "exit".
   * Serves as the loop control in applicationController() method. Determines and returns a boolean
   * value corresponding to whether or not the user wishes to repeat the calculation process.
   *
   * @return    boolean value of the user's choice to either "continue" ('true') or "exit" ('false')
   *
   * @see       #applicationController( )
   * @see       #showHelpDialog( )
   * @see       #showExitPrompt( )
   *
   */
  private static boolean showContinuePrompt() {
    final String continueMessage = "Would you like to continue using the Carpet Calculator?";
    final String continueTitle = "Continue? | " + DIALOG_TITLE;

    final Object[] choices = new Object[] { "Continue", "Exit", "Help" };

    final int choice = JOptionPane.showOptionDialog(null, wrapMessage(TEXT_WIDTH, continueMessage), continueTitle,
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[2]);

    boolean onemore;
    switch (choice) {
      case JOptionPane.CLOSED_OPTION:
        if (showExitPrompt()) {
          System.exit(211);
        }
        onemore = showContinuePrompt();
        break;
      case 0:
        onemore = true;
        break;
      case 1:
        onemore = false;
        break;
      case 2:
        // fall through
      default:
        showHelpDialog();
        onemore = showContinuePrompt();
        break;
    }
    return onemore;
  }


  /**
   * Confirms that the user meant to quit by prematurely closing a dialog window.
   * Returns a boolean value corresponding to the user's desire ('true') or lack thereof ('false')
   * to exit the program.
   *
   */
  private static boolean showExitPrompt() {
    final String exitMessage = "Are you sure you want to quit? Current calculation progress will not be saved.";
    final String exitTitle = "Exit? | " + DIALOG_TITLE;

    final int options = JOptionPane.YES_NO_CANCEL_OPTION;
    final Object[] labels = new Object[] { "Quit", "Return to Calculator", "Help" };

    final int choice = JOptionPane.showOptionDialog(null, wrapMessage(TEXT_WIDTH, exitMessage), exitTitle,
        options, JOptionPane.WARNING_MESSAGE, null, labels, labels[2]);

    boolean confirmQuit;
    switch (choice) {
      case JOptionPane.CLOSED_OPTION:
        // fall through
      case JOptionPane.YES_OPTION:
        confirmQuit = true;
        break;
      case JOptionPane.CANCEL_OPTION:
        showHelpDialog();
        confirmQuit = showExitPrompt();
        break;
      case JOptionPane.NO_OPTION:
        // fall through
      default:
        confirmQuit = false;
        break;
    }
    return confirmQuit;
  }
}
