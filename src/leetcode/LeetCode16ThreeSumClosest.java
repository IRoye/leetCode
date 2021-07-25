package leetcode;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode16ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {

        // 排个序
        Arrays.sort(nums);

        int minValue = Integer.MAX_VALUE;

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            // 确定第一个值
            int a = nums[i];

            // 对于第二三个数，
            int left = i + 1;
            int right = nums.length - 1;

            // 一样，重复的数据也是不需要的，前进一位。
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (left < right) {

                int temp = (nums[left] + nums[right] + a);

                if (temp == target) {
                    return temp;
                }

                if (temp > target) {
                    right--;
                }

                if (temp < target) {
                    left++;
                }

//              更新sum的值。需要
                if (Math.abs(target - temp) <= minValue) {
                    minValue = Math.abs(target - temp);
                    sum = temp;
                }

            }

        }

        return sum;

    }

    ;

    public static void main(String[] args) {
//        int test[] = {-1, 2, 1, -4};
//        int test[] = {0, 1, 1, 1};
        int test[] = {0, 2, 1, -3};
        int result = threeSumClosest(test, 1);


        System.out.println(result);

    }
}
