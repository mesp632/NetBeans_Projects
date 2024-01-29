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
public class SelectedPartClass {
    private static Part selectedPart;
    public static void SetSelectedPart(Part part){
        SelectedPartClass.selectedPart = part;
    }
    public static Part GetSelectedPart(){
        return SelectedPartClass.selectedPart;
    }
}
