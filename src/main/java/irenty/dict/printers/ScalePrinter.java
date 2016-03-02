package irenty.dict.printers;



import irenty.dict.model.ScaleGroup;

import java.util.List;

public class ScalePrinter extends AbstractPrinterChain {

    @Override
    protected void print(List<String> words) {
        ScaleGroup scaleGroup = threeDigits.getScaleGroup();
        if (scaleGroup == ScaleGroup.ONE) {
            return;
        }
        if (threeDigits.getThreeDigits() > 0) {
            words.add(translations.scale(scaleGroup.getScale()));
        }
    }
}
