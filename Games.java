/*
 * Name:        James Horton
 * Date:        12/11/2018
 * Assignment:  Final Project
 * File:        Games.java
 */
package froggy.s.book.and.game.store;
/**
 *
 * @author jh0375800
 */
public class Games extends Product
{
    
    protected String rating;
    
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
       
    // do i need methods for working with these items??
    // maybe a print book item and price
    
    // need a constructor to create this object
    public Games(String code, String name,String desc, double prc, String rtng)
        {
            super(code, name, desc, prc);
            this.rating = rtng;
        } // end of full constructor
    

    
} // end of class Games
