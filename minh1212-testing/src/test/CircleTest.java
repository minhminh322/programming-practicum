/*
 * 
 */
package test;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;
import org.junit.Before;
import org.junit.Test;
import shapes.Circle;

/**
 * Tests of the Circle class.
 * 
 * @author minhphan
 * @version October 5, 2018
 */

public class CircleTest {
    
    

    /** A tolerance used when comparing double values for equality. */
    private static final double TOLERANCE = .000001;
    
    /** A Circle to use in the tests. */
    private Circle myCircle;
    /** A Circle to use in the tests. */
    private Circle myCircleTest;


    /**
     * A method to initialize the test fixture before each test.
     */
    @Before
    public void setUp() {
        myCircle = new Circle(1.0, new Point(0, 0), Color.BLACK);
        myCircleTest = new Circle(50.0, new Point(1, 100), Color.GREEN);
    }

    /**
     * Test method for {@link shapes.Circle#Circle(double, java.awt.Point, java.awt.Color)}.
     */
    @Test
    public void testCircleDoublePointColor() {
        
        assertEquals("Test radius value", 50.0, myCircleTest.getRadius(), TOLERANCE);
        
        assertEquals("Test center point", new Point(1, 100), myCircleTest.getCenter());
        
        assertEquals("Test color", Color.GREEN, myCircleTest.getColor());


    }  
    
    /**
     * Test method for {@link shapes.Circle#Circle()}.
     */
    @Test
    public void testCircle() {
        assertEquals(1.0, myCircle.getRadius(), TOLERANCE);
        
        assertEquals(new Point(0, 0), myCircle.getCenter());
        
        assertEquals(Color.BLACK, myCircle.getColor());
        
    }
    
    /**
     * Test method for {@link shapes.Circle#Circle()}.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCircleIAE() {
        new Circle(-4, new Point(0, 0), Color.black); 
    }
    
    /**
     * Test method for {@link shapes.Circle#setRadius(double)}.
     */
    @Test
    public void testSetRadius() {
        myCircle.setRadius(5.0);       
        assertEquals("setRadius failed", 5.0, myCircle.getRadius(), TOLERANCE);
        
        myCircle.setRadius(95.5);       
        assertEquals("setRadius failed", 95.5, myCircle.getRadius(), TOLERANCE);
        
    }
    /**
     * Test method for Radius when the value is zero.
     * IllegalArgumentException.
     */   
    @Test(expected = IllegalArgumentException.class)
    public void testRadiusZeroIAE() {
        myCircle.setRadius(0.0);    
    } 
    /**
     * Test method for Radius when the value is negative.
     * Throw IllegalArgumentException.
     */   
    @Test(expected = IllegalArgumentException.class)
    public void testRadiusNegativeIAE() {
        myCircle.setRadius(-50.0);    
    }
    /**
     * Test method for Radius when the value is positive.
     * Not Throw IllegalArgumentException.
     */   
    @Test
    public void testRadiusPositeIAE() {
        myCircle.setRadius(50.0);    
    }
    

    /**
     * Test method for {@link shapes.Circle#setCenter(java.awt.Point)}.
     */
    @Test
    public void testSetCenter() {

        myCircle.setCenter(new Point(-26, 74));  
        assertEquals("setCenter failed", new Point(-26, 74), myCircle.getCenter());

    }
    /**
     * Test method for Center(Point) when the parameter is null}.
     */
    @Test(expected = NullPointerException.class)
    public void testCenterNPE() {
        myCircle.setCenter(null);
    }

    /**
     * Test method for {@link shapes.Circle#setColor(java.awt.Color)}.
     */
    @Test
    public void testSetColor() {
        myCircle.setColor(Color.BLUE);      
        assertEquals("setColor failed", Color.BLUE , myCircle.getColor());
        
        myCircle.setColor(Color.GRAY);      
        assertEquals("setColor failed", Color.GRAY , myCircle.getColor());
    }
    /**
     * Test method for Color when the parameter is null}.
     */
    @Test(expected = NullPointerException.class)
    public void testColorNPE() {
        myCircle.setColor(null);
    }

    /**
     * Test method for {@link shapes.Circle#getRadius()}.
     */
    @Test
    public void testGetRadius() {
        assertEquals(1.0, myCircle.getRadius(), TOLERANCE);
    }

    /**
     * Test method for {@link shapes.Circle#getCenter()}.
     */
    @Test
    public void testGetCenter() {
        assertEquals(new Point(0, 0), myCircle.getCenter());
    }

    /**
     * Test method for {@link shapes.Circle#getColor()}.
     */
    @Test
    public void testGetColor() {
        assertEquals(Color.BLACK, myCircle.getColor());
    }

    /**
     * Test method for {@link shapes.Circle#calculateDiameter()}.
     */
    @Test
    public void testCalculateDiameter() {
        
        final Circle c1 = new Circle();
        c1.setRadius(5);
        assertEquals("testCalculateDiameter() failed", 
                     10.0, c1.calculateDiameter(), TOLERANCE);
    }

    /**
     * Test method for {@link shapes.Circle#calculateCircumference()}.
     */
    @Test
    public void testCalculateCircumference() {
        
        final Circle c1 = new Circle();
        c1.setRadius(5);
        assertEquals("testCalculateCircumference() failed", 
                     Math.PI * 2 * 5, 
                     c1.calculateCircumference(), TOLERANCE);
        
    }

    /**
     * Test method for {@link shapes.Circle#calculateArea()}.
     */
    @Test
    public void testCalculateArea() {
        
        final Circle c1 = new Circle();
        c1.setRadius(5);
        assertEquals("testCalculateArea() failed", 
                     Math.PI * Math.pow(5, 2), 
                     c1.calculateArea(), TOLERANCE);
               
    }

    /**
     * Test method for {@link shapes.Circle#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("toString() produced an unexpected result!", 
                     "Circle [radius=1.00, center=java.awt.Point"
                     + "[x=0,y=0], color=java.awt.Color"
                     + "[r=0,g=0,b=0]]", myCircle.toString());
    }

}
