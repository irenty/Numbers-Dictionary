package irenty.dict.engb;


import irenty.dict.NumbersDictionary;
import irenty.dict.utils.Joiner;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements a {@link NumbersDictionary} for a En GB locale
 */
public final class NumbersDictionaryEnGB implements NumbersDictionary {

    private ThreeDigitsNumberDictionaryEnGB threeDigitsNumberDictionaryEnGB;
    private IntegerSplitter integerSplitter;

    public NumbersDictionaryEnGB(ThreeDigitsNumberDictionaryEnGB threeDigitsNumberDictionaryEnGB, IntegerSplitter integerSplitter) {
        this.threeDigitsNumberDictionaryEnGB = threeDigitsNumberDictionaryEnGB;
        this.integerSplitter = integerSplitter;
    }

    public String print(int number) {
        if (number < 0 || number > 999999999) {
            throw new IllegalArgumentException("Number is out of supported range of [0, 999999999]: " + number);
        }
        // optimization for numbers 1 to 19
        if (number < 20) {
            return threeDigitsNumberDictionaryEnGB.getForNumberUnder20(number);
        }

        List<ThreeDigitsNumberGroup> threeDigGroupList = integerSplitter.splitByThousands(number);
        List<String> tokens = new ArrayList<String>();
        for (ThreeDigitsNumberGroup threeDigGroup : threeDigGroupList) {
            tokens.add(threeDigitsNumberDictionaryEnGB.print(threeDigGroup));
        }
        return Joiner.on(' ').join(tokens);
    }
}
