/*
 * TCSS 305
 * Assignment 3 - roadrage
 */
package model;

import java.util.Map;

/**
 * Vehicle child class - Taxi.
 * @author minhphan
 * @version October 26, 2018
 *
 */
public class Taxi extends AbstractVehicle {
    
    /**
     * The vehicle's death time.
     */
    private static final int DEATH_TIME = 15;
    
    /**
     * Count to 3 clock cycle.
     */
    private static final int COUNT_TO_3 = 3;   
    
    /**
     * Initial clock cycle for Taxi's crosswalks stop.
     */
    private int myCount;
    
    /**
     * Constructor of the Taxi class.
     * @param theX The x coordinate of this taxi.
     * @param theY The y coordinate of this taxi.
     * @param theDir The direction of this taxi.
     */
    public Taxi(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, DEATH_TIME);
        // TODO Auto-generated constructor stub
    }

    /**
     * Returns the object move onto the given type of
     * terrain, when the street lights are the given color.
     * 
     * @param theTerrain The terrain.
     * @param theLight The light color.
     * @return the object move onto the given type of
     * terrain, when the street lights are the given color.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean canPass = false;
        
        if (theTerrain == Terrain.STREET) {
            canPass = true;
        } else if (theTerrain == Terrain.CROSSWALK && theLight == Light.RED) {
            myCount++;
            if (myCount == COUNT_TO_3) {
                myCount = 0;
            
                canPass = true;
            }
        } else if (theTerrain == Terrain.LIGHT && theLight != Light.RED) {
            canPass = true;
        } else if (theTerrain == Terrain.CROSSWALK && theLight != Light.RED) {
            canPass = true;
        }
        
        return canPass;
    }

    /**
     * Returns the direction this object would like to move, based on the given
     * map of the neighboring terrain.
     * 
     * @param theNeighbors The map of neighboring terrain.
     * @return The direction this object would like to move.
     */
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        
        
        Direction taxiDir = getDirection();
        
        if (theNeighbors.get(taxiDir) == Terrain.STREET
                        || theNeighbors.get(taxiDir) == Terrain.LIGHT
                        || theNeighbors.get(taxiDir) == Terrain.CROSSWALK) {
            taxiDir = getDirection();
            
       
        
        } else if (theNeighbors.get(taxiDir.left()) == Terrain.STREET
                        || theNeighbors.get(taxiDir.left()) == Terrain.LIGHT
                        || theNeighbors.get(taxiDir.left()) == Terrain.CROSSWALK) {
            taxiDir = getDirection().left();
         
        
        } else if (theNeighbors.get(taxiDir.right()) == Terrain.STREET
                        || theNeighbors.get(taxiDir.right()) == Terrain.LIGHT
                        || theNeighbors.get(taxiDir.right()) == Terrain.CROSSWALK) {
            taxiDir = getDirection().right();
        
        } else {
            taxiDir = taxiDir.reverse();
        }
        return taxiDir;
         
    }
}
