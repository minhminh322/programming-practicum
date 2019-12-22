/*
 * TCSS 305
 * Assignment 3 - roadrage
 */
package model;

import java.util.Map;

/**
 * Vehicle child class - Truck.
 * @author minhphan
 * @version October 26, 2018
 *
 */

public class Truck extends AbstractVehicle {
    
    /**
     * The vehicle's death time.
     */
    private static final int DEATH_TIME = 0;
    
    /**
     * Constructor of the Truck class.
     * @param theX The x coordinate of this truck.
     * @param theY The y coordinate of this truck.
     * @param theDir The direction of this truck.
     */
    public Truck(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, DEATH_TIME);
           
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
        
        if (theTerrain == Terrain.STREET || theTerrain == Terrain.LIGHT) {
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
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
    
        Direction randTruck = Direction.random();
       
        // check if Truck need reverse
        if (theNeighbors.get(getDirection().left()) != Terrain.STREET 
                       && theNeighbors.get(getDirection().left()) != Terrain.LIGHT 
                       && theNeighbors.get(getDirection().left()) != Terrain.CROSSWALK
                       && theNeighbors.get(getDirection().right()) != Terrain.STREET 
                       && theNeighbors.get(getDirection().right()) != Terrain.LIGHT 
                       && theNeighbors.get(getDirection().right()) != Terrain.CROSSWALK
                       && theNeighbors.get(getDirection()) != Terrain.STREET 
                       && theNeighbors.get(getDirection()) != Terrain.LIGHT 
                       && theNeighbors.get(getDirection()) != Terrain.CROSSWALK) {
           
            randTruck = getDirection().reverse();
           
        } else {
           
           // check random option until get the valid one.
            while (theNeighbors.get(randTruck) != Terrain.STREET
                           && theNeighbors.get(randTruck) != Terrain.LIGHT
                           && theNeighbors.get(randTruck) != Terrain.CROSSWALK
                           || randTruck == getDirection().reverse()) {
                randTruck = Direction.random();
            }
        }
               
        return randTruck;
             
    }

}
