package tyrbropro.buildaship.util.event.player;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tyrbropro.buildaship.mysql.PlayerData;
import tyrbropro.buildaship.mysql.PlayerService;

import java.util.UUID;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PlayerAsync implements Listener {

    PlayerService playerService;

    @Autowired
    public PlayerAsync(PlayerService playerService) {
        this.playerService = playerService;
    }

    @EventHandler
    public void asyncPlayerLogin(AsyncPlayerPreLoginEvent event) {
        UUID uuid = event.getUniqueId();
        System.out.println("ТЕст");
        try {
            PlayerData playerData = playerService.getPlayerByUuid(uuid);

            if (playerData == null) {
                playerData = new PlayerData(uuid, 0, 0);
                playerService.savePlayer(playerData);
                System.out.println("Новый игрок добавлен в базу данных: " + uuid);
            } else {
                System.out.println("Игрок успешно загружен: " + playerData);
            }

        } catch (Exception e) {
            System.err.println("Ошибка при загрузке игрока: " + e.getMessage());
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, "Ошибка загрузки данных. Попробуйте позже.");
        }
    }
}
