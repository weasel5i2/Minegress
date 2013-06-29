package net.weasel.Minegress;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.kumpelblase2.remoteentities.api.RemoteEntity;
import de.kumpelblase2.remoteentities.api.RemoteEntityType;

public class CommandPopulate implements CommandExecutor 
{
	public Minegress plugin;
	 	
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
			
			RemoteEntity entity = Minegress.manager.createNamedEntity(RemoteEntityType.Human, player.getTargetBlock( null, 100 ).getLocation(), name );
				
			entity.save();
			
			entity.spawn( player.getTargetBlock( null, 100 ).getLocation() );
			
			return false;
		}
		
		return false;
	}
}
