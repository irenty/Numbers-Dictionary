package irenty.dict;

import irenty.dict.engb.NumbersDictionaryEnGB;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.testng.Assert.*;

public class NumbersDictionaryRegisterTest {

    @Test(dataProvider = "dictionaryProvider")
    public void shouldReturnFactoryForASupportedLocale(Locale locale, Class dictImplClazz) throws Exception {
        NumbersDictionary dict = NumbersDictionaryRegister.get(locale);
        assertTrue(dict.getClass().equals(dictImplClazz), "Incorrect implementation");
    }

    @DataProvider(name="dictionaryProvider")
    public Object[][] getScenario() {
        return new Object[][] {
                { new Locale("en", "GB"), NumbersDictionaryEnGB.class }
        };
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForUnsupportedLocale() throws Exception {
        NumbersDictionaryRegister.get(new Locale("fr"));
    }


}