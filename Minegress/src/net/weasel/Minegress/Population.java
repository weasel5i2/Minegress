package net.weasel.Minegress;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.java.JavaPlugin;

import de.kumpelblase2.remoteentities.api.RemoteEntity;
import de.kumpelblase2.remoteentities.api.RemoteEntityType;
import de.kumpelblase2.remoteentities.api.thinking.Desire;
import de.kumpelblase2.remoteentities.api.thinking.goals.DesireLookAtNearest;
import de.kumpelblase2.remoteentities.api.thinking.goals.DesireMoveToTarget;
import de.kumpelblase2.remoteentities.api.thinking.goals.DesireWanderAround;

public class Population 
{
	private final JavaPlugin plugin;
	public static List<String> names = new ArrayList<String>();

	public static Location getTopBlock( Location loc ) { return( Minegress.getTopBlock(loc) ); }
	public static void logOutput( String message ) { Minegress.logOutput( message ); }
	
    public Population(Minegress plugin)
    {        
    	this.plugin = plugin;
    }
	
	public void init_npc_population()
	{		
		RemoteEntity entity = Minegress.manager.createEntity(RemoteEntityType.Human, plugin.getServer().getWorld("Minegress").getSpawnLocation(), false);
		entity.getMind().addMovementDesire(new DesireWanderAround( entity ), 1);
		entity.getMind().addMovementDesire(new DesireLookAtNearest( entity, Entity.class, 8F), 1);

		entity.save();
		
		entity.spawn( plugin.getServer().getWorld("Minegress").getSpawnLocation() );
	}

	public static void init_names()
	{
		names.add( "Johnson" ); names.add( "Rogers" ); names.add( "Wilson" ); names.add( "Wheaton" ); names.add( "Scott" );
		names.add( "White" ); names.add( "Green" ); names.add( "Black" ); names.add( "Taylor" ); names.add( "Vogel" );
		names.add( "Mitchell" ); names.add( "Anderson" ); names.add( "Smith" ); names.add( "Goldstein" ); names.add( "Abrams" );
		names.add( "McCullough" ); names.add( "Masterson" ); names.add( "Walters" ); names.add( "Reed" ); names.add( "Pinner" );
		names.add( "Laughlin" ); names.add( "Hooker" ); names.add( "Mitchell" ); names.add( "Michaels" ); names.add( "Richardson" );
		names.add( "Johanssen" ); names.add( "Jackson" ); names.add( "Furlough" ); names.add( "Ludlum" ); names.add( "Brooks" );
		names.add( "Ramirez" ); names.add( "Sanchez" ); names.add( "Aguilar" ); names.add( "Cervantes" ); names.add( "Williamson" );
		names.add( "Hayes" ); names.add( "Frasier" ); names.add( "Gruber" ); names.add( "Wagner" ); names.add( "Schneider" );
		names.add( "Mayer" ); names.add( "Edelweiss" ); names.add( "Peters" ); names.add( "Peterson" ); names.add( "Petersen" );
		names.add( "Jacobs" ); names.add( "Jacobsen" ); names.add( "Jacobson" ); names.add( "Martin" ); names.add( "Martinson" ); 
		names.add( "Tomlinson" ); names.add( "Tomlin" ); names.add( "Thompson" ); names.add( "Thomson" ); names.add( "Dubois" );
		names.add( "Nichols" ); names.add( "Nicholson" ); names.add( "Lambert" ); names.add( "Lambertson" ); names.add( "Dupont" );
		names.add( "Dufourier" ); names.add( "Fourier" ); names.add( "Popov" ); names.add( "Santana" ); names.add( "Garcia" );
		names.add( "Lopez" ); names.add( "Ramos" ); names.add( "Medina" ); names.add( "Fernandez" ); names.add( "Rivera" );
		names.add( "Trujillo" ); names.add( "Nielsen" ); names.add( "Jensen" ); names.add( "Hansen" ); names.add( "Larsen" );
		names.add( "Christensen" ); names.add( "Andersen" ); names.add( "Smirnov" ); names.add( "Ivanov" ); names.add( "Petrov" );
		names.add( "Olson" ); names.add( "Olsen" ); names.add( "Saarinen" ); names.add( "Lindholm" ); names.add( "Lindhurst" );
		names.add( "Lindberg" ); names.add( "Bernard" ); names.add( "Moreau" ); names.add( "McAllister" ); names.add( "Fournier" );
		names.add( "Muller" ); names.add( "Schmidt" ); names.add( "Schneider" ); names.add( "Fischer" ); names.add( "Fisher" );
		names.add( "Weber" ); names.add( "Schultz" ); names.add( "Becker" ); names.add( "Hoffmann" ); names.add( "Papadopoulos" );
		names.add( "Vargas" ); names.add( "Murphy" ); names.add( "Walsh" ); names.add( "Sullivan" ); names.add( "O'Sullivan" );
		names.add( "O'Brien" ); names.add( "Kennedy" ); names.add( "Gallagher" ); names.add( "Lynch" ); names.add( "Dougherty" );
		names.add( "Donnelly" ); names.add( "Murray" ); names.add( "Ericsson" ); names.add( "Rossi" ); names.add( "Russo" );
		names.add( "Gallo" ); names.add( "Romano" ); names.add( "Bianchi" ); names.add( "Contini" ); names.add( "Mancini" );
		names.add( "Conti" ); names.add( "Costa" ); names.add( "Giordano" ); names.add( "Rizzo" ); names.add( "Lombardi" );
		names.add( "Moretti" ); names.add( "Moretz" ); names.add( "Visser" ); names.add( "Hendricks" ); names.add( "Novak" );
		names.add( "Andrews" ); names.add( "Hamilton" ); names.add( "Medeiros" ); names.add( "Gomez" ); names.add( "Smirnov" );
		names.add( "Ivanov" ); names.add( "Pavlov" ); names.add( "Schrodinger" ); names.add( "Tyson" ); names.add( "Hawking" );
		names.add( "Stein" ); names.add( "Vasilyev" ); names.add( "Weidmar" ); names.add( "Filippenko" ); names.add( "Josephson" );
		names.add( "Diaz" ); names.add( "Ortiz" ); names.add( "Ortega" ); names.add( "Brown" ); names.add( "Davies" );
		names.add( "Robinson" ); names.add( "Wright" ); names.add( "Evans" ); names.add( "Walker" ); names.add( "Roberts" );
		names.add( "Hall" ); names.add( "Wood" ); names.add( "Clarke" ); names.add( "Clark" ); names.add( "Clarkson" );
		names.add( "Lewis" ); names.add( "Lewiston" ); names.add( "Phillips" ); names.add( "Philips" ); names.add( "Campbell" );
		names.add( "Moore" ); names.add( "Stewart" ); names.add( "Quinn" ); names.add( "Murphy" ); names.add( "Graham" );
		names.add( "Laughlin" ); names.add( "Loughlin" ); names.add( "McLaughlin" ); names.add( "Hughes" ); names.add( "Warner" );
		names.add( "Walton" ); names.add( "Abrams" ); names.add( "Thomson" ); names.add( "MacDonald" ); names.add( "McDonald" );
		names.add( "Edwards" ); names.add( "Owens" ); names.add( "Reese" ); names.add( "Driscoll" ); names.add( "Wong" );
		names.add( "Lee" ); names.add( "Patel" ); names.add( "Tremblay" ); names.add( "Bouchard" ); names.add( "Gauthier" ); 
		names.add( "Lavoie" ); names.add( "Willis" ); names.add( "Harris" ); names.add( "Harrison" ); names.add( "Young" ); 
		names.add( "Baker" ); names.add( "Adams" ); names.add( "Adamson" ); names.add( "Tomlinson" ); names.add( "Tomlin" );
		names.add( "Drummond" ); names.add( "Mullan" ); names.add( "Mullen" ); names.add( "Mullin" ); names.add( "Chang" );
		names.add( "Olson" ); names.add( "Olsen" ); names.add( "Nixon" );  names.add( "Dixon" ); 	names.add( "Dickson" );
		names.add( "Dickman" ); names.add( "Turlington" ); names.add( "Crawford" ); names.add( "Olvera" ); names.add( "Masters" );
		names.add( "Masterson" ); names.add( "Turner" ); names.add( "Vasquez" );
	}
	
