package irenty.dict.engb;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ThreeDigitsNumbersDictionaryEnGBTest {

    private ThreeDigitsNumberDictionaryEnGB testedDict = new ThreeDigitsNumberDictionaryEnGB();

    @Test(dataProvider = "numbersProvider")
    public void testPrint(ThreeDigitsNumberGroup number, String name) {
        assertEquals(testedDict.print(number), name);
    }

    @DataProvider(name = "numbersProvider")
    public Object[][] getScenario() {
        return new Object[][]{
                {new ThreeDigitsNumberGroup(0, ScaleGroup.ONE, true), "zero"},
                {new ThreeDigitsNumberGroup(1, ScaleGroup.ONE, true), "one"},
                {new ThreeDigitsNumberGroup(21, ScaleGroup.ONE, true), "twenty one"},
                {new ThreeDigitsNumberGroup(99, ScaleGroup.ONE, true), "ninety nine"},
                {new ThreeDigitsNumberGroup(100, ScaleGroup.ONE, true), "one hundred"},
                {new ThreeDigitsNumberGroup(101, ScaleGroup.ONE, true), "one hundred and one"},
                {new ThreeDigitsNumberGroup(999, ScaleGroup.ONE, true), "nine hundred and ninety nine"},
                {new ThreeDigitsNumberGroup(1, ScaleGroup.ONE, false), "and one"},
                {new ThreeDigitsNumberGroup(21, ScaleGroup.ONE, false), "and twenty one"},
                {new ThreeDigitsNumberGroup(99, ScaleGroup.ONE, false), "and ninety nine"},
                {new ThreeDigitsNumberGroup(100, ScaleGroup.ONE, false), "one hundred"},
                {new ThreeDigitsNumberGroup(101, ScaleGroup.ONE, false), "one hundred and one"},
                {new ThreeDigitsNumberGroup(121, ScaleGroup.ONE, false), "one hundred and twenty one"},
                {new ThreeDigitsNumberGroup(999, ScaleGroup.ONE, false), "nine hundred and ninety nine"},
                {new ThreeDigitsNumberGroup(1, ScaleGroup.THOUSAND, true), "one thousand"},
                {new ThreeDigitsNumberGroup(21, ScaleGroup.THOUSAND, true), "twenty one thousand"},
                {new ThreeDigitsNumberGroup(99, ScaleGroup.THOUSAND, true), "ninety nine thousand"},
                {new ThreeDigitsNumberGroup(100, ScaleGroup.THOUSAND, true), "one hundred thousand"},
                {new ThreeDigitsNumberGroup(101, ScaleGroup.THOUSAND, true), "one hundred and one thousand"},
                {new ThreeDigitsNumberGroup(101, ScaleGroup.THOUSAND, true), "one hundred and one thousand"},
                {new ThreeDigitsNumberGroup(999, ScaleGroup.THOUSAND, true), "nine hundred and ninety nine thousand"},
                {new ThreeDigitsNumberGroup(1, ScaleGroup.THOUSAND, false), "and one thousand"},
                {new ThreeDigitsNumberGroup(21, ScaleGroup.THOUSAND, false), "and twenty one thousand"},
                {new ThreeDigitsNumberGroup(99, ScaleGroup.THOUSAND, false), "and ninety nine thousand"},
                {new ThreeDigitsNumberGroup(100, ScaleGroup.THOUSAND, false), "one hundred thousand"},
                {new ThreeDigitsNumberGroup(101, ScaleGroup.THOUSAND, false), "one hundred and one thousand"},
                {new ThreeDigitsNumberGroup(121, ScaleGroup.THOUSAND, false), "one hundred and twenty one thousand"},
                {new ThreeDigitsNumberGroup(999, ScaleGroup.THOUSAND, false), "nine hundred and ninety nine thousand"},
                {new ThreeDigitsNumberGroup(1, ScaleGroup.MILLION, true), "one million"},
                {new ThreeDigitsNumberGroup(21, ScaleGroup.MILLION, true), "twenty one million"},
                {new ThreeDigitsNumberGroup(99, ScaleGroup.MILLION, true), "ninety nine million"},
                {new ThreeDigitsNumberGroup(100, ScaleGroup.MILLION, true), "one hundred million"},
                {new ThreeDigitsNumberGroup(101, ScaleGroup.MILLION, true), "one hundred and one million"},
                {new ThreeDigitsNumberGroup(101, ScaleGroup.MILLION, true), "one hundred and one million"},
                {new ThreeDigitsNumberGroup(999, ScaleGroup.MILLION, true), "nine hundred and ninety nine million"},
        };
    }
}