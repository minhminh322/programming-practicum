/*
 * TCSS 305
 * 
 * ItemTest.java
 */

package tests;


import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import model.Item;




/**
 * Test the Item class.
 * 
 * @author minhphan
 * @version October 12, 2018
 */


public class ItemTest {
    
    /** A tolerance used when comparing double values for equality. */
    private static final double TOLERANCE = .000001;
    
    /** Item use in the test. */
    private Item myItemTest;
    
    /** Item 1 use in the test. */
    private Item myItemTest1;
    
    /** Item 2 use in the test. */    
    private Item myItemTest2;

    

    /**
     * A method to initialize the test fixture before each test.
     */
    @Before
    public void setUp() {
        myItemTest = new Item("Uw Note Pad", BigDecimal.valueOf(4.41), 6,  
                            BigDecimal.valueOf(10.04));
        
        myItemTest1 = new Item("Uw Note Pad", BigDecimal.valueOf(4.41));
        
        myItemTest2 = new Item("Java Rules", BigDecimal.valueOf(0.95), 10, 
                            BigDecimal.valueOf(5.00));
        
        
    }


    
    /**
     * Test Item(final String theName, final BigDecimal thePrice) method.
     */
    @Test
    public void testItemStringBigDecimal() {
        
        assertEquals(BigDecimal.valueOf(4.41), myItemTest.getPrice());
        
        assertEquals(6, myItemTest.getBulkQuantity());
        
        assertEquals(BigDecimal.valueOf(10.04), myItemTest.getBulkPrice());
        
        
    }

    /**
     * Test Item(final String theName, final BigDecimal thePrice, final theBulkQuantity,
                final BigDecimal theBulkPrice) method.
     */
    @Test
    public void testItemStringBigDecimalIntBigDecimal() {
        
        assertEquals(BigDecimal.valueOf(0.95), myItemTest2.getPrice());
        
        assertEquals(10, myItemTest2.getBulkQuantity());
        
        assertEquals(BigDecimal.valueOf(5.00), myItemTest2.getBulkPrice());
    }
    
    /** Test when Quantity is negative. */
    @Test (expected = IllegalArgumentException.class)
    public void testItemBulkQuantityIAE() {
        new Item("Java Rules", BigDecimal.valueOf(0.95), -10,  BigDecimal.valueOf(5.00));
 
    }
    
    
    /**
     * Test getPrice() method.
     */
    @Test
    public void testGetPrice() {
        assertEquals(BigDecimal.valueOf(4.41), myItemTest.getPrice());
    }

    /**
     * Test getBulkQuantity() method.
     */
    @Test
    public void testGetBulkQuantity() {
        assertEquals(6, myItemTest.getBulkQuantity());
    }
    
    /**
     * Test getBulkPrice() method.
     */
    @Test
    public void testGetBulkPrice() {
        assertEquals(BigDecimal.valueOf(10.04), myItemTest.getBulkPrice());
    }

    /**
     * Test IsBulk() method.
     */
    @Test
    public void testIsBulk() {
        assertEquals(true, myItemTest.isBulk());
        
        assertEquals(false, myItemTest1.isBulk());
    }
    
    /**
     * Test method for HashCode.
     */
    @Test
    public void testHashCode() {
        assertEquals(myItemTest.hashCode(), myItemTest.hashCode());
    }

}
