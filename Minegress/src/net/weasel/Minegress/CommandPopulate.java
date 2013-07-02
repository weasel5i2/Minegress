package net.weasel.Minegress;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.kumpelblase2.remoteentities.api.RemoteEntity;
import de.kumpelblase2.remoteentities.api.RemoteEntityType;
import de.kumpelblase2.remoteentities.api.thinking.goals.DesireLookRandomly;
import de.kumpelblase2.remoteentities.api.thinking.goals.DesireMoveToLocation;

public class CommandPopulate implements CommandExecutor 
{
	public Minegress plugin;

	public static void logOutput( String message ) { Minegress.logOutput( message ); }
	 	
	public CommandPopulate(Minegress plugin)
	{        
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) 
	{
		if( sender instanceof Player )
		{
			Player player = (Player)sender;
			
			String name = Population.get_random_npc_name();
			
			RemoteEntity entity = ( Population.manager).createNamedEntity( RemoteEntityType.Human, player.getTargetBlock( null, 100 ).getLocation(), name );
		
			entity.getMind().addTargetingDesire( new DesireLookRandomly( entity ), 10 );
			entity.save();

			entity.spawn( player.getTargetBlock( null, 100 ).getLocation() );

			Location destination = Population.i_spy( entity, 32 );
			
			if( destination != null )
			{
				DesireMoveToLocation walk_to = new DesireMoveToLocation( entity, destination );
				entity.getMind().addMovementDesire( walk_to, 32 );
				walk_to.startExecuting();
				// logOutput( "NPC " + entity.getID() + " initial walk_to: " + (int)destination.getX() + "," + (int)destination.getY() + "," + (int)destination.getZ() + "." );
			}
			
			return false;
		}
		
		return false;
	}
}
