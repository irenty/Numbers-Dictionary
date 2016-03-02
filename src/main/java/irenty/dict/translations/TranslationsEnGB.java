package irenty.dict.translations;


public class TranslationsEnGB implements Translations {

    private static final String[] UNITS = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] TENS = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public String unit(int number) {
        return UNITS[number];
    }

    public String tens(int number) {
        return TENS[number];
    }

    public String scale(int scale) {
        switch (scale) {
            case 100: return "hundred";
            case 1000: return "thousand";
            case 1000000: return "million";
        }
        return "";
    }

    public String translate(Word word) {
        return word == Word.AND ? "and" : null;
    }

}
