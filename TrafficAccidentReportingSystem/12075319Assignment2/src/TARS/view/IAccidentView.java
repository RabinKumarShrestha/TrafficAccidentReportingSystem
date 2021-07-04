/*
 Interface class. It posses the method to be called by the view
 */
package TARS.view;

import TARS.model.Accident;
import TARS.presenter.AccidentPresenter;

/**
 12075319
 * @author sthra
 */



// CREATING INTERFACE CLASS FOR ACCIDENTVIEW
public interface IAccidentView {
   
    public void show(AccidentPresenter AP);
     
   void displayMessage(String m); 
   void displayRecord(Accident p);
   void displayMaxAndCurrent(int c);
    void setBrowsing(Boolean f); 
   
} // END OF CLASS
