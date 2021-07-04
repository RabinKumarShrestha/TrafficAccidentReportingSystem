/*
// different methods to give command to view 
*/
package TARS.presenter;

import TARS.model.IVehicleModel;
import TARS.model.Vehicle;
import TARS.view.IVehicleView;
import java.util.List;

/**
 *12075319
 * @author sthra
 */

// CLASS VEHICLE PRESENTER
public class VehiclePresenter {   
    IVehicleView view;
    IVehicleModel model2;
    int currentEntryIndex;
    int numberOfEntries;
    Vehicle currentEntry;
    List< Vehicle > results;
        
    // PARAMATERIZED CONSTRUCTOR FOR VEHICLEPRESENTER
    public VehiclePresenter(IVehicleView IVV, IVehicleModel IVM) {
        view = IVV;
        model2 = IVM;
        currentEntryIndex = 0;
        numberOfEntries = 0;
        results = null;
        currentEntry = null;
       System.out.println("Accident presenter is successfully accessed");   
    }
    
   
   // handles call when insertButton is clicked
   public void insertNewEntry(String vehicle_Id,String model, int make_Year, String owner_Name, String address, String phone) {
      try{
       int result = model2.addVehicle ( vehicle_Id, model, make_Year,owner_Name, address, phone );
      if ( result == 1 )
          view.displayMessage2("Vehicle added");
      else
          view.displayMessage2("Vehicle not added");
          }
      catch(Exception e){
      System.out.println("Error in entering data");
      System.out.println("Check the data type and is not null");
      }
     
   }
   
   
   // HANDLES UPDATE BUTTON CALLS
    public void updateEntry(String vehicle_Id,String model, int make_Year, String owner_Name, String address, String phone) {
      
      try{
        int result = model2.updateVehicle ( vehicle_Id, model, make_Year,owner_Name, address, phone );
      if ( result == 1 )
          view.displayMessage2("Vehicle updated ");
      else
          view.displayMessage2("Vehicle not updated   ");
          
     }
      
      catch(Exception e){
          System.out.println("Error while updating vehicle");
      }
   }
   
    
    // METHOD TO POPULATE ALL TEXT FIELD
    private void populateAllTextFields() {
        
        view.displayRecord2(currentEntry);
        view.displayMaxAndCurrent2(currentEntryIndex);
    }
   
   

// handles window closure
   public void close() {
      model2.close();
   }



   // HANDLES ALL METHODS IF BROWSE IS CLICKED
   public void browse() {
      try {
         results = model2.getAllVehicles();
         
         numberOfEntries = results.size();
         if(numberOfEntries ==0)
             view.displayMessage2("No records to browse");
         if ( numberOfEntries != 0 ) {
            currentEntryIndex = 0;
            currentEntry = results.get( currentEntryIndex );
            populateAllTextFields();
            view.setBrowsing2(true);
         }
      }
      
      catch ( Exception e ) {
          
          System.out.println("Error while browsing data");
      }
   }
   

   
// handles call when previousButton is clicked
   public void showPrevious() {   
      currentEntryIndex--;
      // wrap around
      if ( currentEntryIndex < 0 )
         currentEntryIndex = numberOfEntries - 1;
      currentEntry = results.get( currentEntryIndex );
      populateAllTextFields();
   }

   // handles call when nextButton is clicked
   public void showNext() {
      currentEntryIndex++;
      // wrap around
      if ( currentEntryIndex >= numberOfEntries )
         currentEntryIndex = 0;
      currentEntry = results.get( currentEntryIndex );
      populateAllTextFields();
   }

   
   
   // METHOD TO PERFORM QUERY BASED ON NUMBERPLATE
   public void performQueryByNumberPlate() {
       
   try{
    // results = model2.getAccidentsByID( id );
     
     results = model2.getVehicleByNumberPlate ( view.getQueryTextField() );
     
     numberOfEntries = results.size();
      
      
      if ( numberOfEntries != 0 ) {
         currentEntryIndex = 0;
         currentEntry = results.get( currentEntryIndex );
         populateAllTextFields();
         view.setBrowsing2(true);
         
      } 
      else
        view.displayMessage2("Not found");
   }
  catch(Exception E){
      System.out.println(" You occured with error while searching vehicle ");
  
  } 
   }

   
} // end of class

