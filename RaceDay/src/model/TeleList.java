
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Participants myTeleList class.
 * 
 * @author minhphan
 * @version 2019
 *
 */
public class TeleList {
    /** List of participants. */
    private List<TelementryMessge> myTeleList;
    /** List of participants. */
    private List<Integer> myRaceIDList;
    /** List of participants. */
    private List<Double> myDistanceList;


    /**
     * Default constructor.
     */
    public TeleList() {
        
        myTeleList = new ArrayList<>();
        
        myRaceIDList = new ArrayList<>();
        
        myDistanceList = new ArrayList<>();

    }
    
    /**
     * Add new Racers.
     * @param theRacer .
     */
    public void add(final TelementryMessge theRacer) {
        myTeleList.add(theRacer);
        myRaceIDList.add(theRacer.getRaceID());
        myDistanceList.add(theRacer.getDistance());
    }
    /**
     * List of participants. 
     * @return tele list.
     */
    public List<TelementryMessge> getTeleList() {
        return myTeleList;
    }
    /**
     * List of participants. 
     * @return tele list.
     */
    public List<Integer> getTeleRaceIDList() {
        return myRaceIDList;
    }
    /**
     * List of participants. 
     * @return tele list.
     */
    public List<Double> getTeleDistanceList() {
        return myDistanceList;
    }
    
    
    
}



