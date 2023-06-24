package leetcode.arrangement;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列，固定最左边的元素，右边的自由排列
 * 1， 2， 3， 4
 */
public class Leetcode47PermuteUnique {

    /**
     * 步骤：
     * 1、遍历选择数组（每次除掉selected剩余的数组）的一个值，作为目标结果的result[0]；
     * 需要有结构记录当前递归，可以初始化定义已选数组 selected = []
     * 每次的递归结束，清除，作为下次递归的工具；
     *
     * 2、递归处理数组。结束的条件即：selected.size == nums.size
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        List<Integer> selected = new ArrayList<Integer>();

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        boolean [] used = new boolean[nums.length];
        recursionPermute(nums, selected, used, result);
        return result;
    };

    /**
     * 使用之前记得先排序，因为排序的话，类似1、2、1  ——> 到1、1、2，这里，如果1走完了，接下来还是1，这个1走的过程其实是和第一个1没有区别的，那么遇到这种情况，直接去掉第二个1即可。
     * @param nums 当前剩余可选元素；
     */
    public static void recursionPermute(int [] nums, List<Integer> selected, boolean [] used, List<List<Integer>> result) {

       // 如果当前待遍历圆元素为0，那么
       if (selected.size() == nums.length) {
           result.add(new ArrayList<Integer>(selected));
           return;
       }

        for(int i = 0; i < nums.length; i++) {
//           如果当前值已经被使用过，则没有必要继续走下去。这里画出树就比较好理解；
            if (used[i]) continue;
            /**
             * 标记状态：
             *
             * i - 1 >= 0 && nums.get(i) == nums.get(i - 1) 这个条件比较好理解，对于1，1，2，组装完1，1，2这个结果后，回溯到1 ——> 1,1,2继续组装，已经以1为开头进行了组装，再继续
             * 以1开始组装就没有必要了，这里判断出这个条件直接砍掉；
             *
//             * used[i - 1] == 1 这个条件的作用是，标记前面用过了才略过，要不是没用过，直接略过，那么
             */
           if (i - 1 >= 0 && nums[i] == nums[i - 1] && used[i - 1])  continue;
            selected.add(nums[i]);
            used[i] = true;
            recursionPermute(nums, selected, used,result);
            selected.remove(selected.size() - 1);
            used[i] = false;
        }
    };

    public static void main(String[] args) {

         int [] nums = {3,3,0,3};

//        排序；
        Arrays.sort(nums);



        List<Integer> selected = new ArrayList<Integer>();

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        boolean [] used = new boolean[4];
        recursionPermute(nums, selected, used,result);

        System.out.println(result.size());

        for (List<Integer> element : result) {
            for (int j = 0; j < element.size(); j++) {
                System.out.print(element.get(j));
            }
            System.out.println("-------");
        }



    }
}
