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

import javax.swing.JOptionPane;

import java.lang.String;
import java.lang.Character;

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

    // 'hasChars' is an array of three boolean values, each of which corresponds
    //   to one of the three character "types" that must be present in a "valid"
    //   password. All three array elements are implicitly initialized to
    //   'false' upon instantiation of the array.
    boolean[] hasChars = new boolean[3];

    // A 'for' loop to iterate through each character in the 'password'
    //  parameter. If a character fulfills one of the "type" requirements for
    //  a "valid" password then the corresponding element in the 'hasChars'
    //  array is set to 'true'. The first element of 'hasChars' corresponds to
    //  "letters", the second corresponds to "digits" and the third corresponds
    //  to "special characters". If at any point in the loop, the character is
    //  a "whitespace" or "control" character, the function returns 'false'.
    for (int i = 0; i < password.length() || (hasChars[0] && hasChars[1] && hasChars[2]); ++i) {
      char c = password.charAt(i);
      if (Character.isLetterOrDigit(c)) {
        hasChars[0] = Character.isLetter(c);
        hasChars[1] = Character.isDigit(c);
      }
      else {
        boolean isInvalid = Character.isWhitespace(c) || Character.isISOControl(c);
        if (isInvalid) { return false; }
        hasChars[2] = Character.isJavaIdentifierPart(c);
      }
    }
    // returns the value obtained by folding 'hasChars[]' with '&&' and an
    //  initial accumulator of 'true':  foldr (&&) True hasChars
    return hasChars[0] && hasChars[1] && hasChars[2];
  }


  /**
   * Main function for program execution control.
   * This is the obligatory 'main' function for the program. It executes the
   * general procedure and interaction with the user required for the program to
   * perform as expected. It first prompts the user for a password and then
   * passes that password to the 'isValidPassword(String password)' function. It
   * then outputs an appropriate response and reprompts the user if necessary.
   * Upon receiving a valid password, it prompts the user to enter the SAME
   * password. This second password is compared to the first and an appropriate
   * response is output to the user.
   */
  public static void main(String[] args) {

  }
}
