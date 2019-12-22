
package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

/**
 * A implementation of Action that will "toggle" between two states.
 * 
 * @author Charles Bryan
 * @version Autumn 2018
 */
public class SingleAction extends AbstractAction {

    /**
     * A generated serial version UID for object Serialization.
     * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
     */
    private static final long serialVersionUID = 1234567890L;

    /** The text to use when the toggle is true. */
    private final String myText;

    /** The icon to use when the toggle is true. */
    private final String myIcon;

    /** The behavior to run when the toggle is true. */
    private final Runnable myAction;

    /**
     * Creates a ToggleAction.
     * 
     * @param theText the text of this Action in the original state
     * @param theIcon the icon of this Action in the original state
     * @param theAction the behavior of this Action in the original state
     */
    public SingleAction(final String theText, final String theIcon, final Runnable theAction) {
        super(theText);

        myText = theText;

        myIcon = theIcon;

        myAction = theAction;

        setIcon(new ImageIcon(theIcon));

    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {

        myAction.run();
        putValue(Action.NAME, myText);
        setIcon(new ImageIcon(myIcon));

    }

    /**
     * Helper to set the Icon to both the Large and Small Icon values.
     * 
     * @param theIcon the icon to set for this Action
     */
    private void setIcon(final ImageIcon theIcon) {
        final ImageIcon icon = (ImageIcon) theIcon;
        final Image largeImage =
                        icon.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
        final ImageIcon largeIcon = new ImageIcon(largeImage);
        putValue(Action.LARGE_ICON_KEY, largeIcon);

        final Image smallImage =
                        icon.getImage().getScaledInstance(12, -1, java.awt.Image.SCALE_SMOOTH);
        final ImageIcon smallIcon = new ImageIcon(smallImage);
        putValue(Action.SMALL_ICON, smallIcon);
    }

}
