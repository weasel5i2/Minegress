package net.weasel.Minegress;

import java.io.File;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Minegress extends JavaPlugin 
{
	public static String pluginName = "";
	public static String pluginVersion = "";
	public static String pluginIni = "plugins/Minegress/settings.ini";
	public static Server server = null;
	public static ConsoleCommandSender console = null;
	public static boolean pluginEnabled = false;

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
		
		new Listeners(this);
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
}