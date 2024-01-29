/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverclientconnections;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author Saelin
 */
public class ServerClientConnections {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (OutputStream out = new FileOutputStream("/tmp/data.txt")) 
{
    // work with the output stream...
    
} catch (IOException ex) 
{
    System.err.println(ex.getMessage());
}
        
        
        
        
    }
    
}
