/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareiproject;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Michelle
 */
public class AddPartPageFXMLController implements Initializable {

    
    @FXML
    Label testRadio;
    
    @FXML
    private RadioButton inHouse;
    @FXML
    private RadioButton outsource;
    
    @FXML
    TextField PartCompanyNameField;
    @FXML
    Label CompanyNameText; 
    
    @FXML
    TextField PartMachineID;
    @FXML
    Label MachineIDText; 
    
    @FXML
    private TextField getPartIDField;
    @FXML
    private TextField PartNameField;
    @FXML
    private TextField PartInvField;
    @FXML
    private TextField PartPriceField;
    @FXML
    private TextField PartMaxField;
    @FXML
    private TextField PartMinField;
    

    public AddPartPageFXMLController() {
        
    }
    
    
    
    public void openwindowEvent(){
        
        getPartIDField.setEditable(false);
        getPartIDField.setText("Auto-Gen (Disabled)");
        getPartIDField.setStyle("-fx-background-color: lightgrey;");
        //testRadio.setText("Select Outsource or In House");
            outsource.setSelected(true);
            
            CompanyNameText.setVisible(true);
            PartCompanyNameField.setVisible(true);
            MachineIDText.setVisible(false);
            PartMachineID.setVisible(false);
            
            
    }
 
    @FXML
    public void handleInHouseButtonAction(ActionEvent event){
    
            testRadio.setText("In House selected");
            CompanyNameText.setVisible(false);
            PartCompanyNameField.setVisible(false);
            MachineIDText.setVisible(true);
            PartMachineID.setVisible(true);
    } 
    
    @FXML    
    public void handleOutsourceButtonAction(ActionEvent event){
            testRadio.setText("Outsource selected");
            //outsource.setSelected(true);
            CompanyNameText.setVisible(true);
            PartCompanyNameField.setVisible(true);
            MachineIDText.setVisible(false);
            PartMachineID.setVisible(false);
        }
        
        
    
    
  
    
    @FXML 
    private Text actiontarget;
    
    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
        
              
        
        
        if("".equals(getPartIDField.getText())){
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
        else if(Integer.parseInt(PartMinField.getText()) >= (Integer.parseInt(PartMaxField.getText()))){
            testRadio.setText("Minimum value must be less than Maximum value");
        }
        else if(inHouse.isSelected() && !"".equals(PartMachineID.getText())){
           // System.out.println("in house selected");
            Inhouse test = new Inhouse();
        
            test.setName(PartNameField.getText());
            System.out.println(test.getName());
            test.setMachineID(Integer.parseInt(PartMachineID.getText()));
            
            test.setInStock(Integer.parseInt(PartInvField.getText()));
            test.setPrice(Double.parseDouble(PartPriceField.getText()));
            test.setMax(Integer.parseInt(PartMaxField.getText()));
            test.setMin(Integer.parseInt(PartMinField.getText()));
            
            Inventory.addPart(test);
            
            final Node source = (Node) event.getSource();
            final Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            
        }
        else if(outsource.isSelected() && !"".equals(PartCompanyNameField.getText())){
            System.out.println("Outsourced selected");
            Outsourced test = new Outsourced(PartNameField.getText(), 
                     Double.parseDouble(PartPriceField.getText()), Integer.parseInt(PartInvField.getText()),
                            Integer.parseInt(PartMaxField.getText()),Integer.parseInt(PartMinField.getText()), PartCompanyNameField.getText());
            
            Inventory.addPart(test);

            
            
            
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
      
        inHouse.setUserData("InHouse");
        outsource.setUserData("outsource");
        
    }       
    
}
