package net.weasel.Minegress;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMkportal implements CommandExecutor 
{
	public Minegress plugin;
	
    public CommandMkportal(Minegress plugin)
    {        
    	this.plugin = plugin;
    }

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) 
	{
		if( sender instanceof Player )
		{
			Player player = (Player)sender;
			
			// Block block = player.getTargetBlock( null,  10 );
			
			player.sendMessage( "The yaw is " + player.getLocation().getYaw() );
			player.sendMessage( "The pitch is " + player.getLocation().getPitch() );
		
			return true;
		}
		
		return false;
	}
}
