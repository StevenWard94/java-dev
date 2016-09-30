/**
 * Steven Ward
 * WardDuplicate.java | Duplicate Project
 *
 * A program to validate a user-input array and output information about duplicate elements.
 * This program first prompts the user to enter the number of elements they intend to input. This
 * number is validated to ensure that it is greater than or equal to 15, and the program will prompt
 * the user for another number (this cycle is repeated until a valid number is given); from now on,
 * this number will be referred to as 'N'. Once the user has entered a legal value for N, he/she
 * will be prompted, one at a time, for N integer elements. Each element must be an integer value on
 * the interval, [1,N] (note: this range is inclusive), and if it is not, the user will be
 * prompted repeatedly until an acceptable value has been input. Once the array has been populated
 * with N valid elements, this program presents an output containing the following information:
 *     a) the array elements given by the user (i.e. "the array")
 *     b) the elements, if any, that were duplicated
 *     c) if there are duplicate values, those values and the number of times they were duplicated.
 * When the user closes this final output window, the program will terminate.
 *
 * Due Date: October 2, 2016
 *
 * @see #main(String[] args)
 * TODO: Add 'see' tags for the methods in this program
 *       Add any additional tags as needed
 */

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class WardDuplicate {

  private static boolean tryParseInt(String value) {
    try {
      Integer.parseInt(value);
      // If 'value' did not represent a valid 'int', then the above threw an exception and the
      // following line is not executed.
      return true;
    }
    catch (NumberFormatException nfe) {  // If 'Integer.parseInt' throws, execution jumps here.
      return false;
    }
  }


  private static int[] getElements(int[] userArray, int index) {

    if (index >= userArray.length) {
      return userArray;
    }
    else {
      String title = "Element " + (index + 1) + " of " + userArray.length;
      String message = "Please enter a number between 1 and " + userArray.length;
      String elementStr = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);

      while (!tryParseInt(elementStr) || Integer.parseInt(elementStr) < 1 || Integer.parseInt(elementStr) > userArray.length) {
        String errTitle = "Invalid Element!";
        elementStr = JOptionPane.showInputDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
      }
      userArray[index] = Integer.parseInt(elementStr);
      return getElements(userArray, ++index);
    }
  }


  private static String toString(int[] array) {
    String arrayStr = "[ ";
    for (int element : array) {
      arrayStr += Integer.toString(element) + " ";
    }
    return arrayStr + " ]";
  }


  private static int[] selectionSort(int[] array) {

    for (int i = 0; i < array.length - 1; i++) {
      int lowest = i;

      for (int j = i + 1; j < array.length; j++) {
        lowest = array[j] < array[lowest] ? j : lowest;
      }
      int selection = array[lowest];
      array[lowest] = array[i];
      array[i] = selection;
    }
    return array;
  }


  private static ArrayList<int[]> getDuplicateData(int[] array) {

    ArrayList<int[]> duplicateData = new ArrayList<int[]>();

    int i = 0;
    while (i < array.length) {
      final int value = array[i];
      int[] dataCol = { value, 1 };

      boolean isDuplicate;
      do {
        i++;
        isDuplicate = false;
        if (array[i] == dataCol[0]) {
          isDuplicate = true;
          dataCol[1] += 1;
        }
        // else { isDuplicate still false, no change to duplicate count in dataCol[1] }
      } while (isDuplicate);

      if (dataCol[1] > 1) {
        duplicateData.add(dataCol);
      }
      // no 'i++' here b/c the current 'array[i]' is the next 'dataCol[0]'
    }
    return duplicateData;
  }


  public static void main(String[] args) {
    String inputBuffer;

    inputBuffer = JOptionPane.showInputDialog(null, "We are going to make a 'Number List'!\n"
        + "How many numbers would you like to put in your list? (please make it at least 15)"
        , "Pick a Size for Your 'Number List'", JOptionPane.QUESTION_MESSAGE);

    while (!tryParseInt(inputBuffer) || Integer.parseInt(inputBuffer) < 15) {
      inputBuffer = JOptionPane.showInputDialog(null, "Whoops! That just won't do...\n"
          + "Please enter a size of at least 15 for the list!", "Invalid List Size!"
          , JOptionPane.ERROR_MESSAGE);
    }
    final int size = Integer.parseInt(inputBuffer);
    int[] emptyArray = new int[size];

    JOptionPane.showMessageDialog(null, "Now you will choose the " + size
        + " numbers for your list!\n" + "All numbers must be between 1 and "
        + size + " but you CAN REPEAT!\n" + "Click 'OK' when you are ready to proceed"
        , "Picking Numbers for Your List", JOptionPane.INFORMATION_MESSAGE);

    int[] userArray = getElements(emptyArray, 0);
    ArrayList<int[]> duplicateData = getDuplicateData(selectionSort(userArray));

    int nDuplicated = duplicateData.size();
    String arrayStr = toString(userArray);
    String messageTitle = "Here is Your 'Number List'!";
    String dataMessage = "Duplicates:\n";

    if (nDuplicated > 0) {
      for (int[] col : duplicateData) {
        String line = "  " + col[0] + "    appears " + col[1] + " times\n";
        dataMessage += line;
      }
    }
    else {
      dataMessage += "  You didn't duplicate a single element!\n";
    }
    JOptionPane.showMessageDialog(null, "Here is the completed list!\n" + arrayStr + "\n"
        + dataMessage, messageTitle, JOptionPane.INFORMATION_MESSAGE);
  }

}
