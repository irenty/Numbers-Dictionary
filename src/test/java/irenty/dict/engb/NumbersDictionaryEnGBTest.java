package irenty.dict.engb;


import irenty.dict.translations.Translations;
import irenty.dict.translations.TranslationsEnGB;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NumbersDictionaryEnGBTest {

    private final Translations translations = new TranslationsEnGB();
    private final ThreeDigitsNumberDictionaryEnGB threeDigitsNumberDictionaryEnGB = new ThreeDigitsNumberDictionaryEnGB(translations);
    private final IntegerSplitter integerSplitter = new IntegerSplitter();

    private final NumbersDictionaryEnGB testedDict = new NumbersDictionaryEnGB(threeDigitsNumberDictionaryEnGB, integerSplitter);

    @Test(dataProvider = "numbersProvider")
    public void testPrint(int number, String name) {
        assertEquals(testedDict.print(number), name);
    }

    @DataProvider(name="numbersProvider")
    public Object[][] getScenario() {
        return new Object[][] {
        // from sample
                { 0, "zero"},
                { 1, "one"},
                { 21, "twenty one"},
                { 105, "one hundred and five"},
                { 123, "one hundred and twenty three"},
                { 1005, "one thousand and five"},
                { 1042, "one thousand and forty two"},
                { 1105, "one thousand one hundred and five"},
                { 56945781, "fifty six million nine hundred and forty five thousand seven hundred and eighty one"},
                { 999999999, "nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine"},
        // extra data
                { 9, "nine"},
                { 11, "eleven"},
                { 15, "fifteen"},
                { 19, "nineteen"},
                { 40, "forty"},
                { 49, "forty nine"},
                { 100, "one hundred"},
                { 1000, "one thousand"},
                { 10000, "ten thousand"},
                { 100000, "one hundred thousand"},
                { 1000000, "one million"},
                { 10000000, "ten million"},
                { 100000000, "one hundred million"},
        };
    }

    @Test(dataProvider = "outOfRangeNumbersProvider", expectedExceptions = IllegalArgumentException.class)
    public void testPrintOutOfRange(int number) {
        testedDict.print(number);
    }

    @DataProvider(name="outOfRangeNumbersProvider")
    public Object[][] getOutOfRangeScenario() {
        return new Object[][] {
                { -1},
                { 1000000000}
        };
    }


}
