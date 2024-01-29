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
public class SelectedProductClass {
        private static Product selectedProduct;
    public static void SetSelectedProduct(Product product){
        SelectedProductClass.selectedProduct = product;
    }
    public static Product GetSelectedProduct(){
        return SelectedProductClass.selectedProduct;
    }
}
