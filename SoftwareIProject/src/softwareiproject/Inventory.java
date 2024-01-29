/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareiproject;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

/**
 *
 * @author Michelle
 */
public class Inventory {
    
    static ObservableList<Part> allParts =
        FXCollections.observableArrayList(
            new Outsourced("part1", 200, 300, 0, 500, "companyName"),
            new Outsourced("part2", 700, 800, 0, 900, "companyName2"),
            new Inhouse("part3", 456, 789, 10, 11, 12)
        );
    
    
    
    static ObservableList<Product> Products = FXCollections.observableArrayList(
            new Product("product1", 200, 300, 0, 500));
    
    
    static void addProduct(Product newProduct){
        Products.add(newProduct);
    }
    
    static boolean removeProduct(int productID){
        for (Product product : Products) {
        if (product.getProductID() == productID) {
            Products.remove(product);
            return true;
        }
        }
        return false;
    }
    
    static Product lookupProduct(int productID){
        for (Product product : Products) {
        if (product.getProductID() == productID) {
            return product;
        }
        }
        return null;
    }
    
    static Product lookupProduct(String productName){
        int searchListLength = Products.size();
          
          System.out.println("list size"+searchListLength);
           for (Product product : Products) {
               System.out.println("for works");
               if (product.getName().equalsIgnoreCase(productName)) {
                   
                   return product;
               }
               
           }
           return null;
    }
    
    static void updateProduct(int amount, Product productID){
        
    }
    
    static void addPart(Part part){
        allParts.add(part);
        
    }
    
    static boolean deletePart(Part partName){
         for (Part part : allParts) {
        if (part.getPartID() == partName.getPartID()) {
            allParts.remove(partName);
            return true;
        }
        }
        return false;
    }
    
    static Part lookupPart(int partID){
        
        for (Part part : allParts) {
        if (part.getPartID() == partID) {
            return part;
        }
    }
    return null; 
        
    }
    
    static void updatePart(int amount, Part PartID){
        
    }
    
    static int lookupPart(String partName){
        int searchListLength = Inventory.getPartList().size();
          
          System.out.println("list size"+searchListLength);
           for (Part part : Inventory.getPartList()) {
               System.out.println("for works");
               if (part.getName().equalsIgnoreCase(partName)) {
                   
                   return part.getPartID();
               }
               
           }
           return -1;
    }
    
    static ObservableList<Part> getPartList(){
        return allParts;
    }
    
    static ObservableList<Product> getProductList(){
        return Products;
    }
    
   
}
