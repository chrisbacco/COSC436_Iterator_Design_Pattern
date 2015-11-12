

package IteratorDesignPattern;


import java.util.Iterator;

public class HeartHealthyIterator implements Iterator<Node>{
    
    private Node current;
    private int indexValue;
    
    public HeartHealthyIterator(Node head)
    {
           current = head;
    } 
    
    public Node next()
    {   
        while(this.hasNext())
        {   
            if(this.getItem().getHeartHealthy() == true)
                return current = current.getNext();
            else
            {
                current = current.getNext();
            }
        }
        return null;
    }

    public boolean hasNext()
    {
        return !(current.getNext() == null);
    }
    
    public MenuItem getItem()
    {
        return current.getNext().getInfo();
    }   

}
