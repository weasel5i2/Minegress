package net.weasel.Minegress;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandProtect implements CommandExecutor {

	public Minegress plugin;

	public CommandProtect( Minegress plugin ) 
	{
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) 
	{
		if( sender instanceof Player )
		{	
			Player player = (Player)sender;

			if( player.isOp() )
			{
				if( Minegress.protectBlocks )
				{
					player.sendMessage( "Global block protection is now OFF." );
					Minegress.protectBlocks = false;
				}
				else
				{
					player.sendMessage( "Global block protection is now ON." );
					Minegress.protectBlocks = true;
				}
			}
		}
			
		return false;
	}

}
