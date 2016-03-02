package irenty.dict.model;

/**
 * Wrapper for an integer number focuses on the 3 digits number at a given scale
 */
public class ThreeDigits {

    private final int number;
    private final ScaleGroup scaleGroup;
    private final int threeDigits;
    private final int lastTwoDigits;
    private final int hundredDigit;
    private final boolean biggestPrintableGroup;

    public ThreeDigits(int number, ScaleGroup scaleGroup) {
        this.number = number;
        this.scaleGroup = scaleGroup;
        this.threeDigits = (number / scaleGroup.getScale()) % 1000;
        this.lastTwoDigits = this.threeDigits % 100;
        this.hundredDigit = this.threeDigits / 100;
        this.biggestPrintableGroup = number < scaleGroup.getHigherScale() && number >= scaleGroup.getScale();
    }

    public boolean shouldPrefixWithWordAnd() {
        return !biggestPrintableGroup && threeDigits < 100 && threeDigits > 0;
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

    public int getThreeDigits() {
        return threeDigits;
    }

    public int getLastTwoDigits() {
        return lastTwoDigits;
    }

    public int getHundredDigit() {
        return hundredDigit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThreeDigits that = (ThreeDigits) o;

        if (number != that.number) return false;
        if (threeDigits != that.threeDigits) return false;
        if (lastTwoDigits != that.lastTwoDigits) return false;
        if (hundredDigit != that.hundredDigit) return false;
        if (biggestPrintableGroup != that.biggestPrintableGroup) return false;
        return scaleGroup == that.scaleGroup;

    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + scaleGroup.hashCode();
        result = 31 * result + threeDigits;
        result = 31 * result + lastTwoDigits;
        result = 31 * result + hundredDigit;
        result = 31 * result + (biggestPrintableGroup ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ThreeDigits{" +
                "number=" + number +
                ", scaleGroup=" + scaleGroup +
                ", threeDigits=" + threeDigits +
                ", lastTwoDigits=" + lastTwoDigits +
                ", hundredDigit=" + hundredDigit +
                ", biggestPrintableGroup=" + biggestPrintableGroup +
                '}';
    }
}
