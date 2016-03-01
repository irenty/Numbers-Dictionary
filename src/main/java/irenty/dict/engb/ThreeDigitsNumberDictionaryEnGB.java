package irenty.dict.engb;

import irenty.dict.utils.Joiner;

import java.util.LinkedList;
import java.util.List;

public class ThreeDigitsNumberDictionaryEnGB {

    private static final String[] NUMBERS = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] TENS = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public String print(ThreeDigitsNumberGroup number) {
        boolean is3DigitNumber = number.getNumber() >= 100;
        if (number.getNumber() == 0
                && !is3DigitNumber
                && number.getScaleGroup() == ScaleGroup.ONE
                && number.isBiggestPrintableGroup()) {
            return NUMBERS[0];
        }
        List<String> tokens = new LinkedList<String>();
        if (number.shouldPrefixWithWordAnd()) {
            tokens.add("and");
        }
        int twoDigitReminder = number.getNumber() % 100;
        if (is3DigitNumber) {
            int numOfHundreds = number.getNumber() / 100;
            tokens.add(NUMBERS[numOfHundreds]);
            tokens.add("hundred");
            if (twoDigitReminder > 0) {
                tokens.add("and");
            }
        }
        if (twoDigitReminder > 0) {
            if (twoDigitReminder < 20) {
                tokens.add(NUMBERS[twoDigitReminder]);
            } else {
                int numOfTens = twoDigitReminder / 10;
                tokens.add(TENS[numOfTens]);

                int tensReminder = twoDigitReminder % 10;
                if (tensReminder > 0) {
                    tokens.add(NUMBERS[tensReminder]);
                }
            }
        }
        if (number.getScaleGroup() != ScaleGroup.ONE) {
            tokens.add(number.getScaleGroup().getScaleGroupName());
        }
        return Joiner.on(' ').join(tokens);
    }

    public String getForNumberUnder20(int number) {
        return NUMBERS[number];
    }
}
