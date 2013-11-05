package net.weasel.Minegress;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;

public class Listeners implements Listener 
{
	public static void logOutput( String message ) { Minegress.logOutput( message ); }
	public static void debugOutput( String message ) { Minegress.debugOutput( message ); }
	
	public static Minegress plugin;

	public Listeners(Minegress instance) 
	{
		plugin = instance;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
	
	@EventHandler
	public void block_break( BlockBreakEvent event )
	{
		if( event.getPlayer().isOp() == false )
		{
			event.setCancelled( true );
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void movement_of_xm( EntityTargetEvent event )
	{
		if( event.getEntityType() == EntityType.EXPERIENCE_ORB )
		{
			Entity target = event.getTarget();
			
			if( target instanceof Player )
			{
				event.setCancelled( true );
		    }
		}
	}

	@EventHandler
	public void player_xm_pickup(PlayerExpChangeEvent event) 
    {
		Player player = event.getPlayer();
		int amount = event.getAmount();
    	float max = (float)0.9999999;
    	
        if( player.getExp() + amount >= max )
        {
        	player.setExp( (float)0.9999999 );
    		Location location = player.getLocation();
        	event.setAmount( 0 );
        	player.getWorld().spawn( location, ExperienceOrb.class).setExperience( amount ); 
        }
    }
    
	@EventHandler
	public void playerLevel(PlayerLevelChangeEvent event) 
	{
		Player player = event.getPlayer();
		
		player.setLevel( event.getOldLevel() );
    }
}
