
package IteratorDesignPattern;
import java.util.Iterator;

public class PriceIterator implements Iterator<Node>{
    
    private Node here;
    private int price;
    
    //Price iterator -- show items BELOW a value
    
    
    public PriceIterator(Node head, int price)
    {       
           this.price = price;
           here = head;
    } 
    
    
    
    public Node next()
    {   
        while(this.hasNext())
        {   
            
            
            //Great than a certain value -- testing//
            /* if(this.getItem().getPrice() >= this.price) 
             return here = here.getNext();
             else
             {
                here = here.getNext();
             }
          }
        return null;
        */    
            
            
            if(this.getItem().getPrice() <= this.price)
                return here = here.getNext();
            else
            {
                here = here.getNext();
            }
        }
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


