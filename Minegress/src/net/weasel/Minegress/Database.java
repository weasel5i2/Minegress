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
			
			if( db_player_exists( player ) == true )
			{
				created = true;
			}

			result.close();
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
		boolean exists = false;
		String query = "SELECT COUNT(*) FROM minegress.players WHERE player_id = '" + player_id + "';";
		ResultSet result = db_execute( query );

		if( result.next() )
		{
			if( result.getInt( "COUNT(*)" ) > 0 )
			{
				exists = true;
			}
		}
		
		result.close();
		
		return( exists );
	}
	
	public static double[] db_get_portal_location( String portal_id ) throws SQLException
	{
		double pos_x = -1;
		double pos_y = -1;
		double pos_z = -1;
		
		String query = "SELECT * FROM minegress.portals WHERE portal_id = '" + portal_id + "';";
		ResultSet result = db_execute( query );
		
		if( result.next() )
		{
			if( result.getString( "portal_id" ) == portal_id )
			{
				pos_x = Double.parseDouble( result.getString( "portal_x" ) );
				pos_y = Double.parseDouble( result.getString( "portal_y" ) );
				pos_z = Double.parseDouble( result.getString( "portal_z" ) );
			}
		}
		
		result.close();

		double[] location = { pos_x, pos_y, pos_z };

		return( location );
	}
	
	public static boolean db_check_portal_proximity( String portal_id, int distance ) throws SQLException
	{
		boolean portal_too_close = false;
		
		double pos_x, pos_z, prox_x1, prox_z1, prox_x2, prox_z2;
		
		double[] portal_location = db_get_portal_location( portal_id );
		
		pos_x = portal_location[0];
		pos_z = portal_location[2];
		
		prox_x1 = pos_x + distance;
		prox_x2 = pos_x - distance;
		
		prox_z1 = pos_z + distance;
		prox_z2 = pos_z - distance;
		
		String query = "SELECT COUNT(*) FROM minegress.portals WHERE ( location_x <= " + prox_x1 + " AND location_z <= " + prox_z1 + " ) OR ";
		query += "( location_x >= " + prox_x2 + " AND location_z >= " + prox_z2 + " );";
		
		ResultSet result = db_execute( query );
		
		if( result.getInt( "COUNT(*)" ) > 0 )
		{
			portal_too_close = true;
		}
		
		result.close();

		return( portal_too_close );
	}
}