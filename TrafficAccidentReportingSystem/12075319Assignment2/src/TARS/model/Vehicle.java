/*
// To define all the variables of the Vehicle class 
*/
package TARS.model;

/**
 *12075319
 * @author sthra
 */

// CREATING VEHICLE CLASS
public class Vehicle
{
  
    // DECLARING ALLL THE VARIABLES USED BY VEHICLE CLASSS
   private String vehicle_Id;
    private String model;
   private int make_Year;
   private String owner_Name;
   private String address;
   private String phone;
   
   
   
   // no-argument constructor(DEFAULT CONSTRUCTOR)
   public Vehicle()
   {
   } // end no-argument vehicle constructor

   
   
   
// parameterised constructor

    public Vehicle(String vehicle_Id, String model, int make_Year, String owner_Name, String address, String phone) {
        this.vehicle_Id = vehicle_Id;
        this.model = model;
        this.make_Year = make_Year;
        this.owner_Name = owner_Name;
        this.address = address;
        this.phone = phone;
    }
 
    
    // GETTERS AND SETTERS FOR THE DECLARED VARIABLES

    public String getVehicle_Id() {
        return vehicle_Id;
    }

    public void setVehicle_Id(String vehicle_Id) {
        this.vehicle_Id = vehicle_Id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMake_Year() {
        return make_Year;
    }

    public void setMake_Year(int make_Year) {
        this.make_Year = make_Year;
    }

    public String getOwner_Name() {
        return owner_Name;
    }

    public void setOwner_Name(String owner_Name) {
        this.owner_Name = owner_Name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
   
} //END OF CLASS VEHICLE
