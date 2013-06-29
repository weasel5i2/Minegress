package net.weasel.Minegress;

import java.io.File;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import de.kumpelblase2.remoteentities.EntityManager;
import de.kumpelblase2.remoteentities.RemoteEntities;

public class Minegress extends JavaPlugin 
{
	public static String pluginName = "";
	public static String pluginVersion = "";
	public static String pluginIni = "plugins/Minegress/settings.ini";
	public static Server server = null;
	public static ConsoleCommandSender console = null;
	public static boolean pluginEnabled = false;
	public static EntityManager manager = null;
	
	public static int map_x = 0;
	public static int map_z = 0;
	public static Player map_agent = null;
	public static int map_min = -4096;
	public static int map_max = 4096;
	public static int map_step_x = 32;
	public static int map_step_z = 32;
	public static int map_interval = 33;

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
		
		manager = RemoteEntities.createManager( this );
	
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
		addCommand("mapper", new CommandMapper(this));
		addCommand("mknpc", new CommandPopulate(this));

		new Listeners(this);
		new Population(this);
		
		Population.init_names();
		
		new MainTask(this).runTaskTimer( this, 1, 30 );
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
    
    public static Location getTopBlock( Location loc )
    {
    	World world = loc.getWorld();
    	Block block = null;
    	Block above = null;
    	
    	double x = loc.getX();
    	double y = loc.getY();
    	double z = loc.getZ();
    	
    	for( double c = 255; c >= y; c-- )
    	{
    		block = world.getBlockAt( (int)x, (int)y, (int)z );
    		above = world.getBlockAt( (int)x, (int)y+1, (int)z );
    		
    		if( above.getTypeId() == 0 && block.getTypeId() != 0 )
    		{
    			loc = new Location( world, x, y, z );
    			break;
    		}
    	}
    	
		return loc;
    	
    }
}
