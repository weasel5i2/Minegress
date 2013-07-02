package net.weasel.Minegress;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class MainTask extends BukkitRunnable
{
	@SuppressWarnings("unused")
	private static JavaPlugin plugin;
	
	public static void logOutput( String message ) { Minegress.logOutput( message ); }

	public MainTask( Minegress instance )
    {        
    	plugin = instance;
    }

	@Override
	public void run() 
	{
		// Do the portal upkeep, xm expression, etc..
		//
		
		// Entity npc = Population.get_random_npc( plugin );
		
		// if( npc != null )
		// {
		// 	npc.setVelocity( npc.getLocation().getDirection() );
		// }
		
		// logOutput( "MainTask tick.." );

		if( Minegress.init_population_done == false )
		{
			Population.init();
			Minegress.init_population_done = true;
		}
	}

}
