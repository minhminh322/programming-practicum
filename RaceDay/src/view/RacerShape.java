package view;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

/**
 * Racer Shape. 
 * @author minhphan
 * @version Fall 2018.
 *
 */
public class RacerShape {
    /** Racer shape. */
    private Ellipse2D myRacerShape;
    /** Racer ID. */
    private int myRacerID;
    /** Racer color. */
    private Color myColor;
    
    /**
     * RacerShape constructor.
     * @param theRacerShape .
     * @param theRacerID .
     * @param theColor .
     */
    public RacerShape(final Ellipse2D theRacerShape, final int theRacerID, final Color theColor
                      ) {
        
        myRacerShape = theRacerShape;
        
        myRacerID = theRacerID;
        
        myColor = theColor;
   
    }
    
    /**
     * Get racer shape.
     * @return shape.
     */
    public Ellipse2D getRacerShape() {
        return myRacerShape;
    }
    /**
     * Get racer id.
     * @return race id.
     */
    public int getRacerID() {
        return myRacerID;
    }
    /**
     * Get racer color.
     * @return color.
     */
    public Color getColor() {
        return myColor;
    }
}
