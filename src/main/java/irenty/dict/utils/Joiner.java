package irenty.dict.utils;

import java.util.Iterator;
import java.util.List;

public class Joiner {

    private final char joinChar;

    private Joiner(char joinChar) {
        this.joinChar = joinChar;
    }

    public static Joiner on(char joinChar) {
        return new Joiner(joinChar);
    }

    public String join(List<String> tokens) {
        if (tokens.isEmpty()) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        Iterator<String> it = tokens.iterator();
        sb.append(it.next());
        while (it.hasNext()) {
            sb.append(joinChar);
            sb.append(it.next());
        }
        return sb.toString();
    }
}
