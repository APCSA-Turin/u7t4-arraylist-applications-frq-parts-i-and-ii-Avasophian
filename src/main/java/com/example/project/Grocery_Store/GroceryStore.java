package com.example.project.Grocery_Store;


import java.util.ArrayList;
import java.util.Arrays;

import com.example.project.Airport.Airport;
import com.example.project.Airport.Flight;
public class GroceryStore {
    /** An array of products normally stocked at the grocery store
     *  Guaranteed not to be null and to contain only non-null entries
     */
    private Product[] productsStocked;

    public GroceryStore(Product[] initialInventory) {
        productsStocked = initialInventory;
    }

    /** Returns an ArrayList of indices for Product elements in the
     *  productsStocked array that need to be reordered, as described in part (a)
     *  Precondition: min > 0 */
    public ArrayList<Integer> getReorderList(int min) 
    {
      ArrayList<Integer> reorderList = new ArrayList<Integer>();
      boolean neededReordering = false;
      for (int i = 0; i < productsStocked.length; i++)
      {
            if (productsStocked[i].getQuantity() <= min)
            {
                neededReordering = true;
                reorderList.add(i);
            }
      }

      if (neededReordering == false)
      {
        return new ArrayList<Integer>();
      }
      else
      {
        return reorderList;
      }
    }

    public static Product[] initialList;


    public static void setupProductArray() {
        Product p0 = new Product("cereal", 5);
        Product p1 = new Product("milk", 10);
        Product p2 = new Product("bread", 1);
        Product p3 = new Product("frozen pizza", 4);
        Product p4 = new Product("ice cream", 0);
        Product p5 = new Product("spaghetti", 6);
        Product p6 = new Product("muffins", 0);
        Product p7 = new Product("apples", 3);

        initialList = new Product[]{p0, p1, p2, p3, p4, p5, p6, p7};
    }
     public static void main(String[] args) 
    {
        setupProductArray();
        GroceryStore store = new GroceryStore(initialList);

     }

    /** Returns true if all products named in shoppingList are available for purchase
     *  and returns false otherwise, as described in part (b)
     *  Precondition: The products named in shoppingList are found exactly once
     *  in the productsStocked array.
     */
    public boolean checkAvailability(ArrayList<String> shoppingList) 
    {
        String available = "";
        for (Product product : productsStocked)
        {
          if (product.getQuantity() >= 1)
          {
            available += product.getName();
          }
        }

        for (String item : shoppingList)
        {
          if (available.indexOf(item) == -1)
          {
            return false;
          }
        }
        return true;
    }
}