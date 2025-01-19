package tyrbropro.buildaship.currency.diamond.repository;

public interface DiamondRepository {
    void setDiamond(int diamond);

    int getDiamond();

    void addDiamond(int diamond);

    void subDiamond(int diamond);
}
