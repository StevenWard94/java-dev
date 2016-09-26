/**
 * Steven Ward
 * WardValidPassword.java | Valid Password Project
 *
 * This program will prompt the user to enter a single password twice.
 * If the initial password is valid, then the two passwords will be compared. If
 *   they are equivalent, then the program will accept them and output an
 *   appropriate message; otherwise, it will output an "error" message. A "valid"
 *   password must be between 6 and 10 (inclusive) characters in length. It must
 *   also contain at least one each of letters, numbers and special characters.
 *   For example, 'sward94!' would be valid, but 'sward94' or 'sw94!' would not.
 *
 * Due Date: September 11, 2016
 */

import javax.swing.JOptionPane;  // For JOptionPane dialog windows.

import java.lang.String;         // For use of the String.charAt(..) function.
import java.lang.Character;      // For use of character type validation functions (e.g. isDigit(..) ).
import java.util.Objects;        // For use of Objects.equals(String, String) to compare passwords.

public class WardValidPassword {

  /**
   * Password validation function.
   * This function ensures that the password entered by the user is "valid".
   *  The requirements for a password to be considered "valid" are: 1) the
   *  password is no less than 6 and no more than 10 characters in length,
   *  and 2) the password contains at least one each of letters, numbers and
   *  special characters. Furthermore, if the password contains whitespace
   *  or a control character, it is automatically considered "invalid", even
   *  if it meets the two aforementioned requirements.
   *
   * @see java.lang.Character
   * @see java.lang.String
   * @param password  the user's password input that is to be validated.
   * @return          true if 'password' fulfills the validity requirements; otherwise false.
   */
  private static boolean isValidPassword(String password) {
    // password is invalid if its length is not within [6,10]
    if (password.length() < 6 || password.length() > 10) { return false; }

    // Initialize three boolean variables to represent the three character requirements.
    boolean hasAlpha = false, hasDigit = false, hasSpecial = false;

    // A 'for' loop to iterate through each character in the 'password'
    //  parameter. If a character fulfills one of the "type" requirements for
    //  a "valid" password then the corresponding variable is set equal to 'true'.
    //  If at any point in the loop, the character is a "whitespace" character, the function returns 'false'.
    for (int i = 0; i < password.length() && !(hasAlpha && hasDigit && hasSpecial); ++i) {
      char c = password.charAt(i);
      if (Character.isLetterOrDigit(c)) {
        if (Character.isLetter(c)) {
          hasAlpha = true;
        }
        else if (Character.isDigit(c)) {
          hasDigit = true;
        }
      }
      else {
        if (Character.isWhitespace(c)) { return false; }
        hasSpecial = true;
      }
    }
    // Return the logical conjunction of the three character predicates.
    return (hasAlpha && hasDigit && hasSpecial);
  }


  /**
   * Main function for program execution control.
   * This is the obligatory 'main' function for the program. It executes the
   * general procedure and interaction with the user required for the program to
   * perform as expected. It first prompts the user for a password and then
   * passes that password to the 'isValidPassword(String password)' function. It
   * then outputs an appropriate response and re-prompts the user if necessary.
   * Upon receiving a valid password, it prompts the user to enter the SAME
   * password. This second password is compared to the first and an appropriate
   * response is output to the user.
   */
  public static void main(String[] args) {
    // First, prompt the user for a password. The user's input is stored in the 'password' String variable.
    String password = JOptionPane.showInputDialog("Please enter a password. Passwords must contain between 6 and 10 characters (inclusive)"
            + " and have at least one each of letters, digits, and special characters.");
    
    // Loop "invalid password" message and "enter valid password" prompt until 'isValidPassword(password)' returns 'true'.
    while (!isValidPassword(password)) {
      JOptionPane.showMessageDialog(null, "Invalid Password. Please ensure that the password you select is no less than 6"
              + " and no more than 10 characters in length. Your password must also contain at least one letter, one number,"
              + " and one special character (punctuation will suffice).");
      password = JOptionPane.showInputDialog("Please enter a valid password.");  // Alter String object stored in 'password' variable.
    }
    
    // Now, the user is asked to enter their password a second time, storing their input in the 'password2' variable.
    String password2 = JOptionPane.showInputDialog("Please enter your password again to confirm.");
    
    // Using a null-safe equivalence test, compare the first and second password entries.
    if (Objects.equals(password, password2)) {
      // If the two passwords match, output a "success" message.
      JOptionPane.showMessageDialog(null, "You are now registered as a new user.");
    }
    else {
      // Otherwise, output a "typo" error-like message.
      JOptionPane.showMessageDialog(null, "Sorry, there is a typo in your password.");
    }
  // End of main(..) function body.
  }
// End of WardValidPassword class definition.
}
