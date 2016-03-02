package irenty.dict.engb;

import irenty.dict.model.ScaleGroup;
import irenty.dict.model.ThreeDigits;
import irenty.dict.printers.*;
import irenty.dict.translations.Translations;
import irenty.dict.utils.NumberSplitter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Builds a printers chain that can be used to print integer numbers
 */
public class PrintersChainBuilder {

    private final NumberSplitter numberSplitter = new NumberSplitter();
    private final Translations translations;

    public PrintersChainBuilder(Translations translations) {
        this.translations = translations;
    }

    public PrinterChain build(int number) {
        List<ThreeDigits> threeDigitGroups = numberSplitter.splitByThousands(number);

        List<AbstractPrinterChain> chains = new ArrayList<AbstractPrinterChain>();
        for (ThreeDigits threeDigits : threeDigitGroups) {
            buildForGroup(chains, threeDigits);
        }
        configureAndAddChain(chains, new ThreeDigits(number, ScaleGroup.ONE), new ZeroPrinter());
        return linkChains(chains);
    }

    private PrinterChain linkChains(List<AbstractPrinterChain> chains) {
        Iterator<AbstractPrinterChain> iterator = chains.iterator();
        AbstractPrinterChain firstChain = iterator.next();
        AbstractPrinterChain previousChain = firstChain;
        while (iterator.hasNext()) {
            AbstractPrinterChain thisChain = iterator.next();
            previousChain.setSuccessor(thisChain);
            previousChain = thisChain;
        }
        return firstChain;
    }

    private void buildForGroup(List<AbstractPrinterChain> chains, ThreeDigits threeDigits) {
        configureAndAddChain(chains, threeDigits, new HundredPrinter());
        configureAndAddChain(chains, threeDigits, new AndBeforeTwoDigitsPrinter());
        configureAndAddChain(chains, threeDigits, new TwoDigitsPrinter());
        configureAndAddChain(chains, threeDigits, new ScalePrinter());
    }

    private void configureAndAddChain(List<AbstractPrinterChain> chains, ThreeDigits threeDigits, AbstractPrinterChain chain) {
        chain.setThreeDigits(threeDigits);
        chain.setTranslations(translations);
        chains.add(chain);
    }
}
