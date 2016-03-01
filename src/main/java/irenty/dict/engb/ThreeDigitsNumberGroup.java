package irenty.dict.engb;

public class ThreeDigitsNumberGroup {

    private final int number;
    private final ScaleGroup scaleGroup;
    private final boolean biggestPrintableGroup;

    public ThreeDigitsNumberGroup(int number, ScaleGroup scaleGroup, boolean biggestPrintableGroup) {
        this.number = number;
        this.scaleGroup = scaleGroup;
        this.biggestPrintableGroup = biggestPrintableGroup;
    }

    public boolean shouldPrefixWithWordAnd() {
        return !biggestPrintableGroup && number < 100 && number > 0;
    }

    public int getNumber() {
        return number;
    }

    public ScaleGroup getScaleGroup() {
        return scaleGroup;
    }

    public boolean isBiggestPrintableGroup() {
        return biggestPrintableGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThreeDigitsNumberGroup that = (ThreeDigitsNumberGroup) o;

        if (number != that.number) return false;
        if (biggestPrintableGroup != that.biggestPrintableGroup) return false;
        return scaleGroup == that.scaleGroup;

    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + scaleGroup.hashCode();
        result = 31 * result + (biggestPrintableGroup ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ThreeDigitsNumberGroup{" +
                "number=" + number +
                ", scaleGroup=" + scaleGroup +
                ", biggestPrintableGroup=" + biggestPrintableGroup +
                '}';
    }
}
