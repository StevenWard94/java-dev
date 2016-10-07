/**
 * Steven Ward
 * WardCarpetCalculator.java | Carpet Calculator Project
 *
 * This file contains the entry point for the 'Carpet Calculator' program, which is described below.
 *
 * Due Date: October 09, 2016
 *
 */

import javax.swing.JOptionPane;

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

  public static void main(String[] args) {
  }


  private static void showHelpDialog() {
    final String helpMessage =
      "This application is here to help you determine the total cost of your new Westfield Carpets. \n" +
      "First, it will ask you to input the length and width of your room. Please ensure that you \n" +
      "specify these measurements in FEET. Next, you will be asked to input the price per square \n" +
      "foot of your new Westfield Carpets. After you have entered the requested information, just \n" +
      "sit back and let the Westfield Carpet Calculator do the rest of the work! If you are buying \n" +
      "carpeting for more than one room, you may optionally repeat this process as necessary.";

    final String helpTitle = "Help | " + WardCarpetCalculator.DIALOG_TITLE;

    JOptionPane.showMessageDialog(null, helpMessage, helpTitle, JOptionPane.INFORMATION_MESSAGE);
  }


  private static int showContinuePrompt() {
    final String continueMessage = "Would you like to continue using the Carpet Calculator?";
    final String continueTitle = "Continue? | " + WardCarpetCalculator.DIALOG_TITLE;

    final Object[] choices = { "Continue", "Exit", "Help" };

    return JOptionPane.showOptionDialog(null, continueMessage, continueTitle,
        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[2]);
  }
}
