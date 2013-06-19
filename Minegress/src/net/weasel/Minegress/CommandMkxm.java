package net.weasel.Minegress;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;

public class CommandMkxm implements CommandExecutor 
{
	public Minegress plugin;
	
    public CommandMkxm(Minegress plugin)
    {        
    	this.plugin = plugin;
    }

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) 
	{
		if( sender instanceof Player )
		{
			Player player = (Player)sender;
			
			Block block = player.getTargetBlock( null,  10 );
			
			for( int c = 1; c < 32; c++ )
			{
				block.getLocation().getWorld().spawn(block.getLocation(), ExperienceOrb.class).setExperience(1);
			}
			
			player.sendMessage( "You make some XM." );

			ResultSet result = Database.read_database( "SELECT * FROM minegress.players WHERE name = 'weasel5i2';" );
			
			try 
			{
				while( result.next() )
				{
					Minegress.logOutput( "Result: " + result.toString() );
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
			return true;
		}
		
		return false;
	}

}
