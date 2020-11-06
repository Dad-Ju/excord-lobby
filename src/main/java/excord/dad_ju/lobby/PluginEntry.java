package excord.dad_ju.lobby;

import excord.dad_ju.lobby.commands.SpawnCommand;
import excord.dad_ju.lobby.events.JoinEvent;
import excord.dad_ju.lobby.events.PlayerRelatedEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

/**
 * Entry point for the template plugin. You should edit
 * this comment by explaining the main purpose of your
 * plugin
 *
 * You should also edit these tags below.
 *
 * @author Dad_Ju
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class PluginEntry extends JavaPlugin {
    public static PluginEntry INSTANCE;
    public static JavaPlugin plugin;

    public static String prefix = "§c[§aLOBBY§c]§r ";

    public PluginEntry() {
        INSTANCE = this;
    }

    @Override
    public void onEnable() {
        plugin = this;
        registerCommands();
        new PlayerRelatedEvents(this);
        new JoinEvent(this);
        this.saveDefaultConfig();
        log("Plugin Started!");
    }

    @Override
    public void onDisable() {
        log("Plugin Stopped!");
    }


    public static void log(String text) {
        Bukkit.getConsoleSender().sendMessage(prefix + text);
    }

    public static void registerCommands() {
        Objects.requireNonNull(Bukkit.getPluginCommand("spawn")).setExecutor(new SpawnCommand());
    }
}
