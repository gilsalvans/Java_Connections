package db_con;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Acces_db {
	public static void main(String[] args) {
		
		 try {
	  	      
	            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testing" , "postgres", "714625");
	            System.out.println("Connected to the PostgreSQL server successfully.");
	            PreparedStatement stat  = conn.prepareStatement("SELECT * FROM trips_count WHERE \"start station name\" = 'Ames St at Main St'");
	            ResultSet rs = stat.executeQuery();
	            while(rs.next()) {
	            	
	            	int id = rs.getInt("start station id");
	            	
	       	 	   //System.out.println(rs.getInt(1)+" "+rs.getString(2) + " " + rs.getString(3));  
	            	System.out.println(id);
	            
	            }
	            conn.close();
	            	
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	 
	      
	    }
		
		
			

	}

