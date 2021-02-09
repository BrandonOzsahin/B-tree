import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.*;
/**
 * Write a description of class LeafNode here.
 * assignment 1 with help of ta
 * @author Brandon Ozsahin
 * @version (a version number or a date)
 */
public class LeafNode extends Node
{
    Collection<Integer> values; // creates a collection of ints derived form the name Integer to signify object based ints
     public LeafNode(Collection<Integer> values)
     {
       this.values = values; // calls to the class into the function
        
     }
      
      public void add(int a)
      {
          values.add(a);
        }
        
                
       public String toString()
       {
           
        return "" + values;

      }
        
      public  Collection<Integer> getValues()
      {
          return values;
        }
}
