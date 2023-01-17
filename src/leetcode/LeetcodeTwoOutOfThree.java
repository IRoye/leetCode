package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2032. 至少在两个数组中出现的值
 * 简单
 * 70
 * 相关企业
 * 给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 元素各不相同的 数组，且由 至少 在 两个 数组中出现的所有值组成。数组中的元素可以按 任意 顺序排列。
 */
public class LeetcodeTwoOutOfThree {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

//       思路
        /**
         * 1. 3个数字，依次遍历，额外定义一个map。每次set key为数组的值，value为1
         * 2、第二个数组，同样的操作，但是如果相同key，key set value to 2
         * 3、第三个数组，同理，key set to 3
         * 4、汇总map下>=2的value的key，作为结果输出。
         */

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], 1);
        }

        for (int j = 0; j < nums2.length; j ++) {
            if (map.get((nums2[j])) == null) {
                map.put(nums2[j], 1);
            } else if (map.get((nums2[j])) == 2) {
                map.put(nums2[j], 2);
            } else if (map.get((nums2[j])) == 1) {
                map.put(nums2[j], 2);
            }
        }

        for (int k = 0; k < nums2.length; k ++) {
            if (map.get((nums3[k])) >=2 ) {
                map.put(nums3[k], 3);
            } else {
                map.put(nums3[k], 1);
            }
        }
        return null;
    }
}
