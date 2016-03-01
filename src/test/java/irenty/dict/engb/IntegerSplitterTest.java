package irenty.dict.engb;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class IntegerSplitterTest {

    private IntegerSplitter testedSplitter = new IntegerSplitter();

    @Test(dataProvider = "scenarioDataProvider")
    public void testSplitByThousands(int number, ThreeDigitsNumberGroup firstGroup) throws Exception {
        List<ThreeDigitsNumberGroup> result = testedSplitter.splitByThousands(number);
        assertEquals(result.size(), 1);
        ThreeDigitsNumberGroup actualFirstGroup = result.get(0);
        assertEquals(actualFirstGroup, firstGroup);
    }

    @DataProvider(name = "scenarioDataProvider")
    public Object[][] getScenario() {
        return new Object[][]{
                {0, g(0, ScaleGroup.ONE, true)},
                {1, g(1, ScaleGroup.ONE, true)},
                {99, g(99, ScaleGroup.ONE, true)},
                {100, g(100, ScaleGroup.ONE, true)},
                {999, g(999, ScaleGroup.ONE, true)},
        };
    }

    private ThreeDigitsNumberGroup g(int number, ScaleGroup scaleGroup, boolean biggestPrintableGroup) {
        return new ThreeDigitsNumberGroup(number, scaleGroup, biggestPrintableGroup);
    }
}