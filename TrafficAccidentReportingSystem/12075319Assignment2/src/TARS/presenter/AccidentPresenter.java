/*
// Defining meyhods that give command to view
 */
package TARS.presenter;

import TARS.model.Accident;
import TARS.model.IAccidentModel;
import TARS.view.IAccidentView;
import java.util.List;

/**
 *12075319
 * @author sthra
 */

// CREATING CLASS ACCIDENTPRESENTER
public class AccidentPresenter {   
    IAccidentView view;
    IAccidentModel model;
    int currentEntryIndex;
    int numberOfEntries;
    Accident currentEntry;
    List< Accident > results;

    // CONSTRUCTOR FOR ACCIDENT PRESENTER
    // PASSING ACCIDENTVIEW AND ACCIDENTMODEL TO ACCIDENTPRESENTER
    public AccidentPresenter(IAccidentView IAV, IAccidentModel IAM) {
        view = IAV;
        model = IAM;
        currentEntryIndex = 0;
        numberOfEntries = 0;
        results = null;
        currentEntry = null;
    System.out.println("Accident presenter is successfully accessed");   
    }
    
   
   // handles call when insertButton is clicked
   public void insertNewEntry(String location,String comments) {
      
       try{
       int result = model.addAccident(location, comments );
      if ( result == 1 )
          view.displayMessage("Accident added");
      else
          view.displayMessage("Accident not added");
       }
       
       catch(Exception e){
      System.out.println("Error in entering data");
      System.out.println("Check the data type and is not null");
      }
     
   }
   
   // ACCIDENT PRESENTER METHOD
   public void updateAccident(String location,String comments) {
     
       try{
       
       int result = model.updateAccident(location, comments );
      if ( result == 1 )
          view.displayMessage(" Updated Accident    ");
      else
          view.displayMessage("    Accident not updated    ");
          }
     catch(Exception e)
               {
               System.out.println("Error while updating Accident Record");
               }
   }
   
   
   
    // handles call when insertButton is clicked
   public void deleteAccidentsByID(String location,String comments) {
      
       int result = model.deleteAccident(location, comments );
      if ( result == 1 )
          view.displayMessage("Accident deleted");
      else
          view.displayMessage("Accident not deetdeddd");
          
      //browse();
   }
   
   
   
  // METHOD TO POPULATE ALL TEXTFIELDS
    private void populateAllTextFields() {
        
        view.displayRecord(currentEntry);
        view.displayMaxAndCurrent(currentEntryIndex);
    }
    
    
   
   // handles window closure
   public void close() {
      model.close();
   }
   
   
   // METHOD TO BROWSE ALL RECORDS
   public void browse() {
      
       try{
         results = model.getAllAccidents();
         
         numberOfEntries = results.size();
         if(numberOfEntries ==0)
             view.displayMessage("No records to browse");
         if ( numberOfEntries != 0 ) {
            currentEntryIndex = 0;
            currentEntry = results.get( currentEntryIndex );
            populateAllTextFields();
            view.setBrowsing(true);
         }
       }
       catch(Exception e){
       System.out.println("Error in browsing");
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


   // handles call when queryButton is clicked
   public void performQueryById(int id) {
       
    try{
     results = model.getAccidentsByID( id );
     
      numberOfEntries = results.size();
      if ( numberOfEntries != 0 ) {
         currentEntryIndex = 0;
         currentEntry = results.get( currentEntryIndex );
         populateAllTextFields();
         view.setBrowsing(true);
         
      } 
      else
        view.displayMessage(" RECORD QUERY Not found");
    }
    catch(Exception e){
    System.out.println("Error while performing query by id");
    }
   
   
   }
   

} // end of class

