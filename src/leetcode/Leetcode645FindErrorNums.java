package leetcode;

import generic.Pair;

import java.util.Arrays;

/**
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * <p>
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1]
 * 输出：[1,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 思路不对，不光是临近元素，不相邻的也可能是交换的：例如：[1,5,3,2,2,7,6,4,8,9]，[2,10]
 */
public class Leetcode645FindErrorNums {
    public static int[] findErrorNums(int[] nums) {
        int du[] = new int[2];

//       加排序
        Arrays.sort(nums);

        int temp[] = new int[nums.length];

        for (int i = 1; i <= nums.length; i++) {
            temp[i - 1] = i;
        }



        for (int j = 0; j < temp.length; j++) {
            if (j > 0 && nums[j - 1] == nums[j]) {
                System.out.println(nums[j]);
                du[0] = nums[j];
            }
//            对int 数组无效
            if (Arrays.binarySearch(nums, temp[j]) < 0) {
                du[1] = temp[j];
            }
        }

        return du;

    }

    public static void main(String[] args) {
        int a[] = {1, 1};

        int[] result = findErrorNums(a);

        int b = Arrays.binarySearch(a, 11);

        System.out.println(result[0]);
        System.out.println(result[1]);

    }
}
