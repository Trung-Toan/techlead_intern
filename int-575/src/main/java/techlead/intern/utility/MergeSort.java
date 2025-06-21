package techlead.intern.utility;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static List<BigDecimal> mergeSort(List<BigDecimal> list1, List<BigDecimal> list2) {
        List<BigDecimal> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        int n1 = list1.size();
        int n2 = list2.size();

        // So sánh từng phần tử và thêm vào list kết quả
        while (i < n1 && j < n2) {
            if (list1.get(i).compareTo(list2.get(j)) < 0)
                mergedList.add(list1.get(i++));
            else
                mergedList.add(list2.get(j++));
        }

        // Thêm các phần tử còn lại của list1 (nếu có)
        while (i < n1)
            mergedList.add(list1.get(i++));

        // Thêm các phần tử còn lại của list2 (nếu có)
        while (j < n2)
            mergedList.add(list2.get(j++));

        return mergedList;
    }

}
