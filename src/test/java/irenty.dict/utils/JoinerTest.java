package irenty.dict.utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class JoinerTest {

    @Test(dataProvider = "scenarioDataProvider")
    public void testJoiner(String[] input, char joiner, String output) throws Exception {
        List<String> list = Arrays.asList(input);
        assertEquals(Joiner.on(joiner).join(list), output);
    }

    @DataProvider(name = "scenarioDataProvider")
    public Object[][] getScenario() {
        return new Object[][]{
                {new String[]{"a", "b", "c"}, ' ', "a b c"},
                {new String[]{"a", "b", "c"}, ',', "a,b,c"},
                {new String[]{}, ',', ""},
        };
    }
}