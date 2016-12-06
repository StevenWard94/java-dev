/** This short program outputs a list of fonts available on the current system */

import java.awt.GraphicsEnvironment;

public class ListAvailableFonts {

    public static void main(String[] args) {
        String[] fontNames =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for (int i = 0; i < fontNames.length; i++) {
            System.out.println(fontNames[i]);
        }
    }
}
