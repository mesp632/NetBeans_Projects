/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareiproject;

/**
 *
 * @author Saelin
 */
public abstract class Part {
    protected static int count = 0;
    protected int partID;
    protected String name;
    protected double price;
    protected int inStock;
    protected int min;
    protected int max;
    
    public Part(){
        this.inStock = 0;//start with an amount of 0
        
    }
    
    void setName(String name){
        this.name = name;
    }
    
    String getName(){
        return this.name;
    }
    
    void setPrice(double price){
        this.price = price;        
       
    }
    
    double getPrice(){
        return this.price;
    }
    
    void setInStock(int amount){
        this.inStock += amount; //add amount that is in stock
        
    }
    
    int getInStock(){
        return this.inStock;
    }
    
    void setMin(int minimum){
        this.min = minimum;
    }
    
    int getMin(){
        return this.min;
    }
    
    void setMax(int maximum){
        this.max = maximum;
    }
    
    int getMax(){
        return this.max;
    }
    
    void setPartID(int PartID){
        this.partID = PartID;
    }
    
    int getPartID(){
        return this.partID;
    }

    int autoGenID(){
        return ++count;
    }
    
}


