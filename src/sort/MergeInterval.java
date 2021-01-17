package sort;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 56. 合并区间
 */
public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        sortArray(intervals);
        List<int[]> merge = new ArrayList<>();
        // 获取当前需要比较的值
        merge.add(intervals[0]);
//        合并
        for (int i = 1; i < intervals.length; i++) {
//            System.out.printf("%d, %d \n", intervals[i][0], intervals[i][1]);
            // 什么条件下不能合并?
            int[] current = merge.get(merge.size() - 1);
            if (!(current[1] < intervals[i][0])) {
                int left = 0;
                int right = 0;
                if (current[0] > intervals[i][0]) {
                    left = intervals[i + 1][0];
                } else {
                    left = current[0];
                }
                if (current[1] > intervals[i][1]) {
                    right = current[1];
                } else {
                    right = intervals[i][1];
                }
                int[] item = {left, right};
//                可以合并，
                merge.remove(merge.size() - 1);
                merge.add(item);
                System.out.printf("%d, %d \n", item[0], item[1]);
            } else {
                System.out.printf("%d, %d \n", intervals[i][0], intervals[i][1]);
                merge.add(intervals[i]);
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }

    ;

    public static void sortArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j][0] > array[j + 1][0]) {
                    int[] temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
