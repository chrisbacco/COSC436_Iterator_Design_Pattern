
package IteratorDesignPattern;

import java.util.Iterator;


public class Menu {
      
    //item node count
    public MenuItem item;
    public Node head;
    public int count;
    
    public Menu()
    {
        head = new Node(null);
        count = 0;
            
    }
    
    public void add(String name, int type, boolean hh, int price)
    {
        item = new MenuItem(name, type, hh, price);
        Node temp = new Node (item);
        Node current = head;
        
        while (current.getNext()!= null)
        {
            current = current.getNext();
        }
        current.setNext(temp);
        count++;
    }
    
    public void delete(Node temp, Node delete)
    {
        delete = delete.getNext();
        temp.setNext(delete);
    }
    
    public Iterator getMenuIterator()
    {
        return new MenuIterator(head);
    }
    
    public Iterator getTypeIterator(int itemType)
    {
        return new TypeIterator(head, itemType);
    }
    
    public Iterator getHeartHealthyIterator()
    {
        return new HeartHealthyIterator(head);
    }
    
    public Iterator getPriceIterator(int price)
    {
        return new PriceIterator(head, price);    
    }

    public int getCount()
    {
        return count;
    }
    
    public void printMenu() //temp
    {
        Node current = head;       
        while (current.getNext()!= null)
        {   
            current = current.getNext();
            System.out.println(current.getInfo().toString());
        }
    }
    

                
   
}
