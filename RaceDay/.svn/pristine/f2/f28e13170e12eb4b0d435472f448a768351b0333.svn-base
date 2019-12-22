
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Child class store Line Crossing Message.
 * @author minhphan
 * @version Fall 2018
 *
 */
public class LeaderboardMessge extends AbstractMessage {
    
    /**
     * List of racer Leaderboard.
     */
    private List<Integer> myBoard = new ArrayList<Integer>();
    /** Time Stamp. */
    private int myTimeStamp;
    
    /**
     * Constructor with parameter.
     * @param theTimeStamp time stamp.
     * @param theList list of leaderboard.
     */
    public LeaderboardMessge(final int theTimeStamp, final List<Integer> theList) {
        super(theTimeStamp);
        
        myTimeStamp = theTimeStamp;
        myBoard = theList;

    }
    
    /**
     * Get leaderboard method.
     * @return list of racer in leaderboard.
     */
    public List<Integer> getBoard() {
        return myBoard;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Integer s : myBoard) {
            sb.append(":");
            sb.append(s);

        }
        return "$L:" + myTimeStamp + sb.toString();
        
    }
    

}
