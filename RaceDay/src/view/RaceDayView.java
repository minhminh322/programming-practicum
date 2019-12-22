
package view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import model.PropertyChangeEnabledRaceControls;

/**
 * RaceDay view Class.
 * @author minhphan
 * @version Fall 2019
 *
 */
public class RaceDayView extends JPanel {
    
    /**
     * 
     */
    private static final long serialVersionUID = 6462838404424268828L;
    /** Race TRack. */
    private RaceTrack myRaceTrack;
    /** Race leaderboard. */
    private RaceLeaderboard myRaceLeader;
    /** Race Status. */
    private RaceStatus myRaceStatus;


    /**
     * Default Constructor.
     * @param theModel .
     */
    public RaceDayView(final PropertyChangeEnabledRaceControls theModel) {
        setLayout(new BorderLayout());

        addPropertyChangeListener(theModel);
        add(new RaceTrack(), BorderLayout.NORTH);
        add(new RaceLeaderboard(), BorderLayout.CENTER);
        add(new RaceStatus(), BorderLayout.SOUTH);
    }

    /**
     * addPropertyChange.
     * @param theModel .
     */
    private void addPropertyChangeListener(final PropertyChangeEnabledRaceControls theModel) {
        theModel.addPropertyChangeListener(myRaceTrack);
        theModel.addPropertyChangeListener(myRaceLeader);
        theModel.addPropertyChangeListener(myRaceStatus);

    }


}
