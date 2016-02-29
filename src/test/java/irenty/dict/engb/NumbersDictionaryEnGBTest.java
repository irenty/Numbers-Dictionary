package irenty.dict.engb;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NumbersDictionaryEnGBTest {

    private final NumbersDictionaryEnGB testedDict = new NumbersDictionaryEnGB();

    @Test(dataProvider = "numbersProvider")
    public void testPrint(int number, String name) {
        assertEquals(testedDict.print(number), name);
    }

    @DataProvider(name="numbersProvider")
    public Object[][] getScenario() {
        return new Object[][] {
                { 0, "zero"},
                { 1, "one"},
                { 21, "twenty one"},
                { 105, "one hundred and five"},
                { 123, "one hundred and twenty three"},
                { 1005, "one thousand and five"},
                { 1042, "one thousand and forty two"},
                { 1105, "one thousand one hundred and five"},
                { 56945781, "fifty six million nine hundred and forty five thousand seven hundred and eighty one"},
                { 999999999, "nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine"}
        };
    }


}
