package tyrbropro.buildaship.util.event.player;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tyrbropro.buildaship.mysql.PlayerData;
import tyrbropro.buildaship.mysql.PlayerService;

import java.util.UUID;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PlayerQuit implements Listener {
    PlayerService playerService;

    @Autowired
    public PlayerQuit(PlayerService playerService) {
        this.playerService = playerService;
    }

    @EventHandler
    public void quitPlayer(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        PlayerData playerData = PlayerData.users.get(uuid);
        if (playerData != null) {
            try {
                playerService.savePlayer(playerData);
                System.out.println("Данные игрока сохранены: " + playerData);
            } catch (Exception e) {
                System.err.println("Ошибка при сохранении данных игрока: " + e.getMessage());
            }
        } else {
            System.out.println("Данные игрока не найдены в кэше для UUID: " + uuid);
        }
    }
}
