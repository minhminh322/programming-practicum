/*
 * TCSS 305
 * 
 * Item.java
 */
package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

/**
 * An Item object stores information about an individual item.
 * 
 * @author minhphan
 * @version October 12, 2018
 */



public final class Item {
    
    // class constants

    /**
     * A default Bulk Quantity to use when no other value is specified .
     */
    private static final int DEFAULT_BULKQUANTITY = 0;
    
    /**
     * A default Bulk Price to use when no other value is specified .
     */
    private static final BigDecimal DEFAULT_BULKPRICE = BigDecimal.ZERO;
    
    /** A tolerance used when comparing double values for equality. */
    private static final double TOLERANCE = .000001;
    
    // instance fields

    /**
     * The Name of this Item.
     */
    private final String myName;
    
    /**
     * The Price of this Item.
     */
    private final BigDecimal myPrice;
    
    /**
     * The Bulk Quantity of this Item.
     */
    private final int myBulkquantity;
    
    /**
     * The Bulk Price of this Item.
     */
    private final BigDecimal myBulkprice;


    // constructors


    /**
     * Constructs a DEFAULT value for Item.
     * 
     * @param theName name assign to this Item
     * @param thePrice price assign to this Item
     */
    public Item(final String theName, final BigDecimal thePrice) {
        this(theName, thePrice, DEFAULT_BULKQUANTITY, DEFAULT_BULKPRICE);

    }

    /**
     * Constructs a Item with String Name, BigDecimal Price, Integer Bulk Quantity,
     * and BigDecimal Bulk Price.
     * 
     * <p>Precondition: The parameters must not violate the class invariant.
     * That is, thePrice and theBulkPrice must be BigDecimal type
     *      AND theBulkQuantity must be an integer that greater than 0.
     *      AND Name must not be null</p>
     * @param theName name assign to this Item
     * @param thePrice price assign to this Item
     * @param theBulkQuantity bulk quantity assign to this Item
     * @param theBulkPrice bulk price assign to this Item
     */
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuantity,
                final BigDecimal theBulkPrice) {
        
        myName = Objects.requireNonNull(theName);
             
        if (thePrice.signum() < 0) {
            throw new IllegalArgumentException("The price must be a positive value!");
        }
        myPrice = thePrice;
        
        if (theBulkQuantity < 0) {
            throw new IllegalArgumentException("The Bulk Quanitity must be a positive value!");
        }
        myBulkquantity = theBulkQuantity;
        
        if (theBulkPrice.signum() < 0) {
            throw new IllegalArgumentException("The Bulk price must be a positive value!");
        }
        myBulkprice = theBulkPrice;
        

    }

    // instance methods
    
    /**
     * Returns the price of this Item.
     * 
     * @return the price of this Item.
     */
    public BigDecimal getPrice() {
        
        return myPrice;
    }
    
    /**
     * Returns the Bulk Quantity of this Item.
     * 
     * @return the Bulk Quantity of this Item.
     */
    public int getBulkQuantity() {
        
        return myBulkquantity;
    }
    
    /**
     * Returns the Bulk Price of this Item.
     * 
     * @return the Bulk Price of this Item.
     */
    public BigDecimal getBulkPrice() {
        
        return myBulkprice;
    }

    /**
     * Check if the Item is bulk or not.
     * 
     * @return true if the Item is bulk,
     */
    public boolean isBulk() {
        boolean bulkValue = true;
        if (myBulkprice.signum() < TOLERANCE) {
            bulkValue = false;
        } 
           
        return bulkValue;
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * The String representation of the Item will be formatted as the assignment.
     * 
     */
    @Override
    public String toString() {
        final NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        
        final StringBuilder builder = new StringBuilder(128);      
        builder.append(myName);
        builder.append(", ");
        builder.append(nf.format(getPrice()));
        if (isBulk()) {
            builder.append(String.format(" (%d for %s)", getBulkQuantity(),
                                     nf.format(getBulkPrice())));
        }
        return builder.toString();
    }

    /**
     * {@inheritDoc}
     * 
     * This method compares theName, thePrice, theBulkquantity, theBulkprice
     * to determine the equality of Item objects. All three fields must be equal 
     * for 2 Item objects to be considered equal.
     */
    @Override
    public boolean equals(final Object theOther) {
        
        boolean returnValue = false;
        
        if (this == theOther) {
            returnValue = true;
        } else if (theOther != null && this.getClass() == theOther.getClass()) {
            final Item otherItem = (Item) theOther;
            returnValue = Objects.equals(myName, otherItem.myName)
                            && myPrice.compareTo(otherItem.myPrice) < TOLERANCE
                            && Integer.compare(myBulkquantity, otherItem.myBulkquantity) == 0
                            && myBulkprice.compareTo(otherItem.myBulkprice) < TOLERANCE;     
        }

        
        return returnValue;
    }

    /**
     * This method generate number from objects.
     */
    @Override
    public int hashCode() {
        
        return Objects.hash(myName, myPrice, myBulkquantity, myBulkprice);
    }

}
