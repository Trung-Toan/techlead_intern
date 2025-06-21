package techlead.intern.utility;

import java.math.BigDecimal;

public class CheckNumber {

    /**
     * Checks if the input string is a valid long number.
     *
     * @param number the input string to check
     * @return the parsed long value if valid
     * @throws IllegalArgumentException if the input is null, empty, or not a valid long
     */
    private static void checkNullOrEmptyNumber(String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
    }

    public static BigDecimal parseNumber(String number) {
        checkNullOrEmptyNumber(number);
        number = number.replace(",", ".");
        try {
            return new BigDecimal(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input is not a valid number");
        }
    }


    /**
     * Checks if the input string is a valid integer number.
     *
     * @param number the input string to check
     * @return the parsed integer value if valid
     * @throws IllegalArgumentException if the input is null, empty, or not a valid integer
     */
    public static int parseIntegerNumber(String number) {
        checkNullOrEmptyNumber(number);
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input must be a valid integer");
        }
    }

    /**
     * Checks if the input string is a valid double number.
     *
     * @param number the input string to check
     * @return the parsed double value if valid
     * @throws IllegalArgumentException if the input is null, empty, or not a valid double
     */
    public static long parseLongNumber(String number) {
        checkNullOrEmptyNumber(number);
        try {
            return Long.parseLong(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input must be a valid long number");
        }
    }

    /**
     * Checks if the input string is a valid double number.
     *
     * @param number the input string to check
     * @return the parsed double value if valid
     * @throws IllegalArgumentException if the input is null, empty, or not a valid double
     */
    public static double parseDoubleNumber(String number) {
        checkNullOrEmptyNumber(number);
        number = number.replace(",", ".");
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input must be a valid double number");
        }
    }

    /**
     * Checks if the input string is a valid float number.
     *
     * @param number the input string to check
     * @return the parsed float value if valid
     * @throws IllegalArgumentException if the input is null, empty, or not a valid float
     */
    public static float parseFloatNumber(String number) {
        checkNullOrEmptyNumber(number);
        number = number.replace(",", ".");
        try {
            return Float.parseFloat(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input must be a valid float number");
        }
    }


}


