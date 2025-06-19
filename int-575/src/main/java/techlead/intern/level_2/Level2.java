package techlead.intern.level_2;

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

    public static void main(String[] args) {
        System.out.println(new Level2().secondNdLargestNumber(List.of("1", "2", "3", "4", "5", "5")));
    }
}
