package net.weasel.Minegress;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Blocks 
{
	public static Block getTopBlock( Block block )
	{
		World world = block.getWorld();
		int bx = block.getX();
		int by = block.getY();
		int bz = block.getZ();
		
		Block top = block;
		
		for( int y = by+1; y < 256; y++ )
		{
			if( world.getBlockAt( bx, y, bz ).getType() == Material.AIR )
			{
				top = world.getBlockAt( bx, y-1, bz );
			}
		}
		
		return top;
	}
	
    public static Block getTargetBlock( Player player, int range ) 
    {
    	Location loc = player.getEyeLocation();
    	Vector dir = loc.getDirection().normalize();
     
    	Block b = null;
     
    	for( int i = 0; i <= range; i++ ) 
    	{
    		b = loc.add(dir).getBlock();
    	}
     
    	return( b );
    }
}
