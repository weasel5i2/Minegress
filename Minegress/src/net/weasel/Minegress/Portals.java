package net.weasel.Minegress;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Portals 
{
    private Block getTargetBlock( Player player, int range )
    {
    	return( Blocks.getTargetBlock( player, range ) );
    }
	
	public boolean is_portal( Player player )
	{
		Block block = getTargetBlock( player, 10 );
		
		if( block.getType() == Material.BEACON )
		{
			// Do something here..
		}
		
		return false;
	}	
}
