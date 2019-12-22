/*
 * TCSS 305
 * 
 * ItemOrder.java
 */
package model;

import java.util.Objects;

/**
 * An ItemOrder object stores information about a purchase order for an item: 
 * namely, a reference to the item itself and the quantity desired.
 * 
 * @author minhphan
 * @version October 12, 2018
 */


public final class ItemOrder {
    
    // instance fields

    /**
     * input items from Item class.
     */
    private final Item myItem;
    
    /**
     * The Bulk Quantity of this Item.
     */
    private final int myQuantity;
    

    // constructors

    /**
     * Constructs a ItemOrder with theItem from Item class, and Integer Quantity.
     * 
     * <p>Precondition: The parameters must not violate the class invariant.
     * That is, myQuantity must be an integer that greater than 0.
     *          AND myItem must not be null</p>
     * @param theItem item assign to this ItemOrder
     * @param theQuantity quantity assign to this ItemOrder
     */
    public ItemOrder(final Item theItem, final int theQuantity) {
        
        myItem = (Item) Objects.requireNonNull(theItem);
        
        if (theQuantity < 0) {
            throw new IllegalArgumentException("The Quanitity must be a positive value!");
        }       
        myQuantity = theQuantity;
        

    }

    // instance methods
    
    /**
     * Returns the Item of this ItemOrder.
     * 
     * @return the Item of this ItemOrder.
     */
    public Item getItem() {
        
        return (Item) myItem;
    }
    
    /**
     * Returns the quantity of this ItemOrder.
     * 
     * @return the quantity of this ItemOrder.
     */
    public int getQuantity() {
        
        return myQuantity;
    }

    /**
     * {@inheritDoc}
     * 
     * The String representation of this ItemOrder will be formatted as follows:
     * <br>ItemOrder [Item=(current Item), Quantity=(current Quantity)].
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(128); // default initial size = 16
        builder.append(getClass().getSimpleName()); // the class name without the package name
        builder.append(" [Item=");
        builder.append(myItem);
        builder.append(" [, Quantity=");
        builder.append(myQuantity);
        builder.append(']');
        return builder.toString();
    }

}
