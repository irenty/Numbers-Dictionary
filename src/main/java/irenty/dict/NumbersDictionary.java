package irenty.dict;

public interface NumbersDictionary {

    /**
     * Returns a text representation of an integer number.
     * Supports numbers in range of [0, 999999999]
     *
     * @param number input number
     * @return text representation of an integer number
     * @exception IllegalArgumentException if the number is out of supported range
     */
    String print(int number);

}
