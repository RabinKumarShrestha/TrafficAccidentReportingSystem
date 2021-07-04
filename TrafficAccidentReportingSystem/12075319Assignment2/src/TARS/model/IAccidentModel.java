/*
These method defined are to be called from AccidentModel
 */
package TARS.model;

import java.util.List;

/**
 *12075319
 * @author sthra
 */
// CREATING INTERFACE CLASS TO BE USED BY ACCIDENTMODEL
public interface IAccidentModel 
{
  
    public List<Accident> getAllAccidents(); 

    public int addAccident(String location,String comments);

    public int deleteAccident(String location,String comments);

    public void close();

    public List<Accident> getAccidentsByID(int id );
   
    public int updateAccident(String location,String comments);
    
    
    
    
    
} // end of class
