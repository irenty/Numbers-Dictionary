package irenty.dict.engb;

public class ThreeDigitsNumberGroupParamsPrecheck {

    public boolean isPrintable(int number, ScaleGroup scaleGroup, boolean mostSignificantGroup) {
        return number != 0 || (mostSignificantGroup && scaleGroup == ScaleGroup.ONE);
    }
}
