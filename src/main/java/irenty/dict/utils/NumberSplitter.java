package irenty.dict.utils;

import irenty.dict.model.ScaleGroup;
import irenty.dict.model.ThreeDigits;

import java.util.ArrayList;
import java.util.List;

public class NumberSplitter {

    // splits a number into ThreeDigits groups from most to least significant group
    public List<ThreeDigits> splitByThousands(int number) {
        List<ThreeDigits> groups = new ArrayList<ThreeDigits>();
        for (ScaleGroup scaleGroup : ScaleGroup.values()) {
            groups.add(new ThreeDigits(number, scaleGroup));
        }
        return groups;
    }
}
