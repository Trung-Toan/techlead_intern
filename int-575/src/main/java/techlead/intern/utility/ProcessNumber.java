package techlead.intern.utility;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class ProcessNumber {
    private static void checkNullOrEmptyNumber(List<String> number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
    }
    public static BigDecimal ndLargestNumber(int nd, List<String> numbers) {
        checkNullOrEmptyNumber(numbers);
        // sort the list in descending order
        Set<BigDecimal> sortedNumbers = new LinkedHashSet<>(sortNumbersDesc(numbers));
        return sortedNumbers.stream()
                .skip(nd - 1)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not enough unique numbers to find the " + nd + "th largest number"));
    }

    public static BigDecimal ndSmallestNumber(int nd, List<String> numbers) {
        checkNullOrEmptyNumber(numbers);
        // sort the list in descending order
        Set<BigDecimal> sortedNumbers = new LinkedHashSet<>(sortNumbersAsc(numbers));
        return sortedNumbers.stream()
                .skip(nd - 1)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not enough unique numbers to find the " + nd + "th smallest number"));
    }

    public static BigDecimal[] findMaximumAndMinimum(List<String> numbers) {
        checkNullOrEmptyNumber(numbers);
        Set<BigDecimal> sortedNumbers = new LinkedHashSet<>(sortNumbersDesc(numbers));

        if (sortedNumbers.isEmpty()) {
            throw new IllegalArgumentException("No numbers provided");
        }

        BigDecimal max = sortedNumbers.stream().findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No numbers to find maximum"));

        BigDecimal min = sortedNumbers.stream()
                .reduce((first, second) -> second) // get last element in the set
                .orElseThrow(() -> new IllegalArgumentException("No numbers to find minimum"));

        return new BigDecimal[]{max, min};
    }


    public static List<BigDecimal> sortNumbersAsc(List<String> numbers) {
        checkNullOrEmptyNumber(numbers);
        List<BigDecimal> sortedNumbers = parseNumber(numbers);
        sortedNumbers.sort(BigDecimal::compareTo);
        return sortedNumbers;
    }

    public static List<BigDecimal> sortNumbersDesc(List<String> numbers) {
        checkNullOrEmptyNumber(numbers);
        List<BigDecimal> sortedNumbers = parseNumber(numbers);
        sortedNumbers.sort(Comparator.reverseOrder());
        return sortedNumbers;
    }

    public static BigDecimal median(List<String> numbers) {
        checkNullOrEmptyNumber(numbers);
        List<BigDecimal> sortedNumbers = sortNumbersAsc(numbers);
        return findMedian(sortedNumbers);
    }

    private static BigDecimal findMedian(List<BigDecimal> numbers) {
        int size = numbers.size();
        if (size % 2 == 0) {
            BigDecimal mid1 = numbers.get(size / 2 - 1);
            BigDecimal mid2 = numbers.get(size / 2);
            return (mid1.add(mid2)).divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_UP); // div and làm tròn
        } else {
            return numbers.get((size - 1) / 2);
        }
    }

    public static BigDecimal findMedianSorted(List<BigDecimal> sortedNumbers) {
        if ( sortedNumbers == null || sortedNumbers.isEmpty()) {
            throw new IllegalArgumentException("No numbers provided");
        }
        return findMedian(sortedNumbers);
    }

    private static List<BigDecimal> parseNumber(List<String> numbers) {
        List<BigDecimal> parseNumber = new ArrayList<>();
        for (String number : numbers) {
            parseNumber.add(CheckNumber.parseNumber(number));
        }
        return parseNumber;
    }

    // Function to find the maximum subarray sum
    public static int maxSubarraySum(int[] arr) {
        int res = arr[0];
        int maxEnding = arr[0];

        for (int i = 1; i < arr.length; i++) {

            // Find the maximum sum ending at index i by either extending
            // the maximum sum subarray ending at index i - 1 or by
            // starting a new subarray from index i
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);

            // Update res if maximum subarray sum ending at index i > res
            res = Math.max(res, maxEnding);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubarraySum(arr));
    }
}
