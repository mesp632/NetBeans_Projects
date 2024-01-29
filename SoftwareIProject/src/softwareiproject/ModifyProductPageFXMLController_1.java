/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareiproject;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Michelle
 */
public class ModifyProductPageFXMLController_1 implements Initializable {
Product test = SelectedProductClass.GetSelectedProduct();
    ObservableList<Part> tempAssociatedPartList = FXCollections.observableArrayList();
    
    @FXML
    Label testRadio;

    
    @FXML
    private TextField getproductIDField;
    @FXML
    private TextField productNameField;
    @FXML
    private TextField productInvField;
    @FXML
    private TextField productPriceField;
    @FXML
    private TextField productMaxField;
    @FXML
    private TextField productMinField;
    @FXML
    private TableView table;
    
    @FXML
    private TableView associatedPartsTable;
    
    @FXML TextField partSearchField;
   


    
    
    
    public void openwindowEvent(){
        associatedPartsTable.setEditable(true);
        getproductIDField.setEditable(false);
        getproductIDField.setText("Auto-Gen (Disabled)");
        getproductIDField.setStyle("-fx-background-color: lightgrey;");
        //testRadio.setText("Select Outsource or In House");
 
        //Group root = new Group();
      
        
       //occupy product info
        getproductIDField.setText(Integer.toString(test.getProductID()));
    
        productNameField.setText(test.getName());
    
        productInvField.setText(Integer.toString(test.getInStock()));
    
        productPriceField.setText(Double.toString(test.getPrice()));
    
        productMaxField.setText(Integer.toString(test.getMax()));
    
        productMinField.setText(Integer.toString(test.getMin()));
      
       
     

        
       
       //test part array sample
        
        
    
    
    
        
 //part table gui start
        final Label label = new Label("Part Inventory");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
       // table.setTableMenuButtonVisible(true);
        

 
        TableColumn PartIDCol = new TableColumn("PartID");
        PartIDCol.setMinWidth(100);
        PartIDCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Part, Integer>, ObservableValue<Integer>>() {
           @Override
           public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Part, Integer> p) {
               ObservableValue<Integer> obsInt = new ReadOnlyObjectWrapper<>(p.getValue().getPartID());
               return obsInt; // p.getValue() returns the Person instance for a particular TableView row
                               }
       });
        
        TableColumn PartNameCol = new TableColumn("Name");
        PartNameCol.setMinWidth(100);
        PartNameCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Part, String>, ObservableValue<String>>() {
           @Override
           public ObservableValue<String> call(TableColumn.CellDataFeatures<Part, String> p) {
               ObservableValue<String> obsString = new ReadOnlyObjectWrapper<>(p.getValue().getName());
               return obsString; // p.getValue() returns the Person instance for a particular TableView row
                               }
       });
 
       TableColumn partPriceCol = new TableColumn("Price");
        partPriceCol.setMinWidth(100);
        
        partPriceCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Part, Double>, ObservableValue<Double>>() {
            DecimalFormat df = new DecimalFormat("#.##");
           @Override
           public ObservableValue<Double> call(TableColumn.CellDataFeatures<Part, Double> p) {
               ObservableValue<Double> obsDouble = new ReadOnlyObjectWrapper<>(p.getValue().getPrice());
               
               return obsDouble; // p.getValue() returns the Person instance for a particular TableView row
                               }
       });
        partPriceCol.setCellFactory(col -> 
    new TableCell<Part, Double>() {
        @Override 
        public void updateItem(Double price, boolean empty) {
            super.updateItem(price, empty);
            if (empty) {
                setText(null);
            } else {
                setText(String.format("$%.2f", price));
            }
        }
    });
        
        
        TableColumn partInStockCol = new TableColumn("Inventory Level");
        partInStockCol.setMinWidth(100);
        partInStockCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Part, Integer>, ObservableValue<Integer>>() {
           @Override
           public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Part, Integer> p) {
               ObservableValue<Integer> obsInt = new ReadOnlyObjectWrapper<>(p.getValue().getInStock());
               return obsInt; // p.getValue() returns the Person instance for a particular TableView row
                               }
       });
        
        
        
//part col value collection end
        table.setItems(Inventory.getPartList());
        table.getColumns().addAll(PartIDCol,PartNameCol,partPriceCol,partInStockCol);
        table.setMaxHeight(150);
        table.setMaxWidth(400);
        table.setMinHeight(100);
        table.setMinWidth(400);
        // end of all parts list
        
        
        // associated parts table gui start
        final Label label1 = new Label("Associated Parts");
        label1.setFont(new Font("Arial", 20));
 
        associatedPartsTable.setEditable(true);
       // table.setTableMenuButtonVisible(true);
        

 
        TableColumn AssociatedPartIDCol = new TableColumn("PartID");
        AssociatedPartIDCol.setMinWidth(100);
        AssociatedPartIDCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Part, Integer>, ObservableValue<Integer>>() {
           @Override
           public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Part, Integer> p) {
               ObservableValue<Integer> obsInt = new ReadOnlyObjectWrapper<>(p.getValue().getPartID());
               return obsInt; // p.getValue() returns the Person instance for a particular TableView row
                               }
       });
        
        TableColumn AssociatedPartNameCol = new TableColumn("Name");
        AssociatedPartNameCol.setMinWidth(100);
        AssociatedPartNameCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Part, String>, ObservableValue<String>>() {
           @Override
           public ObservableValue<String> call(TableColumn.CellDataFeatures<Part, String> p) {
               ObservableValue<String> obsString = new ReadOnlyObjectWrapper<>(p.getValue().getName());
               return obsString; // p.getValue() returns the Person instance for a particular TableView row
                               }
       });
 
       TableColumn AssociatedPartPriceCol = new TableColumn("Price");
        AssociatedPartPriceCol.setMinWidth(100);
        
        AssociatedPartPriceCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Part, Double>, ObservableValue<Double>>() {
            DecimalFormat df = new DecimalFormat("#.##");
           @Override
           public ObservableValue<Double> call(TableColumn.CellDataFeatures<Part, Double> p) {
               ObservableValue<Double> obsDouble = new ReadOnlyObjectWrapper<>(p.getValue().getPrice());
               
               return obsDouble; // p.getValue() returns the Person instance for a particular TableView row
                               }
       });
        AssociatedPartPriceCol.setCellFactory(col -> 
    new TableCell<Part, Double>() {
        @Override 
        public void updateItem(Double price, boolean empty) {
            super.updateItem(price, empty);
            if (empty) {
                setText(null);
            } else {
                setText(String.format("$%.2f", price));
            }
        }
    });
        
        
        TableColumn AssociatedPartInStockCol = new TableColumn("Inventory Level");
        AssociatedPartInStockCol.setMinWidth(100);
        AssociatedPartInStockCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Part, Integer>, ObservableValue<Integer>>() {
           @Override
           public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Part, Integer> p) {
               ObservableValue<Integer> obsInt = new ReadOnlyObjectWrapper<>(p.getValue().getInStock());
               return obsInt; // p.getValue() returns the Person instance for a particular TableView row
                               }
       });
        
        
        
