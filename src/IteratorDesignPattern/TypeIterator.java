

package IteratorDesignPattern;
import java.util.Iterator;

public class TypeIterator implements Iterator<Node>{
    
    private Node here;
    private int itemType;
 
    //type iterator -- display each food type 
    public TypeIterator(Node head, int itemType)
    {       
        this.itemType = itemType;
        here = head;
    } 
    
    
    
    
    public Node next()
    {   
        while(this.hasNext())
        {   
            if(this.getItem().getType() == this.itemType)
                return here = here.getNext();
            else
            {
                here = here.getNext();
            }
        }
        //return
        return null;
    }

   
    public boolean hasNext()
    {
        return !(here.getNext() == null);
    }
    
    public MenuItem getItem()
    {
        return here.getNext().getInfo();
    }    
}
