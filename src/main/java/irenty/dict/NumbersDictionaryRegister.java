package irenty.dict;

import irenty.dict.engb.IntegerSplitter;
import irenty.dict.engb.NumbersDictionaryEnGB;
import irenty.dict.engb.ThreeDigitsNumberDictionaryEnGB;
import irenty.dict.translations.Translations;
import irenty.dict.translations.TranslationsEnGB;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * This class holds implementations of {@link NumbersDictionary} for a various Locales
 * that can be retrieved with a get method.
 */
public class NumbersDictionaryRegister {

    private static final Map<Locale, NumbersDictionary> DICTS = new HashMap<Locale, NumbersDictionary>();
    static {
        Translations translations = new TranslationsEnGB();
        ThreeDigitsNumberDictionaryEnGB threeDigitsNumberDictionaryEnGB = new ThreeDigitsNumberDictionaryEnGB(translations);
        IntegerSplitter integerSplitter = new IntegerSplitter();

        DICTS.put(new Locale("en", "GB"), new NumbersDictionaryEnGB(threeDigitsNumberDictionaryEnGB, integerSplitter));
    }

    /**
     * Returns an implementation of Numbers Dictionary for a given locale
     *
     * @param locale input locale
     * @return instance of {@link NumbersDictionary}
     * @throws IllegalArgumentException if dictionary is not supported for a given locale
     */
    public static NumbersDictionary get(Locale locale) {
        final NumbersDictionary dict = DICTS.get(locale);
        if (dict == null) {
            throw new IllegalArgumentException("Locale not supported: " + locale);
        }
        return dict;
    }

}
