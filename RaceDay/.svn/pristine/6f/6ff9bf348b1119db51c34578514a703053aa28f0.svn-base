
package view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Participants myRacerList class.
 * 
 * @author minhphan
 * @version 2019
 *
 */
public class RacerList {
    /** List of participants. */
    private List<RacerShape> myRacerList;
    /** List of participants shape. */
    private List<java.awt.geom.Ellipse2D> myShapeList;
    /** List of participants race id. */
    private List<Integer> myRaceIDList;
    /** List of participants color. */
    private List<Color> myColorList;


    /**
     * Default constructor.
     */
    public RacerList() {
        
        myRacerList = new ArrayList<>();
        
        myShapeList = new ArrayList<>();
        
        myRaceIDList = new ArrayList<>();
        
        myColorList = new ArrayList<>();

    }
    
    /**
     * Add new Racers.
     * @param theRacer .
     */
    public void add(final RacerShape theRacer) {
        myRacerList.add(theRacer);
        myShapeList.add(theRacer.getRacerShape());
        myRaceIDList.add(theRacer.getRacerID());
        myColorList.add(theRacer.getColor());

    }
    /**
     * Get racer list.
     * @return racer list.
     */
    public List<RacerShape> getList() {
        return myRacerList;
    }
    /**
     * Get shape list.
     * @return shape list.
     */
    public List<java.awt.geom.Ellipse2D> getShapeList() {
        return myShapeList;
    }
    /**
     * Get race id list.
     * @return race id list.
     */
    public List<Integer> getRaceIDList() {
        return myRaceIDList;
    }
    /**
     * Get racer color list.
     * @return color list.
     */
    public List<Color> getColorList() {
        return myColorList;
    }
    
    
    
}



