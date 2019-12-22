/*
 * TCSS 305
 * Assignment 3 - roadrage
 */
package model;

import java.util.Map;


/**
 * Vehicle child class - Car.
 * @author minhphan
 * @version October 26, 2018
 *
 */
public class Car extends AbstractVehicle {
    
    /**
     * The vehicle's death time.
     */
    private static final int DEATH_TIME = 15;

    /**
     * Constructor of the Car class.
     * @param theX The x coordinate of this car.
     * @param theY The y coordinate of this car.
     * @param theDir The direction of this car.
     */
    public Car(final int theX, final int theY, final Direction theDir) {
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
        } else if (theTerrain == Terrain.CROSSWALK && theLight == Light.GREEN) {
            canPass = true;
        } else if (theTerrain == Terrain.LIGHT && theLight != Light.RED) {
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
        
        Direction carDir = getDirection();
        
        if (theNeighbors.get(carDir) == Terrain.STREET
                        || theNeighbors.get(carDir) == Terrain.LIGHT
                        || theNeighbors.get(carDir) == Terrain.CROSSWALK) {
            carDir = getDirection();

        } else if (theNeighbors.get(carDir.left()) == Terrain.STREET
                        || theNeighbors.get(carDir.left()) == Terrain.LIGHT
                        || theNeighbors.get(carDir.left()) == Terrain.CROSSWALK) {
            carDir = getDirection().left();
        
        
        } else if (theNeighbors.get(carDir.right()) == Terrain.STREET
                        || theNeighbors.get(carDir.right()) == Terrain.LIGHT
                        || theNeighbors.get(carDir.right()) == Terrain.CROSSWALK) {
            carDir = getDirection().right();
        
        } else {
            carDir = carDir.reverse();
        }
        return carDir;     
    }

}
