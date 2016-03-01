package irenty.dict.engb;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ThreeDigitsNumberGroupTest {

    @Test(dataProvider = "numbersProvider")
    public void testShouldPrefixWithWordAnd(ThreeDigitsNumberGroup number, boolean shouldPrefix) throws Exception {
        assertEquals(number.shouldPrefixWithWordAnd(), shouldPrefix);
    }

    @DataProvider(name = "numbersProvider")
    public Object[][] getScenario() {
        return new Object[][]{
                {new ThreeDigitsNumberGroup(1, ScaleGroup.ONE, false), true},
                {new ThreeDigitsNumberGroup(99, ScaleGroup.ONE, false), true},
                {new ThreeDigitsNumberGroup(100, ScaleGroup.ONE, false), false},
                {new ThreeDigitsNumberGroup(999, ScaleGroup.ONE, false), false},
                {new ThreeDigitsNumberGroup(0, ScaleGroup.ONE, true), false},
                {new ThreeDigitsNumberGroup(1, ScaleGroup.ONE, true), false},
                {new ThreeDigitsNumberGroup(99, ScaleGroup.ONE, true), false},
                {new ThreeDigitsNumberGroup(100, ScaleGroup.ONE, true), false},
                {new ThreeDigitsNumberGroup(999, ScaleGroup.ONE, true), false},
        };
    }

}