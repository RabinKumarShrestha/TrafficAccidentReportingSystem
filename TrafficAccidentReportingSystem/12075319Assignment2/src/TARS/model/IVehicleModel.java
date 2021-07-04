/*
 //These method are to be called by vehicleModel 
*/
package TARS.model;

import java.util.List;

/**
 *12075319
 * @author sthra
 */

// CREATING INTERFACE CLASS FOR VEHICLEMODEL
public interface IVehicleModel {
    
    public List<Vehicle> getAllVehicles(); 
    public int addVehicle(String vehicle_Id, String model, int make_Year, String owner_Name, String address, String phone);
   
    public void close();

    public int updateVehicle(String vehicle_Id, String model, int make_Year, String owner_Name, String address, String phone);
    public List<Vehicle> getVehicleByNumberPlate(String  vehicle_Id );
    
} // END OF CLASS
