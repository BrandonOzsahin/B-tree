import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.*;

/**
   Linked List class with recursive methods. 
*/

class RLinkedList
{
    /**
       The Node class will store a list element
       and a reference to the next node.
    */
    
    private class Node
    {
        String value;   
		  Node next;      
        
        /**
           Constructor.            
           @param val The element to store in the node.
           @param n The reference to the successor node.
        */
        
        Node(String val, Node n)
        {
            value = val;
            next = n;
        } 
        
        /**
           Constructor. 
           @param val The element to be stored in the node.
        */
        
        Node(String val)
        {
           // Just call the other (sister) constructor
           this(val, null);            
        }
    }
    
    private Node first;   // List head   
    
    /**
       Constructor.
    */
    
    public RLinkedList()
    {
        first = null;           
    }
    
    /**
       The isEmpty method checks to see if the list is empty.
       @return true if list is empty, false otherwise.
    */
    
    public boolean isEmpty()
    {        
        return first == null;
    }
    
    /**
       The size method returns the length of the list.
       @return The number of elements in the list.
    */
    
    public int size()
    {       
       return size(first);       
    }
    
    /**
       This size method recursively computes the
       length of a linked list passed to it.
       @param The linked listl
       @return The number of items in the linked list.
    */
    
    private int size(Node list)
    {
       if (list == null)   
           return 0;
       else 
           return size(list.next) + 1;        
    }
     
    /**
       The add method adds an element to the end of the list.
       @param e The value to add to the end of the list.       
    */
    
    public void add(String e)
    {
       // Replace first with result of adding e to first 
       first = add(e, first);
    }
    
    /**
       This recursive private add method adds
       an element e to the end of a list.
       @param e The element to add to the list.
       @param list The list to add e to.
       @return The list resulting from adding e to its end.
    */
    
    private Node add(String e, Node list)
    {
       if (list == null)
       {
           // Base case
           return new Node(e);
       }
       else
       {
           // Add e to the end of the tail and use
           // the result to replace the tail
           list.next = add(e, list.next);
           return list;
       }        
    }
    
    /**
       The add method adds an element e at place index
       in this linked list.
       @param index The place in the list to add an element.
       @param e The element to add this the linked list.
		 @exception IndexOutOfBoundsException When index is 
                  out of bounds.  
    */
    
    public void add(int index, String e)
    {
       // Replace first with the result of adding
       // e at index in first
       first = add(index, e, first);        
    }    
    
    /**
       This add method adds an element at an index in a list.
       @param e The element to add to the list.
       @param index The index at which to add the element.
       @param list The list to add e to.
       @return The list resulting from adding e.
       @exception IndexOutOfBoundsException When index is 
                  out of bounds.  
    */
    
    private Node add(int index, String e, Node list)
    {
        if (index < 0  || index > size()) 
        {
             String message = String.valueOf(index);
             throw new IndexOutOfBoundsException(message);
        }         
        if (index == 0)        
             return new Node(e, list);        
        
        // 0 < index and index <= size so list is not empty
        // Replace the tail with result of adding e at index - 1
        // in the tail
        list.next = add(index-1, e, list.next);        
        return list;     
    }
    
    /**
       The toString method computes the string
       representation of the list.
       @return The string representation of the linked list.
    */
    
    public String toString()
    {
      StringBuilder strBuilder = new StringBuilder();
      
      // Use p to walk down the linked list
      Node p = first;
      while (p != null)
      {
         strBuilder.append(p.value + "\n"); 
         p = p.next;
      }      
      return strBuilder.toString(); 
    } 
    
    /**
       The RemovalResult class describes the results of
       removing a node from a linked list.
    */
    
    private class RemovalResult
    {
       Node node;     // The node removed from the list
       Node list;     // The list remaining after the removal
       RemovalResult(Node remNode, Node remList)
       {
         node = remNode;
         list = remList;
       }
    }     
    
    /**
       The remove method removes the element at an index.
       @param index The index of the element to remove. 
       @return The element removed.  
		 @exception IndexOutOfBoundsException When index is 
                  out of bounds.     
    */
    
    public String remove(int index)
    {    
       // Pass the job on to the recursive version
       RemovalResult  remRes = remove(index, first);     
       String element = remRes.node.value;  // Element to return
       first = remRes.list;                 // Remaining list
       return element;      
    }  
    
    /**
       The private remove method recursively removes 
       the node at the given index from a list.
       @param index The position of the node to remove.
       @param list The list from which to remove a node.
       @return The result of removing the node from the list.
       @exception IndexOutOfBoundsException When index is 
                  out of bounds.  
    */
    private RemovalResult remove(int index, Node list)
    {
       if (index < 0 || index >= size())
       {  
           String message = String.valueOf(index);
           throw new IndexOutOfBoundsException(message);
       }
       
       if (index == 0)
       {
           // Remove the first node on list
           RemovalResult remRes;
           remRes = new RemovalResult(list, list.next);
           list.next = null;
           return remRes;           
       }  
       
       // Recursively remove the element at index-1 in the tail
       RemovalResult remRes;
       remRes = remove(index-1, list.next);
       
       // Replace the tail with the results and return
       // after modifying the list part of RemovalResult
       list.next = remRes.list;    
       remRes.list = list;
       return remRes;
    }
    
    /**
       The remove method removes a given 
       element from linked list.
    */
    
    public boolean remove(String e)
    {
       RemovalResult remRes;
       remRes = remove(e, first);
       
       // Replace the list by the results of the removal
       first = remRes.list;   
       if (remRes.node != null)
          return true;
       else 
          return false;
    }
    
    /**
       The remove method recursively removes a 
       node containing a given element from 
       a specified list.
       @param element The element to remove.
       @param list The list to remove from.
       @return the list containing
    */
    
    private RemovalResult remove(String e, Node list)
    {
        if (list == null)
            return new RemovalResult(null, null);
            
        
        // Is the first node on list the target of the removal?
        if (list.value.equals(e)) 
        {
            RemovalResult remRes;
            remRes = new RemovalResult(list, list.next);
            list.next = null;
            return remRes;            
        }
        
        // Node to be removed is after the first node on list
        // Recursively remove it from the tail
        RemovalResult remRes;
        remRes = remove(e, list.next);
       
        list.next = remRes.list;
        remRes.list = list;
        return remRes;          
    }    
    
    public static void main(String [] args)
    {
        RLinkedList ll = new RLinkedList();
        ll.add("Amy");
        ll.add("Bob");
        ll.add(0, "Al");
        ll.add(2, "424343");
        ll.add(4, "Carol");
        System.out.println("The members of the list are:");
        System.out.print(ll);
    }
}

