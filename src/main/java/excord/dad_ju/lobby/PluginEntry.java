package excord.dad_ju.lobby;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

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

    public static String prefix = "§c[§aLOBBY§c]§r ";

    @Override
    public void onEnable() {
        // Copy the config.yml in the plugin configuration folder if it doesn't exists.
        this.saveDefaultConfig();
        log("Plugin Started!");
    }

    @Override
    public void onDisable() {
        log("Plugin Stopped!");
    }


    public void log(String text) {
        Bukkit.getConsoleSender().sendMessage(prefix + text);
    }
}
