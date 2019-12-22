/*
 * TCSS 305
 * Assignment 3 - roadrage
 */
package model;

import java.util.Map;

/**
 * Vehicle child class - ATV.
 * @author minhphan
 * @version October 26, 2018
 *
 */
public class Atv extends AbstractVehicle {
    
    /**
     * The vehicle's death time.
     */
    private static final int DEATH_TIME = 25;

    /**
     * Constructor of the ATV class.
     * @param theX The x coordinate of this ATV.
     * @param theY The y coordinate of this ATV.
     * @param theDir The direction of this ATV.
     */
    public Atv(final int theX, final int theY, final Direction theDir) {
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
        
        if (theTerrain != Terrain.WALL) {
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
        
        Direction randAtv = Direction.random();
        
        while (theNeighbors.get(randAtv) == Terrain.WALL
                            || randAtv == getDirection().reverse()) {
            randAtv = Direction.random();
        }
          
        return randAtv;
    }
}
