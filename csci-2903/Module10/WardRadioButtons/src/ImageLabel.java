/**
 * Steven Ward
 * ImageLabel.java | Radio Buttons Project
 *
 * This file contains the definition of the ImageLabel class, which is described below.
 *
 * Due Date: November 6, 2016
 *
 */

import javax.swing.*;

/**
 * Specialized label to update and display images corresponding to radio button selections.
 *
 * A subclass of JLabel defining a label to be used in this program's GUI. The label can be empty or
 * display one of three (3) images: a dog, a bear, or an owl. Each of these images is associated
 * with an ImageIcon object that has been constructed with its corresponding image. This class also
 * contains a method for changing the displayed image, which is called from an associated instance
 * of the ButtonPanel class.
 *
 * @see WardRadioButtons#WardRadioButtons( )
 * @see WardRadioButtons#main(String[])
 * @see ButtonPanel#addAssociatedImageLabel(ImageLabel)
 * @see ButtonPanel#handleRadioButtonEvent(Object)
 * @see javax.swing.JLabel
 * @see javax.swing.ImageIcon
 */
public class ImageLabel extends JLabel {
  public static final ImageIcon DOG_IMAGE = new ImageIcon(ImageLabel.class.getResource("DogPicture.png"));
  public static final ImageIcon BEAR_IMAGE = new ImageIcon(ImageLabel.class.getResource("BearPicture.png"));
  public static final ImageIcon OTHER_IMAGE = new ImageIcon(ImageLabel.class.getResource("OwlPicture.png"));

  private static final long serialVersionUID = 1L;


  public ImageLabel( ) {

    this.setHorizontalAlignment(ImageLabel.CENTER);
    this.setVerticalAlignment(ImageLabel.TOP);
  }


  public void updateDisplay(final ImageIcon img) {
    if (img != this.getIcon()) {
      this.setIcon(img);
    }
  }

}
