
package IteratorDesignPattern;
import java.util.Iterator;

public class MenuIterator implements Iterator<Node>{
    
    private Node here;
    private int indexValue = 0;
    
    public MenuIterator(Node head)
    {
           here = head;
    }
    
    public Node next()
    { 
        return here = here.getNext();    
    }

    public MenuItem getItem()
    {
        return here.getInfo();
    }
    
    public boolean hasNext()
    {
        return !(here.getNext() == null);
    }








}