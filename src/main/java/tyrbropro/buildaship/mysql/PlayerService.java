package tyrbropro.buildaship.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public PlayerData getPlayerByUuid(UUID uuid) {
        return playerRepository.findById(uuid).orElse(null);
    }

    public void savePlayer(PlayerData player) {
        playerRepository.save(player);
    }

    public void saveAllPlayers() {
        playerRepository.saveAll(PlayerData.users.values());
        System.out.println("Все игроки сохранены в базу данных.");
    }
}
