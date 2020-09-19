package leetcode.subSet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
 */
public class SubSets {
    public static List<List<Integer>> subsets(int[] nums) {
        // 整个数组的长度
        int length = nums.length;
        // 构造大的list
        List <List<Integer>> list = new ArrayList();
        // 初始化第一个list<Integer>
        list.add(new ArrayList<>());
        System.out.println(list);
        // 遍历每一个元素
        for (int i = 0; i < length; i++) {
            int currentitem = nums[i];
            // 当前子集的长度
            int sublength = list.size();
            for (int j = 0; j < sublength; j++) {
                List sublist = new ArrayList<Integer>(list.get(j));
//                List sub = list.get(j);
                // 将当前值放入到sublist，并新加入currentitem
                sublist.add(currentitem);
                // 改变的是元素组，get 返回的是地址
//                sublist.addAll(sub);
                list.add(sublist);
//                System.out.println(sublist);
            }
        }
//        System.out.println(list);
        return list;
    }

    public static void main(String[] args) {
//        int[] a = {1, 2, 3};
//        subsets(a);

        double num = 0.1;

        for(int i = 0; i < 10; i++){
            num += 0.1;
        }

        System.out.println(num);

        // 八进制
        int aaaa = 0010;
        System.out.println(10);
        System.out.println(aaaa);

    }
}

