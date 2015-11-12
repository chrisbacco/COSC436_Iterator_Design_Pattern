package IteratorDesignPattern;
import java.util.Iterator;
import java.util.Scanner;

//Project Break Down
//Iterator Design Pattern 
//Iterators: type, heart healthy, price, all menu items
//price: less than a value 
//type: you can pick which type (1,2 or 3) you want to display
//all menu: displays the contents of the entire menu
//add or remove: you can add or remove and item and its contents
//for add or remove there is case sensitivity 


public class IteratorDesignPattern {

    
    public static void main(String[] args) {
    //Objects for things
        Scanner cin = new Scanner(System.in);
        Menu EatAtJoes = new Menu();
        
    //user input 
        int input;
        int input2;
        
        boolean select = true;
        createMenu(EatAtJoes);
        // menuOptions(); display menuOptions only once -- less text on console for testing puproses
        
        while(select == true)
        {
            System.out.println("\n");
            menuOptions(); //display menuOptions after every selection
            System.out.println("\n *********************************");
            System.out.println("*- Welcome to the EatAtJoe's Menu -*");
            System.out.print("Please Make a Selection From Above: ");
                    input = cin.nextInt(); cin.nextLine(); 
            while (input<1 || input>7)
            {
                System.out.println("Poor choice, try again! ");
                input = cin.nextInt(); cin.nextLine();
            }    

            switch(input) //switch statement for input selection
                    {
                    case 1 : displayMenu(EatAtJoes); //ALL ITEMS
                             break;
                        
                    case 2 : displayHealthyHeartItems(EatAtJoes); //HH
                             break;
                    // rather than having a separate menu selection for each type
                    // use 1 menu selection -> select type -> display based on user input    
                    case 3 : System.out.println("Enter 1: appetizers -- 2: main dish -- 3: desserts");
                             input2 = cin.nextInt(); cin.nextLine(); 
                             while (input<1 || input>3)
                             {
                                System.out.println("That is not a valid option, enter another");
                                input2 = cin.nextInt(); cin.nextLine();
                             }     
                             displayItems(EatAtJoes, input2);//TYPE
                             break;
                        
                    case 4 : System.out.println("Enter price (this only works with integers");
                             input2 = cin.nextInt(); cin.nextLine(); 
                             while (input<1)
                             {
                                System.out.println("Must * > 1");
                                input2 = cin.nextInt(); cin.nextLine();
                             }     
                             displayPriceItems(EatAtJoes, input2);//PRICE
                             break; 
                        
                    case 5 : addItem(EatAtJoes, cin);
                             break;
                        
                    case 6 : deleteItem(EatAtJoes, cin);
                             break; 
                        
                    case 7 : select = false;
                             System.out.println("Thanks for Eating At Joe's!");
                             break;
                    }
        }   
    }
    
    
    public static void createMenu(Menu menu) //menu
    {   
        //Type Options
        //1:appetizers 
        //2:main dish
        //3:desserts
        

        //   ----  apps
        menu.add("Buffalo Bites", 1, true, 4);
        menu.add("Mozzarella Sticks", 1, false, 5);
        menu.add("Bacon Loaded Potato Skins", 1, false, 4);
        menu.add("Chilli Fries", 1, false, 6);
        menu.add("Veggies and Hummus", 1, true, 3);
        menu.add("Pretzels with Beer Cheese", 1, false, 4); 
        
        
        
        
        // ----   main dish
        menu.add("T Bone Steak", 2, false, 16);
        menu.add("Bison Burger", 2, true, 18);
        menu.add("Grilled Shrimp", 2, true, 17);
        menu.add("Crab Cakes", 2, true, 22);
        menu.add("Bean Burger", 2, false, 18);
        
        
        // ----- desserts 3
        menu.add("Chocolate Ice Cream", 3, false, 6);
        menu.add("Connolli", 3, true, 4);
        menu.add("Ice Cream Cake", 3, false, 6);
        menu.add("Cheese Cake", 3, true, 3);
        menu.add("Salted Caramel Cup Cakes", 3, false, 3);      
    }        
    
