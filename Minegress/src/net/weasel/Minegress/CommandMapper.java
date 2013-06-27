package net.weasel.Minegress;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class CommandMapper implements CommandExecutor
{
	public Minegress plugin;
	
    public CommandMapper(Minegress plugin)
    {        
    	this.plugin = plugin;
    }

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) 
	{
		if( sender instanceof Player )
		{
			Minegress.map_agent = (Player)sender;

			String a1 = ( arg3.length > 0 ? arg3[0] : "" );
			String a2 = ( arg3.length > 1 ? arg3[1] : "" );

			if( a1 == "" )
			{
				Minegress.map_x = Minegress.map_min;
			}
			else
			{
				Minegress.map_x = Integer.parseInt(a1);
			}
			
			if( a2 == "" )
			{
				Minegress.map_z = Minegress.map_min;
			}
			else
			{
				Minegress.map_z = Integer.parseInt(a2);
			}
			
			Minegress.map_agent.sendMessage( "Starting mapping process (" + Minegress.map_x + "," + Minegress.map_z + " to " 
										    + ( Minegress.map_max - Minegress.map_x ) + "," + ( Minegress.map_max - Minegress.map_agent.getLocation().getY() ) + ").." );
			Minegress.map_agent.teleport( new Location( Minegress.map_agent.getWorld(), Minegress.map_min, Minegress.map_agent.getLocation().getY(), Minegress.map_min ) );

			BukkitTask task = new MapperTask(plugin).runTaskTimer( plugin, 1, Minegress.map_interval );
			
			task.toString();
		}
		
		return false;
	}
}
