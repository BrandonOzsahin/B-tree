import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.*;
import java.*;
/**
 * Write a description of class Main here.
 * 311 assignment #1 with help of TA
 * Brandon Ozsahin
 * @version (a version number or a date)
 */
public class Main

{
    public static boolean search(Node n, int k) // start recursion ** doesnt recurse**
    {
        if(n instanceof LeafNode)  // n grabs values from LeafNode collection
        {
            Collection<Integer> values =  ((LeafNode) n).getValues(); //  n gets  collection<Integer>

            for(int i: values) // comprehension to find values in leaf
            {
                if(k == i) // if the value is found it will return true if found in LEafNode
                {
                    return true; 
                }
            }

        }
        else // it will be a root node
        {
           if(k <= ((RootNode) n).getMax() && k >= ((RootNode) n).getMin())
           {
              
                Collection<Node> nodes = ((RootNode) n).getNodes(); // n gets collection<Nodes>
                for(Node o: nodes) // searches all possible RootNOdes
                {
                    search(o,k);  // calls the function and o replaces n and k is the sane and returns 
                    return true; // returns if number is within said rootnode.
                }
               
            }
          
        } // doesnt recurse**
        return false; // end of recursion goes back to main returns either true or false
    }
    
    public static void main(String [] args)
    {
        Collection<Node> nodes = new ArrayList<>(); // creates array list of Nodes for root node
        Collection<Integer> values = new ArrayList<>(); // creates array list of Integer objects for leaf
        RootNode node = new RootNode(9,12,nodes); // assigns value to rootnode for each node since theyre INITIALLY empty at first
        LeafNode child = new LeafNode(values); // adds leaf node (which is first in recusion to be built) with values 
        child.add(12);
        child.add(11);
        child.add(10);
        child.add(9);
        node.add(child);
        
        Collection<Node> nodes2 = new ArrayList<>();
        RootNode node2 = new RootNode(5,8,nodes2);
        Collection<Integer> values2 = new ArrayList<>();
        LeafNode child2 = new LeafNode(values2);
        child2.add(8);
        child2.add(7);
        child2.add(6);
        child2.add(5);
        node2.add(child2);
        
        Collection<Node> nodes3 = new ArrayList<>();
        RootNode node3 = new RootNode(1,4,nodes3);
        Collection<Integer> values3 = new ArrayList<>();
        LeafNode child3 = new LeafNode(values3);
        child3.add(4);
        child3.add(3);
        child3.add(2);
        child3.add(1);
        node3.add(child3);
        
        System.out.println(search(node3,9));
        System.out.println(search(node,12));
        System.out.println(search(node2,5));
        //System.out.println(nodes);
        //System.out.println(node2);
    }
    
}