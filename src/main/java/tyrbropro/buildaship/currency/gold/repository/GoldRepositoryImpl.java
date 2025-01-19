package tyrbropro.buildaship.currency.gold.repository;

import tyrbropro.buildaship.currency.gold.GoldInfo;

public class GoldRepositoryImpl implements GoldRepository {

    GoldInfo goldInfo = new GoldInfo();

    @Override
    public void setGold(int gold) {
        goldInfo.setGold(gold);
    }

    @Override
    public int getGold() {
        return goldInfo.getGold();
    }

    @Override
    public void addGold(int gold) {
        goldInfo.setGold(goldInfo.getGold() + gold);
    }

    @Override
    public void subGold(int gold) {
        goldInfo.setGold(goldInfo.getGold() - gold);
    }
}