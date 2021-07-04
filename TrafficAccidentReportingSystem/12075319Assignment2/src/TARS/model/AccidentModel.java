/*
to connect accident class to database 
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

// ACCIDENT CLASS IMPLEMENTING ALL THE METHODS OF INTERFACE IACCIDENTMODEL
public class AccidentModel implements IAccidentModel
{
    // DATABASE URL TO CONNECT TO DATABASE
    private static final String URL = "jdbc:derby://localhost:1527/assignment";
   // USERNAME AND PASSWORD USED IN THE DATABASE
    private static final String USERNAME = "rabin";
   private static final String PASSWORD = "rabin";

   private Connection connection = null; // manages connection
   
   // DECLARING PREPARED STATEMENTS TO BE USED IN DATABASE
   private PreparedStatement insertNewAccident = null; 
   private PreparedStatement selectAllAccidents = null;
   private PreparedStatement selectAccidentsByID = null;
   private PreparedStatement deleteAccidentsByID = null;
   private PreparedStatement updateAccident = null;
   
      
   // constructor FOR ACCIDENTMODEL
   public AccidentModel()
   {
      try 
      {
          // CHECKING IF THE ACCIDENTMODEL IS LOADING OR NOT
          System.out.println("Model is successfully accessed");
         // ESTABLISHING CONNECTION TO DATABASE
          connection = 
            DriverManager.getConnection( URL, USERNAME, PASSWORD );

          // SQL QUERY TO GET ALL THE ACCIDENTS FROM THE RECORD
           selectAllAccidents = 
            connection.prepareStatement( "SELECT * FROM ACCIDENT" );
           
              
          // create query that selects entirs with a specific id
          
         selectAccidentsByID = connection.prepareStatement( 
            "SELECT * FROM ACCIDENT WHERE AccidentID = ?" );
         
         // for inserting new accident
         insertNewAccident = connection.prepareStatement( 
            "INSERT INTO ACCIDENT " + 
            "( Location, Comments ) " + 
            "VALUES ( ?, ? )" );
         
         //delete accident by Id
         deleteAccidentsByID = connection.prepareStatement( 
            "INSERT INTO ACCIDENT " + 
            "( Location, Comments ) " + 
            "VALUES ( ?, ? )" );
         
        // to update the accident 
         updateAccident = connection.prepareStatement( 
            "UPDATE ACCIDENT SET Location = ?, Comments = ? " );
         

      } // end try
      catch ( SQLException sqlException )
      {
          System.out.println("Error in accident database connection");
         System.exit( 1 );
      } // end catch
   } // end AccidentModel constructor

   
   // METHOD TO ADD NEW ACCIDENT
   public int addAccident( 
      String location, String comments )
   {
      int result = 0;
      
      // set parameters, then execute insert New Accident
      try 
      {
         // INSERTING ACCIDENT RECORD TO DATABASE COLUMN2 AND COLUMN3
         insertNewAccident.setString( 1, location );
         insertNewAccident.setString( 2, comments );

         // insert the new entry; returns # of rows updated
         result = insertNewAccident.executeUpdate(); 
      } // end try
      catch ( SQLException sqlException )
      {
         close();
      } // end catch
      
      return result;
   } // end method addAccident
   
   
   
   // METHOD TO DELETE ACCIDENT
   public int deleteAccident( 
      String location, String comments )
   {
      int result = 0;
      
      // set parameters, then execute delete Accident
      try 
      {
         
          // DELETING ACCIDENT RECORD FROM DATABASE
         deleteAccidentsByID.setString( 1, location );
         deleteAccidentsByID.setString( 2, comments );

         // DELETING ACCIDNETS RECORD BASED ON ID
         result = deleteAccidentsByID.executeUpdate(); 
      } // end try
      catch ( SQLException sqlException )
      {
         close();
      } // end catch
      
      return result;
   } // end method addAccident
   
   
   
   
   // select all of the Accident in the database
   public List< Accident > getAllAccidents()
   {
      List< Accident> results = null;
      ResultSet resultSet = null;
      
      try 
      {
         // executeQuery returns ResultSet containing matching entries
         resultSet = selectAllAccidents.executeQuery(); 
         results = new ArrayList< Accident>();
         
         while ( resultSet.next() )
         {
            results.add( new Accident (
               resultSet.getInt( "AccidentID" ),
               resultSet.getString( "Location" ),
               resultSet.getString( "Comments" ),
               resultSet.getTimestamp("accident_Date"))
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
   
   
   
   // METHOD TO GET ACCIDENT BASED ON ACCIDENTID
   public List< Accident > getAccidentsByID( int id )
   {
      List< Accident > results = null;
      ResultSet resultSet = null;

      try 
      {
         selectAccidentsByID.setInt( 1, id ); // specify id

         // executeQuery returns ResultSet containing matching entries
         resultSet = selectAccidentsByID.executeQuery(); 

         results = new ArrayList< Accident >();

         while ( resultSet.next() )
         {
            results.add( new Accident(
               resultSet.getInt( "AccidentID" ),
               resultSet.getString( "Location" ),
               resultSet.getString( "Comments" ),
                    resultSet.getTimestamp("accident_Date")
                ) );
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
            close();
         } // end catch
      } // end finally
      
      return results;
   } // end method getByid
   
   
  // METHOD TO CLOSE THE CONNECTION
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

    
    // METHOD TO UPDATE ACCIDENT
    public int updateAccident( 
      String location, String comments )
   {
      int result = 0;
      
      // set parameters, then execute insertNewPAccident
      try 
      {
         
         updateAccident.setString( 1, location );
         updateAccident.setString( 2, comments );

         // insert the new entry; returns # of rows updated
         result = updateAccident.executeUpdate(); 
      } // end try
      catch ( SQLException sqlException )
      {
         close();
         System.out.println("Error while updating output");
      } // end catch
      
      return result;
   } // end method addAccident
  
   
} // end class

