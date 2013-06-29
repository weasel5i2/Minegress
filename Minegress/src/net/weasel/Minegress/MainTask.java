package net.weasel.Minegress;

import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import de.kumpelblase2.remoteentities.EntityManager;
import de.kumpelblase2.remoteentities.RemoteEntities;
import de.kumpelblase2.remoteentities.api.RemoteEntity;

public class MainTask extends BukkitRunnable
{
	private final JavaPlugin plugin;
	
	public static void logOutput( String message ) { Minegress.logOutput( message ); }

	public MainTask(Minegress plugin)
    {        
    	this.plugin = plugin;
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
		
		logOutput( "MainTask tick.." );
		
		EntityManager manager = RemoteEntities.createManager( plugin );

		List<RemoteEntity> npc_list = manager.getAllEntities();

		RemoteEntity npc = null;
		
		while( npc_list.iterator().hasNext() )
		{
			npc = npc_list.iterator().next();
			
			Population.business_as_usual( npc );
		}
		
	}

}
