
package model;

/**
 * Child class store Line Crossing Message.
 * @author minhphan
 * @version Fall 2018
 *
 */
public class LineCrossingMessge extends AbstractMessage {

    /** race id variable. */
    private int myRaceID;

    /** new lap variable. */
    private int myNewLap;
    
    /** check finish varialbe. */
    private boolean myIsFinish;

    /**
     * Constructor with parameters.
     * @param theTimeStamp time stamp.
     * @param theRaceID race id.
     * @param theNewLap new lap.
     * @param theIsFinish check finish.
     */
    public LineCrossingMessge(final int theTimeStamp, final int theRaceID, final int theNewLap,
                              final boolean theIsFinish) {
        super(theTimeStamp);

        myNewLap = theNewLap;

        myIsFinish = theIsFinish;

        myRaceID = theRaceID;
    }

    /**
     * get the new lap method.
     * @return new lap.
     */
    public int getNewLap() {
        return myNewLap;
    }

    /**
     * Check finish race.
     * @return true or false finish.
     */
    public boolean isFinish() {
        return myIsFinish;
    }

    /**
     * get the race id.
     * @return race id.
     */
    public int getRaceID() {
        return myRaceID;
    }

}
