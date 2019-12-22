
package controller;

import static model.PropertyChangeEnabledRaceControls.PROPERTY_MAP;
import static model.PropertyChangeEnabledRaceControls.PROPERTY_TIME;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import model.Race;
import model.RaceInformation;
import view.RaceTrack;

/**
 * Race Controller class.
 * 
 * @author minhphan
 * @version Fall 2018
 *
 */
public class RaceDayController extends JPanel {

    /**
     * A generated serial version UID for object Serialization.
     * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
     */
    private static final long serialVersionUID = 1L;

    /** The default border size. */
    private static final int BORDER_SIZE = 10;

    /** Amount of milliseconds between each call to the timer. */
    private static final int TIMER_FREQUENCY = 30;

    /** Start text for the restart button. */
    private static final String BUTTON_TEXT_RESTART = "Restart";

    /** Start text for the restart button. */
    private static final String BUTTON_TEXT_CLEAR = "Clear";

    /** Start text for the start button. */
    private static final String BUTTON_TEXT_PLAY = "Play";

    /** Stop text for the pause button. */
    private static final String BUTTON_TEXT_PAUSE = "Pause";

    /** Start text for the time one button. */
    private static final String BUTTON_TEXT_TIMESONE = "Times One";

    /** Start text for the time four button. */
    private static final String BUTTON_TEXT_TIMESFOUR = "Times Four";

    /** Start text for the single race button. */
    private static final String BUTTON_TEXT_SINGLERACE = "Single Race";

    /** Start text for the loop race button. */
    private static final String BUTTON_TEXT_LOOPRACE = "Loop Race";

    /** Start icon for the restart button. */
    private static final String BUTTON_ICON_RESTART = "./images/ic_restart.png";

    /** Start icon for the clear button. */
    private static final String BUTTON_ICON_CLEAR = "./images/ic_clear.png";

    /** Start icon for the play button. */
    private static final String BUTTON_ICON_PLAY = "./images/ic_play.png";

    /** Stop icon for the pause button. */
    private static final String BUTTON_ICON_PAUSE = "./images/ic_pause.png";

    /** Stop icon for the time one button. */
    private static final String BUTTON_ICON_TIMESONE = "./images/ic_one_times.png";

    /** Stop icon for the time four button. */
    private static final String BUTTON_ICON_TIMESFOUR = "./images/ic_four_times.png";

    /** Stop icon for the single race button. */
    private static final String BUTTON_ICON_SINGLERACE = "./images/ic_repeat.png";

    /** Stop icon for the loop race button. */
    private static final String BUTTON_ICON_LOOPRACE = "./images/ic_repeat_color.png";

    /** new line. */
    private static final Integer SLIDER_WIDTH = 465;

    /** new line. */
    private static final Integer SLIDER_HEIGHT = 50;

    /** new line. */
    private static final Integer TAB_WIDTH = 590;

    /** new line. */
    private static final Integer TAB_HEIGHT = 207;

    /** Minor tick. */
    private static final int MINOR_TICK_SPACING = 10000;

    /** Major tick. */
    private static final int MAJOR_TICK_SPACING = 60000;

    /** new line. */
    private static final String NEW_LINE = "\n";

    /** new number. */
    private static final Integer NUM = 3;

    /** Participants String. */
    private static final String RACE_PARTICIPANT = "Race Participants";

    /** Multiple by 1 times. */
    private static final int MULTIPLE_BY_ONE = 1;

    /** Multiple by 4 times. */
    private static final int MULTIPLE_BY_FOUR = 4;
    
