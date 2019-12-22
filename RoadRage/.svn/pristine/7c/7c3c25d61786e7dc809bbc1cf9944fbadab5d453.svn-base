/*
 * TCSS 305
 * Assignment 3 - roadrage
 */
package model;

/**
 * Vehicle parent class.
 * @author minhphan
 * @version October 26, 2018
 *
 */

public abstract class AbstractVehicle implements Vehicle {
  
   /**
    * Vehicle object's x-coordinate.
    */
    private int myX;
    
    /**
     * Vehicle object's y-coordinate.
     */
    private int myY;
    
    /**
     * Vehicle object's direction.
     */
    private Direction myDir;
    
    /**
     * the time (How many moves) that each vehicle should lie dead.
     */
    private int myDeathTime;
    
    /**
     * Vehicle object's initial x-coordinate.
     */
    private final int myInitialX;
    
    /**
     * Vehicle object's initial y-coordinate.
     */
    private final int myInitialY;
    
    /**
     * Vehicle object's initial direction.
     */
    private final Direction myInitialDir;
    
    /**
     * the time (How many moves left) that each vehicle should revise after.
     */
    private int myDeathTimeRevise;
    
    /**
     * check if Vehicle is alive.
     */
    private boolean myLiveVehicle;
    
    /**
     * the String vehicle name.
     */
    private final String myVehicleName = getClass().getSimpleName().toLowerCase();
    
    /**
     * constructor that initializes the instance fields.
     * @param theX the x-coordinate of vehicle.
     * @param theY the y-coordinate of vehicle.
     * @param theDir the direction of vehicle.
     * @param theDeathTime number of moves vehicle stays dead.
     */
    protected AbstractVehicle(final int theX, final int theY, 
                              final Direction theDir, final int theDeathTime) {
        
        myX = theX;
        myY = theY;
        myDir = theDir;
        myDeathTime = theDeathTime;
        
        myInitialX = theX;
        myInitialY = theY;
        myInitialDir = theDir;
        myDeathTimeRevise = 0;
        
        myLiveVehicle = true;
        
    }


    
    /**
     * Called when the vehicle collides with other vehicle.
     */
    @Override
    public void collide(final Vehicle theOther) {
        if (this.isAlive() && theOther.isAlive()
                        && this.myDeathTime > theOther.getDeathTime()) {
            myLiveVehicle = false;
        }
        
    }

    /**
     * Return the number of moves vehicle stays dead.
     */
    @Override
    public int getDeathTime() {
        return myDeathTime;
    }

    /**
     * Return the file name of the image for vehicle alive and dead.
     */
    @Override
    public String getImageFileName() {
        final StringBuilder builder = new StringBuilder(128); 
        if (isAlive()) {
            builder.append(myVehicleName);
            builder.append(".gif");
        } else {
            builder.append(myVehicleName);
            builder.append("_dead.gif");
        }
        
        return builder.toString();
    }

    /**
     * return the current direction.
     */
    @Override
    public Direction getDirection() {
        return myDir;
    }

    /**
     * return the current x-coordinate.
     */
    @Override
    public int getX() {
        return myX;
    }

    /**
     * return the current y-coordinate.
     */
    @Override
    public int getY() {
        return myY;
    }

    /**
     * check if vehicle object is alive.
     */
    @Override
    public boolean isAlive() {
        return myLiveVehicle;
    }

    /**
     * Track how long the vehicle is dead, and when they revise
     * it has random direction.
     */
    @Override
    public void poke() {
        if (!myLiveVehicle) {
            myDeathTimeRevise++;
            if (myDeathTimeRevise == myDeathTime) {
                myLiveVehicle = true;
                myDeathTimeRevise = 0;
            }     
       
        } 
        myDir = Direction.random();
    }

    /**
     * Reset vehicle to their initial positions and direction.
     */
    @Override
    public void reset() {
        myX = myInitialX;
        myY = myInitialY;
        myDir = myInitialDir;
        myDeathTimeRevise = myDeathTime;
    }

    /**
     * Set vehicle direction.
     */
    @Override
    public void setDirection(final Direction theDir) {
        myDir = theDir;
    }

    /**
     * Set vehicle x-coordinate.
     */
    @Override
    public void setX(final int theX) {
        myX = theX;
    }

    /**
     * Set vehicle y-coordinate.
     */
    @Override
    public void setY(final int theY) {
        myY = theY;
    }
     
    /**
     * The String representation the name of vehicle when debug.
     */
    @Override
    public String toString() {
       
        return myVehicleName;
        
    }

}
