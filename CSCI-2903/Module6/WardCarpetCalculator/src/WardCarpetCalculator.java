/**
 * Steven Ward
 * WardCarpetCalculator.java | Carpet Calculator Project
 *
 * This file contains the entry point for the 'Carpet Calculator' program, which is described below.
 *
 * Due Date: October 09, 2016
 *
 * TODO: FINISH METHOD TO GET LENGTH AND WIDTH
 *       WRITE METHOD TO GET PRICE AND INSTANTIATE RoomCarpet OBJECT
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
 * @see #main(String[] args)
 * @see RoomCarpet#getTotalCost
 * @see RoomCarpet#toString
 * @see RoomDimension
 */
public class WardCarpetCalculator {

  public static final String DIALOG_TITLE = "Carpet Calculator! courtesy of Westfield Carpet Company";
  public static final int TEXT_WIDTH = 500;

  public static void main(String[] args) {
    showHelpDialog();
  }


  public static void calculatorRoutine() {

  }


  private static void getCarpetData() {}


  private static boolean tryParseDouble(String value) {
    try {
      Double.parseDouble(value);
      return true;
    }
    catch (NumberFormatException nfe) {
      return false;
    }
  }


  private static RoomDimension getSize() {
    // constant for 'int messageType' parameter of 'JOptionPane.showInputDialog' function.
    final int msg_t = JOptionPane.QUESTION_MESSAGE;
    // constant to assist with 'showInputDialog(..)->showExitPrompt()' controller.
    final String CLOSED_DIALOG = "USER CLOSED INPUT DIALOG";

    // first, get the length of the user's room...
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
          System.exit(121);
        }
        else {
          lengthStr = CLOSED_DIALOG;
        }
      }
    }

    // TODO: FINISH CODE TO GET WIDTH
    return new RoomDimension(1.1,1.1);  // REMOVE THIS LINE! ONLY TO QUIET ERRORS
  }


  private static JLabel wrapMessage(int width, final String message) {
    final String preHtml = "<html><body style='width: ";
    final String postHtml = "px'>";
    return new JLabel(preHtml + width + postHtml + message, SwingConstants.CENTER);
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


  private static void showErrorPrompt(final String errorMsg) {
    final String errorTitle = "Whoops! | " + DIALOG_TITLE;
    JOptionPane.showMessageDialog(null, wrapMessage(TEXT_WIDTH, errorMsg), errorTitle, JOptionPane.ERROR_MESSAGE);
  }

  private static String showInvalidInputPrompt(final String errorMsg) {
    final String errorTitle = "Invalid Input! | " + DIALOG_TITLE;
    return JOptionPane.showInputDialog(null, wrapMessage(TEXT_WIDTH, errorMsg), errorTitle, JOptionPane.ERROR_MESSAGE);
  }


  private static int showContinuePrompt() {
    final String continueMessage = "Would you like to continue using the Carpet Calculator?";
    final String continueTitle = "Continue? | " + DIALOG_TITLE;

    final Object[] choices = new Object[] { "Continue", "Exit", "Help" };

    return JOptionPane.showOptionDialog(null, wrapMessage(TEXT_WIDTH, continueMessage), continueTitle,
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[2]);
  }


  private static boolean showExitPrompt() {
    final String exitMessage = "Are you sure you want to quit? Current calculation progress will not be saved.";
    final String exitTitle = "Exit? | " + DIALOG_TITLE;

    final int options = JOptionPane.YES_NO_OPTION;
    final Object[] labels = new Object[] { "Quit", "Return to Calculator" };

    final int choice = JOptionPane.showOptionDialog(null, wrapMessage(TEXT_WIDTH, exitMessage), exitTitle,
        options, JOptionPane.WARNING_MESSAGE, null, labels, labels[1]);

    boolean confirmQuit;
    switch (choice) {
      case JOptionPane.CLOSED_OPTION:
        //fall through
      case JOptionPane.YES_OPTION:
        confirmQuit = true;
        break;
      case JOptionPane.NO_OPTION:
        //fall through
      default:
        confirmQuit = false;
        break;
    }
    return confirmQuit;
  }
}
