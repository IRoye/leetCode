package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 */
public class Leetcode5ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
//
        // 特殊判断的几种类型

        if (nums == null || nums.length == 0) return ans;

        if (nums.length < 3) return ans;

//      排序，此时的元组【a,b,c】就会使 a < b < c，而不会再出现【b,a,c】这样的顺序，保证去重。
        Arrays.sort(nums);

//       看别人代码新发现的一个判断，如果第一个值都是大于零了，那么就没有必要再判断了
        if (nums[0] > 0) return ans;

        // 遍历
        for (int i = 0; i < nums.length; i++) {
//          这里已经取了值，后面的就不再需要了
            int a = nums[i];

            // 开始考虑找第二三个数。

//          设置初始左右指针
            int left = i + 1;
            int right = nums.length - 1;

            // 这里少了去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (left < right) {


                if (a + nums[left] + nums[right] == 0) {
//                 符合条件；
                    List result = new ArrayList<Integer>();

                    result.add(a);
                    result.add(nums[left]);
                    result.add(nums[right]);

                    ans.add(result);

//                   移动指针
                    left++;
                    right--;

                    //          首先排除重复的数据。也就是类似 -2, -1, -1，-1***里-1这样的数，直到最后一个。从左到右。
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    //同理对于右侧的数据也是，如果右侧的数据也是有重复的，那么指针也是需要一直向做移动
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (a + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }

            }


        }
        return ans;
    }

    ;

    public static void main(String[] args) {
//        int test[] = {-1, 0, 1, 2, -1, -4};
        int test[] = {0, 0, 0, 0};
//        int test[] = {-2, 0, 1, 1, 2};
        List result = (List<List<Integer>>) threeSum(test);

        for (Object item : result) {
            System.out.println((List<Integer>) item);
        }
    }
}
