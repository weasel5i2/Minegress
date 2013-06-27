package net.weasel.Minegress;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class MainTask extends BukkitRunnable
{
	private final JavaPlugin plugin;
	
    public MainTask(Minegress plugin)
    {        
    	this.plugin = plugin;
    }

	@Override
	public void run() 
	{
		// Do the portal upkeep, xm expression, etc..
		//
		
		plugin.getServer();
	}

}
