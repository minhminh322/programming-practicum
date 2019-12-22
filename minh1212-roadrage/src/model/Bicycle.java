/*
 * TCSS 305
 * Assignment 3 - roadrage
 */
package model;

import java.util.Map;

/**
 * Vehicle child class - Bicycle.
 * @author minhphan
 * @version October 26, 2018
 *
 */
public class Bicycle extends AbstractVehicle {
    
    /**
     * The vehicle's death time.
     */
    private static final int DEATH_TIME = 35;

    /**
     * Constructor of the Bicycle class.
     * @param theX The x coordinate of this bicycle.
     * @param theY The y coordinate of this bicycle.
     * @param theDir The direction of this bicycle.
     */
    public Bicycle(final int theX, final int theY, final Direction theDir) {
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
        
        if (theTerrain == Terrain.STREET || theTerrain == Terrain.TRAIL) {
            canPass = true;
        } else if ((theTerrain == Terrain.LIGHT && theLight == Light.GREEN)
                        || (theTerrain == Terrain.CROSSWALK && theLight == Light.GREEN)) {
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
        
        
        Direction bicDir = getDirection();
        
        if (theNeighbors.get(bicDir) == Terrain.TRAIL
                        || theNeighbors.get(bicDir.left()) == Terrain.TRAIL
                        || theNeighbors.get(bicDir.right()) == Terrain.TRAIL) {
            
            while (theNeighbors.get(bicDir) != Terrain.TRAIL
                            || bicDir == getDirection().reverse()) {
                bicDir = Direction.random();
                
            }
            
        } else if (canBicycle(theNeighbors.get(bicDir))) {
            bicDir = getDirection();
        } else if (canBicycle(theNeighbors.get(bicDir.left()))) {
            bicDir = bicDir.left();
        } else if (canBicycle(theNeighbors.get(bicDir.right()))) {
            bicDir = bicDir.right();
        } else {
            bicDir = bicDir.reverse();
        }
        return bicDir;
    }


    /**
     * Helper method to check if the Bicycle can ride.
     * @param theTerrain The terrain.
     * @return return the valid value if the terrain is true,
     */
    private boolean canBicycle(final Terrain theTerrain) {
        boolean canBicycle = false;
        
        if (theTerrain == Terrain.STREET || theTerrain == Terrain.LIGHT
                        || theTerrain == Terrain.CROSSWALK) {
            canBicycle = true;
        }
        return canBicycle;
    }
    
}
