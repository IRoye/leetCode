package array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 那么就是使用二分查找
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target);
    }

    /**
     * 二分查找
     * @param nums 数组
     * @param target 待查找数组
     * @return
     */
    public static int binarySearch(int [] nums, int target) {

        int i = 0;
        int j = nums.length - 1;

        // i + (j - i) / 2，避免溢出
        while (i <= j) {

            int m = i + (j - i) / 2;
            if (nums[m] < target) {
                i = m + 1;
            } else if (nums[m] > target) {
                j = m - 1;
            }

            //  如果查找得到，直接返回目标值
            if (nums[m] == target) {
                return m;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int []nums = {1,3,5,6, 8, 9};
        int target = 10;
        int result = binarySearch(nums, target);

        System.out.println(result);
    }
}
