package irenty.dict.engb;

public enum ScaleGroup {

    ONE(1, ""),
    THOUSAND(1000, "thousand"),
    MILLION(1000000, "million");

    private int scale;
    private String scaleGroupName;

    ScaleGroup(int scale, String scaleGroupName) {
        this.scale = scale;
        this.scaleGroupName = scaleGroupName;
    }

    public String getScaleGroupName() {
        return scaleGroupName;
    }

    public int getScale() {
        return scale;
    }
}
