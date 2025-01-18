package main.buildaship.gameplay.event;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import main.buildaship.world.MapService;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerJoin implements Listener {

    final MapService mapService = new MapService();

    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent event) {
        Location spawnLocation = new Location(mapService.getWorldSpawn(), 0.5, 100, 0.5);
        org.bukkit.entity.Player player = event.getPlayer();
        player.teleport(spawnLocation);
    }

    // Swap teleport for MapService

}
