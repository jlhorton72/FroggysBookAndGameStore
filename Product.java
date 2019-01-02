/*
 * Name:        James Horton
 * Date:        12/11/2018
 * Assignment:  Final Project
 * File:        Product.java
 */
package froggy.s.book.and.game.store;
/**
 *
 * @author jh0375800
 */
public class Product 
{
    private String itemCode;
    private String itemName;
    private String desc;
    private double price;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public Product(String itCd, String itN, String desc, double prc)
    {
        this.itemCode = itCd;
        this.itemName = itN;
        this.desc = desc;
        this.price = prc;
    } // end of full arg constructor
    
    public void displayItem()
    {
        System.out.println("\t" + itemCode + " " + itemName);
    } // end of display item
    
} // end of class Product
