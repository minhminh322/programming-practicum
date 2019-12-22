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
public class ToggleAction extends AbstractAction {

    /**  
     * A generated serial version UID for object Serialization. 
     * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
     */
    private static final long serialVersionUID = 1234567890L;
    
    /** A flag for the toggle. */
    private boolean myFlag;
    
    /** The text to use when the toggle is true. */
    private final String myFirstText;
    
    /** The text to use when the toggle is false. */
    private final String mySecondText;
    
    /** The icon to use when the toggle is true. */
    private final String myFirstIcon;
    
    /** The icon to use when the toggle is false. */
    private final String mySecondIcon;
    
    /** The behavior to run when the toggle is true. */
    private final Runnable myFirstAction;
    
    /** The behavior to run when the toggle is false. */
    private final Runnable mySecondAction;
    
    /**
     * Creates a ToggleAction.
     * 
     * @param theFirstText the text of this Action in the original state
     * @param theSecondText the text of this Action in the toggle state
     * @param theFirstIcon the icon of this Action in the original state
     * @param theSecondIcon the icon of this Action in the toggle state
     * @param theFirstAction the behavior of this Action in the original state
     * @param theSecondAction the behavior of this Action in the toggle state
     */
    public ToggleAction(final String theFirstText,
                        final String theSecondText,
                        final String theFirstIcon,
                        final String theSecondIcon,
                        final Runnable theFirstAction,
                        final Runnable theSecondAction) {
        super(theFirstText);
        
        myFirstText = theFirstText;
        mySecondText = theSecondText;
        myFirstIcon = theFirstIcon;
        mySecondIcon = theSecondIcon;
        myFirstAction = theFirstAction;
        mySecondAction = theSecondAction;
        
        setIcon(new ImageIcon(theFirstIcon));
        
        myFlag = true;
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        //Look at the status of the toggle. 
        if (myFlag) {
            myFirstAction.run();
            putValue(Action.NAME, mySecondText);
            setIcon(new ImageIcon(mySecondIcon));
        } else {
            mySecondAction.run();
            putValue(Action.NAME, myFirstText);
            setIcon(new ImageIcon(myFirstIcon));
        }
        myFlag = !myFlag;

    }
    
    /**
     * Helper to set the Icon to both the Large and Small Icon values. 
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
