package main.buildaship.world;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;
import org.springframework.stereotype.Component;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapService implements Listener {

    World worldSpawn;

    @EventHandler
    public void onWorldLoad(WorldLoadEvent event) {
        worldSpawn = event.getWorld();

        if (worldSpawn != null) {
            System.out.println("World loaded: " + event.getWorld().getName());
        } else {
            System.out.println("Error: World fail is loaded");
            Bukkit.shutdown();
        }
    }
}
