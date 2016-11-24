/**
 * Steven Ward
 * WardMousePosition.java | Mouse Position Project
 *
 * This file defines the WardMousePosition GUI class and program, which is described below.
 *
 * Due Date: November 13, 2016
 *
 */

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * Single, top-level GUI class containing this program's execution outline.
 *
 * Contains all methods and private classes required for the execution of the 'WardMousePosition'
 * program. This includes the program's entry point, defined in the public 'main' method. The class
 * itself defines a GUI window derived from the JFrame class, which displays the mouse position in
 * its title as the mouse cursor moves within its window.
 *
 * @see          javax.swing.JFrame
 * @see          java.awt.event.MouseEvent
 * @see          java.awt.event.MouseInputListener
 */

public class WardMousePosition extends JFrame {
  private static final long serialVersionUID = 0L;

  private static final int WINDOW_WIDTH = 1000;
  private static final int WINDOW_HEIGHT = 750;

  private MouseAdapter generalListener = new MouseAdapter() {
    @Override
    public void mouseEntered(MouseEvent e) {
      WardMousePosition.this.updateTitle(e.getPoint());
    }

    @Override
    public void mouseExited(MouseEvent e) {
      WardMousePosition.this.updateTitle(-1);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
      WardMousePosition.this.updateTitle(e.getPoint());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
      this.mouseMoved(e);
    }
  };


  public static void main(String[] args) {
    JFrame applicationWindow = new WardMousePosition();
    applicationWindow.setVisible(true);
  }


  public WardMousePosition( ) {
    this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        int confirmExit =
            JOptionPane.showConfirmDialog(null, "Are you sure you want to leave?", "Exit?",
                                          JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirmExit == JOptionPane.YES_OPTION) {
          System.exit(0);
        }
      }
    });

    this.addMouseListener(this.generalListener);
    this.addMouseMotionListener(this.generalListener);
  }


  private void updateTitle(final Point point) {
    final String newTitle = "(" + point.x + ", " + point.y + ")";
    this.setTitle(newTitle);
  }

  private void updateTitle(int i) {
    this.setTitle("???");
  }

}
