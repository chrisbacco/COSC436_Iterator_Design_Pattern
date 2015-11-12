
package IteratorDesignPattern;


public class MenuItem {
    
    private String name;
    private int type; //1:appetizers 2:main dish 3:desserts
    private boolean hh;
    private int price;
    
    // constructor DONE
    //getters(setters not needed) DONE
    //toString DONE
    
    public MenuItem()
    {
        name = "name";
        type = 0;
        hh = false;
        price = 0;
    }
    
    public MenuItem(String name, int type, boolean heart_healthy, int price)
    {
        this.name = name;
        this.type = type;
        this.hh = heart_healthy;
        this.price = price;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getType()
    {
        return this.type;
    } 
    
    public boolean getHeartHealthy()
    {
        return this.hh;      
    }
    
    public int getPrice()
    {
        return this.price;
    }
    
    public String toString()
    {
        return ("*** Menu Item: " + name + " -- Type: " + type + " -- Heart Healthy: " + hh + " -- Price: $" + price + " ***");
    }







}
