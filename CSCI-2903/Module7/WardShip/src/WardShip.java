/**
 * Steven Ward
 * WardShip.java | Ship, CruiseShip, and CargoShip Classes Project
 *
 * This file contains the entry point for the 'Ship, CruiseShip, CargoShip' program described below.
 *
 * Due Date: October 16, 2016
 *
 */

import java.util.HashSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


public class WardShip {

  private static boolean tryParseInt(String value) {
    try {
      Integer.parseInt(value);
      return true;
    }
    catch (NumberFormatException nfe) {
      return false;
    }
  }


  // year never required as int - this is just an odd algorithm for input validation.
  private static boolean tryParseYear(String yearStr) {
    try {
      int year = Integer.parseInt(yearStr);
      return ( year > 999 && year < 2017 ? true : false );
    }
    catch (NumberFormatException nfe) {
      return false;
    }
  }
}
