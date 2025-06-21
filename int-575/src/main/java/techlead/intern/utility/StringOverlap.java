package techlead.intern.utility;
import java.util.*;

public class StringOverlap {
    // Function to count common characters between two strings
    private static int countCommonChars(String s1, String s2) {
        // Convert strings to char arrays and sort them
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int count = 0;
        int i = 0, j = 0;

        // Count matching characters
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                count++;
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return count;
    }

    // Function to find two strings with maximum overlap
    public static String[] findMaxOverlap(List<String> strings) {
        if (strings == null || strings.size() < 2) {
            return new String[]{};
        }

        String[] result = new String[2];
        int maxOverlap = -1;

        // Compare each pair of strings
        for (int i = 0; i < strings.size(); i++) {
            for (int j = i + 1; j < strings.size(); j++) {
                String s1 = strings.get(i);
                String s2 = strings.get(j);
                int overlap = countCommonChars(s1, s2);

                if (overlap > maxOverlap) {
                    maxOverlap = overlap;
                    result[0] = s1;
                    result[1] = s2;
                }
            }
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test case 1
        List<String> test1 = Arrays.asList("hello", "world", "foobar", "barfoo", "he", "llo");
        String[] result1 = findMaxOverlap(test1);
        System.out.println("Test 1: " + Arrays.toString(result1));

        // Test case 2
        List<String> test2 = Arrays.asList("hello", "world", "foobar", "barfoo", "he", "llo", "foobars", "abc", "cba");
        String[] result2 = findMaxOverlap(test2);
        System.out.println("Test 2: " + Arrays.toString(result2));
    }
}