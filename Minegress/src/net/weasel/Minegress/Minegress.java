package net.weasel.Minegress;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Minegress extends JavaPlugin 
{
	public static String pluginIni = "plugins/Minegress/settings.ini";
	public static boolean init_population_done = false;
	public static ConsoleCommandSender console = null;
	public static boolean pluginEnabled = false;
	public static String pluginVersion = "";
	public static String pluginName = "";
	public static Server server = null;

	public static ArrayList<Location> walk_to = new ArrayList<Location>();
	
	public static boolean debugMode = false;

	public static Player map_agent = null;
	public static int map_interval = 33;
	public static int map_min = -4096;
	public static int map_step_x = 32;
	public static int map_step_z = 32;
	public static int map_max = 4096;
	public static int map_x = 0;
	public static int map_z = 0;
	
    @Override
	public void onDisable() 
	{
		logOutput( getDescription().getName() + " v" + getDescription().getVersion() + " disabled." );
	}

	@Override
	public void onEnable() 
	{
		server = getServer();
		console = server.getConsoleSender();
		pluginName = getDescription().getName();
		pluginVersion = getDescription().getVersion();

		pluginInit();

		logOutput( getDescription().getName() + " v" + getDescription().getVersion() + " enabled." );
	}
	
	private void addCommand( String keyword, CommandExecutor exec ) 
	{
		PluginCommand cmd = getCommand(keyword);
		
		if( cmd == null || exec == null ) 
		{
			logOutput( "error: unable to register command '" + keyword + "'" );
		} 
		else 
		{
			cmd.setExecutor( exec );
		}
	}

	public void pluginInit()
	{
		File checkConfigDir = new File( "plugins/Minegress" );
		
		if( checkConfigDir.exists() == false )
		{
			checkConfigDir.mkdirs();
			logOutput( "Created new config directory." );
		}

		if( new File( "plugins/Minegress/debug.mode" ).exists() )
		{
			debugMode = true;
			debugOutput( "Debug mode active. rm plugins/Minegress/debug.mode to disable." );
		}

		if( checkPlugin("WorldEdit") == false )
		{
			logOutput( "error: this plugin requires the WorldEdit plugin.");
			logOutput( "error: you can download it at http://dev.bukkit.org/bukkit-mods/worldedit/" );			
		}

		if( checkPlugin("CityWorld") == false )
		{
			logOutput( "error: this plugin requires the CityWorld plugin.");
			logOutput( "error: you can download it at http://dev.bukkit.org/bukkit-mods/cityworld/" );			
		}
		
		addCommand("mkportal", new CommandMkportal(this));
		addCommand("mkxm", new CommandMkxm(this));
		addCommand("mapper", new CommandMapper(this));

		new Listeners(this);
		
		new MainTask(this).runTaskTimer( this, 1, 24 );
	}
	
	public boolean checkPlugin( String name )
	{
		if( server.getPluginManager().getPlugin(name) != null )
		{
			return( true );
		}
		
		return( false );
	}
	
    public static void logOutput( String message )
	{
		console.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + pluginName + ChatColor.GRAY + "] " + ChatColor.WHITE + message );
	}

    public static void debugOutput( String message )
	{
    	if( debugMode )
    	{
    		console.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + pluginName + ChatColor.GRAY + "] " + ChatColor.WHITE + message );
    	}
    }
}
