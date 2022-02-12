package GenericUtility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * THIS CLASS CONTAINS GENERIC METHODS TO CONNECT TO DATABASE
 * @author VINAYAKARAM J
 *
 */
public class DataBaseUtility {

	Connection con = null;
	//STEP 1: REGISTER THE DATABASE--1
	//STEP 2: GET CONNECTION WITH DB--1
	//STEP 3: ISSUE CTRATE STATEMENT---2
	//STEP 4: EXECUTE QUERY---2
	//STEP 5: CLOSE CONNECTION ----3
	
	/**
	 * THIS METHOD WILL ESTABLISH CONNECTION WITH DATABASE
	 * 
	 */
public void connectDb() throws Throwable {
	
		Driver Driverref=new Driver();
		DriverManager.registerDriver(Driverref);
		  con = DriverManager.getConnection(Iconstants.dbURL, Iconstants.dbUserName, Iconstants.dbPassword);
		 
		}

     /**
      * this method will execute query and return the data present in database
      * @param Query
      * @param colunindex
      * @param expData
      * @return
      * @throws SQLException
      */

	 public String executequeryAndgetData(String Query,int colunindex,String expData) throws SQLException {
		 boolean flag=false;
		ResultSet result = con.createStatement().executeQuery(Query);
	 
	while(result.next())
	{
		 String value = result.getString(colunindex);
		 if(value.equalsIgnoreCase(expData))
		 {
			 flag=true;//raise the flag
			 break;
		 }
	}
	if(flag)
	{
		System.out.println(expData+" Data Verified");
		return expData;
	}
	else {
		System.out.println("data not present");
		return " ";
	}
	 }
	 
	 /**
	  * this method will close the database connection 
	  * @throws Throwable
	  */
	 public void closeDB() throws Throwable {
		 
		con.close();
	 }
}