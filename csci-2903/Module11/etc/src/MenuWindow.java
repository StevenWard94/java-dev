/*
 * Code Listing 13-6  |  MenuWindow.java
 *     Chapter 13.8: Menus
 *     (pp. 888-892)
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The MenuWindow class demonstrates a menu system.
 */

public class MenuWindow extends JFrame
{
    private JLabel messageLabel;             // Displays a message
    private final int LABEL_WIDTH = 400;     // Label's width
    private final int LABEL_HEIGHT = 200;    // Label's height

    // The following will reference menu components:
    private JMenuBar menuBar;                // The menu bar
    private JMenu fileMenu;                  // The File menu
    private JMenu textMenu;                  // The Text menu
    private JMenuItem exitItem;              // To exit
    private JRadioButtonMenuItem blackItem;  // Makes text black
    private JRadioButtonMenuItem redItem;    // Makes text red
    private JRadioButtonMenuItem blueItem;   // Makes text blue
    private JCheckBoxMenuItem visibleItem;   // Makes text black

    /**
     * Constructor
     */

    public MenuWindow( )
    {
        // Set the title.
        setTitle("Example Menu System");

        // Specify an action for the "close" button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the 'messageLabel' label.
        messageLabel = new JLabel("Use the 'Text' menu to " +
                  "change my color and make me invisible.",
                  SwingConstants.CENTER);

        // Set the label's preferred size.
        messageLabel.setPreferredSize(new Dimension(LABEL_WIDTH, LABEL_HEIGHT));

        // Set the label's foreground color.
        messageLabel.setForeground(Color.BLACK);

        // Add the label to the content pane.
        add(messageLabel);

        // Build the menu bar.
        buildMenuBar();

        // Pack and display the window.
        pack();
        setVisible(true);
    }

    /**
     * The 'buildMenuBar' method builds the menu bar.
     */

    private void buildMenuBar( )
    {
        // Create the menu bar.
        menuBar = new JMenuBar();

        // Create the file and text menus.
        buildFileMenu();
        buildTextMenu();

        // Add the file and text menus to the menu bar.
        menuBar.add(fileMenu);
        menuBar.add(textMenu);

        // Set the window's menu bar.
        setJMenuBar(menuBar);
    }

    /**
     * The buildFileMenu method builds the File menu
     * and returns a reference to its JMenu object.
     */

    private void buildFileMenu( )
    {
        // Create an 'Exit' menu item.
        exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.addActionListener(new ExitListener());

        // Create a JMenu object for the "File" menu.
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        // Add the "Exit" menu item to the "File" menu.
        fileMenu.add(exitItem);
    }
}
