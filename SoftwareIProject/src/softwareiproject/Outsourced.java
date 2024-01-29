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
public class Outsourced extends Part{
    protected String companyName;
    Outsourced(){
        int genID = autoGenID();
        setPartID(genID);
    }
    Outsourced(String name, double price, int inStock, int min, int max, String companyName){
        int genID = autoGenID();
        setPartID(genID);
        this.name = name;
        this.price = price;
        this.inStock = inStock;
        this.min = min;
        this.max = max;
        this.companyName = companyName;
    }
    
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }
    
    public String getCompanyName(){
        return this.companyName;
    }
}