    /** Custom icon. */
    private static ImageIcon img = new ImageIcon("./images/raceday.png");
    /** Create a main frame. */
    private static JFrame frame;  
    /** Create Race Track object. */
    private static RaceTrack myRaceTrack;
    /** The time multiplier. */
    private int myMutiplier = 1;
    /** JTabbedPane for 2 tabs. */
    private JTabbedPane myTabs = new JTabbedPane();
    /** Info menu items. */
    private JMenuItem myInfoItem;
    /** Timer for the clock. */
    private final Timer myTimers;
    /** Slider for time. */
    private JSlider mySlider;
    /** TimeRace Object. */
    private RaceTimer myRaceTimer = new RaceTimer();
    /** Race Data Output Stream object. */
    private RaceDOS myRaceDOS  = new RaceDOS();
    /** Race Participants. */
    private RaceRP myRaceRP = new RaceRP();
    /** The Actions for the ToolBar and File Menu. */
    private final List<Action> myActions;
    /** Race Main.  */
    private Race myLoadRace;
    /** Create RaceInformation object. */
    private RaceInformation myRaceInfo = new RaceInformation();
//    /** Create RaceLeaderboard object. */
//    private RaceLeaderboard myRaceLB = new RaceLeaderboard();
//    /** Create RaceStatus object. */
//    private RaceStatus myRaceStatus = new RaceStatus();
    /** JFileChooser object. */
    private final JFileChooser myChooser = new JFileChooser();
    /**The default directory. */  
    private File myFile = new File(".");

    /**
     * Constructs Race Day.
     */
    public RaceDayController() {
        super(new BorderLayout());

        mySlider = new JSlider(SwingConstants.HORIZONTAL, 0, 0, 0);

        myTimers = new Timer(TIMER_FREQUENCY, this::handleTimer);

        myRaceTrack = new RaceTrack();

        myActions = new ArrayList<>();

        myLoadRace = new Race();

        createActions();

        propertyChange();

        setUpComponents();

    }
    /** Method to create action of buttons. */
    private void createActions() {

        final SingleAction restart = new SingleAction(BUTTON_TEXT_RESTART, 
                                                      BUTTON_ICON_RESTART, () -> reset());

        final ToggleAction playpause =
                        new ToggleAction(BUTTON_TEXT_PLAY, BUTTON_TEXT_PAUSE, BUTTON_ICON_PLAY,
                                         BUTTON_ICON_PAUSE, () -> play(), () -> pause());

        final ToggleAction timesmode = new ToggleAction(BUTTON_TEXT_TIMESONE, 
            BUTTON_TEXT_TIMESFOUR, 
            BUTTON_ICON_TIMESONE, 
            BUTTON_ICON_TIMESFOUR, 
            () -> myMutiplier = MULTIPLE_BY_FOUR, 
            () -> myMutiplier = MULTIPLE_BY_ONE);

        final ToggleAction racemode = new ToggleAction(BUTTON_TEXT_SINGLERACE, 
            BUTTON_TEXT_LOOPRACE, 
            BUTTON_ICON_SINGLERACE, 
            BUTTON_ICON_LOOPRACE, 
            () -> isRepeat(), 
            () -> isRepeat());

        final SingleAction clear = new SingleAction(BUTTON_TEXT_CLEAR, 
            BUTTON_ICON_CLEAR, 
            () -> myRaceDOS.setEmpty());

        myActions.add(restart);
        myActions.add(playpause);
        myActions.add(timesmode);
        myActions.add(racemode);
        myActions.add(clear);

    }

    /**
     * Lay out the components.
     */
    public final void setUpComponents() {

        mySlider.setPreferredSize(new Dimension(SLIDER_WIDTH, SLIDER_HEIGHT));
        // mySlider.setEnabled(false);
        mySlider.setMajorTickSpacing(MAJOR_TICK_SPACING);
        mySlider.setMinorTickSpacing(MINOR_TICK_SPACING);
        mySlider.addChangeListener(e -> myLoadRace.moveTo(mySlider.getValue()));

        final JPanel innerPanel = new JPanel(new BorderLayout());

        final JPanel higherPanel = new JPanel();
        higherPanel.add(mySlider);
        higherPanel.add(myRaceTimer);
        innerPanel.add(higherPanel, BorderLayout.NORTH);

        /* Lower Panel for two tabs */
        final JPanel lowerPanel = new JPanel();

        myTabs.add("Data Output Stream", myRaceDOS);
        myTabs.add(RACE_PARTICIPANT, myRaceRP);
        myTabs.setEnabledAt(1, false);
        myTabs.setPreferredSize(new Dimension(TAB_WIDTH, TAB_HEIGHT));

        myTabs.setBorder(BorderFactory.createEmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE,
                                                         BORDER_SIZE));

