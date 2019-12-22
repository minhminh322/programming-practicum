
package view;

import static model.PropertyChangeEnabledRaceControls.PROPERTY_MAP;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_TIME;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import model.Race;
import model.RaceInformation;
import track.VisibleRaceTrack;

/**
 * Race Track class.
 * 
 * @author minhphan
 * @version Fall 2018.
 *
 */
public class RaceTrack extends JPanel implements PropertyChangeListener {
    /**
     * 
     */
    private static final long serialVersionUID = 5547916873682403421L;
    /** Track width. */
    private static final int TRACK_WIDTH = 500;
    /** Track height. */
    private static final int TRACK_HEIGHT = 400;
    /** Track width. */
    private static final int REC_X = 10;
    /** Track height. */
    private static final int REC_Y = 20;
    /** The size of the Race Track Panel. */
    private static final Dimension TRACK_SIZE = new Dimension(500, 400);
    /** The size of the Leaderboard. */
    private static final Dimension LEADERBOARD_SIZE = new Dimension(170, 50);
    /** The size of the Leaderboard. */
    private static final Dimension PAINT_SIZE = new Dimension(700, 450);
    /** Border size. */
    private static final Border BORDER_SIZE = BorderFactory.createEmptyBorder(5, 10, 5, 5);
    /** The x and y location of the Track. */
    private static final int OFF_SET = 40;
    /** The stroke width in pixels. */
    private static final int STROKE_WIDTH = 25;
    /** The size of participants moving around the track. */
    private static final int OVAL_SIZE = 20;
    /** The separator for formatted. */
    private static final String SEPARATOR = ":";
    /** The separator for formatted. */
    private static final String SPACE = "                                              ";
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

    /** The visible track. */
    private VisibleRaceTrack myTrack;
    /** Rectangle shape. */
    private Shape myRectangle;
    /** List of racer. */
    private List<RacerShape> myRacerList;
    /** RacerList object. */
    private RacerList myList;
    /** Race object. */
    private Race myRace;
    /** RacerShape object. */
    @SuppressWarnings("unused")
    private RacerShape myRacers;
    /** Race information object. */
    private RaceInformation myRaceInfo = new RaceInformation();
    /** JPanel status. */
    private JPanel myStatus;
    /** JLabel participants. */
    private JLabel myParticipant;
    /** JLabel timer. */
    private JLabel myTimerLabel;
    /** JPanel leaderboard. */
    private JPanel myLeader;
    /** JPanel button. */
    private JButton myButton;

    /**
     * Constructor.
     * 
     */
    public RaceTrack() {
        super();
        setPreferredSize(TRACK_SIZE);
        setLayout(new BorderLayout());
        myRace = new Race();
        myList = new RacerList();
        myRacerList = new ArrayList<>();
        myRacerList = myList.getList();

        raceTrack();
        raceLeaderboard();
        raceStatus();

    }

    /** Race Track. */
    private void raceTrack() {
        final JLabel trackLabel = new JLabel("Race Track");
        trackLabel.setBorder(BORDER_SIZE);
        add(trackLabel, BorderLayout.NORTH);
    }

    /** Race leaderboard. */
    private void raceLeaderboard() {
        myLeader = new JPanel();
        myLeader.setPreferredSize(LEADERBOARD_SIZE);
        add(myLeader, BorderLayout.LINE_END);
    }

    /** Race Status. */
    private void raceStatus() {
        myStatus = new JPanel();
        myTimerLabel = new JLabel(formatTime(0));
        myParticipant = new JLabel();
        myStatus.add(myParticipant);
        myParticipant.setText("Participant: " + SPACE + SPACE + SPACE);
        myStatus.add(myTimerLabel);

        add(myStatus, BorderLayout.SOUTH);
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
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;

        // for better graphics display
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(Color.BLUE);
        myRectangle = new Rectangle2D.Double(REC_X, REC_Y, TRACK_WIDTH, TRACK_HEIGHT);
        g2d.draw(myRectangle);

        if (myTrack != null) {
            g2d.setPaint(Color.DARK_GRAY);
            g2d.setStroke(new BasicStroke(STROKE_WIDTH));
            g2d.draw(myTrack);
        }

        for (final RacerShape b : myRacerList) {
            g2d.setPaint(b.getColor());
            g2d.setStroke(new BasicStroke(1));
            g2d.fill(b.getRacerShape());
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return PAINT_SIZE;
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if (PROPERTY_TIME.equals(theEvent.getPropertyName())) {
            myTimerLabel.setText(formatTime((Integer) theEvent.getNewValue()));
            // final int time = (Integer) theEvent.getNewValue();
//            for (final RacerShape b : myRacerList) {
//                final Point2D update =
//                                myTrack.getPointAtDistance(1);
//                if (myRace.getRacerID().equals(b.getRacerID())) {
//                    b.getRacerShape().setFrame(update.getX() - OVAL_SIZE / 2,
//                                               update.getY() - OVAL_SIZE / 2, OVAL_SIZE,
//                                               OVAL_SIZE);
//                }
//
//            }
//            repaint();
        }

        if (PROPERTY_MAP.equals(theEvent.getPropertyName())) {

            myRace = (Race) theEvent.getNewValue();

            final int width = (int) TRACK_SIZE.getWidth() - (OFF_SET * 2);
            final int height = ((int) TRACK_SIZE.getWidth() - 2 * OFF_SET) / 5 * 2;
            final int x = OFF_SET;
            final int y = (int) TRACK_SIZE.getHeight() / 2 - height / 2;
            myTrack = new VisibleRaceTrack(x, y, width, height, myRaceInfo.getOneDistance());

            for (int i = 0; i < myRace.getRacerID().size(); i++) {
                final Point2D current =
                                myTrack.getPointAtDistance(myRace.getDistance().get(i));
                final RacerShape racer =
                                new RacerShape(new Ellipse2D.Double(current.getX()
                                                                    - OVAL_SIZE / 2,
                                                                    current.getY() - OVAL_SIZE
                                                                                     / 2,
                                                                    OVAL_SIZE, OVAL_SIZE),
                                               myRace.getRacerID().get(i),
                                               new Color((int) (Math.random() * 0x1000000)));

                myList.add(racer);
            }
            repaint();

            for (int i = 0; i < myRace.getRacerID().size(); i++) {
                myButton = new JButton(myRace.getRacerID().get(i) + ": "
                                       + myRace.getRacerName().get(i));
                myLeader.add(myButton);
                myButton.setBackground(Color.PINK);
                myButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            }
            revalidate();

        }
    }

}