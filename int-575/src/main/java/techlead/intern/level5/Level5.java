package techlead.intern.level5;

import techlead.intern.utility.ReverseArray;
import techlead.intern.utility.Unique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level5 {
    public String[] reverseArray(String[] arr) {
        return ReverseArray.reverse(arr);
    }

    public static List<List<String>> chunk(String[] arr, int chunkSize) {
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i += chunkSize) {
            List<String> chunk = new ArrayList<>();
            for (int j = i; j < i + chunkSize && j < arr.length; j++) {
                chunk.add(arr[j]);
            }
            result.add(chunk);
        }

        return result;
    }

    public static List<Integer> unique(Integer[] arr) {
        return Unique.unique(arr);
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Level5().reverseArray(new String[]{"1", "2", "3"})));
        System.out.println((chunk(new String[]{"a", "b", "c", "d"}, 3)));
        System.out.println(unique(new Integer[]{1, 2, 3, 2, 4, 3, 3}));
    }
}
