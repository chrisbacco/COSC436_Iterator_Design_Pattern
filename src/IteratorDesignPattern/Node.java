

package IteratorDesignPattern;


public class Node {
    
    Node next;
    MenuItem info;
    
    public Node(MenuItem info)
    {
        this.info = info;
        this.next = null;
    }
    
    
    
    public MenuItem getInfo()
    {
        return this.info;
    }
    
    
    
    public Node getNext()
    {
        return this.next;
    }
    
    
    
    public void setNext(Node next)
    {
        this.next = next;
    }
    
    
}
