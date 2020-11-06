package excord.dad_ju.lobby.events;

import excord.dad_ju.lobby.utils.LocationUtils;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import org.bukkit.plugin.java.JavaPlugin;

public class JoinEvent implements Listener {

    public JoinEvent(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    // @EventHandler
    // public void onPreLogin(AsyncPlayerPreLoginEvent event){}

    @EventHandler
    public void onLogin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        Location spawn = LocationUtils.getSpawnLocation();
        player.teleport(spawn);
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.7F, 1.2F);
    }

}