    public static void displayMenu(Menu menu)
    {
        Node item;
        Iterator itr = menu.getMenuIterator();
        
        System.out.println("\n");
	System.out.println("--- DISPLAY ALL MENU ITEMS --- ");
	
        
        while (itr.hasNext())
            {
		item = (Node)itr.next();
		System.out.println(item.getInfo().toString());
            }
    }

    public static void displayHealthyHeartItems(Menu menu)
    {
        Node item;
        Iterator itr = menu.getHeartHealthyIterator();
        
        System.out.println("\n");
	System.out.println("<3 ALL HEART HEALTHY ITEMS <3");       
        
        
        while (itr.hasNext())
            {
		item = (Node)itr.next();
                if(item != null)
                    System.out.println(item.getInfo().toString());
            }
    }
       
    public static void displayItems(Menu menu, int iType)
    {
        Node item;
        Iterator itr = menu.getTypeIterator(iType);
	
        System.out.println("\n");
        System.out.println("*** MENU BY TYPE");
	
        
        
        while (itr.hasNext())
            {
		item = (Node)itr.next();
                if(item != null)
                    System.out.println(item.getInfo().toString());
            }
    }    
    
    public static void displayPriceItems(Menu menu, int price)
    {
        Node item;
        Iterator itr = menu.getPriceIterator(price);
        
        
        System.out.println("\n");
	System.out.println("*** ITEMS BY PRICE");
	
        
        while (itr.hasNext())
            {
		item = (Node)itr.next();
                if(item != null)
                    System.out.println(item.getInfo().toString());
            }
    }    
    
    
    
    // Menu options: add/remove iterators: hh, price, all and type (conditional based on user input)
    public static void menuOptions()
    {
        System.out.println("1 – Display all menu items");
        System.out.println("2 – Display heart healthy items");   
        System.out.println("3 – Display items by user selected type: appetizers, main dishes and desserts");        
        System.out.println("4 – Display items BELOW a certain price [integer onlly]");
        System.out.println("5 – Add menu item");        
        System.out.println("6 – Remove menu item");       
        System.out.println("7 – To Quit This Menu");            
    }
    
    
    
    
    
    //add item -- 
    public static void addItem(Menu menu, Scanner cin)
    {
        String name; int type; int input; boolean hh; int price;
        System.out.print("Enter the name of the item?");
            name = cin.nextLine();
        System.out.print("What is the items type? Please select from the following: 1:appetizers - 2:main dish - 3:desserts: ");
            type = cin.nextInt(); cin.nextLine();
        System.out.print("Is this a heart healthy item? Enter 1 for true or 2 for false: ");
            input = cin.nextInt(); cin.nextLine();
            if (input == 1)
                hh = true;
            else 
                hh = false;
        System.out.print("What is the items price? (integers only)");
            price = cin.nextInt(); cin.nextLine();
        System.out.println("*** ADDING ITEM:" + name + "***");
        menu.add(name, type, hh, price);    
            
    }
    
    
    
    
    
    
    public static void deleteItem(Menu menu, Scanner cin)
    {
        String name;
        Node item = null;
        Node temp;
        boolean x = false; 
        
        
        //user input stuff
        System.out.print("Which item do you wish to remove? (first leter of each word must be uppercase)");
            name = cin.nextLine();
        //iterate and display the name of deleted item        
        Iterator itr = menu.getMenuIterator();
	System.out.println("*** DELETING ITEM: " + name + "***");
        
        
	while (itr.hasNext() & x == false)
            {   
                //temp item 
                temp = item;
		item = (Node)itr.next();
                
                //if(item.getName().equalsTo(name)) 
                if (item.getInfo().getName().equals(name)) //name comparison
                {                   
                    menu.delete(temp, item);
                    x = true;
                }
            }        
    }
  
}
