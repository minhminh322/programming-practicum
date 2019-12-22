/*
 * TCSS 305 - Assignment 5: RaceDay
 */

package model;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Represents an Race object.
 * 
 * @author minhphan
 * @version Fall 2018
 *
 */
public final class Race implements PropertyChangeEnabledRaceControls {

    /** The default starting time. */
    public static final int DEFAULT_START_TIME = 0;
    /** The separator for formatted. */
    public static final String SEPARATOR = ":";
    /** An error myMessage for illegal arguments. */
    private static final String ERROR_MESSAGE = "Time may not be less than 0.";
    /** Scanner variable. */
    private static Scanner scanner;

    /** Stores this objects time. */
    private int myTime;

    /**
     * Manager for Property Change Listeners.
     */
    private final PropertyChangeSupport myPcs;

    /** Scanner variable. */
    private Scanner myInput;
    /** List of Information. */
    private List<RaceInformation> myInformation;
    /** List of myRacer. */
    private ParticipantsList myRacerList;
    /** Map list. */
    private Map<Integer, List<Message>> myMapList;
    /** List of myMessage. */
    private List<Message> myMessage;
    /** TelementryMessage object. */
    private TelementryMessge myTele;
    /** RaceParticipants object. */
    private RaceParticipants myRacer;
    /** Leaderboard object. */
    private LeaderboardMessge myLeader;
    
    

    /**
     * Construct race object with a start time of 0.
     */
    public Race() {
        this(DEFAULT_START_TIME);
    }

    /**
     * Construct a race object with a specific start time.
     * 
     * @param theStartTime the start time for this object
     * @throws IllegalArgumentException if theStartTime is < 0
     */
    public Race(final int theStartTime) {
        super();

        if (theStartTime < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);

        }
        myPcs = new PropertyChangeSupport(this);

        myTime = theStartTime;

        myInformation = new ArrayList<RaceInformation>();
        myRacerList = new ParticipantsList();
        
//        myTeleList = new TeleList();
        
      //  rceList = new ArrayList<Map<Integer, List<Message>>>();

