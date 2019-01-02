/*
 * Name:        James Horton
 * Date:        12/11/2018
 * Assignment:  Final Project
 * File:        CartItem.java
 */
package froggy.s.book.and.game.store;
/**
 *
 * @author jh0375800
 */
public class CartItem 
{
    // this object should hold the itemPurchased and QTY
    // for each line item.....
    protected int qty;          // how many of this item
    protected String itemName;  // this is which item it was
    protected double itemPrice; // this is each items prices to be used for display on invoice
                                // yes this is doubling the data but was easier to reach for display purposes
    protected double lineTotal; // this is the qty * price 
    
        // ------------ begin getters/setters --------------------
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getItemCode() {
        return itemName;
    }

    public void setItemCode(String itemName) {
        this.itemName = itemName;
    }
        // ------------ end of getters/setters --------------------
    
        // constructor to build each line item
    public CartItem (int qty, String itemName, double price)
    {
        this.qty = qty;
        this.itemName = itemName;
        this.itemPrice = price;
        this.lineTotal = SubTotal(qty, price);
    } // end of full arg constructor
    
        // returns the line subtotal
    public double SubTotal(int qty, double prc)
    {
        double subTotal = qty * prc;
        return subTotal;
    } // end of line subtotal    
   
    public void displayCart()
    {
        System.out.printf("%d\t\t%s\t$ %.2f\t\t\t$ %.2f", qty, itemName, itemPrice, lineTotal);
    } // hopefully this displays correct format
    
    public void showItem()
    {
        System.out.printf("Qty:\t\t %d \n", qty);
        System.out.printf("Item:\t\t %s \n", itemName);
        System.out.println("");
        System.out.printf("Price:\t\t $ %6.2f \n", itemPrice);
        System.out.printf("Subtotal:\t $ %6.2f \n", lineTotal);
    }
    
} // end of class CartItem
