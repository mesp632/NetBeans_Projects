/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareiproject;

import java.util.ArrayList;


/**
 *
 * @author Saelin
 */
public class Product{
    protected static int count = 0;
    protected ArrayList<Part> associatedParts = new ArrayList<Part>();
    protected int productID;
    protected String name;
    protected double price;
    protected int inStock;
    protected int min;
    protected int max;
    
    Product(){
        int genID = autoGenID();
        setProductID(genID);
    }
    
    Product(String name, double price, int inStock, int min, int max){
        int genID = autoGenID();
        setProductID(genID);
        this.name = name;
        this.price = price;
        this.inStock = inStock;
        this.min = min;
        this.max = max;
        
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
        this.inStock = amount;
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
    
    void addAssociatedPart(Part part){
     associatedParts.add(part);
    }
    
    void removeAsociatedPart(int partID){
         Part removePart = Inventory.lookupPart(partID);
         System.out.println(removePart.getName());
        associatedParts.remove(removePart);
    }
    
    Part lookupAssociatedPart(int partIDindex){
        return this.associatedParts.get(partIDindex);
    }
    
    int getAssociatedPartSize(){
        return this.associatedParts.size();
    }
    
    void setProductID(int productID){
        this.productID = productID;
    }
    
    int getProductID(){
        return this.productID;
    }
    int autoGenID(){
        return ++count;
    }
    
}

