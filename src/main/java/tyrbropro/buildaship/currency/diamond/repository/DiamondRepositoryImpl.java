package tyrbropro.buildaship.currency.diamond.repository;

import tyrbropro.buildaship.currency.diamond.DiamondInfo;

public class DiamondRepositoryImpl implements DiamondRepository {
    DiamondInfo diamondInfo = new DiamondInfo();

    @Override
    public void setDiamond(int diamond) {
        diamondInfo.setDiamond(diamond);
    }

    @Override
    public int getDiamond() {
        return diamondInfo.getDiamond();
    }

    @Override
    public void addDiamond(int diamond) {
        diamondInfo.setDiamond(diamondInfo.getDiamond() + diamond);
    }

    @Override
    public void subDiamond(int diamond) {
        diamondInfo.setDiamond(diamondInfo.getDiamond() - diamond);
    }
}
