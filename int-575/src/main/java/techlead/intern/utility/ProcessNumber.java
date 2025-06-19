package techlead.intern.utility;

import java.math.BigDecimal;
import java.util.*;

public class ProcessNumber {
    public static BigDecimal ndLargestNumber(int nd, List<String> numbers) {
        // sort the list in descending order
        Set<BigDecimal> sortedNumbers = new LinkedHashSet<>(sortNumbersDesc(numbers));
        return sortedNumbers.stream()
                .skip(nd - 1)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not enough unique numbers to find the " + nd + "th largest number"));
    }

    public static List<BigDecimal> sortNumbersAsc(List<String> numbers) {
        List<BigDecimal> sortedNumbers = parseNumber(numbers);
        sortedNumbers.sort(BigDecimal::compareTo);
        return sortedNumbers;
    }

    public static List<BigDecimal> sortNumbersDesc(List<String> numbers) {
        List<BigDecimal> sortedNumbers = parseNumber(numbers);
        sortedNumbers.sort(Comparator.reverseOrder());
        return sortedNumbers;
    }

    public static BigDecimal median(List<String> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Input list cannot be null or empty");
        }
        List<BigDecimal> sortedNumbers = sortNumbersAsc(numbers);
        int size = sortedNumbers.size();
        if (size % 2 == 0) {
            BigDecimal mid1 = sortedNumbers.get(size / 2 - 1);
            BigDecimal mid2 = sortedNumbers.get(size / 2);
            return mid1.add(mid2).divide(BigDecimal.valueOf(2));
        } else {
            return sortedNumbers.get((size - 1) / 2);
        }
    }

    private static List<BigDecimal> parseNumber(List<String> numbers) {
        List<BigDecimal> parseNumber = new ArrayList<>();
        for (String number : numbers) {
            parseNumber.add(CheckNumber.parseNumber(number));
        }
        return parseNumber;
    }

}
