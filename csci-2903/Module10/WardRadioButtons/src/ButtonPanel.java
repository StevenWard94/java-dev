/**
 * Steven Ward
 * ButtonPanel.java | Radio Buttons Project
 *
 * This file contains the definition of the ButtonPanel class, which is described below.
 *
 * Due Date: November 6, 2016
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Specialized panel to display, and handle ActionEvents from, this program's radio
 * buttons.
 *
 * A subclass of JPanel defining one of the panels to be used in this program's GUI.
 * Contains three (3) JRadioButton components as well as an inner class implementing
 * ActionListener, as its object member fields. This class also defines a "handler"
 * method to perform the proper behaviors upon creation of an ActionEvent by one of the
 * radio buttons.
 *
 * @see WardRadioButtons#MainWindow
 * @see ImagePanel
 * @see javax.swing.JPanel
 * @see javax.swing.JRadioButton
 * @see java.awt.event.ActionListener
 */
public class ButtonPanel extends JPanel {

  public final ActionListener buttonListener = new RadioButtonListener();

  private static final long serialVersionUID = 0L;

  private JRadioButton dogButton, bearButton, otherButton;
  private ButtonGroup radioButtonGroup = new ButtonGroup();

  public ButtonPanel( ) {
    dogButton = new JRadioButton("DOG");
    bearButton = new JRadioButton("BEAR");
    otherButton = new JRadioButton("OTHER");

    this.setLayout(new FlowLayout());
    this.add(dogButton);
    this.add(bearButton);
    this.add(otherButton);

    dogButton.addActionListener(buttonListener);
    bearButton.addActionListener(buttonListener);
    otherButton.addActionListener(buttonListener);

    radioButtonGroup.add(dogButton);
    radioButtonGroup.add(bearButton);
    radioButtonGroup.add(otherButton);
  }

  private class RadioButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
      handleRadioButtonEvent(event.getSource());
    }
  }

  private void handleRadioButtonEvent(Object component) {
    // TODO: WRITE HANDLER FOR RADIO BUTTON EVENTS
  }
}
