/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareiproject;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Platform.exit;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;


/**
 *
 * @author Saelin
 */
public class SoftwareIProject extends Application {
    
    final ScrollBar sc = new ScrollBar();
    final VBox vb = new VBox();
        @Override
    public void start(Stage primaryStage) {
        
       Group root = new Group();
       FlowPane rootPane = new FlowPane(root);
       GridPane titleGrid = new GridPane(); 
       GridPane grid = new GridPane();
       GridPane grid2 = new GridPane();
       GridPane exitGrid = new GridPane();
       //ListView<String> PartList = new ListView<String>();
      
       
       double height = 180;

        
       
       //test part array sample
        
        TableView<Part> table = new TableView<>();
    
    
    
        
 //part table gui start
        final Label label = new Label("Part Inventory");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
       // table.setTableMenuButtonVisible(true);
        

 
        TableColumn PartIDCol = new TableColumn("PartID");
        PartIDCol.setMinWidth(100);
        PartIDCol.setCellValueFactory(new Callback<CellDataFeatures<Part, Integer>, ObservableValue<Integer>>() {
           @Override
           public ObservableValue<Integer> call(CellDataFeatures<Part, Integer> p) {
               ObservableValue<Integer> obsInt = new ReadOnlyObjectWrapper<>(p.getValue().getPartID());
               return obsInt; // p.getValue() returns the Person instance for a particular TableView row
                               }
       });
        
        TableColumn PartNameCol = new TableColumn("Name");
        PartNameCol.setMinWidth(100);
        PartNameCol.setCellValueFactory(new Callback<CellDataFeatures<Part, String>, ObservableValue<String>>() {
           @Override
           public ObservableValue<String> call(CellDataFeatures<Part, String> p) {
               ObservableValue<String> obsString = new ReadOnlyObjectWrapper<>(p.getValue().getName());
               return obsString; // p.getValue() returns the Person instance for a particular TableView row
                               }
       });
 
       TableColumn partPriceCol = new TableColumn("Price");
        partPriceCol.setMinWidth(100);
        
        partPriceCol.setCellValueFactory(new Callback<CellDataFeatures<Part, Double>, ObservableValue<Double>>() {
            DecimalFormat df = new DecimalFormat("#.##");
           @Override
           public ObservableValue<Double> call(CellDataFeatures<Part, Double> p) {
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
        partInStockCol.setCellValueFactory(new Callback<CellDataFeatures<Part, Integer>, ObservableValue<Integer>>() {
           @Override
           public ObservableValue<Integer> call(CellDataFeatures<Part, Integer> p) {
               ObservableValue<Integer> obsInt = new ReadOnlyObjectWrapper<>(p.getValue().getInStock());
               return obsInt; // p.getValue() returns the Person instance for a particular TableView row
                               }
       });
        
        
        
//part col value collection end
        table.setItems(Inventory.getPartList());
        table.getColumns().addAll(PartIDCol,PartNameCol,partPriceCol,partInStockCol);
        table.setMaxHeight(150);
        table.setMaxWidth(400);
        final VBox vbox = new VBox();
        vbox.setMaxHeight(150);
        vbox.setMaxWidth(400);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
 
        grid.getChildren().add(vbox);
    
 
    //part table gui end
 
    //product table begin
            TableView<Product> table2 = new TableView<>();
    
    
    
        
 
        final Label label2 = new Label("Product Inventory");
        label2.setFont(new Font("Arial", 20));
 
        table2.setEditable(true);
       // table.setTableMenuButtonVisible(true);
        

 
        TableColumn ProductIDCol = new TableColumn("ProductID");
        ProductIDCol.setMinWidth(100);
        ProductIDCol.setCellValueFactory(new Callback<CellDataFeatures<Product, Integer>, ObservableValue<Integer>>() {
           @Override
           public ObservableValue<Integer> call(CellDataFeatures<Product, Integer> p) {
               ObservableValue<Integer> obsInt2 = new ReadOnlyObjectWrapper<>(p.getValue().getProductID());
               return obsInt2; // p.getValue() returns the Person instance for a particular TableView row
                               }
       });
        
        TableColumn ProductNameCol = new TableColumn("Name");
        ProductNameCol.setMinWidth(100);
        ProductNameCol.setCellValueFactory(new Callback<CellDataFeatures<Product, String>, ObservableValue<String>>() {
           @Override
           public ObservableValue<String> call(CellDataFeatures<Product, String> p) {
               ObservableValue<String> obsString = new ReadOnlyObjectWrapper<>(p.getValue().getName());
               return obsString; // p.getValue() returns the Person instance for a particular TableView row
                               }
       });
 
       TableColumn productPriceCol = new TableColumn("Price");
        productPriceCol.setMinWidth(100);
        
        productPriceCol.setCellValueFactory(new Callback<CellDataFeatures<Product, Double>, ObservableValue<Double>>() {
            DecimalFormat df = new DecimalFormat("#.##");
           @Override
           public ObservableValue<Double> call(CellDataFeatures<Product, Double> p) {
               ObservableValue<Double> obsDouble = new ReadOnlyObjectWrapper<>(p.getValue().getPrice());
               
               return obsDouble; // p.getValue() returns the Person instance for a particular TableView row
                               }
       });
        productPriceCol.setCellFactory(col -> 
    new TableCell<Product, Double>() {
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
        
        
        TableColumn productInStockCol = new TableColumn("Inventory Level");
        productInStockCol.setMinWidth(100);
        productInStockCol.setCellValueFactory(new Callback<CellDataFeatures<Product, Integer>, ObservableValue<Integer>>() {
           @Override
           public ObservableValue<Integer> call(CellDataFeatures<Product, Integer> p) {
               ObservableValue<Integer> obsInt = new ReadOnlyObjectWrapper<>(p.getValue().getInStock());
               return obsInt; // p.getValue() returns the Person instance for a particular TableView row
                               }
       });
        
        
        

        table2.setItems(Inventory.Products);
        table2.getColumns().addAll(ProductIDCol,ProductNameCol,productPriceCol,productInStockCol);
        table2.setMaxHeight(150);
        table2.setMaxWidth(400);
        final VBox vbox2 = new VBox();
        vbox2.setMaxHeight(150);
        vbox2.setMaxWidth(400);
        vbox2.setSpacing(5);
        vbox2.setPadding(new Insets(10, 0, 0, 10));
        vbox2.getChildren().addAll(label2, table2);
 
        grid2.getChildren().add(vbox2);
    //product table end
        
       
       
       
       grid.setAlignment(Pos.CENTER_LEFT);
       grid2.setAlignment(Pos.CENTER_RIGHT);
       exitGrid.setAlignment(Pos.BOTTOM_RIGHT);
       exitGrid.setHgap(10);
       exitGrid.setVgap(10);
       exitGrid.setPadding(new Insets(25,25,25,25));
       grid.setHgap(10);
       grid.setVgap(10);
       grid.setPadding(new Insets(25,25,25,25));
       grid2.setHgap(10);
       grid2.setVgap(10);
       grid2.setPadding(new Insets(25,25,25,25));
       
       Scene scene = new Scene(rootPane,900,600);
      
       
       

       
       rootPane.getChildren().addAll(titleGrid,grid,grid2,exitGrid);
       

       
       Text scenetitle = new Text("Inventory Management System");
       scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL,20));
       Label parts = new Label("Parts:");
       Label partSearch = new Label("Search:");
       titleGrid.add(scenetitle, 0, 0);
       
       TextField partsSearchField = new TextField();
       Label products = new Label("Products:");
       TextField productsSearchField = new TextField();
       Label productSearch = new Label("Search:");
       
       Button searchPartButton = new Button("Search");
       HBox hbSearchPartButton = new HBox(10);
       hbSearchPartButton.getChildren().add(searchPartButton);
       grid.add(hbSearchPartButton,3,1);
       
       //grid.add(scenetitle,0,0,2,1);
       grid.add(parts,0,1);
       grid.add(partSearch,1,1);
       grid.add(partsSearchField,2,1);
       
       grid.getStyleClass().add("gridpane-border");
       grid2.add(products,0,1);
       grid2.add(productSearch,1,1);
       grid2.add(productsSearchField,2,1);
       grid2.getStyleClass().add("gridpane-border");
       
       Button searchProductButton = new Button("Search");
       HBox hbSearchProductButton = new HBox(10);
       hbSearchProductButton.getChildren().add(searchProductButton);
       grid2.add(hbSearchProductButton,3,1);
       
       grid.setGridLinesVisible(false);
       
       Button partsAddBtn = new Button("Add");
       HBox hbpartsAddBtn = new HBox(10);
       hbpartsAddBtn.getChildren().add(partsAddBtn);
       grid.add(hbpartsAddBtn,1,3);
       
       
       searchPartButton.setOnMouseClicked((MouseEvent event) -> {
          
          
          
               int partID = Inventory.lookupPart(partsSearchField.getText());
               if (partID > -1) {
                   
                   
                   
                   ObservableList<Part> temp = FXCollections.observableArrayList();
                   
                   temp.add(Inventory.lookupPart(partID));
                   System.out.println(temp.get(0).getName());
                   table.setItems(temp);
                   table.getItems().get(Inventory.getPartList().size()).getName();
                   
                   table.refresh();
                   table.getColumns().get(0).setVisible(false);
                   table.getColumns().get(0).setVisible(true);
                   
                   
                   table.getColumns().addAll(PartIDCol,PartNameCol,partPriceCol,partInStockCol);
                   table.getColumns().get(0).setVisible(false);
                   table.getColumns().get(0).setVisible(true);
                   
                   
               }
               else{
                   table.setItems(Inventory.getPartList());
                   table.getColumns().clear();
                   table.getColumns().addAll(PartIDCol,PartNameCol,partPriceCol,partInStockCol);
               }
           
          
       });
       
       partsAddBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent event) {
               try {
                   FXMLLoader fxmlLoader = new FXMLLoader();
                   fxmlLoader.setLocation(SoftwareIProject.this.getClass().getResource("AddPartPageFXML.fxml"));
                   /*
                   * if "fx:controller" is not set in fxml
                   * fxmlLoader.setController(NewWindowController);
                   */
                   Scene addPartScene = new Scene(fxmlLoader.load(), 700, 400);
                   Stage stage = new Stage();
                   stage.setTitle("Add Part");
                   stage.setScene(addPartScene);
                   stage.show();
                   
                   stage.setOnHidden((WindowEvent we) -> {
                       System.out.print("in set on hidden handler");
                       
                       table.setItems(Inventory.getPartList());
                       table.getColumns().clear();
                       table.getColumns().addAll(PartIDCol,PartNameCol,partPriceCol,partInStockCol);
                       table.setMaxHeight(150);
                       table.setMaxWidth(400);
                       
                   });
                   
               } catch (IOException e) {
                   Logger logger = Logger.getLogger(SoftwareIProject.this.getClass().getName());
                   logger.log(Level.SEVERE, "Failed to create new Window.", e);
               }
           }
       });
       
       
        Button partsModifyBtn = new Button("Modify");
        HBox hbpartsModifyBtn = new HBox(10);
        hbpartsModifyBtn.getChildren().add(partsModifyBtn);
        grid.add(hbpartsModifyBtn,2,3);
        
           partsModifyBtn.setOnMouseClicked((MouseEvent event) -> {
           try {
               FXMLLoader fxmlLoader = new FXMLLoader();
               fxmlLoader.setLocation(SoftwareIProject.this.getClass().getResource("ModifyPartPageFXML_1.fxml"));
               Part selected = table.getSelectionModel().getSelectedItem();
               SelectedPartClass.SetSelectedPart(selected);
               
               Scene modifyPartScene = new Scene(fxmlLoader.load(), 600, 400);
               Stage stage = new Stage();
               stage.setTitle("Modify Part");
               stage.setScene(modifyPartScene);
               stage.show();
           } catch (IOException e) {
               Logger logger = Logger.getLogger(SoftwareIProject.this.getClass().getName());
               logger.log(Level.SEVERE, "Failed to create new Window.", e);
           }
       });

       
       

       
       Button partsDeleteBtn = new Button("Delete");
       HBox hbpartsDeleteBtn = new HBox(10);
       hbpartsDeleteBtn.getChildren().add(partsDeleteBtn);
       grid.add(hbpartsDeleteBtn,3,3);
       
       partsDeleteBtn.setOnMouseClicked((MouseEvent event) ->{
           
           
         DeleteDialogue.openDeleteDialogue();
        
         if(DeleteDialogue.getDeleteResponse().equals(false)) {
             //do nothing
        } else {

             try {
               
               Part selected = table.getSelectionModel().getSelectedItem();
               SelectedPartClass.SetSelectedPart(selected);
               Inventory.deletePart(selected);
              
               
           } catch (Exception e) {
               
               System.out.println("Part not selected.");
           }
         }
            
       });
       
       
        searchProductButton.setOnMouseClicked((MouseEvent event) -> {
          Product product = Inventory.lookupProduct(productsSearchField.getText());
               if (product != null) {
                   
                   System.out.println(product.getName());
                   //Product foundProduct = Inventory.lookupProduct(productID);
                   ObservableList<Product> temp = FXCollections.observableArrayList();
                   
                   temp.add(product);
                   System.out.println(temp.get(0).getName());
                   //table2.getColumns().clear();
                   table2.setItems(temp);
                   table2.getItems().get(Inventory.getProductList().size()).getName();
                   
                   table2.refresh();
                   table2.getColumns().get(0).setVisible(false);
                   table2.getColumns().get(0).setVisible(true);
                   
                   
                   table2.getColumns().addAll(ProductIDCol,ProductNameCol,productPriceCol,productInStockCol);
                   table2.getColumns().get(0).setVisible(false);
                   table2.getColumns().get(0).setVisible(true);
                   
                   
               }
               else{
                   table2.setItems(Inventory.Products);
                   table2.getColumns().clear();
                   table2.getColumns().addAll(ProductIDCol,ProductNameCol,productPriceCol,productInStockCol);
               }
           
          
       });
       
       Button productsAddBtn = new Button("Add");
       HBox hbproductsAddBtn = new HBox(10);
       hbproductsAddBtn.getChildren().add(productsAddBtn);
       grid2.add(hbproductsAddBtn,1,3);
       
        productsAddBtn.setOnMouseClicked((MouseEvent event) -> {
           try {
               FXMLLoader fxmlLoader = new FXMLLoader();
               fxmlLoader.setLocation(SoftwareIProject.this.getClass().getResource("AddProductPageFXML_1.fxml"));
               
               
               Scene modifyPartScene = new Scene(fxmlLoader.load(), 1000, 600);
               Stage stage = new Stage();
               stage.setTitle("Modify Part");
               stage.setScene(modifyPartScene);
               stage.show();
               
               stage.setOnHidden((WindowEvent we) -> {
                       System.out.print("in set on hidden handler");
                       
                       table2.setItems(Inventory.Products);
                       table2.getColumns().clear();
                       
// table2.refresh();
                       //table2.getColumns().get(0).setVisible(false);
                      // table2.getColumns().get(0).setVisible(true);
                       table2.getColumns().addAll(ProductIDCol,ProductNameCol,productPriceCol,productInStockCol);
                       table2.setMaxHeight(150);
                       table2.setMaxWidth(400);
                       table2.getColumns().get(0).setVisible(false);
                       table2.getColumns().get(0).setVisible(true);
                       
                   });
               
           } catch (IOException e) {
               Logger logger = Logger.getLogger(SoftwareIProject.this.getClass().getName());
               logger.log(Level.SEVERE, "Failed to create new Window.", e);
           }
       });
       
       Button productsModifyBtn = new Button("Modify");
       HBox hbproductsModifyBtn = new HBox(10);
       hbproductsModifyBtn.getChildren().add(productsModifyBtn);
       grid2.add(hbproductsModifyBtn,2,3);
       
        productsModifyBtn.setOnMouseClicked((MouseEvent event) -> {
           try {
               FXMLLoader fxmlLoader = new FXMLLoader();
               fxmlLoader.setLocation(SoftwareIProject.this.getClass().getResource("ModifyPageFXML_1.fxml"));
              
               Product selected = table2.getSelectionModel().getSelectedItem();
               SelectedProductClass.SetSelectedProduct(selected);
               
               Scene modifyProductScene = new Scene(fxmlLoader.load(), 1000, 600);
               Stage stage = new Stage();
               stage.setTitle("Modify Product");
               stage.setScene(modifyProductScene);
               stage.show();
           } catch (IOException e) {
               Logger logger = Logger.getLogger(SoftwareIProject.this.getClass().getName());
               logger.log(Level.SEVERE, "Failed to create new Window.", e);
           }
       });
       
       Button productsDeleteBtn = new Button("Delete");
       HBox hbproductsDeleteBtn = new HBox(10);
       hbproductsDeleteBtn.getChildren().add(productsDeleteBtn);
       grid2.add(hbproductsDeleteBtn,3,3);
       
              productsDeleteBtn.setOnMouseClicked((MouseEvent event) ->{
                  
                  DeleteDialogue.openDeleteDialogue();
        
         if(DeleteDialogue.getDeleteResponse().equals(false)) {
             //do nothing
        } else {

            try {
               
               Product selectedProduct = table2.getSelectionModel().getSelectedItem();
               System.out.println(selectedProduct.getProductID());
               SelectedProductClass.SetSelectedProduct(selectedProduct);
               Inventory.removeProduct(selectedProduct.getProductID());
              
               
           } catch (Exception e) {
               
               System.out.println("Part not selected.");
           }
         }
                  
            
       });
       
//       final Text actiontarget = new Text();
//       grid.add(actiontarget,1,6);
//       
//       btn.setOnAction(event -> {
//        actiontarget.setFill(Color.TURQUOISE);
//        actiontarget.setText("Sign in button Pressed");
//       });
      scene.getStylesheets().
              add(this.getClass().getResource("MainScreen.css").toExternalForm());
      
        primaryStage.setTitle("Inventory Management System");
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        Button exitButton = new Button("Exit");
        HBox hbExitButton = new HBox(10);
        hbExitButton.getChildren().add(exitButton);
        exitGrid.add(exitButton,2,2);
        
        exitButton.setOnAction(event -> {
        exit();
       });
        
        //set selected part to static variable
        
       
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       
        launch(args);
    }

    


    
}


