package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode46Permute {
    public static List<List<Integer>> permute(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        createItem(0, nums, list);

        return list;
    }

    ;

    public static void createItem(int start, int[] nums, List<List<Integer>> total) {
        // 转为 List
        List<Integer> list = new ArrayList();
        for (int j = 0; j < nums.length; j++) {
            list.add(nums[j]);
        }


        if (nums.length - 1 == start) {
            total.add(list);
        }

        // 从start 传递的值开始
        for (int i = start; i < nums.length; i++) {
            // 开始进行交换， 例如 [1,2,3] 首次交换，start 和 i 都是0，也就是当前值，那么此时还是[1,2,3]

//           判断是否重了

            swap(nums, start, i);

            // 当前交换完成,那么开始接下来的处理，也就是以当前的顺序[1,2,3]，此时开始对2进行处理
            createItem(start + 1, nums, total);

//                System.out.println(result);

            // 处理完，恢复顺序，供接下来的处理
            swap(nums, start, i);
        }

    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int nums[] = {1};

//        swap(nums, 0, 1);
//
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }

        System.out.println(nums);

//        for (List<Integer> list: ) {
//
//        }

        System.out.println(permute(nums));


    }


}
