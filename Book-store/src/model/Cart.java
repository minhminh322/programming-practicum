/*
 * TCSS 305
 * 
 * Cart.java
 */
package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * A Cart object stores information about the customer's overall purchase.
 *  One field must be a collection of some type to hold information about 
 *  all the Items the customer has ordered.
 * 
 * @author minhphan
 * @version October 12, 2018
 */


public class Cart {
    
    // instance fields
    
    /**
     * input items into the myCart from ItemOrder class.
     */
    private ArrayList<ItemOrder> myCart;
    
  
   /**
    * Initialize membership check.
    */
    private boolean myMembership;


    /**
     * Constructs that creates an empty shopping cart.
     */
    public Cart() {
        
        /**
         * Constructor that creates an empty ArrayList to hold elements.
         */
        myCart = new ArrayList<ItemOrder>();

    }
    
    /**
     * Adds an order to the shopping cart, replacing any previous order 
     * for an equivalent item with the new order. (equals() would return 
     * true if used to compare equivalent items) 
     * 
     * @param theOrder get list from ItemOrder.
     */
    public void add(final ItemOrder theOrder) {
        
        if (myCart.isEmpty()) {
            myCart.add(theOrder);
            return; //return if Cart is empty.
        }
        
        myCart_reading:
        for (ItemOrder i: myCart) {
            if (i.getItem().equals(theOrder.getItem())) {
                myCart.remove(i);
                myCart.add(theOrder);
                break myCart_reading;
            }
        }
        myCart.add(theOrder);
        // Adds the given value to end of the ArrayList
         
    }

    /**
     * Sets whether or not the customer for this shopping cart has a store membership.
     * @param theMembership check membership
     */
    public void setMembership(final boolean theMembership) {
        myMembership = theMembership;
        
    }

    /**
     * Returns the total cost of this shopping cart as a BigDecimal. This returned BigDecimal 
     * should have scale of 2 and use the ROUND_HALF_EVEN rounding rule.
     * 
     * @return The total value.
     */
    public BigDecimal calculateTotal() {
        BigDecimal total = new BigDecimal(0.00).setScale(2, RoundingMode.HALF_EVEN);
        
        final Map<Item, Integer> orders = new HashMap<Item, Integer>();
        
        for (ItemOrder i: myCart) {
            orders.put(i.getItem(), i.getQuantity());
        }
       
        final Iterator<Item> a = orders.keySet().iterator();
        while (a.hasNext()) {
            final Item item = a.next();
            final int quantity = orders.get(item);
         

            if (item.isBulk() && myMembership)  {
                final int bulkquantity = orders.get(item) / item.getBulkQuantity();
                final int remainder = orders.get(item) % item.getBulkQuantity();
                total = total.add(item.getBulkPrice().multiply
                                  (BigDecimal.valueOf(bulkquantity)).add
                                  ((BigDecimal.valueOf(remainder)).multiply
                                   (item.getPrice())));
            } else {
         
                total = total.add(item.getPrice().multiply
                         (BigDecimal.valueOf(quantity)));
            }
        }
        
        return total;
    }
    
    /**
     * Remove all orders from the cart.
     */
    public void clear() {
        myCart.clear();
    }

    /**
     * {@inheritDoc}
     * 
     * The String representation of this Cart will be formatted as follows:
     * <br>Cart [Total=(Total value)].
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(128); // default initial size = 16
        builder.append(getClass().getSimpleName()); // the class name without the package name
        builder.append(" [Total=");
        builder.append(calculateTotal());
        builder.append(']');
        return builder.toString();
    }

}