//part col value collection end
         
         int maxIndex = test.getAssociatedPartSize();
        for(int i=0; i < maxIndex; i++){
            tempAssociatedPartList.add(test.lookupAssociatedPart(i));
        }
        associatedPartsTable.setItems(tempAssociatedPartList);
        associatedPartsTable.getColumns().addAll(AssociatedPartIDCol,AssociatedPartNameCol,AssociatedPartPriceCol,AssociatedPartInStockCol);
        associatedPartsTable.setMaxHeight(150);
        associatedPartsTable.setMaxWidth(400);
        associatedPartsTable.setMinHeight(100);
        associatedPartsTable.setMinWidth(400);
        // end of associated parts list
            
}  
    
    @FXML
    private void addAssociatedPart(ActionEvent event) {
         Part selected = (Part) table.getSelectionModel().getSelectedItem();
         test.addAssociatedPart(selected);
         tempAssociatedPartList.clear();
         int maxIndex = test.getAssociatedPartSize();
        for(int i=0; i < maxIndex; i++){
            tempAssociatedPartList.add(test.lookupAssociatedPart(i));
        }
         
         associatedPartsTable.setItems(tempAssociatedPartList);
       // associatedPartsTable.getColumns().addAll(openwindowEvent.AssociatedPartIDCol,AssociatedPartNameCol,AssociatedPartPriceCol,AssociatedPartInStockCol);
    }
    
    @FXML 
    private Text actiontarget;
    
    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
        
              
        Inventory.removeProduct(test.getProductID());
        
        if("".equals(getproductIDField.getText())){
            testRadio.setText("Please fill out product ID field");
        }
        else if("".equals(productNameField.getText())){
            testRadio.setText("Please fill out product Name field");
        }
        else if("".equals(productInvField.getText())){
            testRadio.setText("Please fill out Inv field");
        }
        else if("".equals(productPriceField.getText())){
            testRadio.setText("Please fill out Price field");
        }
        else if("".equals(productMaxField.getText())){
            testRadio.setText("Please fill out Max field");
        }
        else if("".equals(productMinField.getText())){
            testRadio.setText("Please fill out Min field");
        }
        else{
           // System.out.println("in house selected");
            
        
            
            
            test.setName(productNameField.getText());
            System.out.println(test.getName());
            
            
            test.setInStock(Integer.parseInt(productInvField.getText()));
            test.setPrice(Double.parseDouble(productPriceField.getText()));
            test.setMax(Integer.parseInt(productMaxField.getText()));
            test.setMin(Integer.parseInt(productMinField.getText()));
           
            
            
            
          //  System.out.println("productID is:" + getproductIDField.getText() + Integer.toString(test2) + test.getName() );
            
//            Inventoryremove.addProduct(test);
//            System.out.println("product name in Invetory is:" + Inventoryremove.lookupproduct(test.productID).getName());
            
            Inventory.addProduct(test);
 
            
            
            
            final Node source = (Node) event.getSource();
            final Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            
        }
        
    }
    
        @FXML
    private void removeAssociatedPart(ActionEvent event) {
        
        DeleteDialogue.openDeleteDialogue();
        
         if(DeleteDialogue.getDeleteResponse().equals(false)) {
             //do nothing
        } else {

              Part selected = (Part) associatedPartsTable.getSelectionModel().getSelectedItem();
         int getpartID = selected.getPartID();
         System.out.println("partID is:" + getpartID);
         test.removeAsociatedPart(getpartID);
         int maxIndex = test.getAssociatedPartSize();
         tempAssociatedPartList.clear();

        for(int i=0; i < maxIndex; i++){
         
            tempAssociatedPartList.add(test.lookupAssociatedPart(i));
        }

         associatedPartsTable.setItems(tempAssociatedPartList);
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
    
        @FXML
    private void handleSearchButtonAction(ActionEvent event) {
         int partID = Inventory.lookupPart(partSearchField.getText());
               if (partID > -1) {
                   
                   ObservableList<Part> temp = FXCollections.observableArrayList();//temporary list to hold found part
                   
                   temp.add(Inventory.lookupPart(partID));
                   System.out.println(temp.get(0).getName());
                   table.setItems(temp);                   
                   
               }
               else{
                   table.setItems(Inventory.getPartList());
           
               }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        openwindowEvent();
        
        
        

        
    } 
    
   
    
}