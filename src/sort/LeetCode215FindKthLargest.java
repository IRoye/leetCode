package sort;

import java.util.Arrays;

/**
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class LeetCode215FindKthLargest {

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int order = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i != nums.length - 1) {
                if (nums[i] == nums[i + 1]) {
//                 如果当前和前一个值相同，不加
                } else {
                    order++;
                }
            } else {
                order++;
            }
            if (order == k) {
                return nums[i];
            }
        }
        return -1;
    }

    ;

    public static void main(String[] args) {
        int
    }
}
