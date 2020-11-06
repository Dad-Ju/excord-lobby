package excord.dad_ju.lobby.commands;

import excord.dad_ju.lobby.PluginEntry;
import excord.dad_ju.lobby.utils.LocationUtils;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;
        if(!player.hasPermission("excord.spawn")) return true;

        Location playerLoc = player.getLocation();

        if (!label.equalsIgnoreCase("setspawn")) {
            Location Spawn = LocationUtils.getSpawnLocation();
            player.teleport(Spawn);
            player.playSound(playerLoc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2F, 1F);

            return true;
        }

        if(player.hasPermission("excord.spawn.set")){
            String newSpawn = LocationUtils.getLocationString(playerLoc);
            PluginEntry.plugin.getConfig().set("lobby.cords", newSpawn);
            PluginEntry.plugin.saveConfig();
            player.sendMessage("Set the new Spawn to '" + newSpawn + "'");
        }

        return true;
    }

}
