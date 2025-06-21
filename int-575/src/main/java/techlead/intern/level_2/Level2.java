package techlead.intern.level_2;

import techlead.intern.utility.LongestCommonSubsequence;
import techlead.intern.utility.ProcessNumber;
import techlead.intern.utility.ProcessString;

import java.math.BigDecimal;
import java.util.List;

public class Level2 {
    public BigDecimal secondNdLargestNumber(List<String> numbers) {
        return ProcessNumber.ndLargestNumber(2, numbers);
    }

    public String getLongestWord (String input) {
        String[] wordSplit = ProcessString.splitString(input);
        int maxLengthWord = wordSplit[0].length();
        String maxLengthWordString = wordSplit[0];
        for (String word : wordSplit) {
            if (word.length() > maxLengthWord) {
                maxLengthWord = word.length();
                maxLengthWordString = word;
            }
        }
        if (maxLengthWordString.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        return maxLengthWordString;
    }

    public String longestCommonSubstring(String a, String b) {
        return LongestCommonSubsequence.longestCommonSubstring(a, b);
    }

    public int sumDivisibleBy3And5(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            if (number % 3 == 0 && number % 5 == 0) {
                sum += number;
            }
        }
        return sum;
    }

    public int maxSubarraySum(int[] arr) {
        return ProcessNumber.maxSubarraySum(arr);
    }

    public static void main(String[] args) {
        System.out.println(new Level2().secondNdLargestNumber(List.of("1", "2", "3", "4", "5", "5")));
        System.out.println(new Level2().getLongestWord("2.2. Write a program that takes a list of strings as input and returns the longest word in the list"));
        System.out.println("Chuỗi con chung dài nhất: " + new Level2().longestCommonSubstring("abcdef", "abczyzcdef"));
        System.out.println("tong cac so chia het cho 3 va 5 la: " + new Level2().sumDivisibleBy3And5(List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)));
        System.out.println("Max subarray: " + new Level2().maxSubarraySum(new int[] {-2, -3, 4, -1, -2, 1, 5, -3}));

    }
}
