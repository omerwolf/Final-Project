package DB.Entites;

public class Soil {
    //Members
    private int id;
    private String name;
    private int nPrecent;
    private int pPrecent;
    private int kPrecent;
    private int somDecompHigh;
    private int somDecompModerate;
    private int somDecompLow;
    private int baseDressingStrategy;
    private int rainEffect;
    private int defualtCEC;
    private int defualtBulkDensity;

    //Constructor
    public Soil(int id, String name, int nPrecent, int pPrecent, int kPrecent, int somDecompHigh, int somDecompModerate,
                int somDecompLow, int baseDressingStrategy, int rainEffect, int defualtCEC, int defualtBulkDensity) {
        this.id = id;
        this.name = name;
        this.nPrecent = nPrecent;
        this.pPrecent = pPrecent;
        this.kPrecent = kPrecent;
        this.somDecompHigh = somDecompHigh;
        this.somDecompModerate = somDecompModerate;
        this.somDecompLow = somDecompLow;
        this.baseDressingStrategy = baseDressingStrategy;
        this.rainEffect = rainEffect;
        this.defualtCEC = defualtCEC;
        this.defualtBulkDensity = defualtBulkDensity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getnPrecent() {
        return nPrecent;
    }

    public void setnPrecent(int nPrecent) {
        this.nPrecent = nPrecent;
    }

    public int getpPrecent() {
        return pPrecent;
    }

    public void setpPrecent(int pPrecent) {
        this.pPrecent = pPrecent;
    }

    public int getkPrecent() {
        return kPrecent;
    }

    public void setkPrecent(int kPrecent) {
        this.kPrecent = kPrecent;
    }

    public int getSomDecompHigh() {
        return somDecompHigh;
    }

    public void setSomDecompHigh(int somDecompHigh) {
        this.somDecompHigh = somDecompHigh;
    }

    public int getSomDecompModerate() {
        return somDecompModerate;
    }

    public void setSomDecompModerate(int somDecompModerate) {
        this.somDecompModerate = somDecompModerate;
    }

    public int getSomDecompLow() {
        return somDecompLow;
    }

    public void setSomDecompLow(int somDecompLow) {
        this.somDecompLow = somDecompLow;
    }

    public int getBaseDressingStrategy() {
        return baseDressingStrategy;
    }

    public void setBaseDressingStrategy(int baseDressingStrategy) {
        this.baseDressingStrategy = baseDressingStrategy;
    }

    public int getRainEffect() {
        return rainEffect;
    }

    public void setRainEffect(int rainEffect) {
        this.rainEffect = rainEffect;
    }

    public int getDefualtCEC() {
        return defualtCEC;
    }

    public void setDefualtCEC(int defualtCEC) {
        this.defualtCEC = defualtCEC;
    }

    public int getDefualtBulkDensity() {
        return defualtBulkDensity;
    }

    public void setDefualtBulkDensity(int defualtBulkDensity) {
        this.defualtBulkDensity = defualtBulkDensity;
    }
}
