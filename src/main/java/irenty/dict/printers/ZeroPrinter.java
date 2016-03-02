package irenty.dict.printers;


import java.util.List;

public class ZeroPrinter extends AbstractPrinterChain {

    @Override
    protected void print(List<String> words) {
        if (threeDigits.getNumber() == 0) {
            words.add(translations.unit(0));
        }
    }
}
