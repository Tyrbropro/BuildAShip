package tyrbropro.buildaship.currency.gold.repository;

public interface GoldRepository {
    void setGold(int gold);

    int getGold();

    void addGold(int gold);

    void subGold(int gold);
}
