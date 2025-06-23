package techlead.intern.utility;

import java.util.ArrayList;
import java.util.List;

public class Unique {
    public static List<Integer> unique(Integer[] arr) {
        // Convert array to list for return type compatibility
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }

        // First pass: count unique elements
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i].equals(arr[j])) {
                        arr[j] = null; // Mark duplicates as null
                    }
                }
            }
        }

        // Second pass: add non-null elements to result
        for (Integer num : arr) {
            if (num != null) {
                result.add(num);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(unique(new Integer[]{1, 2, 3, 2, 4, 3, 3}));
    }
}
