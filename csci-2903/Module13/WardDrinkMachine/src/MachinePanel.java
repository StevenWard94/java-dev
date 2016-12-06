/**
 * Steven Ward
 * MachinePanel.java | Drink Machine Project
 *
 */

import javax.swing.Box;
import javax.swing.Box.Filler;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import java.util.ArrayList;
import java.util.List;

public class MachinePanel extends JPanel {
  private static final long serialVersionUID = 1L;

  private JButton colaButton;
  private JButton lemonLimeButton;
  private JButton waterButton;
  private JTextField machineReadout;


  private List<Component> initFillerPanels( ) {
    List<Component> fillerPanels = new ArrayList<Component>();
    fillerPanels.add(Box.createHorizontalGlue());
    fillerPanels.add(Box.createHorizontalGlue());
    fillerPanels.add(new Box.Filler(new Dimension(50,50), new Dimension(50,50), new Dimension(50,50)));
    fillerPanels.add(new Box.Filler(new Dimension(50,50), new Dimension(50,50), new Dimension(50,50)));
    fillerPanels.add(new Box.Filler(new Dimension(50,50), new Dimension(50,50), new Dimension(50,50)));

    return fillerPanels;
  }


  private JTextField initMachineReadout( ) {
    this.machineReadout = new JTextField("Ice Cold Drinks! Only $0.75!");
    machineReadout.setEditable(false);
    machineReadout.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
    return this.machineReadout;
  }


  public MachinePanel( ) {
    super();
    this.setPreferredSize(new Dimension(750,750));

    List<Component> componentPanels = initFillerPanels();
    componentPanels.add(1, initMachineReadout());

  }
}
