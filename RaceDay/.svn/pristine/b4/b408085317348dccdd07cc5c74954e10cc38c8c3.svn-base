
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Store Racer Information class.
 * @author minhphan
 * @version Fall 2019.
 *
 */
public class RaceInformation {
    /** Track Name. */
    private static String myTrackName;

    /** Track Geometry. */
    private static String myTrackGeometry;

    /** Total time of the track. */
    private static int myTotalTime;

    /** Distance for one lap. */
    private static int myOneDistance;

    /**
     * Default Constructor.
     */
    public RaceInformation() {
        //this(myTrackName, myTrackGeometry, myTotalTime, myOneDistance);
    }

    /**
     * Constructor with parameters.
     * @param theTrackName Track name.
     * @param theTrackGeometry Track Geometry.
     * @param theTotalTime Total time.
     * @param theOneDistance Distance one lap.
     */
    public RaceInformation(final String theTrackName, 
                           final String theTrackGeometry, 
                           final int theTotalTime,
                           final int theOneDistance) {

        myTrackName = theTrackName;
        myTrackGeometry = theTrackGeometry;
        myTotalTime = theTotalTime;
        myOneDistance = theOneDistance;
        

    }

    /** 
     * Get Track name.
     * @return Track name.
     */
    public String getTrackName() {
        return myTrackName;
    }

    /** 
     * Get Track name.
     * @return Track name.
     */
    public String getTrackGeometry() {
        return myTrackGeometry;
    }

    /** 
     * Get Track name.
     * @return Track name.
     */
    public int getTotalTime() {
        return myTotalTime;
    }
    
    /** 
     * Get Track name.
     * @return Track name.
     */
    public int getOneDistance() {
        return myOneDistance;
    }

    /** 
     * Get Track name.
     * @return Track name.
     */
    public String getTimeString() {
        final long time = myTotalTime;

        return (new SimpleDateFormat("mm:ss:SSS")).format(new Date(time));
    }
}
