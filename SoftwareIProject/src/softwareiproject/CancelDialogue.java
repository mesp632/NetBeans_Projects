/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareiproject;


import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Saelin
 */
public class CancelDialogue {
    
    private static Boolean cancelResponse;

    public static void openCancelDialogue()
    {
        
    
        
        Stage dialog = new Stage();
        
        dialog.initStyle(StageStyle.UTILITY);
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 200, 200);
        
        Label label = new Label("Do yo want to close\n" +"without saving?");
        
        Button OK = new Button("OK");
        Button Cancel = new Button("Cancel");
        
        gridPane.add(label,1,1);
        gridPane.add(OK,1,4);
        gridPane.add(Cancel,2,4);
        dialog.setScene(scene);
        
        
        
        OK.setOnMouseClicked((MouseEvent event) -> {
             setCancelResponse(true);
            // System.out.println(getCancelResponse());
             dialog.close();
            
       });
        Cancel.setOnMouseClicked((MouseEvent event) -> {
               setCancelResponse(false);
               
               dialog.close();
               
       });
        dialog.showAndWait();
        
        //return getCancelResponse();
        
    }
    
   public static void setCancelResponse(Boolean CancelResponse){
       CancelDialogue.cancelResponse = CancelResponse;
       System.out.println(CancelDialogue.cancelResponse);
   };
   public static Boolean getCancelResponse(){
       return CancelDialogue.cancelResponse;
   }
    
}
