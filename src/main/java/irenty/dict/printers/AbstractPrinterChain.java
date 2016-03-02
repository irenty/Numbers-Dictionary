package irenty.dict.printers;

import irenty.dict.model.ThreeDigits;
import irenty.dict.translations.Translations;

import java.util.List;

public abstract class AbstractPrinterChain implements PrinterChain {

    protected ThreeDigits threeDigits;
    protected Translations translations;
    private PrinterChain successor;

    protected abstract void print(List<String> words);

    public void process(List<String> words) {
        print(words);
        if (successor != null) {
            successor.process(words);
        }
    }

    public void setThreeDigits(ThreeDigits threeDigits) {
        this.threeDigits = threeDigits;
    }

    public void setTranslations(Translations translations) {
        this.translations = translations;
    }

    public void setSuccessor(PrinterChain successor) {
        this.successor = successor;
    }
}