        myMapList = new HashMap<Integer, List<Message>>();
        
        
        

    }

    @Override
    public void advance() {
        advance(1);
    }

    @Override
    public void advance(final int theMillisecond) {
        changeTime(myTime + theMillisecond);
        
        

    }

    @Override
    public void moveTo(final int theMillisecond) {
        if (theMillisecond < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        changeTime(theMillisecond);

    }

    /**
     * Helper method to change the value of time and notify observers. Functional
     * decomposition.
     * 
     * @param theMillisecond the time to change to
     */
    public void changeTime(final int theMillisecond) {
        final int old = myTime;
        myTime = theMillisecond;
        myPcs.firePropertyChange(PROPERTY_TIME, old, myTime);

    }

    @Override
    public void toggleParticipant(final int theParticpantID, final boolean theToggle) {
        // TODO Auto-generated method stub

    }

    @SuppressWarnings({ "resource", "unused" })
    @Override
    public void loadRace(final File theRaceFile) throws IOException {
     
        final FileReader reader = new FileReader(theRaceFile);
        myInput = new Scanner(reader).useDelimiter(SEPARATOR);
        String[] tokens;
        tokens = myInput.nextLine().split(SEPARATOR);
        final String raceName = tokens[1];
        tokens = myInput.nextLine().split(SEPARATOR);
        final String trackGeometry = tokens[1];
        tokens = myInput.nextLine().split(SEPARATOR);
        final int width = Integer.valueOf(tokens[1]);
        tokens = myInput.nextLine().split(SEPARATOR);
        final int height = Integer.valueOf(tokens[1]);
        tokens = myInput.nextLine().split(SEPARATOR);
        final int distanceOneLap = Integer.valueOf(tokens[1]);
        tokens = myInput.nextLine().split(SEPARATOR);
        final int timeTotal = Integer.valueOf(tokens[1]);
        tokens = myInput.nextLine().split(SEPARATOR);
        final int participant = Integer.valueOf(tokens[1]);

        myInformation.add(new RaceInformation(raceName, trackGeometry, timeTotal,
                                            distanceOneLap));

        for (int lineCount = 0; lineCount < participant; lineCount++) {
            final String temp = myInput.nextLine();
            final int raceId =
                            Integer.valueOf(temp.split(SEPARATOR)[0].replaceAll("[^0-9]", ""));
            final String name = temp.split(SEPARATOR)[1];
            final double starts = Double.valueOf(temp.split(SEPARATOR)[2]);
            myRacer = new RaceParticipants(raceId, name, starts);
            myRacerList.add(myRacer);
        }

        while (myInput.hasNextLine()) {
            myMessage = new ArrayList<Message>();
            final String line = myInput.nextLine();
            scanner = extracted(line);
            final Scanner split = scanner.useDelimiter(SEPARATOR);

            final String messageType = split.next();
            final int timeStamp = split.nextInt();

            if (messageType.charAt(1) == 'T') {
                final int raceId = split.nextInt();
                final double distance = split.nextDouble();
                final int lap = split.nextInt();
                myTele = new TelementryMessge(timeStamp, raceId, distance, lap);
                myMessage.add(myTele);               
                myMapList.computeIfAbsent(timeStamp, k -> new ArrayList<>()).add(myTele);
                
            } else if (messageType.charAt(1) == 'C') {
                final int raceId = split.nextInt();
                final int newLap = split.nextInt();
                final boolean isFinish = split.nextBoolean();
                final LineCrossingMessge lineMess =
                                new LineCrossingMessge(timeStamp, raceId, newLap, isFinish);
                myMessage.add(lineMess);
                myMapList.computeIfAbsent(timeStamp, k -> new ArrayList<>()).add(lineMess);
            } else if (messageType.charAt(1) == 'L') {
                final List<Integer> lbList = new ArrayList<Integer>();
                for (int i = 2; i < participant + 2; i++) {
                    lbList.add(Integer.valueOf(line.split(SEPARATOR)[i]));
                }
                myLeader = new LeaderboardMessge(timeStamp, lbList);
                myMessage.add(myLeader);
                myMapList.computeIfAbsent(timeStamp, k -> new ArrayList<>()).add(myLeader);

            }

        } 
  
    }

    /**
     * Get the hashmap.
     * @return myMapList.
     */
    public Map<Integer, List<Message>> getMap() {
        return myMapList;
    }
    /**
     * Get the RacerName.
     * @return myRacer names.
     */
    public List<String> getRacerName() {
        return myRacerList.getNameList();
    }
    /**
     * Get the RacerID.
     * @return myRacer ID.
     */
    public List<Integer> getRacerID() {
        return myRacerList.getRaceIDList();
    }
    /**
     * Get the RacerDistance.
     * @return myRacer distance.
     */
    public List<Double> getDistance() {
        return myRacerList.getDistanceList();
    }
    /**
     * Get the participant list.
     * @return list of participants.
     */
    public ParticipantsList getRacerList() {     
        return myRacerList;
    }
//    
//    public List<Message> getMessage() {
//        return myMessage;
//    }
//    
//    public List<TelementryMessge> getTeleList() {
//        return myTeleList.getTeleList();
//    }
//    
//    public List<Integer> getTeleID() {
//        return myTeleList.getTeleRaceIDList();
//    }
//    
//    public List<Double> getTeleDistance() {
//        return myTeleList.getTeleDistanceList();
//    }

    /**
     * Extracted scanner method.
     * 
     * @param theLine line.
     * @return new line.
     */
    private static Scanner extracted(final String theLine) {
        return new Scanner(theLine);
    }

    @Override
    public void addPropertyChangeListener(final PropertyChangeListener theListener) {
        myPcs.addPropertyChangeListener(theListener);
    }

    @Override
    public void addPropertyChangeListener(final String thePropertyName,
                                          final PropertyChangeListener theListener) {
        myPcs.addPropertyChangeListener(thePropertyName, theListener);

    }

    @Override
    public void removePropertyChangeListener(final PropertyChangeListener theListener) {
        myPcs.removePropertyChangeListener(theListener);

    }

    @Override
    public void removePropertyChangeListener(final String thePropertyName,
                                             final PropertyChangeListener theListener) {
        myPcs.removePropertyChangeListener(thePropertyName, theListener);

    }

}
