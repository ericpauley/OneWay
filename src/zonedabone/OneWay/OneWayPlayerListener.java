package zonedabone.OneWay;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;

public class OneWayPlayerListener extends PlayerListener {
	
	private OneWay plugin;
	
	Location loc1;
	Location loc2;
	
	int x1 = 0;
	int y1 = 0;
	int z1 = 0;
	int x2 = 0;
	int y2 = 0;
	int z2 = 0;
	
	
	int x_s = 0;
	int y_s = 0;
	int z_s = 0;
	int x_l = 0;
	int y_l = 0;
	int z_l = 0;
	boolean running = false;
	int dir = 0;
	boolean greater;
	
	
	OneWayPlayerListener(OneWay instance){
		plugin = instance;
	}
	
	public void onPlayerInteract(PlayerInteractEvent e){
		if(e.getItem().getType()!=Material.WOOD_SWORD){return;}
		if(e.getAction()==Action.LEFT_CLICK_BLOCK){
			Location loc = e.getClickedBlock().getLocation();
			x1 = loc.getBlockX();
			y1 = loc.getBlockY();
			z1 = loc.getBlockZ();
			loc1 = loc;
			e.getPlayer().sendMessage("Location 1 registered");
		}else if(e.getAction()==Action.RIGHT_CLICK_BLOCK){
			Location loc = e.getClickedBlock().getLocation();
			x2 = loc.getBlockX();
			y2 = loc.getBlockY();
			z2 = loc.getBlockZ();
			loc2=loc;
			if(loc1.getWorld()!=loc2.getWorld()){
				e.getPlayer().sendMessage("Multiworld sucks!");
				return;
			}
			int xs = Math.min(x1, x2);
			int ys = Math.min(y1, y2);
			int zs = Math.min(z1, z2);
			int xl = Math.max(x1, x2);
			int yl = Math.max(y1, y2);
			int zl = Math.max(z1, z2);
			if(xl-xs!=0&&yl-ys!=0&&zl-zs!=0){
				e.getPlayer().sendMessage("LOL U FAIL! THAT'S NO PANE!");
				return;
			}
			
			
		}
	}

}
