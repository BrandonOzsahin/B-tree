import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.*;
/**
 * Write a description of class RootNode here.
 * assignment 1 with ta help
 * @author Brandon Ozsahin
 * @version (a version number or a date)
 */
public class RootNode extends Node
{
    private int min; // assigns values min and max from the class to method
    private int max;
    private Collection<Node> nodes; // object collection for nodes
    public RootNode(int min, int max, Collection<Node> nodes)
      {
           this.min = min; // calls and assigns values with the this. functon
           this.max = max;
           this.nodes = nodes;
      }
      
    public void add(Node n)
      {
          nodes.add(n);
        }
        
       public String toString()
       {
           
        return "" + min + " "+ max + " " + nodes;  
        
    }
    
    public Collection<Node> getNodes()
    {
        return nodes;
    }
    
    public int getMin()
    {
        return min;
    }
    
    public int getMax()
    {
        return max;
    }

}