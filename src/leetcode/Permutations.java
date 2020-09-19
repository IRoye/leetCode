package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 全排列
 */
public class Permutations {

    private static List<List<Integer>> array = new ArrayList<>();

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        List b = permute(a);
        System.out.println(b);
    }

    /**
     * @param args 交换的数组
     * @param a    index a
     * @param b    index b
     */
    public static void swap(int args[], int a, int b) {
        int temp = args[a];
        args[a] = args[b];
        args[b] = temp;
    }

    public static List<List<Integer>> permute(int[] nums) {
        permutations(nums, 0);
        return array;
    }

    public static List<Integer> convertList(int[] nums) {
        List list = new ArrayList<Integer>();
        for (int item : nums) {
            list.add(item);
        }
        return list;
    }

    /**
     * @param args  原始数组
     * @param start 子数组开始
     * @description: 递归调用，生成数组的全排列
     */
    public static void permutations(int args[], int start) {
        // 1. 临界条件，如果此时数组的最后一个元素
        if (args.length == start + 1) {
            // 不能是基本数据类型
            array.add(convertList(args));
        }

        // 2. 对于每一个元素，递归调用一次,让其占据第一个位置，剩下的元素开始全排列
        for (int i = start; i < args.length; i++) {
            // 和第一个元素交换，固定第一个元素，然后开始递归后面的
            int item = args[i];
            // 将遍历的元素和第一个元素交换, start是开始的index, i是当前的Index，开始交换
            swap(args, i, start);
            // 待交换完成，固定好第一个后，对第一个元素后的子数组进行全排列
            permutations(args, start + 1);
            // 恢复下开始时的顺序
            swap(args, i, start);
        }
    }
}
