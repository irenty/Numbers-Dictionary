package irenty.dict.engb;


import irenty.dict.NumbersDictionary;

/**
 * Implements a {@link NumbersDictionary} for a En GB locale
 */
public final class NumbersDictionaryEnGB implements NumbersDictionary {


    public String print(int number) {
        if (number < 0 || number > 999999999) {
            throw new IllegalArgumentException("Number is out of supported range of [0, 999999999]: " + number);
        }
        return null;
    }
}
