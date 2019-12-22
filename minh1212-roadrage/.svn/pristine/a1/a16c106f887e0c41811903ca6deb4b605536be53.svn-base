/*
 * TCSS 305
 * Assignment 3 - roadrage
 */
package model;

import java.util.Map;

/**
 * Vehicle child class - Human.
 * @author minhphan
 * @version October 26, 2018
 *
 */
public class Human extends AbstractVehicle {

    /**
     * The vehicle's death time.
     */
    private static final int DEATH_TIME = 45;

    /**
     * Constructor of the Human class.
     * @param theX The x coordinate of this human.
     * @param theY The y coordinate of this human.
     * @param theDir The direction of this human.
     */
    public Human(final int theX, final int theY, final Direction theDir) {
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

        if (theTerrain == Terrain.GRASS) {
            canPass = true;
            
        } else if (theTerrain == Terrain.CROSSWALK && theLight != Light.GREEN) {
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

        Direction randHum = Direction.random();

        if (theNeighbors.get(getDirection()) == Terrain.CROSSWALK) {
            randHum = getDirection();

        } else if (theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK) {
            randHum = getDirection().left();
        
        } else if (theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK) {
            randHum = getDirection().right();
        }

        if (theNeighbors.get(getDirection().left()) != Terrain.GRASS
            && theNeighbors.get(getDirection().left()) != Terrain.CROSSWALK
            && theNeighbors.get(getDirection().right()) != Terrain.GRASS
            && theNeighbors.get(getDirection().right()) != Terrain.CROSSWALK
            && theNeighbors.get(getDirection()) != Terrain.GRASS
            && theNeighbors.get(getDirection()) != Terrain.CROSSWALK) {

            randHum = getDirection().reverse();
        
        } else {

            // check random option
            while (theNeighbors.get(randHum) != Terrain.GRASS

                   && theNeighbors.get(randHum) != Terrain.CROSSWALK
                   || randHum == getDirection().reverse()) {
                randHum = Direction.random();
            }
        }

        return randHum;
    }

}
