package irenty.dict.translations;


/**
 * Provides translations required to generate integer words in a given language
 */
public interface Translations {

    /**
     * Translations for numbers in range [0, 19]
     * @param number
     * @return
     */
    String unit(int number);

    /**
     * Translations of tens for numbers [10, 90] step 10
     * @param number
     * @return
     */
    String tens(int number);

    /**
     * Translations for scale numbers {100, 1000, 1000000}
     * @param scale
     * @return
     */
    String scale(int scale);

    /**
     * Translations for words like: and
     * @param word
     * @return
     */
    String translate(Word word);
}
