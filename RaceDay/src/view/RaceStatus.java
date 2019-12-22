
package view;

import static model.PropertyChangeEnabledRaceControls.PROPERTY_TIME;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * RaceStatus class.
 * @author minhphan
 * @version Fall 2018.
 *
 */
public class RaceStatus extends JPanel implements PropertyChangeListener {

    /**
     * 
     */
    private static final long serialVersionUID = 7872728925089958093L;
    /** The size of the Race Track Panel. */
    private static final GridLayout LAYOUT = new GridLayout(1, 3);
    /** The size of the Race Track Panel. */
    private static final Dimension TRACK_SIZE = new Dimension(650, 35);
    /** The separator for formatted. */
    private static final String SEPARATOR = ":";
    /** The number of milliseconds in a second. */
    private static final int MILLIS_PER_SEC = 1000;
    /** The number of seconds in a minute. */
    private static final int SEC_PER_MIN = 60;
    /** The number of minute in a hour. */
    private static final int MIN_PER_HOUR = 60;
    /** A formatter to require at least 1 digit, leading 0. */
    @SuppressWarnings("unused")
    private static final DecimalFormat ONE_DIGIT_FORMAT = new DecimalFormat("0");
    /** A formatter to require at least 2 digits, leading 0s. */
    private static final DecimalFormat TWO_DIGIT_FORMAT = new DecimalFormat("00");
    /** A formatter to require at least 3 digits, leading 0s. */
    private static final DecimalFormat THREE_DIGIT_FORMAT = new DecimalFormat("000");
    /** JLabel participants. */
    private JLabel myParticipant;
    /** JLabel timer. */
    private JLabel myTimerLabel;

 
    /**
     * Constructor. 
     */
    public RaceStatus() {
        // TODO Auto-generated constructor stub
        super();
        setupComponents();

        myTimerLabel = new JLabel(formatTime(0));
        myParticipant = new JLabel();

 
    }
    /** setup layout. */
    private void setupComponents() {
        setLayout(LAYOUT);
        setPreferredSize(TRACK_SIZE);
        add(myParticipant);

        myParticipant.setText("Participant: ");
        add(myTimerLabel);
    }

    /**
     * This formats a positive integer into minutes, seconds, and milliseconds. 00:00:000
     * 
     * @param theTime the time to be formatted
     * @return the formated string.
     */
    public static String formatTime(final long theTime) {
        long time = theTime;
        final long milliseconds = time % MILLIS_PER_SEC;
        time /= MILLIS_PER_SEC;
        final long seconds = time % SEC_PER_MIN;
        time /= SEC_PER_MIN;
        final long min = time % MIN_PER_HOUR;
        time /= MIN_PER_HOUR;
        return TWO_DIGIT_FORMAT.format(min) + SEPARATOR + TWO_DIGIT_FORMAT.format(seconds)
               + SEPARATOR + THREE_DIGIT_FORMAT.format(milliseconds);
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if (PROPERTY_TIME.equals(theEvent.getPropertyName())) {
            myTimerLabel.setText(formatTime((Integer) theEvent.getNewValue()));
            // System.out.println(theEvent.getNewValue());

        }
    }

}
