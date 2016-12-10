/**
 * Steven Ward
 * FollowMe.java | FollowMe Applet
 *
 * This is a solution to Programming Challenge 14-1 (pg. 988)
 *
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JApplet;
import javax.swing.JTextField;

public class FollowMe
  extends JApplet implements MouseListener, MouseMotionListener {
  private static final long serialVersionUID = 1L;

  private static final String FOLLOW_TEXT = "Hello";
  private Point cursorPosition;
  private boolean helloVisible = false;

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    if (this.helloVisible) {
      g.drawString(FOLLOW_TEXT, (int) cursorPosition.getX(), (int) cursorPosition.getY());
    }
  }

  // empty implementations for abstract methods of MouseListener interface
  @Override public void mouseClicked(MouseEvent e) {/* no implementation */}
  @Override public void mousePressed(MouseEvent e) {/* no implementation */}
  @Override public void mouseReleased(MouseEvent e) {/* no implementation */}

  // empty implementation for MouseMotionListener.mouseDragged(MouseEvent ) abstract method
  @Override public void mouseDragged(MouseEvent e) {/* no implementation */}

  @Override
  public void mouseEntered(MouseEvent me) {
    cursorPosition.setLocation(me.getPoint());
    helloVisible = true;
    this.repaint();
  }

  @Override
  public void mouseExited(MouseEvent me) {
    helloVisible = false;
    this.repaint();
  }

  @Override
  public void mouseMoved(MouseEvent me) {
    cursorPosition.setLocation(me.getPoint());
    this.repaint();
  }


  public void init( ) {
    this.helloVisible = true;
    this.cursorPosition =
      new Point((int) getSize().getWidth() / 2, (int) getSize().getHeight() / 2);

    addMouseListener(this);
    addMouseMotionListener(this);
  }

}
