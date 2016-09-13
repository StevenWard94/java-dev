/**
 * Steven Ward
 * WardDomainName.java | Domain Name Project
 *
 * A program to demonstrate the DomainName class.
 * This program is intended to test and demonstrate the 'DomainName' class (defined in
 * 'DomainName.java'). It first prompts the user to enter a "domain name". Once the input received
 * from the user is considered "valid", it is used to construct an instance of the 'DomainName'
 * class. This instance is then used to call the 'hasPrefix', 'extension' and 'name' member
 * functions, which subsequently have their respective return values output in a human-readable
 * format.
 *
 * @see #main(String[] args)
 * @see DomainName#DomainName(String)
 * @see DomainName#hasPrefix
 * @see DomainName#extension
 * @see DomainName#name
 */

import javax.swing.JOptionPane;  /** Allows use of unqualified 'JOptionPane' class name. */

public class WardDomainName {

  /**
   * Method to validate a "domain name" string.
   * This is a utility method that takes the domain name String entered by the user and returns
   * a boolean value: 'true' if the domain name is "valid"; otherwise, 'false'. The predicates used
   * to determine validity are, 1) that the domain name String is not empty, and 2) that the domain
   * name matches a regular expression specifying the general format of a "valid" domain name, which
   * is case-insensitive and defined as:
   *   {optional "www."} + {sequence of letters/numbers} + "." + {sequence of exactly 3 letters}
   *
   * @param input  The domain name entered by the user, which is to be validated.
   * @return       A boolean reflecting the "validity" of the domain name argument.
   *
   * @see java.lang.String
   * @see java.lang.String#matches(String)
   * @see java.util.regex.Pattern
   */
  private static boolean isValidDomain(String input) {

    /**
     * Regular expression for a "valid" domain name.
     * Defines the pattern (described above method header) used by this method to validate a domain
     * name String. A brief overview of the tokens used follows:
     *
     *     Regex Token                          Meaning/Matches
     *    -------------                        -----------------
     *         \\           equivalent to a single backslash in the pattern - '\' is escaped ('\\').
     *        (?i)          makes the regular expression that follows case-insensitive.
     *          ^           matches the beginning of a String (so optional "www." must be at start).
     *      (www\.)?        matches ONE or NO occurrences of "www." - '.' is escaped ('\.').
     *         \w+          matches ONE or MANY "word" characters ('\w' - alphanumeric & underscore).
     *         \.           matches EXACTLY ONE literal '.' character.
     *     [a-zA-Z]{3}      matches a sequence of EXACTLY THREE upper or lowercase letters.
     *          $           matches the end of a String (no match if there are excess characters).
     */
    String domainRegex = "(?i)^(www\\.)?\\w+\\.[a-zA-Z]{3}$";

    /*
     * Return 'true' IFF the String, 'input', matches the regular expression defined in
     * 'domainRegex' (also implicitly checks that 'input' is non-empty).
     */
    return input.matches(domainRegex);
  }


  public static void main(String[] args) {

    String domainIn = JOptionPane.showInputDialog(frame, "A domain name is the \"core\" address of a website.\n"
        + "Here is an example:  'www.facebook.com'\n"
        + "Please enter a domain name of your choice, with or without the leading 'www.':");

    while (!isValidDomain(domainIn)) {
      JOptionPane.showMessageDialog(frame,
          "A valid domain name must contain:\n"
          + " 1. An optional \"www.\" at the start of the domain name\n"
          + " 2. A sequence of characters containing ONLY letters, digits and underscores ('_')\n"
          + " 3. A dot ('.') followed by EXACTLY THREE letters, which must be the last characters\n"
          + " 4. No \"whitespace\" characters (space, tab, <Enter>, etc.)", "Invalid Domain Name",
          JOptionPane.WARNING_MESSAGE);

      domainIn = JOptionPane.showInputDialog(frame, "Please enter a valid domain name:");
    }

    //! TODO:
    //!     - initialize an instance of 'DomainName' class
    //!     - output values returned from 'hasPrefix', 'extension' and 'name' methods
    //!     - end program execution
    //!     - DOCUMENTATION
  }
}
