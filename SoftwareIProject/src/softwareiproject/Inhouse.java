/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareiproject;

/**
 *
 * @author Michelle
 */
public class Inhouse extends Part{
    protected int machineID;
    
    Inhouse(){
        int genID = autoGenID();
        setPartID(genID);
    }
    Inhouse(String name, double price, int inStock, int min, int max, int machineID){
        int genID = autoGenID();
        setPartID(genID);
        this.name = name;
        this.price = price;
        this.inStock = inStock;
        this.min = min;
        this.max = max;
        this.machineID = machineID;
    }
    
    void setMachineID(int machineID){
        this.machineID = machineID;
    }
    
    int getMachineID(){
        return this.machineID;
    }
}
