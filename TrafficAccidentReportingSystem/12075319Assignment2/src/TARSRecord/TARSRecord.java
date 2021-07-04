/*
Main class
Loads the Accident view as soon as the program is executed.
 */
package TARSRecord;

import TARS.model.AccidentModel;
import TARS.model.IAccidentModel;
import TARS.presenter.AccidentPresenter;
import TARS.view.AccidentView;
import TARS.view.IAccidentView;

/**
 *12075319
 * @author sthra
 */
public class TARSRecord {

    // MAIN METHOD
    public static void main(String[] args) {
        
 // CHECKING IF THE MAIN METHOD IS LOADED OR NOT       
 System.out.println("Main page is successfully accessed");
 // CREATING ACCIDENTMODEL OBJECT 
 IAccidentModel IAM = new AccidentModel();
 // CREATING ACCIDENTVIEW OBJECT
 IAccidentView IAV = new AccidentView();
 //CREATING PRESENTER OBJECT AND PASSING ACCIDENTVIEW AND ACCIDENTMODEL TO PRESENTER 
  AccidentPresenter AP = new AccidentPresenter( IAV, IAM);
  // DISPLAYING THE ACCIDENTVIEW USING PRESENTER
 IAV.show(AP);
  

}
    
}
// end of clss

