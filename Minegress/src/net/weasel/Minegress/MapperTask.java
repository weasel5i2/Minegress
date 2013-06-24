package net.weasel.Minegress;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class MapperTask extends BukkitRunnable
{
	private final JavaPlugin plugin;
	
    public MapperTask(Minegress plugin)
    {        
    	this.plugin = plugin;
    }

	@Override
	public void run() 
	{
		int x = Minegress.map_x;
		int z = Minegress.map_z;
		int y = Minegress.map_y;
		
		plugin.toString();
		
		if( x < Minegress.map_max )
		{
			x += Minegress.map_step_x;
		}
		else
		{
			x = Minegress.map_min;
			
			if( z < Minegress.map_max )
			{
				z += Minegress.map_step_z;
				Minegress.map_agent.sendMessage( "MapperTask: new line (" + x + "," + z + ")" );
			}
			else
			{
				Minegress.map_agent.teleport( new Location( Minegress.map_agent.getWorld(), 0, y, 0 ) );
				this.cancel();
			}
		}
		
		Minegress.map_x = x;
		Minegress.map_z = z;
		
		Location loc = new Location( Minegress.map_agent.getWorld(), x, y, z );
		float pitch = Minegress.map_agent.getLocation().getPitch();
		float yaw = Minegress.map_agent.getLocation().getYaw();
		
		yaw += 15;
		
		if( yaw > 360 ) yaw -= 360;
		
		loc.setPitch( pitch );
		loc.setYaw( yaw );
		
		Minegress.map_agent.teleport( loc );
		
	}

}
