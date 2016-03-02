package irenty.dict.printers;



import java.util.List;

public class TwoDigitsPrinter extends AbstractPrinterChain {

    @Override
    protected void print(List<String> words) {
        int lastTwo = threeDigits.getLastTwoDigits();
        if (lastTwo == 0) {
            return;
        }
        if (lastTwo < 20) {
            words.add(translations.unit(lastTwo));
            return;
        }

        int numOfTens = lastTwo / 10;
        words.add(translations.tens(numOfTens));

        int tensReminder = lastTwo % 10;
        if (tensReminder > 0) {
            words.add(translations.unit(tensReminder));
        }
    }
}
