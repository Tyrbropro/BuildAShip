package tyrbropro.buildaship.util.event.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.springframework.stereotype.Component;
import tyrbropro.buildaship.world.MapService;

@Component
public class PlayerJoin implements Listener {

    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent event) {
        Location spawnLocation = new Location(MapService.getWorld(), 0.5, 100, 0.5);
        Player player = event.getPlayer();
        player.teleport(spawnLocation);
    }
    // Swap teleport for MapService
}
