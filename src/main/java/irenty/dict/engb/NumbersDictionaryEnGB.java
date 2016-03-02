package irenty.dict.engb;


import irenty.dict.NumbersDictionary;
import irenty.dict.printers.PrinterChain;
import irenty.dict.translations.Translations;
import irenty.dict.translations.TranslationsEnGB;
import irenty.dict.utils.Joiner;

import java.util.LinkedList;
import java.util.List;

/**
 * Implements a {@link NumbersDictionary} for a En GB locale
 */
public final class NumbersDictionaryEnGB implements NumbersDictionary {

    private final Translations translations = new TranslationsEnGB();
    private final PrintersChainBuilder printersChainBuilder = new PrintersChainBuilder(translations);

    public String print(int number) {
        if (number < 0 || number > 999999999) {
            throw new IllegalArgumentException("Number is out of supported range of [0, 999999999]: " + number);
        }

        PrinterChain printerChain = printersChainBuilder.build(number);

        List<String> words = new LinkedList<String>();
        printerChain.process(words);

        return Joiner.on(' ').join(words);
    }
}
