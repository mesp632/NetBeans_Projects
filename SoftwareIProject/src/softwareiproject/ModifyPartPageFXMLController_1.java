/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareiproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Michelle
 */
public class ModifyPartPageFXMLController_1 implements Initializable {

    
    @FXML
    Label testRadio;
    
    @FXML
    RadioButton inHouse = new RadioButton("InHouse");
    @FXML
    RadioButton outsource = new RadioButton("Outsource");
    
    @FXML
    TextField PartCompanyNameField;
    @FXML
    Label CompanyNameText; 
    
    @FXML
    TextField PartMachineID;
    @FXML
    Label MachineIDText; 
    @FXML
    TextField PartIDField;
    
    @FXML
    TextField PartNameField;
    @FXML
    TextField PartInvField;
    @FXML
    TextField PartPriceField;
    @FXML
    TextField PartMaxField;
    @FXML
    TextField PartMinField;

    
    public ModifyPartPageFXMLController_1() {
        
       // 
    }
    
    
    
    public void openwindowEvent(){
        
        PartIDField.setEditable(false);
        
        PartIDField.setStyle("-fx-background-color: lightgrey;");
        testRadio.setText("Select Outsource or In House");
            CompanyNameText.setVisible(false);
            PartCompanyNameField.setVisible(false);
            MachineIDText.setVisible(false);
            PartMachineID.setVisible(false);
            
            Part part = SelectedPartClass.GetSelectedPart();
            System.out.println(part.getClass());
            
            PartIDField.setText(Integer.toString(part.getPartID()));
            PartNameField.setText(part.getName());
            PartInvField.setText(Integer.toString(part.getInStock()));
            PartPriceField.setText(Double.toString(part.getPrice()));
            PartMaxField.setText(Integer.toString(part.getMax()));
            PartMinField.setText(Integer.toString(part.getMin()));
            
            
            if ( Outsourced.class.isInstance(part)){
               CompanyNameText.setVisible(true);
               PartCompanyNameField.setVisible(true);
               PartCompanyNameField.setText(((Outsourced)part).getCompanyName());
               outsource.setSelected(true);
               
                   
               
            }
            else{
                MachineIDText.setVisible(true);
                PartMachineID.setVisible(true);
                PartMachineID.setText(Integer.toString(((Inhouse)part).getMachineID()));
                inHouse.setSelected(true);
            }
    }
 
    @FXML
    public void handleInHouseButtonAction(ActionEvent event){
        
            testRadio.setText("In House selected");
            CompanyNameText.setVisible(true);
            PartCompanyNameField.setVisible(true);
            MachineIDText.setVisible(false);
            PartMachineID.setVisible(false);
    } 
    
    @FXML    
    public void handleOutsourceButtonAction(ActionEvent event){
            testRadio.setText("Outsource selected");
            
            CompanyNameText.setVisible(true);
            PartCompanyNameField.setVisible(true);
            MachineIDText.setVisible(false);
            PartMachineID.setVisible(false);
        }
        
        
    
    
  
    
    @FXML 
    private Text actiontarget;
    
    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
        
              
        
        
        if("".equals(PartIDField.getText())){
            testRadio.setText("Please fill out Part ID field");
        }
        else if("".equals(PartNameField.getText())){
            testRadio.setText("Please fill out Part Name field");
        }
        else if("".equals(PartInvField.getText())){
            testRadio.setText("Please fill out Inv field");
        }
        else if("".equals(PartPriceField.getText())){
            testRadio.setText("Please fill out Price field");
        }
        else if("".equals(PartMaxField.getText())){
            testRadio.setText("Please fill out Max field");
        }
        else if("".equals(PartMinField.getText())){
            testRadio.setText("Please fill out Min field");
        }
        else if(inHouse.isSelected() && !"".equals(PartMachineID.getText())){
          
        
            Inhouse test = (Inhouse)SelectedPartClass.GetSelectedPart();
            int partIndex = Inventory.getPartList().indexOf(test);
            Inhouse test2 = new Inhouse(PartNameField.getText(), 
                     Double.parseDouble(PartPriceField.getText()), Integer.parseInt(PartInvField.getText()),
                            Integer.parseInt(PartMaxField.getText()),Integer.parseInt(PartMinField.getText()), Integer.parseInt(PartMachineID.getText()));
            
            
            
        
//            test.setPartID(Integer.parseInt(PartIDField.getText()));
//            //int test = test.getPartID();
//            System.out.println(Integer.toString(test2));
//            test.setName(PartNameField.getText());
//            System.out.println(test.getName());
//            test.setCompanyName(PartCompanyNameField.getText());
//            System.out.println(test.getCompanyName());
//            test.setInStock(Integer.parseInt(PartInvField.getText()));
//            test.setPrice(Double.parseDouble(PartPriceField.getText()));
//            test.setMax(Integer.parseInt(PartMaxField.getText()));
//            test.setMin(Integer.parseInt(PartMinField.getText()));
            
            Inventory.getPartList().set(partIndex, test2);
            
            
            
            final Node source = (Node) event.getSource();
            final Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            
            
        }
        else if(outsource.isSelected() && !"".equals(PartCompanyNameField.getText())){
           // System.out.println("Outsourced selected");
            Outsourced test = (Outsourced)SelectedPartClass.GetSelectedPart();
            int partIndex = Inventory.getPartList().indexOf(test);
            Outsourced test2 = new Outsourced(PartNameField.getText(), 
                     Double.parseDouble(PartPriceField.getText()), Integer.parseInt(PartInvField.getText()),
                            Integer.parseInt(PartMaxField.getText()),Integer.parseInt(PartMinField.getText()), PartCompanyNameField.getText());
            
            
            
        
//            test.setPartID(Integer.parseInt(PartIDField.getText()));
//            //int test = test.getPartID();
//            System.out.println(Integer.toString(test2));
//            test.setName(PartNameField.getText());
//            System.out.println(test.getName());
//            test.setCompanyName(PartCompanyNameField.getText());
//            System.out.println(test.getCompanyName());
//            test.setInStock(Integer.parseInt(PartInvField.getText()));
//            test.setPrice(Double.parseDouble(PartPriceField.getText()));
//            test.setMax(Integer.parseInt(PartMaxField.getText()));
//            test.setMin(Integer.parseInt(PartMinField.getText()));
            
            Inventory.getPartList().set(partIndex, test2);
            
            
            final Node source = (Node) event.getSource();
            final Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        }
        else if(outsource.isSelected() && "".equals(PartCompanyNameField.getText())){
            testRadio.setText("Please fill out Company Name field");
        }
        else if(inHouse.isSelected() && "".equals(PartMachineID.getText())){
            testRadio.setText("Please fill out Machine ID field");
        }
        
    }
    
         @FXML
    private void handleCancelButtonAction(ActionEvent event) {
                 CancelDialogue.openCancelDialogue();
         System.out.println("test" + CancelDialogue.getCancelResponse());
         if(CancelDialogue.getCancelResponse().equals(false)) {
             //do nothing
        } else {

             final Node source = (Node) event.getSource();
             final Stage stage = (Stage) source.getScene().getWindow();
             stage.close();
         }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        openwindowEvent();
        
    //    inHouse.setToggleGroup(partToggle);
        inHouse.setUserData("InHouse");
        
    //    outsource.setToggleGroup(partToggle);
        outsource.setUserData("outsource");
        
        
        
        
        

        
    }       
    
}
