package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class LeetCode136SingleNumber {
    public int singleNumber(int[] nums) {

        int key = 0;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value == 1) {
                key = entry.getKey();
            }
        }

        return key;
    };

    public int singleNumber2(int[] nums) {

        int start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            start = start ^ nums[i];
        }
        return start;
    };

    public static void main(String[] args) {

        System.out.println();
    }
}
