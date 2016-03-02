package irenty.dict.model;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ThreeDigitsTest {

    @Test(dataProvider = "numbersProvider")
    public void testShouldPrefixWithWordAnd(ThreeDigits number, boolean shouldPrefix) throws Exception {
        assertEquals(number.shouldPrefixWithWordAnd(), shouldPrefix);
    }

    @DataProvider(name = "numbersProvider")
    public Object[][] getScenario() {
        return new Object[][]{
                {new ThreeDigits(0, ScaleGroup.ONE), false},
                {new ThreeDigits(1, ScaleGroup.ONE), false},
                {new ThreeDigits(99, ScaleGroup.ONE), false},
                {new ThreeDigits(100, ScaleGroup.ONE), false},
                {new ThreeDigits(999, ScaleGroup.ONE), false},
                {new ThreeDigits(1001, ScaleGroup.ONE), true},
                {new ThreeDigits(1099, ScaleGroup.ONE), true},
        };
    }

}