	public static String get_random_npc_name()
	{
		int c = names.size();
		int r = (int)( Math.random() * c );
		
		String name = names.get( r );
		
		return( name );
	}
	
	public static void business_as_usual( RemoteEntity npc )
	{
		logOutput( "business as usual for " + npc.getBukkitEntity().getCustomName() + "." );
		
		if( npc.isStationary() )
		{		
			Location destination = i_spy( npc, 10 );
			
			if( destination != null )
			{
				Desire walk_to = new DesireMoveToTarget( npc, 0 );
				
				npc.getMind().addMovementDesire( walk_to, 10 );
			}

		}
	}
	
	public static Location i_spy( RemoteEntity npc, int range )
	{
		LivingEntity entity = npc.getBukkitEntity();
		Location loc = entity.getLocation();
		Location target = null;
		Block block = null;
		
		double top_y = 0;
		double x = loc.getX();
		double y = loc.getY();
		double z = loc.getZ();
		double r = Math.random() * 32;
		
		if( Math.random() < .5 )
		{
			if( Math.random() < .5 )
			{
				for( double c = ( x + range + r ); c >= x; c-- )
				{
					block = loc.getWorld().getBlockAt( (int)c, (int)y, (int)z );
					top_y = getTopBlock( block.getLocation() ).getY();					

					if( loc.getWorld().getBlockAt((int)c, (int)top_y, (int)z ).getTypeId() == 44 )
					{
						target = loc.getWorld().getBlockAt((int)c, (int)top_y, (int)z ).getLocation();
					}
				}
			}
			else
			{
				for( double c = ( x - range - r ); c >= x; c++ )
				{
					block = loc.getWorld().getBlockAt( (int)c, (int)y, (int)z );
					top_y = getTopBlock( block.getLocation() ).getY();					

					if( loc.getWorld().getBlockAt((int)c, (int)top_y, (int)z ).getTypeId() == 44 )
					{
						target = loc.getWorld().getBlockAt((int)c, (int)top_y, (int)z ).getLocation();
					}
				}
			}
		}
		else
		{
			if( Math.random() < .5 )
			{
				for( double c = ( z + range + r ); c >= z; c++ )
				{
					block = loc.getWorld().getBlockAt( (int)x, (int)y, (int)c );
					top_y = getTopBlock( block.getLocation() ).getY();					

					if( loc.getWorld().getBlockAt((int)c, (int)top_y, (int)z ).getTypeId() == 44 )
					{
						target = loc.getWorld().getBlockAt((int)c, (int)top_y, (int)z ).getLocation();
					}
				}
			}
			else
			{
				for( double c = ( z - range - r ); c >= z; c++ )
				{
					block = loc.getWorld().getBlockAt( (int)x, (int)y, (int)c );
					top_y = getTopBlock( block.getLocation() ).getY();					

					if( loc.getWorld().getBlockAt((int)c, (int)top_y, (int)z ).getTypeId() == 44 )
					{
						target = loc.getWorld().getBlockAt((int)c, (int)top_y, (int)z ).getLocation();
					}
				}
			}
		}
		
		return( target );
	}
}
