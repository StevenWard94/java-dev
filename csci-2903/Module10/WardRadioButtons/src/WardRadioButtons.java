/**
 * Steven Ward
 * WardRadioButtons.java | Radio Buttons Project
 *
 * This file contains the WardRadioButtons class, which defines the entry point for this program.
 *
 * Due Date: November 6, 2016
 *
 */

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;

/**
 * Provides an entry point and relevant classes for the WardRadioButtons program's execution.
 *
 * Defines a GUI class derived from JFrame that this program uses as its primary input/output
 * interface. Contains a simple 'main' method to instantiate a WardRadioButtons object in order to
 * display the driving user interface. This class has two instance member Components, an ImageLabel object
 * and a ButtonPanel object. Also contains an inner class implementing the PropertyChangeListener
 * interface. An instance of this inner class is added to the ImageLabel member in order to detect
 * changes in that object's 'icon' property.
 *
 * @see ButtonPanel
 * @see ImageLabel
 * @see ImageLabel#updateDisplay(ImageIcon)
 * @see javax.swing.JFrame
 * @see javax.swing.JLabel#addPropertyChangeListener(String,PropertyChangeListener)
 * @see java.beans.PropertyChangeEvent
 * @see java.beans.PropertyChangeListener
 */
public class WardRadioButtons extends JFrame {

  public static final String DEFAULT_TITLE = "Just Radio Buttons";
  public static final String DOG_TITLE = "DOG | Radio Buttons";
  public static final String BEAR_TITLE = "BEAR | Radio Buttons";
  public static final String OTHER_TITLE = "OTHER | Radio Buttons";

  private static final long serialVersionUID = 2L;

  private ImageLabel imageLabel;
  private ButtonPanel buttonPanel;


  public static void main(String[] args) {
    WardRadioButtons mainWindow = new WardRadioButtons();
    mainWindow.setVisible(true);
  }

  public WardRadioButtons( ) {

    super(DEFAULT_TITLE);

    this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent event) {
        int confirmExit =
            JOptionPane.showConfirmDialog(null, "Are you sure you want to leave?", "Exit?",
                                          JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirmExit == JOptionPane.YES_OPTION) {
          System.exit(0);
        }
      }
    });

    this.imageLabel = new ImageLabel();
    this.imageLabel.addPropertyChangeListener("icon", new PropertyChangeListener() {
      @Override
      public void propertyChange(PropertyChangeEvent event) {
        Object image = event.getNewValue();
        if (image == ImageLabel.DOG_IMAGE) {
          WardRadioButtons.this.setTitle(DOG_TITLE);
          WardRadioButtons.this.revalidate();
          WardRadioButtons.this.repaint();
        }
        else if (image == ImageLabel.BEAR_IMAGE) {
          WardRadioButtons.this.setTitle(BEAR_TITLE);
          WardRadioButtons.this.revalidate();
          WardRadioButtons.this.repaint();
        }
        else if (image == ImageLabel.OTHER_IMAGE) {
          WardRadioButtons.this.setTitle(OTHER_TITLE);
          WardRadioButtons.this.revalidate();
          WardRadioButtons.this.repaint();
        }
      }
    });
    this.buttonPanel = new ButtonPanel();
    this.buttonPanel.addAssociatedImageLabel(imageLabel);

    this.setLayout(new GridLayout(2, 1));
    this.add(imageLabel);
    this.add(buttonPanel);
  }
}
