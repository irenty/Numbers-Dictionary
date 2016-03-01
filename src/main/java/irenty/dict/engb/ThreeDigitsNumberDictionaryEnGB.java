package irenty.dict.engb;

import irenty.dict.translations.Translations;
import irenty.dict.utils.Joiner;

import java.util.LinkedList;
import java.util.List;

public class ThreeDigitsNumberDictionaryEnGB {

    private Translations translations;

    public ThreeDigitsNumberDictionaryEnGB(Translations translations) {
        this.translations = translations;
    }

    public String print(ThreeDigitsNumberGroup number) {
        boolean is3DigitNumber = number.getNumber() >= 100;
        if (number.getNumber() == 0
                && !is3DigitNumber
                && number.getScaleGroup() == ScaleGroup.ONE
                && number.isBiggestPrintableGroup()) {
            return translations.unit(0);
        }
        List<String> tokens = new LinkedList<String>();
        if (number.shouldPrefixWithWordAnd()) {
            tokens.add("and");
        }
        int twoDigitReminder = number.getNumber() % 100;
        if (is3DigitNumber) {
            int numOfHundreds = number.getNumber() / 100;
            tokens.add(translations.unit(numOfHundreds));
            tokens.add(translations.scale(100));
            if (twoDigitReminder > 0) {
                tokens.add("and");
            }
        }
        if (twoDigitReminder > 0) {
            if (twoDigitReminder < 20) {
                tokens.add(translations.unit(twoDigitReminder));
            } else {
                int numOfTens = twoDigitReminder / 10;
                tokens.add(translations.tens(numOfTens));

                int tensReminder = twoDigitReminder % 10;
                if (tensReminder > 0) {
                    tokens.add(translations.unit(tensReminder));
                }
            }
        }
        if (number.getScaleGroup() != ScaleGroup.ONE) {
            tokens.add(translations.scale(number.getScaleGroup().getScale()));
        }
        return Joiner.on(' ').join(tokens);
    }

    public String getForNumberUnder20(int number) {
        return translations.unit(number);
    }
}
