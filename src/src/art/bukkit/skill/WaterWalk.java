package src.art.bukkit.skill;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class WaterWalk extends JavaPlugin implements Listener {
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		Location loc = event.getTo().subtract(0, 1, 0);
		int x = loc.getBlockX();
		int y = loc.getBlockY();
		int z = loc.getBlockZ();

		World world = event.getPlayer().getWorld();
		ifwaterblock(world.getBlockAt(x + 0, y + 0, z + 0), event);
		ifwaterblock(world.getBlockAt(x + 0, y - 1, z + 0), event);
		ifwaterblock(world.getBlockAt(x - 1, y + 0, z + 0), event);
		ifwaterblock(world.getBlockAt(x + 1, y + 0, z + 0), event);
		ifwaterblock(world.getBlockAt(x + 0, y + 0, z - 1), event);
		ifwaterblock(world.getBlockAt(x + 0, y + 0, z + 1), event);
	}

	private void ifwaterblock(Block block,PlayerMoveEvent event) {
		Material blockm = block.getType();
		Player player= event.getPlayer(); 
		if (blockm == Material.WATER || blockm == Material.STATIONARY_WATER)
			if (player.hasPermission("art.test")){
			block.setType(Material.ICE);
		}
	}
}

