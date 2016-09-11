/**
 *  Steven Ward
 *  WardDialogBox.java | Dialog Box Project
 *  
 *  A program to read a sentence using a dialog box, and then, depending on the
 *  punctuation of that sentence, return a categorization of that sentence.
 *  
 *  Due Date:  September 11, 2016
 */

import javax.swing.JOptionPane;

public class WardDialogBox {
  
  public static void main(String[] args) {
    
    // prompt the user to enter a sentence with a dialog box and store the input String in 'sentence'
    String sentence = JOptionPane.showInputDialog("Enter a sentence (including punctuation):");
    
    /**
     * If no sentence was entered into the previous dialog box, the program will throw a
     * StringIndexOutOfBoundsException at the call to 'sentence.charAt(sentence.length()-1)'
     */
    switch (sentence.charAt( sentence.length() - 1 )) {
      
      // case of the sentence ending in a period
      case '.':
        JOptionPane.showMessageDialog(null, "Your sentence was 'declarative'!");
        break;
        
      // case of the sentence ending in a question mark
      case '?':
        JOptionPane.showMessageDialog(null, "Your sentence was 'interrogative'!");
        break;
        
      // case of the sentence ending in an exclamation point
      case '!':
        JOptionPane.showMessageDialog(null, "Your sentence was 'exclamatory'!");
        break;
        
      // default case to catch alternative, or no, punctuation
      default:
        JOptionPane.showMessageDialog(null, "Your sentence was 'other'!");
    }
  }
}