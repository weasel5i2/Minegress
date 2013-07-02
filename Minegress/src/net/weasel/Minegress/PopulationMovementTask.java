package net.weasel.Minegress;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import de.kumpelblase2.remoteentities.api.RemoteEntity;
import de.kumpelblase2.remoteentities.api.thinking.goals.DesireMoveToLocation;

public class PopulationMovementTask extends BukkitRunnable
{
	@SuppressWarnings("unused")
	private static JavaPlugin plugin;
	private static RemoteEntity entity;
	
	public static void logOutput( String message ) { Minegress.logOutput( message ); }

	public PopulationMovementTask( Minegress instance, RemoteEntity npc )
    {        
    	plugin = instance;
    	entity = npc;
    }

	@Override
	public void run() 
	{
		// logOutput( "PopMoveTask invoked for NPC " + entity.getID() );
		Location destination = Population.i_spy( entity, 32 );
		
		if( destination != null )
		{
			DesireMoveToLocation walk_to = new DesireMoveToLocation( entity, destination );
			entity.getMind().addMovementDesire( walk_to, 32 );
			
			walk_to.startExecuting();
			
			// logOutput( "NPC " + entity.getID() + " arrived. Now walking to: " + (int)destination.getX() + "," + (int)destination.getZ() + "." );
		}
		
		this.cancel();
	}	
}