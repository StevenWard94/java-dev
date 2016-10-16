/**
 * Steven Ward
 * WardShip.java | Ship, CruiseShip, and CargoShip Classes Project
 *
 * This file contains the entry point for the 'Ship, CruiseShip, CargoShip' program described below.
 *
 * Due Date: October 16, 2016
 *
 */

import java.util.ArrayDeque;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


public class WardShip {

  public static void main(String[] args) {

  }


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


  private static String getName( ) {
    final String title = "Step 1";
    final String prompt = "1. Please enter the name of the ship:";
    final String name =
        JOptionPane.showInputDialog( null, Utility.format(Utility.WRAP, prompt, SwingConstants.LEFT)
                                   , title, Utility.QUESTION );
    return name;
  }
}
