
package model;

/**
 * Store Racer Participants class.
 * 
 * @author minhphan
 * @version Fall 2019.
 *
 */
public class RaceParticipants {
    /** The separator for formatted. */
    public static final String SEPARATOR = ": ";
    /** Racer myRaceName. */
    private String myRaceName;

    /** Race ID. */
    private int myRaceID;

    /** Race start distance. */
    private double myDistance;


    /**
     * Constructor with parameters.
     * 
     * @param theRaceID race id.
     * @param theRaceName race myRaceName.
     * @param theDistance race start distance.
     */
    public RaceParticipants(final int theRaceID, final String theRaceName,
                            final double theDistance) {

        myRaceID = theRaceID;
        myRaceName = theRaceName;
        myDistance = theDistance;

        // System.out.println(myDistance);

    }

    /**
     * Get raceName.
     * 
     * @return race myRaceName.
     */
    public String getRaceName() {
        return myRaceName;
    }

    /**
     * get raceID.
     * 
     * @return race id.
     */
    public int getRaceID() {
        return myRaceID;
    }

    /**
     * get starting distance.
     * 
     * @return starting distance.
     */
    public double getStartDistance() {
        return myDistance;
    }
    
    

    @Override
    public String toString() {
        return myRaceID + SEPARATOR + myRaceName + SEPARATOR + myDistance;

    }

}
