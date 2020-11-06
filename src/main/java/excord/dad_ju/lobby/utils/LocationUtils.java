package excord.dad_ju.lobby.utils;

import excord.dad_ju.lobby.PluginEntry;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.Objects;

import static java.lang.Double.parseDouble;

public class LocationUtils {
    public static LocationUtils INSTANCE;

    public LocationUtils() {
        INSTANCE = this;
    }

    public static Location getSpawnLocation(){
        String[] cords = Objects.requireNonNull(PluginEntry.plugin.getConfig().getString("lobby.cords")).split(" ");
        if (cords.length != 3) {
            PluginEntry.log("There is something wrong with your Cords! Place them again. (Teleporting to World Spawn Itself!");
            World world = Bukkit.getWorld("world");
            assert world != null;
            return new Location(world, world.getSpawnLocation().getX(), world.getSpawnLocation().getY(), world.getSpawnLocation().getZ());
        }

        return new Location(Bukkit.getWorld("world"), parseDouble(cords[0] + ".5"), parseDouble(cords[1] + ".2"), parseDouble(cords[2] + ".5"));
    }

    public static String getLocationString(Location loc){
        return getPosInt(loc.getX()) + " " + getPosInt(loc.getY()) + " " + getPosInt(loc.getZ());
    }

    static String getPosInt (Double pos) {
        return String.valueOf(pos).split("\\.")[0];
    }

}
