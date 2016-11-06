/**
 * Steven Ward
 * WardCheckBoxes.java | Check Boxes Project
 *
 * This file defines the WardCheckBoxes GUI class, which is described below.
 *
 * Due Date: November 6, 2016
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Defines the GUI to be used as this program's primary input/ouput interface.
 *
 * Creates a window derived from JFrame that contains two child components, both of which are
 * JCheckBox objects. One checkbox is labeled "BLUE" and the other is labeled "ORANGE". A unique
 * color combination for the background and foreground of a WardCheckBoxes object is defined for
 * each combination of "BLUE" and "ORANGE" selections/deselections:
 *         DESELCT BLUE, DESELECT ORANGE  :  Black Foreground on Gray Background
 *         SELECT BLUE, DESELECT ORANGE   :  Yellow Foreground on Blue Background
 *         DESELECT BLUE, SELECT ORANGE   :  White Foreground on Orange Background
 *         SELECT BLUE, SELECT ORANGE     :  Orange Foreground on Blue Background
 *
 * This class also defines a 'main' method to serve as the entry point of the WardCheckBoxes
 * application.
 *
 * @see          javax.swing.JFrame
 * @see          javax.swing.JCheckBox
 * @see          java.awt.event.ItemListener
 * @see          java.awt.Color
 */

public class WardCheckBoxes extends JFrame {

  private static final long serialVersionUID = 0L;

  private static final String DEFAULT_TITLE     = "Black on Gray";
  private static final String BLUE_TITLE        = "Yellow on Blue";
  private static final String ORANGE_TITLE      = "White on Orange";
  private static final String BLUE_ORANGE_TITLE = "Orange on Blue";

  private JPanel checkboxPanel;
  private JCheckBox blueCheckBox, orangeCheckBox;
  private boolean[] boxesChecked;

  private class ColorChangeListener implements ItemListener {
    @Override
    public void itemStateChanged(ItemEvent event) {
      Object checkbox = event.getSource();
      if (checkbox == WardCheckBoxes.this.blueCheckBox) {
        WardCheckBoxes.this.boxesChecked[0] = blueCheckBox.isSelected();
      }
      else {
        WardCheckBoxes.this.boxesChecked[1] = orangeCheckBox.isSelected();
      }

      boolean blueChecked = boxesChecked[0], orangeChecked = boxesChecked[1];
      if (blueChecked && orangeChecked) {
        WardCheckBoxes.this.checkboxPanel.setBackground(Color.BLUE);
        WardCheckBoxes.this.checkboxPanel.setForeground(Color.ORANGE);
        WardCheckBoxes.this.setTitle(WardCheckBoxes.BLUE_ORANGE_TITLE);
      }
      else if (blueChecked && !orangeChecked) {
        WardCheckBoxes.this.checkboxPanel.setBackground(Color.BLUE);
        WardCheckBoxes.this.checkboxPanel.setForeground(Color.YELLOW);
        WardCheckBoxes.this.setTitle(WardCheckBoxes.BLUE_TITLE);
      }
      else if (!blueChecked && orangeChecked) {
        WardCheckBoxes.this.checkboxPanel.setBackground(Color.ORANGE);
        WardCheckBoxes.this.checkboxPanel.setForeground(Color.WHITE);
        WardCheckBoxes.this.setTitle(WardCheckBoxes.ORANGE_TITLE);
      }
      else {
        WardCheckBoxes.this.checkboxPanel.setBackground(Color.GRAY);
        WardCheckBoxes.this.checkboxPanel.setForeground(Color.BLACK);
        WardCheckBoxes.this.setTitle(WardCheckBoxes.DEFAULT_TITLE);
      }
      WardCheckBoxes.this.checkboxPanel.revalidate();
      WardCheckBoxes.this.checkboxPanel.repaint();
      WardCheckBoxes.this.revalidate();
      WardCheckBoxes.this.repaint();
    }
  }
}
