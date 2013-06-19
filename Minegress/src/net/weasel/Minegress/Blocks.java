package net.weasel.Minegress;

import org.bukkit.World;
import org.bukkit.block.Block;

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
			if( world.getBlockAt( bx, y, bz ).getTypeId() == 0 )
			{
				top = world.getBlockAt( bx, y-1, bz );
			}
		}
		
		return top;
	}
}
