/*
 *To define Accident class variable
 */
package TARS.model;

import java.sql.Timestamp;

/**
 *
 * @author sthra
 * 12075319 
 */
public class Accident
{
 // DECLARING ACCIDENTID VARIABLE
       private int accidentID;
 // DECLARING LOCATION VARIABLE
       private String location;
 // DECLARING COMMENTS VARIABLE
       private String comments;
   // DECLARING TIMESTAMP VARIABLE
       private Timestamp accident_Date;
  

// no-argument constructor, DEFAULT CONSTRUCTOR FOR ACCIDENT CLASS
   public Accident()
   {
   } // end no-argument Accident constructor


   // PARAMATERIZED CONSTRUCTOR FOR ACCIDENT CLASS
    public Accident(int accidentID, String location, String comments, Timestamp accident_Date) {
        this.accidentID = accidentID;
        this.location = location;
        this.comments = comments;
        this.accident_Date = accident_Date;
    }


    // GETTERS AND SETTERS  FOR ALL DECLARED VARIABLE
    public Timestamp getAccident_Date() {
        return accident_Date;
    }

    public void setAccident_Date(Timestamp accident_Date) {
        this.accident_Date = accident_Date;
    }

   
    

   
    public int getAccidentID() {
        return accidentID;
    }

    public void setAccidentID(int accidentID) {
        this.accidentID = accidentID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
   
} // end class ACCIDENT


