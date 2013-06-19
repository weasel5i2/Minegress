package net.weasel.Minegress;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Portals 
{
	public boolean is_portal( Player player )
	{
		Block block = player.getTargetBlock( null, 10 );
		
		if( block.getType() == Material.BEACON )
		{
			// Do something here..
		}
		
		return false;
	}	
}
