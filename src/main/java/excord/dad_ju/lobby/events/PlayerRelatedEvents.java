package excord.dad_ju.lobby.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerRelatedEvents implements Listener {
    public PlayerRelatedEvents(JavaPlugin plugin){
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBlockPlace (BlockPlaceEvent event){
        Player player = event.getPlayer();

        if(player.hasPermission("excord.lobby.build")) return;

        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockBreak (BlockBreakEvent event){
        Player player = event.getPlayer();

        if(player.hasPermission("excord.lobby.build")) return;

        event.setCancelled(true);
    }
}
