package techlead.intern.utility;

import java.util.*;

public class SmallestExcludedNumber {
    public static int findSmallestNumber(int[] arr) {
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

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7};
        System.out.println("Số cần tìm là: " + findSmallestNumber(arr)); // Output: 4
    }
}

