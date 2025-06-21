package techlead.intern.level3;

import techlead.intern.utility.GfG;
import techlead.intern.utility.MergeSort;
import techlead.intern.utility.ProcessNumber;
import techlead.intern.utility.StringOverlap;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Level3 {

    public BigDecimal maximumDifferenceTwoElements(List<String> numbers) {
        BigDecimal[] maxAndMin = ProcessNumber.findMaximumAndMinimum(numbers);
        return maxAndMin[0].subtract(maxAndMin[1]);
    }

    public int findSmallestUnreachable(int[] arr) {
        Arrays.sort(arr);
        int res = 1;
        for (int num : arr) {
            if (num > res) break;
            res += num;
        }
        return res;
    }

    public BigDecimal medianTwoArray(List<String> list1, List<String> list2) {
        List<BigDecimal> listMerge = MergeSort.mergeSort(ProcessNumber.sortNumbersAsc(list1), ProcessNumber.sortNumbersAsc(list2));
        return ProcessNumber.findMedianSorted(listMerge);
    }

    // Hàm đếm số ký tự khác nhau trong chuỗi
    private static int countDistinctChars(String str) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }

    // Hàm sắp xếp mảng theo đề bài
    public static void sortByDistinctChars(String[] array) {
        Arrays.sort(array, (s1, s2) -> {
            int distinct1 = countDistinctChars(s1);
            int distinct2 = countDistinctChars(s2);

            if (distinct1 != distinct2) {
                return Integer.compare(distinct1, distinct2);
            }
            return Integer.compare(s1.length(), s2.length());
        });
    }

    public static void main(String[] args) {
        System.out.println("Smallest 2nd is: " + ProcessNumber.ndSmallestNumber(2, List.of("1","2", "3", "4", "5", "6", "7", "8", "9")));
        System.out.println("Maximum difference between any two elements is: " + new Level3().maximumDifferenceTwoElements(List.of("1", "2", "91", "9", "100")));
        System.out.println("The longest increasing subsequence is: " + GfG.lis(new int[]{50, 3, 10, 7, 40, 80}));
        System.out.println("Largest overlap of characters: " + Arrays.toString(StringOverlap.findMaxOverlap(List.of("hello", "world", "foobar", "barfoo", "he", "llo"))));
        System.out.println("Smallest positive integer that cannot be represented as the sum of any subset of the list is: " + new Level3().findSmallestUnreachable(new int[]{1, 2, 3, 7, 8, 20}));
        System.out.println("median of two array is: " + new Level3().medianTwoArray(List.of("8", "9", "1","2", "7"), List.of("5", "6", "3", "4")));

        String[] words = {"apple", "banana", "orange", "kiwi", "strawberry"};

        sortByDistinctChars(words);

        System.out.println("Mảng sau khi sắp xếp:");
        for (String word : words) {
            System.out.print(word + " ");
        }


    }
}
