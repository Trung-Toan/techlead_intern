package techlead.intern.utility;

import java.util.*;

public class LongestPalindrome {
    public static int longestPalindromeLength(String input) {
        // Loại bỏ khoảng trắng và chuyển về chữ thường
        input = input.replaceAll("\\s+", "").toLowerCase();

        Map<Character, Integer> freqMap = new HashMap<>();

        // Đếm số lần xuất hiện của từng ký tự
        for (char c : input.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int length = 0;
        boolean hasOdd = false;

        for (int count : freqMap.values()) {
            // Cộng số chẵn
            length += (count / 2) * 2;
            // Nếu còn số lẻ thì đánh dấu lại
            if (count % 2 == 1) {
                hasOdd = true;
            }
        }

        // Nếu có ít nhất 1 ký tự lẻ thì cộng thêm 1 cho ký tự ở giữa
        if (hasOdd) {
            length += 1;
        }

        return length;
    }

    public static void main(String[] args) {
        String input = "A man a plan a canal Panama";
        int result = longestPalindromeLength(input);
        System.out.println("Độ dài palindrome dài nhất có thể: " + result);
    }
}
