
package view;

import static model.PropertyChangeEnabledRaceControls.PROPERTY_MAP;

import java.awt.Color;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.Race;

/**
 * RaceLeaderboard class.
 * @author minhphan
 * @version Fall 2018.
 *
 */
public class RaceLeaderboard extends JPanel implements PropertyChangeListener {

    /**
     * 
     */
    private static final long serialVersionUID = 3405558915055849185L;
    /** Race object. */
    private Race myRace;
    /** JPanel button. */
    private JButton myButton;

    /**
     * Constructor.
     */
    public RaceLeaderboard() {

        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        myRace = new Race();

    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if (PROPERTY_MAP.equals(theEvent.getPropertyName())) {
            myRace = (Race) theEvent.getNewValue();
            for (int i = 0; i < myRace.getRacerID().size(); i++) {
                myButton = new JButton(myRace.getRacerID().get(i) + ": "
                                       + myRace.getRacerName().get(i));
                add(myButton);
                myButton.setBackground(Color.PINK);
                myButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            }
            revalidate();

        }

    }

}
