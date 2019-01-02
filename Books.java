/*
 * Name:        James Horton
 * Date:        12/11/2018
 * Assignment:  Final Project
 * File:        Books.java
 */
package froggy.s.book.and.game.store;
/**
 *
 * @author jh0375800
 */
public class Books extends Product
{
    private String author;
    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
        
    // do i need methods for working with these items??
    // maybe a print book item and price
    
    // need a constructor to create this object
    public Books(String code, String name,String desc, double prc, String author)
    {
        super(code, name, desc, prc);
        this.author = author;
    } // end of full constructor
    
    public void display()
    {
        System.out.printf("%s \t%s",getItemCode(), getItemName());
    } // end of display
    
} // end of class Books
