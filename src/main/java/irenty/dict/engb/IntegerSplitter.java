package irenty.dict.engb;

import java.util.*;

public class IntegerSplitter {

    private static final List<ScaleGroup> SCALE_GROUPS_FROM_BIGGEST = new ArrayList<ScaleGroup>();
    static {
        SCALE_GROUPS_FROM_BIGGEST.addAll(Arrays.asList(ScaleGroup.values()));
        Collections.sort(SCALE_GROUPS_FROM_BIGGEST, new Comparator<ScaleGroup>() {
            public int compare(ScaleGroup o1, ScaleGroup o2) {
                return Integer.compare(o2.getScale(), o1.getScale());
            }
        });
    }

    private ThreeDigitsNumberGroupParamsPrecheck precheck = new ThreeDigitsNumberGroupParamsPrecheck();

    public List<ThreeDigitsNumberGroup> splitByThousands(int number) {

        List<ThreeDigitsNumberGroup> groups = new ArrayList<ThreeDigitsNumberGroup>();
        if (number == 0) {
            groups.add(new ThreeDigitsNumberGroup(0, ScaleGroup.ONE, true));
            return groups;
        }
        boolean mostSignificantGroup = true;
        for (ScaleGroup scaleGroup : SCALE_GROUPS_FROM_BIGGEST) {
            if (number >= scaleGroup.getScale()) {
                int multiplier = number / scaleGroup.getScale();
                if (precheck.isPrintable(multiplier, scaleGroup, mostSignificantGroup)) {
                    groups.add(new ThreeDigitsNumberGroup(multiplier, scaleGroup, mostSignificantGroup));
                    number %= scaleGroup.getScale();
                    mostSignificantGroup = false;
                }
            }
        }
        return groups;
    }
}
