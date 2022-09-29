package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode350Intersect {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        bubbleSort(nums1);
        bubbleSort(nums2);

//      定义两个指针
        int i = 0;
        int j = 0;

        int length = nums1.length > nums2.length ? nums1.length : nums2.length;
        int k = 0;

        while (i < nums1.length && j < nums2.length) {


                //           保证都是在范围内的
//               如果不相等的话，那么较为小的那个值 指针 ++
                if (nums1[i] != nums2[j]) {
                    if (nums1[i] < nums2[j]) {
                        i++;
                    } else {
                        j++;
                    }
                } else {
//              如果相等的话
                    list.add(nums1[i]);
                    i++;
                    j++;
                }


        }

        int array[] = new int[list.size()];
        for (int m = 0; m < list.size(); m++) {
            array[m] = list.get(m);
        }
        return array;
    }

    /**
     * 冒泡排序；
     * 为什么需要排array.length - 1次？
     *
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
//       总共需要n - 1趟排序
        for (int i = 0; i < nums.length - 1; i++) {
//            在每趟排序下，两两比较。为什么要减去i - 1
//            // 1. 减去1是因为，数组如果有5个元素的话，那么一趟两两比较最多4次就完成了
//            // 2. 减去i是因为，如果每一趟就能把当前趟最大的值给拎出来，每一次就能完成一个当前最大值，放在最后，这个也就不用再次排序了，因此减去i
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0,5,8,7,2,9,7,5};
        int[] nums2 = {1,4,8,9};

//        bubbleSort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }

        int[] nums = intersect(nums1, nums2);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
