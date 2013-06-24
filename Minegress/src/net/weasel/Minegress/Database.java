package net.weasel.Minegress;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database 
{
	public static ResultSet db_execute( String query )
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
	
	public static boolean db_player_exists( String player ) throws SQLException
	{
		Boolean exists = false;
		String query = "SELECT COUNT(*) FROM minegress.players WHERE name = '" + player + "';";
		ResultSet result = db_execute( query );

		if( result.next() )
		{
			if( result.getInt("COUNT(*)") > 0 )
			{
				exists = true;
			}
		}
		
		result.close();
		
		return( exists );
	}
	
	public static boolean db_create_player( String player ) throws SQLException
	{
		boolean created = false;
		
		if( db_player_exists( player ) == false )
		{
			String player_id = db_new_player_id();
			
			String query = "INSERT INTO minegress.players VALUES ('" + player + ",'" + player_id + "','','','','','','';";
			ResultSet result = db_execute( query );
			result.close();
			
			if( db_player_exists( player ) == true )
			{
				created = true;
			}
		}

		return( created );
	}
	
	public static String db_new_player_id() throws SQLException
	{
		String player_id = "";
		String hex = "";

		int number = 0;
		int min = 1;
		int max = 8;
		
		for( int x = 0; x < max; x++ )
		{
			number = ( min + (int)( Math.random() * ( ( max - min ) + 1 ) ) );
			
			hex = Integer.toHexString( number );
			
			if( number < 10 )
			{
				hex = "0" + hex;
			}
			
			player_id = player_id + hex;
		}
		
		if( db_player_id_exists( player_id ) == true )
		{
			player_id = db_new_player_id();
		}
		
		return( player_id );
	}

	public static boolean db_player_id_exists( String player_id ) throws SQLException
	{
		Boolean exists = false;
		String query = "SELECT COUNT(*) FROM minegress.players WHERE player_id = '" + player_id + "';";
		ResultSet result = db_execute( query );

		if( result.next() )
		{
			if( result.getInt("COUNT(*)") > 0 )
			{
				exists = true;
			}
		}
		
		result.close();
		
		return( exists );
	}
	
}
