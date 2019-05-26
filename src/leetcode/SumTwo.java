package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SumTwo {
    /**
     * 用hash 表来提高查找的速度
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> maps = new HashMap<>();
//        记录每个值的下标
        for (int i = 0; i < nums.length; i++) {
            maps.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {
            int subTarget = target - nums[j];
            if (maps.get(subTarget) != null && maps.get(subTarget) != j) {
                return new int[]{j, maps.get(subTarget)};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        int result[] = twoSum(nums, target);
        for (int sub : result) {
            System.out.println(sub);
        }
    }
}
