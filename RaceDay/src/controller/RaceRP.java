
package controller;

import static model.PropertyChangeEnabledRaceControls.PROPERTY_MAP;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.Race;

/**
 * Swing Timer Panel class.
 * 
 * @author minhphan
 * @version Fall 2018
 *
 */
public class RaceRP extends JPanel implements PropertyChangeListener {
    /**
     * A generated serial version UID for object Serialization.
     * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
     */
    private static final long serialVersionUID = 8385732728740430466L;
    /** The number of columns in the text area. */
    private static final int GRID_ROW = 6;
    /** The number of columns in the text area. */
    private static final int GRID_COLS = 0;

    /** ArrayList of Racers. */
    private List<String> myRacers;
    /** JPanel. */
    private JPanel myTabInside;
    /** JScroll pane. */
    private JScrollPane myScrollPane;
    /** Race Object. */
    private Race myRace = new Race();

    /**
     * Construct a Time Panel.
     */
    public RaceRP() {
        super();

        myTabInside = new JPanel(new GridLayout(GRID_ROW, GRID_COLS));

        myScrollPane = new JScrollPane(myTabInside, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                     JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setLayout(new BorderLayout());

        setupComponents();

    }

    /**
     * Setup components methods.
     */
    private void setupComponents() {

        final JCheckBox all = new JCheckBox("Select All", true);
        myTabInside.add(all);

    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if (PROPERTY_MAP.equals(theEvent.getPropertyName())) {

            myRace = (Race) theEvent.getNewValue();

            myRacers = new ArrayList<>();
            myRacers = myRace.getRacerName();

            for (int i = 0; i < myRacers.size(); i++) {
                final JCheckBox button = new JCheckBox(myRacers.get(i), true);
                myTabInside.add(button);
            }
            add(myScrollPane);
        }
    }

}
