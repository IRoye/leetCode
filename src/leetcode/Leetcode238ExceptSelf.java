package leetcode;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * <p>
 * <p>
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * <p>
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class Leetcode238ExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
//  思路：限制除法的话，使用双数组的方法来做乘法；也就是分为两个数组，左侧数组的话，每一项是[i]是数组当前左侧的乘积。右侧的数组，每一项[j]是数组
//  右侧的乘积，那么数组除了自身之外的乘积的话，就是L[i] * R[i]

//  1、定义数组L
        int left[] = new int[nums.length];
        left[0] = 1;

//  2、定义右侧数组
        int right[] = new int[nums.length];
        right[nums.length - 1] = 1;

//  3、初始化左侧数组

        for (int i = 0; i < left.length; i++) {
            if (i == 0) {
//              3.1、第0个值的话，那么就是1，也只能是1
                left[i] = 1;
            } else {
//              3.2、其他的话，那么就是当前值的前一个数值 * 前一个数值对应的它的左侧的值
                left[i] = nums[i - 1] * left[i - 1];
            }

        }

        //  4、初始化右侧数组

        for (int j = right.length - 1; j >= 0; j--) {
            if (j == right.length - 1) {
//              4.1、从最右侧开始
                right[j] = 1;
            } else {
//              4.2、其他的话，那么就是当前值的前一个数值 * 前一个数值对应的它的左侧的值
                right[j] = nums[j + 1] * right[j + 1];
            }

        }

        for (int k = 0; k < nums.length; k++) {
            left[k] = left[k] * right[k];
        }

        return left;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