        lowerPanel.add(myTabs);
        innerPanel.add(lowerPanel, BorderLayout.CENTER);

        /* Set up border layout for main panel */
        add(innerPanel, BorderLayout.CENTER);

        add(createToolBar(), BorderLayout.SOUTH);

    }

    /**
     * Event handler for the timer.
     * 
     * @param theEvent the fired event
     */
    private void handleTimer(final ActionEvent theEvent) {
        myLoadRace.advance(TIMER_FREQUENCY * myMutiplier);
        timeSlider(myMutiplier);

    }

    /**
     * . Helper method for move JSlider
     * 
     * @param theFactor myMutiplier parameter.
     */
    public void timeSlider(final int theFactor) {
        final int value = mySlider.getValue() + TIMER_FREQUENCY * theFactor;
        mySlider.setValue(value);
    }

    /**
     * Build the menu bar for this GUI. This method will need to be called where access to a
     * JFrame occurs. You attach a MenuBar to a Frame, not a Panel.
     * 
     * @param theFrame the containing JFrame of this menu bar
     * @return the menu bar for this GUI
     */
    private JMenuBar createMenu(final JFrame theFrame) {
        final JMenuBar menuBar = new JMenuBar();

        menuBar.add(buildFileMenu(theFrame));
        menuBar.add(buildControlsMenu());
        menuBar.add(buildHelpMenu());

        return menuBar;
    }

    /**
     * Builds a menu with some options.
     * 
     * @param theFrame the containing JFrame of this menu bar
     * @return a "file" menu with some menu items
     */
    private JMenu buildFileMenu(final JFrame theFrame) {
        /* File menu */
        final JMenu menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);

        /* Load Race menu item */
        final JMenuItem loadraceItem = new JMenuItem("Load Race...");
        loadraceItem.setMnemonic(KeyEvent.VK_L);
        loadraceItem.addActionListener(event -> loadingRace());

        /* Exit menu item */
        final JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                theFrame.dispatchEvent(new WindowEvent(theFrame, WindowEvent.WINDOW_CLOSING));
            }
        });

        menu.add(loadraceItem);
        menu.addSeparator();
        menu.add(exitItem);
        return menu;
    }

    /**
     * Load race files and throw exception for Load Race menu.
     */
    public void loadingRace() {
        myChooser.setCurrentDirectory(myFile);
        final int result = myChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            myFile = myChooser.getCurrentDirectory();

            try {
                myLoadRace.loadRace(myChooser.getSelectedFile());

                firePropertyChange(model.PropertyChangeEnabledRaceControls.PROPERTY_MAP, null,
                                   myLoadRace);

                setSliderEnable();
                setSliderValue(myRaceInfo.getTotalTime());
                myTabs.setEnabledAt(1, true);
                myInfoItem.setEnabled(true);
                for (final Action a : myActions) {
                    a.setEnabled(true);

                }

            } catch (final IOException event) {
                final String message = "Error loading file.";

                JOptionPane.showMessageDialog(frame, message, "Error!",
                                              JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Build controls menu.
     * 
     * @return the controls menu.
     */
    private JMenu buildControlsMenu() {
        final JMenu controlsMenu = new JMenu("Controls");
        controlsMenu.setMnemonic(KeyEvent.VK_C);

        for (final Action a : myActions) {
            controlsMenu.add(new JMenuItem(a));
            a.setEnabled(false);

        }

        return controlsMenu;

    }

    /**
     * Build help menu.
     * 
     * @return help menu.
     */
    private JMenu buildHelpMenu() {
        final JMenu helpMenu = new JMenu("Help");

        myInfoItem = new JMenuItem("Race Info...");

        myInfoItem.addActionListener(events -> raceInfo());

        final JMenuItem aboutItem = new JMenuItem("About...");

        aboutItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                final String message =
                                "Minh Phan\n" + "Autumn 2018\n" + "TCSS 305 Assignment 5";
                JOptionPane.showMessageDialog(frame, message, "Personal Information",
                                              JOptionPane.PLAIN_MESSAGE, img);

            }

        });
        myInfoItem.setEnabled(false);
        helpMenu.add(myInfoItem);
        helpMenu.add(aboutItem);

        return helpMenu;

    }

    /**
     * Helper method for Race Information.
     */
    public void raceInfo() {
        final String message = myRaceInfo.getTrackName() + NEW_LINE + "Track type: "
                               + myRaceInfo.getTrackGeometry() + NEW_LINE + "Total time:  "
                               + myRaceInfo.getTimeString() + NEW_LINE + "Lap distance: "
                               + myRaceInfo.getOneDistance();
        JOptionPane.showMessageDialog(frame, message, "Race Information",
                                      JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * A helper method to make a ToolBar.
     * 
     * @return the example Tool Bar
     */
    private JToolBar createToolBar() {
        final JToolBar toolbar = new JToolBar();

        for (final Action a : myActions) {
            final JButton butt = new JButton(a);
            butt.setHideActionText(true);
            toolbar.add(butt);
            a.setEnabled(false);
        }
        return toolbar;
    }
    
    /** Add property change listeners. */
    private void propertyChange() {
        addPropertyChangeListener(PROPERTY_MAP, myRaceDOS);

        addPropertyChangeListener(PROPERTY_MAP, myRaceRP);

      //  addPropertyChangeListener(PROPERTY_MAP, myRaceLB);

        addPropertyChangeListener(PROPERTY_MAP, myRaceTrack);

       // addPropertyChangeListener(PROPERTY_MAP, myRaceStatus);

    //    myLoadRace.addPropertyChangeListener(PROPERTY_TIME, myRaceLB);

        myLoadRace.addPropertyChangeListener(PROPERTY_TIME, myRaceTimer);

        myLoadRace.addPropertyChangeListener(PROPERTY_TIME, myRaceDOS);

        myLoadRace.addPropertyChangeListener(PROPERTY_TIME, myRaceTrack);

     //   myLoadRace.addPropertyChangeListener(PROPERTY_TIME, myRaceStatus);
    }

    /**
     * Helper method for adjust JSlider.
     * 
     * @param theValue setMaximum value.
     */
    public void setSliderValue(final int theValue) {
        mySlider.setMaximum(theValue);
    }

    /** Helper method for adjust JSlider. */
    public void setSliderToZero() {
        mySlider.setValue(0);
    }

    /** Helper method for adjust JSlider. */
    public void setSliderEnable() {
        mySlider.setEnabled(true);
        mySlider.setPaintTicks(true);
    }

    /** Helper method for adjust JSlider. */
    public void setSliderDisable() {
        mySlider.setEnabled(false);
    }

    /** Helper method to play timer. */
    private void play() {
        myTimers.start();
        setSliderDisable();
        myActions.get(2).setEnabled(true);
        myActions.get(NUM).setEnabled(true);

    }

    /** Helper method to pause timer. */
    private void pause() {
        myTimers.stop();
        setSliderEnable();
        myActions.get(2).setEnabled(false);
        myActions.get(NUM).setEnabled(false);

    }

    /** Helper method to reset timer. */
    private void reset() {
        myTimers.stop();
        myLoadRace.moveTo(0);
        setSliderToZero();

    }

    /** Helper method to loop the timer. */
    private void isRepeat() {
        myTimers.setRepeats(true);

    }

    /**
     * Create the GUI and show it. For thread safety, this method should be invoked from the
     * event-dispatching thread.
     */
    public static void createAndShowGUI() {
        // Create and set up the window.
        frame = new JFrame("Race Day!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(img.getImage());

        // Create and set up the content pane.
        final RaceDayController newContentPane = new RaceDayController();
        newContentPane.setOpaque(true); // content panes must be opaque
        frame.setContentPane(newContentPane);
        frame.setJMenuBar(newContentPane.createMenu(frame));

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final JFrame viewFrame = new JFrame("Race Track");
                viewFrame.setContentPane(myRaceTrack);
                viewFrame.pack();
                viewFrame.setVisible(true);
                viewFrame.setResizable(false);
            }
        });

        // Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

}
