package techlead.intern.level4;

import techlead.intern.level_2.Level2;
import techlead.intern.utility.BubbleSort;
import techlead.intern.utility.LongestCommonSubsequence;
import techlead.intern.utility.ProcessNumber;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Level4 {

    public int countSortBubbleSort(int[] arr) {
        return BubbleSort.bubbleSort(arr);
    }

    public static int countSubsequences(int[] nums, int target) {
        return backtrack(nums, target, 0, 0, 0);
    }

    private static int backtrack(int[] nums, int target, int start, int currentSum, int length) {
        int total = 0;
        if (currentSum == target && length >= 2) {
            total += 1;
            // Không return ngay để đếm tiếp các subsequence khác mở rộng hơn
        }
        for (int i = start; i < nums.length; i++) {
            total += backtrack(nums, target, i + 1, currentSum + nums[i], length + 1);
        }
        return total;
    }

    public static int longestCommonSubstringLength(List<String> strings) {
        if (strings == null || strings.isEmpty()) return 0;
        // Tìm chuỗi ngắn nhất làm gốc
        String base = strings.stream().min(Comparator.comparingInt(String::length)).orElse("");

        int maxLen = base.length();

        // Duyệt từ độ dài substring lớn nhất xuống nhỏ nhất
        for (int len = maxLen; len > 0; len--) {
            for (int i = 0; i <= maxLen - len; i++) {
                String sub = base.substring(i, i + len);
                boolean isCommon = true;

                // Kiểm tra xem substring có nằm trong tất cả string không
                for (String s : strings) {
                    if (!s.contains(sub)) {
                        isCommon = false;
                        break;
                    }
                }

                if (isCommon) {
                    return len;
                }
            }
        }

        return 0; // Không có substring chung
    }

    public static List<String> sortByLengthAndAlphabet(List<String> strings) {
        return strings.stream().sorted((s1, s2) -> {
            int lengthCompare = Integer.compare(s2.length(), s1.length());
            if (lengthCompare != 0) return lengthCompare;
            return s1.compareTo(s2);
        }).toList();
    }

    public int findSmallestNumber(int[] arr) {
        Set<Integer> numbers = new HashSet<>();
        Set<Integer> consecutiveSums = new HashSet<>();

        // Thêm các số trong mảng vào set numbers
        for (int num : arr) {
            numbers.add(num);
        }

        // Tính tổng 2 số liên tiếp và thêm vào set consecutiveSums
        for (int i = 0; i < arr.length - 1; i++) {
            consecutiveSums.add(arr[i] + arr[i + 1]);
        }

        // Tìm số nguyên dương nhỏ nhất thỏa điều kiện
        int result = 1;
        while (true) {
            if (!numbers.contains(result) && !consecutiveSums.contains(result)) {
                return result;
            }
            result++;
        }
    }

    public int findLongestIncreasingSubsequence (int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int[] length = new int[arr.length];
        int index = 0;
        length[index] = 0;
        for (int i = 0; i < arr.length; i++) {
            if (length[index] == 0) length[index] += 1;
            else if (arr[i] - arr[i-1] == 1) length[index] += 1;
            else length[++index] = 1;
        }
        int max = length[0];
        for (int i = 1; i < length.length; i++) {
            if (max < length[i]) {
                max = length[i];
            }
        }
        return max;
    }

    public String longestCommonSubstringWithKLength(String a, String b, int k) {
        if (a == null || b == null) return "";
        return LongestCommonSubsequence.longestCommonSubstringWithKLength(a, b, k);
    }


    public static void main(String[] args) {
        System.out.println("Cần " + new Level4().countSortBubbleSort(new int[]{3, 1, 4, 2, 6, 5}) + " lần sắp xếp để hoàn thành");
        System.out.println("Số subsequences có tổng bằng 5 là: " + countSubsequences(new int[]{1, 2, 3, 4, 5}, 5));
        System.out.println(longestCommonSubstringLength(List.of("hello", "world", "jelly")));
        System.out.println(sortByLengthAndAlphabet(List.of("the quick brown fox", "the lazy dog jumps over the fence", "the cat in the hat")));
        System.out.println("Số nguyên dương bé nhất là: " + new Level4().findSmallestNumber(new int[] {1, 2, 3, 7, 8, 20}));
        System.out.println("Dộ dài chuỗi liên tiếp dài nhất là: " + new Level4().findLongestIncreasingSubsequence(new int[] {1, 2, 3, 8, 3, 2, 4, 5, 6, 7, 8, 9}));
        System.out.println("Chuỗi con chung dài nhất: " + new Level4().longestCommonSubstringWithKLength("abcdef", "abczyzcdef", 3));
    }
}
