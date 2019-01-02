/*
 * Name:        James Horton
 * Date:        12/11/2018
 * Assignment:  Final Project
 * File:        FroggySBookAndGameStore.java
 */

// ******* added .txt files under the nbproject folder private subfolder
package froggy.s.book.and.game.store;

import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
/**
 *
 * @author jh0375800
 */
public class FroggySBookAndGameStore 
{
    /**
     * @param args the command line arguments
     */
    
    public static final double TAXRATE = 0.076;
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        
        String str = ",";       // used to split input from xml
        String name;            // name of buyer
        String choice;          // used for input choice by user
        String lcvMain = "N";   // used as loop control variable for the main 
        String lcv1 = "Y";      // used as loop control variable for inneer loop of what choice
        int sum;                // stores how many of each item
        int idx = 0;
        int counter = 0;
        Scanner sc = new Scanner(System.in);                // used for input streams
        Scanner readBooks = new Scanner("Books.txt");       // used to read in the books
        Scanner readGames = new Scanner("Games.txt");       // used to read in games
        ArrayList<CartItem> cart = new ArrayList<>();       // stores the CartItem into an Arraylist
        ArrayList<Books> book = new ArrayList<Books>();     // stores the books for indexing
        ArrayList<Games> game = new ArrayList<Games>();     // stores the games for indexing   
        List<String> code = new ArrayList<String>();        // stores all items by item code
        List<String> iName = new ArrayList<String>();       // stores all item names 
        List<String> cost = new ArrayList<String>();        // stores all items prices
        double subTotal = 0;    // needed a subtotal variable     
        double total = 0;       // needed a total variable
        double tax = 0;         // need for a tax holder
        
            // **********************************************************************************
            // Need an outer loop control variable for between customers
            // **********************************************************************************
        while (lcvMain == "N")
        {
            // *************************
            // this section displays the welcome and gets customer name
            System.out.println("WELCOME TO FROGGY'S BOOK STORE!");
            System.out.println("What is your name? ");
            name = sc.nextLine();
            PrintWriter pw = new PrintWriter(name + ".txt");        // establish the file for this customer
            pw.print(name + str);
            System.out.println("Here is a list of items we have: ");
            System.out.println("Games Available:");            
            List<String> list = new ArrayList<String>();            // this temporarily stores the input file info
            File file = new File("Games.txt");            
            
            // *************************
            
                // this test for file existing then breaks it into components
            if(file.exists())
            {                
                try 
                { 
                    list = Files.readAllLines(file.toPath(),Charset.defaultCharset());
                }
                catch (IOException ex) 
                {
                    ex.printStackTrace();
                }
                if(list.isEmpty())
                return;
            } // end of if exists
            
            for(String line : list)
            {
                String [] res = line.split(",");
                code.add(res[0]);
                iName.add(res[1]);
                cost.add(res[3]);
                game.add(new Games(res[0], res[1],res[2], Double.parseDouble(res[3]), res[4]));
                counter++;  
            } // end of for loop                 
                // this prints out the info
           for (Games item : game)          // while reading use foreach to build the arraylist of games
           {
               item.displayItem();
           } // end of foreach
           
           // ***********************************
           // this builds the book as the game was above
            System.out.println("Books Availiable: ");
            List<String> list2 = new ArrayList<String>(); 
            File file2 = new File("Books.txt");
            if(file2.exists()){
                try { 
                    list2 = Files.readAllLines(file2.toPath(),Charset.defaultCharset());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
              if(list2.isEmpty())
                  return;
            } // end of if exist
            for(String line : list2)
            {
                String [] res = line.split(",");
                code.add(res[0]);
                iName.add(res[1]);
                cost.add(res[3]);
                book.add(new Books(res[0], res[1],res[2], Double.parseDouble(res[3]), res[4]));
                counter++;  
            } // end of for loop
           for (Books item : book)           // print the item code and item name 
           {
               item.displayItem();
           } // end of foreach
           
           // **********************************
           
                // this is an inner loop to run the which product and how many
                // done with a do while structure
            do
            {
                System.out.println("Which would you like? ");
                choice = sc.nextLine();
                choice = choice.toUpperCase();      // can test the eaqulasIgnoreCae below by removing this
                    // choice needs to compare to both arralyllist to find which list and index
                for (int i = 0; i < code.size(); i++)   // starts a comparison of choice to item codes list to find index
                {    
                    String comp = code.get(i);   
                    boolean check = comp.equalsIgnoreCase(choice);
                    if (check)
                    {
                        idx = i;
                    } // if true do this code
                } // search thru book  
                System.out.printf("You chose %s. How many would you like? ", iName.get(idx));   // choice needs to be changed to the itemname
                //pw.print(iName.get(idx));
                sum = sc.nextInt();     // sets the count of how many
                sc.nextLine();          // clears the return
                CartItem crt = new CartItem(sum, iName.get(idx), Double.parseDouble(cost.get(idx)));        // creates this cartItem                
                cart.add(crt);          // adds this item to the cart
                subTotal = subTotal + crt.lineTotal;    // sets the subtotal
                crt.showItem();         // displays the crt
                pw.print(crt.qty + str);        // adds the qty to the customer file
                pw.print(crt.itemName + str);   // adds the itemname to the customer file
                pw.print(crt.itemPrice + str);  // adds the itemprice to the customer file            
                pw.print(crt.lineTotal + str);  // adds the linetotal to the customer file
                System.out.println("");
                System.out.println("Would you like another item? (Y or N) ");   // resets the loop control variable or not
                lcv1 = sc.nextLine();        // ends loop or sends it back thru  
                lcv1 = lcv1.toUpperCase();
            } while (lcv1.equals("Y"));// end of while for cart add loop
            
            Customer now = new Customer(name, cart);
            now.ShowThanks();       // sets up invoice
            for (CartItem item : cart)
            {
                item.displayCart();
                System.out.println("");
            } // foreach to display the cart items info
            
            tax = now.GetTax(TAXRATE, subTotal);
            total = now.TotalDue(tax, subTotal);
            pw.print(tax + str);
            pw.print(total);
            System.out.printf("\nSub Total:\t$ %6.2f \n", subTotal);
            System.out.printf("Tax: \t\t$ %6.2f \n", tax);
            System.out.printf("Total: \t\t$ %6.2f \n", total);
            System.out.println("");
            System.out.println("********************************************************");
                 
            pw.close();
                 // need to reset all variables at this point
            code.removeAll(code);
            cost.removeAll(cost);
            iName.removeAll(iName);
            book.clear();
            game.clear();

        } // end of outer while loop
        
    } // end of main
    
} // end of class FroggySBookAndGameStore
