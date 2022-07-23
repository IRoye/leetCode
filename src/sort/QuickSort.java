package sort;


import java.util.Arrays;

/**
 * @desciption: 快速排序
 */
public class QuickSort {
    /**
     * @param array
     * @param lo    当前子数组开始的index
     * @param hi    当前子数组结束的index
     * @return
     * @description: 对子数组进行
     */
    public static int partition(int[] array, int lo, int hi) {
//    1. 当前数组，选取中间值，中间值默认使用l0
        int partition = array[lo];
        int i = lo, j = hi;
//    2. 使用i,j 开始遍历，i从当前分段数组左侧开始，j从分段数组的右侧开始。当指针i遇到了大于partition的值，暂停；当指针j向左遍历，遇到了小于partition的元素，暂停，并开始和i交换
        while (i < j) {
            // 先从左边开始找，找到第一个大于等于partition的元素，拿到index值；
            while (array[i] < partition) {
                i++;
                if (i == hi) break;
            }
            while (array[j] > partition) {
                j--;
                if (j == lo) break;
            }
            swap(array, i, j);
        }
//       4. 返回j，为什么返回j，j此时当做了分隔的边界，j左边的继续排序，右侧的也继续排序；
        return j;
    }

    ;

    public static void swap(int[] array, int swapIndex1, int swapIndex2) {
        int temp;
        temp = array[swapIndex1];
        array[swapIndex1] = array[swapIndex2];
        array[swapIndex2] = temp;
    }

    /**
     * @param array 数组
     * @param i     当前数组开始
     * @param j     当前数组结束
     */
    public static void quickSort(int[] array, int i, int j) {
        if (j <= i) return;
        int partition = partition(array, i, j);
//     分区左边
        quickSort(array, i, partition - 1);
//       分区右边
        quickSort(array, partition + 1, j);
    }

    public boolean containsDuplicate(int[] nums) {
//        quickSort(nums, 0, nums.length - 1);

        // 快速排序会超时
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }

    ;

    public static void main(String[] args) {
        int[] array = {4, 2, 1, 6, 8, 7, -1, 3};
//        partition(array, 0, array.length - 1);
        quickSort(array, 0, array.length - 1);
        System.out.printf(Arrays.toString(array));
    }
}
