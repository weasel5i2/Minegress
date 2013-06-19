package net.weasel.Minegress;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database 
{
	public static ResultSet read_database( String query )
	{
		Connection conn = null;
		Statement statement = null;
		ResultSet results = null;
		
		try 
		{
			String username = "mingress";
			String password = "VTsJnxYURjfBAR4F";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost/minegress?" + "user=" + username + "&password=" + password );
			statement = conn.createStatement();
			results = statement.executeQuery( query );
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return results;
	}
}
