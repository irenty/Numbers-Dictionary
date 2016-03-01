package irenty.dict.engb;

public enum ScaleGroup {

    ONE(1),
    THOUSAND(1000),
    MILLION(1000000);

    private int scale;

    ScaleGroup(int scale) {
        this.scale = scale;
    }

    public int getScale() {
        return scale;
    }
}
