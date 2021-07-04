/*
To connect vehicle class to database 
*/
package TARS.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *12075319
 * @author sthra
 */


// CREATING VEHICLEMODEL CLASS TO IMPLEMET ALL THE METHODS OF INTERFACE VEHICLEMODEL CLASS
public class VehicleModel implements IVehicleModel
{ 
    
    // DECLARING THE DATABASE URL
   private static final String URL = "jdbc:derby://localhost:1527/assignment";
   
   // USERNAME AND PASSWORD OF ASSIGNMENT DATABASE
   private static final String USERNAME = "rabin";
   private static final String PASSWORD = "rabin";

   private Connection connection = null; // manages connection
  
   // DECLARING PREPARED STATEMENTS TO USE FOR DATABASE QUERY
   private PreparedStatement insertNewVehicle = null; 
   private PreparedStatement selectAllVehicles = null;
   private PreparedStatement selectVehicleByNumberPlate = null; 
   private PreparedStatement updateVehicle = null;
   
   
   
// CONSTRUCTOR FOR VEHICLEMODEL
   public VehicleModel()
   {
      try 
      {
          
          // TO CHECK IF THE VEHICE MODEL IS CALLED OR NOT
          System.out.println("Model vehicle is successfully accessed");
         
          // CREATING CONNECTION BETWEEN DATABASE AND VEHICLEMODEL
          connection = 
            DriverManager.getConnection( URL, USERNAME, PASSWORD );

          // SELECTING ALL THE DETAILS FROM VEHICLE DATABASE 
          selectAllVehicles = 
            connection.prepareStatement( "SELECT * FROM Vehicle" );
           
        
         // TO INSERT NEW VEHICLE RECORD
         insertNewVehicle = connection.prepareStatement( 
            "INSERT INTO Vehicle " + 
            "( Vehicle_Id, Model, Make_Year, Owner_Name, Address, Phone ) " + 
            "VALUES ( ?, ?, ?, ?, ?, ? )" );
         
         // SELECTING VEHCILES RECORD BASED ON NUMBE PLATE
         selectVehicleByNumberPlate = connection.prepareStatement( 
            "SELECT * FROM Vehicle WHERE Vehicle_Id = ?" );
         
         // TO UPDATE THE VEHICLES
         updateVehicle = connection.prepareStatement( 
                 "UPDATE VEHICLE SET Vehicle_Id = ?, Model= ?, Make_Year= ?, Owner_Name= ?, Address= ?, Phone= ? " );
         
         
         
      } // end try
      catch ( SQLException sqlException )
      {
          System.out.println("Error in vehicel database connection");
         System.exit( 1 );
      } // end catch
   } // end VehicleModel constructor

   
   // TO ADD VEHICLE RECORD 
   public int addVehicle( String vehicle_Id, String model, int make_Year, String owner_Name, String address, String phone )
   {
      int result = 0;
      
      // set parameters, then execute insertNewPatient
      try 
      {
         
         insertNewVehicle.setString( 1, vehicle_Id );
         insertNewVehicle.setString( 2, model );
         insertNewVehicle.setInt( 3, make_Year );
         insertNewVehicle.setString( 4, owner_Name  );
         insertNewVehicle.setString( 5, address );
         insertNewVehicle.setString( 6, phone );
         

         // insert the new entry; returns # of rows updated
         result = insertNewVehicle.executeUpdate(); 
      } // end try
      catch ( SQLException sqlException )
      {
         close();
      } // end catch
      
      return result;
   } // end method addAccident
   
   
   // METHOD TO UPDATE VEHICLE RECORD
   public int updateVehicle( String vehicle_Id, String model, int make_Year, String owner_Name, String address, String phone )
   {
      int result = 0;
      
      // set parameters, then execute insertNewPatient
      try 
      {
         
         insertNewVehicle.setString( 1, vehicle_Id );
         insertNewVehicle.setString( 2, model );
         insertNewVehicle.setInt( 3, make_Year );
         insertNewVehicle.setString( 4, owner_Name  );
         insertNewVehicle.setString( 5, address );
         insertNewVehicle.setString( 6, phone );
         

         // insert the new entry; returns # of rows updated
         result = updateVehicle.executeUpdate(); 
      } // end try
      catch ( Exception e )
      {
         close();
         System.out.println("Error  while updating record");
         System.out.println("Check if the data is null or not");
      } // end catch
      
      return result;
   } // end method addAccident
   
   
   // sELECT ALL VEHICLE FROM DATABASE
   public List< Vehicle > getAllVehicles()
   {
      List< Vehicle> results = null;
      ResultSet resultSet = null;
      
      try 
      {
         // executeQuery returns ResultSet containing matching entries
         resultSet = selectAllVehicles.executeQuery(); 
         results = new ArrayList< Vehicle>();
         
         while ( resultSet.next() )
         {
            results.add( new Vehicle (
               resultSet.getString( "Vehicle_ID" ),
               resultSet.getString( "Model" ),
               resultSet.getInt( "Make_Year" ),
               resultSet.getString("Owner_Name"),
               resultSet.getString("Address"),
               resultSet.getString("phone"))
                 );
         } // end while
      } // end try
      catch ( SQLException sqlException )
      {
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();         
            close();
         } // end catch
      } // end finally
      
      return results;
   } // end method getAllAccident
   
   
   
   // SELECTING VEHICLES BASED ON NUMBER PLATE
   public List< Vehicle > getVehicleByNumberPlate( String vehicle_Id)
   {
      List< Vehicle> results = null;
      ResultSet resultSet = null;
      
      try 
      {
        
        selectVehicleByNumberPlate.setString( 1, vehicle_Id );          
        // executeQuery returns ResultSet containing matching entries
         resultSet = selectVehicleByNumberPlate.executeQuery(); 
         results = new ArrayList< Vehicle>();
         
         while ( resultSet.next() )
         {
            results.add( new Vehicle (
               resultSet.getString( "Vehicle_ID" ),
               resultSet.getString( "Model" ),
               resultSet.getInt( "Make_Year" ),
               resultSet.getString("Owner_Name"),
               resultSet.getString("Address"),
               resultSet.getString("phone"))
                 );
         } // end while
      } // end try
      catch ( SQLException sqlException )
      {
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();         
            close();
         } // end catch
      } // end finally
      
      return results;
   } // end method getAllAccident
   
   
   
   
   
   
   
   public void close()
   {
      try 
      {
         connection.close();
      } // end try
      catch ( SQLException sqlException )
      {
      } // end catch
   } // end method close


   
} // end class

