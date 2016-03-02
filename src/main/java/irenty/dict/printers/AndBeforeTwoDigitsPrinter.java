package irenty.dict.printers;

import irenty.dict.translations.Word;

import java.util.List;

/**
 * Prints 'and' word
 */
public class AndBeforeTwoDigitsPrinter extends AbstractPrinterChain {

    @Override
    protected void print(List<String> words) {
        int lastTwo = threeDigits.getLastTwoDigits();
        if (lastTwo == 0) {
            return;
        }
        int shouldPrintAndForAtLeast = threeDigits.getScaleGroup().getScale() * 100;
        if (threeDigits.getNumber() >= shouldPrintAndForAtLeast) {
            words.add(translations.translate(Word.AND));
        }
    }
}
