package irenty.dict.model;

/**
 * Scale values must be decreasing
 */
public enum ScaleGroup {

    MILLION(1000000),
    THOUSAND(1000),
    ONE(1);

    private int scale;

    static {
        validateInvariant();
    }

    ScaleGroup(int scale) {
        this.scale = scale;
    }

    public int getScale() {
        return scale;
    }

    public int getHigherScale() {
        return 1000 * scale;
    }

    private static void validateInvariant() {
        int previousScale = Integer.MAX_VALUE;
        for (ScaleGroup scaleGroup : ScaleGroup.values()) {
            if (scaleGroup.getScale() > previousScale) {
                throw new IllegalStateException("Scale values must be decreasing");
            }
            previousScale = scaleGroup.getScale();
        }
    }
}
