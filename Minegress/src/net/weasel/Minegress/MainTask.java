package net.weasel.Minegress;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class MainTask extends BukkitRunnable
{
	@SuppressWarnings("unused")
	private static JavaPlugin plugin;
	
	public static void logOutput( String message ) { Minegress.logOutput( message ); }
	public static void debugOutput( String message ) { Minegress.debugOutput( message ); }

	public MainTask( Minegress instance )
    {        
    	plugin = instance;
    }

	@Override
	public void run() 
	{
		// Do the portal upkeep, xm expression, etc..
		//
	}

}
