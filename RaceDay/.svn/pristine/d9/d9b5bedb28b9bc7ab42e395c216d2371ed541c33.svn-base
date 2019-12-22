
package model;

/**
 * Child class store Line Crossing Message.
 * 
 * @author minhphan
 * @version Fall 2018
 *
 */
public class TelementryMessge extends AbstractMessage {
    /** separator string. */
    private static final String SEPARATOR = ":";
    
    /** race id variable. */
    private int myRaceID;

    /** distance variable. */
    private double myDistance;

    /** lap variable. */
    private int myLap;

    /** time stamp. */
    private int myTimeStamp;

    /**
     * Constructor with parameters.
     * 
     * @param theTimeStamp time stamp.
     * @param theRaceID race id.
     * @param theDistance distance.
     * @param theLap lap.
     */
    public TelementryMessge(final int theTimeStamp, final int theRaceID,
                            final double theDistance, final int theLap) {
        super(theTimeStamp);
        myTimeStamp = theTimeStamp;
        myRaceID = theRaceID;
        myDistance = theDistance;
        myLap = theLap;

    }

    /**
     * get the race id method.
     * 
     * @return race id.
     */
    public int getRaceID() {
        return myRaceID;
    }

    /**
     * get the distance method.
     * 
     * @return distance.
     */
    public double getDistance() {
        return myDistance;
    }

    /**
     * get the lap method.
     * 
     * @return lap.
     */
    public int getLap() {
        return myLap;
    }

    @Override
    public String toString() {

        return "$T:" + myTimeStamp + SEPARATOR 
                        + myRaceID + SEPARATOR 
                        + myDistance + SEPARATOR + myLap;

    }
    
    

}
