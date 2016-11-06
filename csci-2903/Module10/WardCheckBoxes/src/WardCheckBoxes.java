/**
 * Steven Ward
 * WardCheckBoxes.java | Check Boxes Project
 *
 * This file defines the WardCheckBoxes GUI class, which is described below.
 *
 * Due Date: November 6, 2016
 *
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

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
 * @see          java.awt.GridBagLayout
 * @see          javax.swing.JCheckBox
 * @see          java.awt.event.ItemListener
 * @see          java.awt.Color
 */

public class WardCheckBoxes extends JFrame {

  private static final long serialVersionUID = 0L;
  private static final int MIN_WIN_WIDTH = 800;
  private static final int MIN_WIN_HEIGHT = 600;

  private static final String DEFAULT_TITLE     = "Black on Gray";
  private static final String BLUE_TITLE        = "Yellow on Blue";
  private static final String ORANGE_TITLE      = "White on Orange";
  private static final String BLUE_ORANGE_TITLE = "Orange on Blue";

  private JPanel checkboxPanel;
  private JCheckBox blueCheckBox, orangeCheckBox;
  private ItemListener checkboxListener;
  private GridBagConstraints layoutConstraints;
  private boolean[] checkboxStatus;

  private class ColorChangeListener implements ItemListener {
    @Override
    public void itemStateChanged(ItemEvent event) {
      Object checkbox = event.getSource();
      if (checkbox == WardCheckBoxes.this.blueCheckBox) {
        WardCheckBoxes.this.checkboxStatus[0] = blueCheckBox.isSelected();
      }
      else {
        WardCheckBoxes.this.checkboxStatus[1] = orangeCheckBox.isSelected();
      }

      boolean blueChecked = checkboxStatus[0], orangeChecked = checkboxStatus[1];
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


  public static void main(String[] args) {
    WardCheckBoxes mainWindow = new WardCheckBoxes();
    mainWindow.setVisible(true);
  }


  public WardCheckBoxes( ) {

    super(DEFAULT_TITLE);
    this.setMinimumSize(new Dimension(MIN_WIN_WIDTH, MIN_WIN_HEIGHT));

    this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent event) {
        int confirmExit =
            JOptionPane.showConfirmDialog(null, "Leaving so soon?", "Close Application?",
                                          JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirmExit == JOptionPane.YES_OPTION) {
          System.exit(0);
        }
      }
    });

    this.setLayout(new GridBagLayout());
    this.checkboxPanel.setLayout(new GridBagLayout());
    checkboxPanel.setPreferredSize(this.getSize());
    this.checkboxListener = new ColorChangeListener();

    this.blueCheckBox = new JCheckBox("BLUE");
    blueCheckBox.setFont(blueCheckBox.getFont().deriveFont(Font.BOLD, 48.0f));
    blueCheckBox.addItemListener(checkboxListener);

    this.orangeCheckBox = new JCheckBox("ORANGE");
    orangeCheckBox.setFont(blueCheckBox.getFont());
    orangeCheckBox.addItemListener(checkboxListener);
    orangeCheckBox.setPreferredSize(blueCheckBox.getPreferredSize());

    this.layoutConstraints = new GridBagConstraints();
    layoutConstraints.anchor = GridBagConstraints.CENTER;
    layoutConstraints.fill = GridBagConstraints.BOTH;
    layoutConstraints.ipadx = 2;
    layoutConstraints.gridx = 0;
    layoutConstraints.gridy = 0;
    checkboxPanel.add(blueCheckBox, layoutConstraints);

    layoutConstraints.gridx = 1;
    checkboxPanel.add(orangeCheckBox, layoutConstraints);

    layoutConstraints.ipadx = 0;
    layoutConstraints.gridx = 0;
    this.add(checkboxPanel, layoutConstraints);
  }
}
