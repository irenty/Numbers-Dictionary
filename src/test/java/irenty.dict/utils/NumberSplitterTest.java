package irenty.dict.utils;

import irenty.dict.model.ScaleGroup;
import irenty.dict.model.ThreeDigits;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class NumberSplitterTest {

    private NumberSplitter testedSplitter = new NumberSplitter();

    @Test
    public void testSplitByThousands_1() throws Exception {
        List<ThreeDigits> result = testedSplitter.splitByThousands(1);
        assertEquals(result.size(), 3);
        Assert.assertEquals(result.get(0).getScaleGroup(), ScaleGroup.MILLION);
        assertEquals(result.get(1).getScaleGroup(), ScaleGroup.THOUSAND);
        assertEquals(result.get(2).getScaleGroup(), ScaleGroup.ONE);
        assertFalse(result.get(0).isBiggestPrintableGroup());
        assertFalse(result.get(1).isBiggestPrintableGroup());
        assertTrue(result.get(2).isBiggestPrintableGroup());
    }

    @Test
    public void testSplitByThousands_1000() throws Exception {
        List<ThreeDigits> result = testedSplitter.splitByThousands(1000);
        assertEquals(result.size(), 3);
        assertEquals(result.get(0).getScaleGroup(), ScaleGroup.MILLION);
        assertEquals(result.get(1).getScaleGroup(), ScaleGroup.THOUSAND);
        assertEquals(result.get(2).getScaleGroup(), ScaleGroup.ONE);
        assertFalse(result.get(0).isBiggestPrintableGroup());
        assertTrue(result.get(1).isBiggestPrintableGroup());
        assertFalse(result.get(2).isBiggestPrintableGroup());
    }

    @Test
    public void testSplitByThousands_1000000() throws Exception {
        List<ThreeDigits> result = testedSplitter.splitByThousands(1000000);
        assertEquals(result.size(), 3);
        assertEquals(result.get(0).getScaleGroup(), ScaleGroup.MILLION);
        assertEquals(result.get(1).getScaleGroup(), ScaleGroup.THOUSAND);
        assertEquals(result.get(2).getScaleGroup(), ScaleGroup.ONE);
        assertTrue(result.get(0).isBiggestPrintableGroup());
        assertFalse(result.get(1).isBiggestPrintableGroup());
        assertFalse(result.get(2).isBiggestPrintableGroup());
    }
}