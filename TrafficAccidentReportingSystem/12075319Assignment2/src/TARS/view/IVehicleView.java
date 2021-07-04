/*
 Interface class. It posses the method to be called by the view*/
package TARS.view;

import TARS.model.Vehicle;
import TARS.presenter.VehiclePresenter;

/**
 *12075319
 * @author sthra
 */


// CREATING INTERFACE FOR VEHICLEVIEW
public interface IVehicleView {
    
  public void show2(VehiclePresenter VP);
     
   void displayMessage2(String m); 
   void displayRecord2(Vehicle p);
   void displayMaxAndCurrent2(int c);
   void setBrowsing2(Boolean f); 
  String getQueryTextField(); 
   
}  // END OF CLASS
