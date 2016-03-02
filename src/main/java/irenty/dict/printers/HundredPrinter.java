package irenty.dict.printers;



import java.util.List;

public class HundredPrinter extends AbstractPrinterChain {

    @Override
    protected void print(List<String> words) {
        int hundredDigit = threeDigits.getHundredDigit();
        if (hundredDigit == 0) {
            return;
        }
        words.add(translations.unit(hundredDigit));
        words.add(translations.scale(100));
    }
}
