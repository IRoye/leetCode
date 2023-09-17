package leetcode.arrangement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetcodeSubsetXORSum {

    public int subsetXORSum(int[] nums) {

        int XOR = 0;
        for (int i = 0; i < nums.length; i++) {
//          拆分子问题；
            List <List<Integer>> result = subset(nums, 0, i+ 1);
            for (List<Integer> element : result) {
//               任何值和0异或，值都为本身，初始化为0
                int elementXOR = 0;
                for (int j = 0; j < element.size(); j ++) {
                    elementXOR = elementXOR ^ element.get(j);
                }
                XOR += elementXOR;
            }
        }
        return XOR;
    };


    /**
     * 递归生成子数组；
     * @param nums 原数组
     * @param start 原数组，选择n个如果选定nums[0]，作为子数组的第一个数，start作为n - 1个数的选择开始index；初始值为0;
     * @param k 当前选择的个数，比如从m个数下选择k个作为子数组；初始值为1；
     *          使用分治的方法：
     *          递归处理：这里的递归可以分为两个边界条件
     *          1、如果当前k = nums.length，那么直接返回当前数组即可；
     *          2、如果当前k = 1，那么返回当前以start开始的数组的每一个元素，作为子数组；
     * @return
     */
    public static List<List<Integer>> subset(int [] nums, int start, int k) {

        List <List<Integer>> temp = new ArrayList<>();
        if (k == 0) {
            return temp;
        }
        if (k == 1) {
            for (int i = start; i < nums.length; i++) {
                temp.add(new ArrayList<>(Arrays.asList(nums[i])));
            }
            return temp;
        }

        if (k == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j ++) {
                list.add(nums[j]);
            }
            temp.add(list);
            return temp;
        }

        /**
         * 其他情况下，在当前可用的数组下，选取k个元素作为子数组；
         * 步骤，         */
        for (int i = start; i< nums.length; i++) {

            int first = nums[i];

            List <List<Integer>> sub = subset(nums, i + 1, k - 1);

            // 拼接
            for (int j = 0; j < sub.size(); j ++) {
                sub.get(j).add(0, first);
                temp.add(sub.get(j));
            }
        }

        return temp;
    };
    public static void main(String[] args) {

        int k = 2;
        int [] nums = {3,4,5,6,7,8};
        int start = 0;

//        List <List<Integer>> result  = subset(nums, 0, 0);

//        for (List<Integer> element : result) {
//            System.out.println(Arrays.toString(element.toArray()));
//        }

        int XOR = 0;
        for (int i = 0; i < nums.length; i++) {
//          拆分子问题；
            List <List<Integer>> result = subset(nums, 0, i+ 1);

            for (List<Integer> element : result) {

//               任何值和0异或，值都为本身，初始化为0
                int elementXOR = 0;
                for (int j = 0; j < element.size(); j ++) {
                    elementXOR = elementXOR ^ element.get(j);
                }
                System.out.println(elementXOR);
                XOR += elementXOR;
            }
        }

        System.out.println("------");
        System.out.println(XOR);
    }
}
