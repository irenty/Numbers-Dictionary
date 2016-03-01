package irenty.dict.engb;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ThreeDigitsNumberGroupParamsPrecheckTest {

    private ThreeDigitsNumberGroupParamsPrecheck precheck = new ThreeDigitsNumberGroupParamsPrecheck();

    @Test(dataProvider = "paramsProvider")
    public void shouldValidateGroupParams(ScaleGroup scaleGroup, boolean isFirstGroup, boolean isValid) throws Exception {
        assertEquals(precheck.isPrintable(0, scaleGroup, isFirstGroup), isValid);
    }

    @DataProvider(name = "paramsProvider")
    public Object[][] paramsProvider() {
        return new Object[][]{
                {ScaleGroup.ONE, false, false},
                {ScaleGroup.THOUSAND, false, false},
                {ScaleGroup.MILLION, false, false},
                {ScaleGroup.ONE, true, true},
                {ScaleGroup.THOUSAND, true, false},
                {ScaleGroup.MILLION, true, false},
        };
    }
}