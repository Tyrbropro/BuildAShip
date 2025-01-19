package tyrbropro.buildaship.mysql;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Entity
@Table(name = "players")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerData {

    public static Map<UUID, PlayerData> users = new ConcurrentHashMap<>();

    @Id
    @Column(name = "uuid")
    UUID uuid;
    int diamond;
    int gold;

    public PlayerData() {
    }

    public PlayerData(UUID uuid, int diamond, int gold) {
        this.uuid = uuid;
        this.diamond = diamond;
        this.gold = gold;

        users.put(uuid, this);
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getDiamond() {
        return diamond;
    }

    public void setDiamond(int diamond) {
        this.diamond = diamond;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public void subGold(int gold) {
        this.gold -= gold;
    }

    public void addDiamond(int diamond) {
        this.diamond += diamond;
    }

    public void subDiamond(int diamond) {
        this.diamond -= diamond;
    }
}
