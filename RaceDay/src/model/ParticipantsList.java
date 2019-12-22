
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Participants myRacerList class.
 * 
 * @author minhphan
 * @version 2019
 *
 */
public class ParticipantsList {
    /** List of participants. */
    private List<RaceParticipants> myRacerList;
    /** List of participants name. */
    private List<String> myNameList;
    /** List of participants race id. */
    private List<Integer> myRaceIDList;
    /** List of participants distance. */
    private List<Double> myDistanceList;


    /**
     * Default constructor.
     */
    public ParticipantsList() {
        
        myRacerList = new ArrayList<>();
        
        myNameList = new ArrayList<>();
        
        myRaceIDList = new ArrayList<>();
        
        myDistanceList = new ArrayList<>();

    }
    
    /**
     * Add new Racers.
     * @param theRacer .
     */
    public void add(final RaceParticipants theRacer) {
        myRacerList.add(theRacer);
        myNameList.add(theRacer.getRaceName());
        myRaceIDList.add(theRacer.getRaceID());
        myDistanceList.add(theRacer.getStartDistance());
//        System.out.println(myRacerList);
    }
    /**
     * Get the name list.
     * @return name list.
     */
    public List<String> getNameList() {
        return myNameList;
    }
    /**
     * Get the race id list.
     * @return race id.
     */
    public List<Integer> getRaceIDList() {
        return myRaceIDList;
    }
    /**
     * Get the distance list.
     * @return distance list.
     */
    public List<Double> getDistanceList() {
        return myDistanceList;
    }
    
    
    
}



