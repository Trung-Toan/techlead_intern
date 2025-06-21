package techlead.intern.level4;

import techlead.intern.utility.BubbleSort;

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


    public static void main(String[] args) {
        System.out.println("Cần " + new Level4().countSortBubbleSort(new int[]{3, 1, 4, 2, 6, 5}) + " lần sắp xếp để hoàn thành");
        System.out.println("Số subsequences có tổng bằng 5 là: " + countSubsequences(new int[] {1, 2, 3, 4, 5}, 5));

    }

    // Function to print an array
    static void printArray(int[] arr) {
        int size = arr.length;
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
