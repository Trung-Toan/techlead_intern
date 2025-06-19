package techlead.intern.level_1;

import techlead.intern.utility.CheckNumber;
import techlead.intern.utility.ProcessNumber;
import techlead.intern.utility.ProcessString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Level1 {

    /**
     * Sums two string representations of numbers.
     *
     * @param a the first number as a string
     * @param b the second number as a string
     * @return the sum of the two numbers as a Number object
     * @throws IllegalArgumentException if either input is invalid
     */
    public Number sum(String a, String b) {
        try {
            return CheckNumber.parseNumber(a).add(CheckNumber.parseNumber(b));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid input: " + e.getMessage());
        }
    }

    /**
     * Returns the length of the input string.
     *
     * @param input the input string
     * @return the length of the input string
     * @throws IllegalArgumentException if the input is null
     */
    public int stringLength(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return input.length();
    }

    /**
     * Calculates the square of a number represented as a string.
     *
     * @param number the number as a string
     * @return the square of the number as a Number object
     * @throws IllegalArgumentException if the input is invalid
     */
    public Number square(String number) {
        try {
            return CheckNumber.parseNumber(number).multiply(CheckNumber.parseNumber(number));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid input: " + e.getMessage());
        }
    }

    // Write a program that takes a list of numbers as input and displays the largest number in the list.
    public BigDecimal firstNdLargestNumber(List<String> numbers) {
        return ProcessNumber.ndLargestNumber(1, numbers);
    }

    // Write a program that takes a list of strings as input and displays the shortest string in the list.
    public String shortestString(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("Input list cannot be null or empty");
        }
        String shortest = strings.get(0);
        for (String str : strings) {
            if (str.length() < shortest.length()) {
                shortest = str;
            }
        }
        return shortest;
    }

    //Write a program that takes a list of numbers as input and sorts the list  in ascending order.
    public List<BigDecimal> sortNumbers(List<String> numbers) {
        return ProcessNumber.sortNumbersAsc(numbers);
    }

    //Write a program that takes a list of strings as input and sorts the list in alphabetical order.
    public List<String> sortStrings(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("Input list cannot be null or empty");
        }
        List<String> sortedStrings = new ArrayList<>(strings);
        sortedStrings.sort(String::compareTo);
        return sortedStrings;
    }

    // Write a program that takes a list of numbers as input and returns the median of the numbers.
    public BigDecimal median(List<String> numbers) {
        return ProcessNumber.median(numbers);
    }

    // Write a program that takes a string as input and returns the number of words in the string.
    public int wordCount(String input) {
        return ProcessString.splitString(input).length;
    }

    // Write a program that takes a list of strings as input and returns the number of strings that contain the letter 'a'.
    public int countStringsWithLetterA(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("Input list cannot be null or empty");
        }
        int count = 0;
        for (String str : strings) {
            if (str.contains("a") || str.contains("A")) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        try {
//            System.out.println("Sum = " + new Level1().sum("10", "20"));
//            System.out.println("Length = " + new Level1().stringLength(""));
//            System.out.println("Square = " + new Level1().square("5.3"));
//            System.out.println("Largest Number = " + new Level1().largestNumber(List.of("10", "20", "5.3", "100", "50")))
//            System.out.println("Shortest String = " + new Level1().shortestString(List.of("apple", "banana", "kiwi", "pear")));
//            System.out.println("Shortest String = " + new Level1().shortestString(List.of("apple", "banana", "kiwi", "pear")));
//            System.out.println("Sorted Numbers = " + new Level1().sortNumbers(List.of("10", "20", "5.3", "100", "50")));
//            System.out.println("Sorted Strings = " + new Level1().sortStrings(List.of("apple", "banana", "kiwi", "pear")));
//            System.out.println("Median = " + new Level1().median(List.of("10", "20", "5.3", "100", "50")));
//            System.out.println("Word Count = " + new Level1().wordCount("Hello world! This is a test."));
//            System.out.println("Count of strings with letter 'a' = " + new Level1().countStringsWithLetterA(List.of("apple", "banana", "kiwi", "pear", "grape")));
        } catch (NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
