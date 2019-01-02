/*
 * Name:        James Horton
 * Date:        12/11/2018
 * Assignment:  Final Project
 * File:        Customer.java
 */
package froggy.s.book.and.game.store;
import java.util.ArrayList;
/**
 *
 * @author jh0375800
 */
public class Customer 
{
    private String name;
    ArrayList<CartItem> cartItem;
    
    // need constructor
    
    public Customer(String name)
    {
        this.name = name;
    } // end of one arg constructer
    
    public Customer(CartItem next)
    {
        this.cartItem.add(next);
    } // end of add to cart
    
    public Customer (String name, ArrayList cart)
    {
        this.name = name;
        this.cartItem = cart;
    } // end of full arg constructor
    
        // this method will generate the tax
    public double GetTax(double txRate, double sub)
    {
            // tax equals subtotal sent in times the tax rate sent in
        double tax;
        tax = txRate * sub;
        return tax;     // this returns the amount of tax
    } // end of GetTax
    
        // this method will generate the total bill
    public double TotalDue(double tx, double sub)
    {
        double total = tx + sub;
        return total;   // returns the total invoice due
    } // end of TotalDue
    
    // need a display
    public void ShowThanks()
    {
        System.out.println("********************************************************");
        System.out.println("Thanks you " + name + " for your purchase at Froggy's Book and Game Store");
        System.out.println("********************************************************");
        System.out.println("");
        System.out.println("QTY \t\tItem\t\t\tPrice\t\t\tTotal");
        System.out.println("");
    } // end of display customer
    
} // end of class Customer
