package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 中等
 * 3.4K
 * 相关企业
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 */
@Deprecated
public class Leetcode22GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
//        return generate(n);
        return null;
    }

    ;;;

    /**
     * 递归：
     * 【1】：如果为1，即为：（）
     * 【2】：如果为2，首先列出独立的括号：‘（）（）’，然后用1的括号进行包裹，即：’（（））‘
     * 【3。。。】：如果为3的话：
     * 3.1、首先列出单独的，即：（）（）（）；
     * 3.2、再列出n - 2和n - 1的组合：
     * 即：(()())、（（（））)、（）（（））、（（））（），如此即可组装为n = 3的值；
     */
//    public static List<String> generate(int n) {
//        List<String> list = new ArrayList<String>();
//        if (n == 1) {
//            list.add("()");
//            return list;
//        }
//
//        if (n == 2) {
//            list.add("()()");
//            list.add("(())");
//            return list;
//        }
//
//        // 整合n - 2 和 n - 1的数据，即n-1的
////        generate(list, n - 2) + generate(list,n - 1)
//        List<String> n1 = generate(n - 1);
//        List<String> n2 = generate(1);
//
////      逐个将n1的数据对半拆分，拼接于每一项n2；
//        for (String sub1 : n2) {
//            int halfLength = sub1.length() / 2;
//            String firstHalf = sub1.substring(0, halfLength);
//            String secondHalf = sub1.substring(halfLength);
//
//            // 使用firstHalf、secondHalf 对后续n - 1进行拼接
//
//            for (String sub2 : n1) {
//
//                // 1、进行左侧拼接和右侧拼接；
//                list.add(firstHalf + sub2 + secondHalf);
//
//                // 2、不拆分单独拼接；左右两侧；
//
//                if (!list.contains(sub1 + sub2)) {
//                    list.add(sub1 + sub2);
//                }
//
//                if (!(sub2 + sub1).equals(sub1 + sub2)) {
//                    list.add(sub2 + sub1);
//                }
//            }
//        }
////
////      其他情况
//        String external = "";
//        if (n % 2 == 0) {
//            for (int i = 0; i < n / 2; i++) {
//                external += "(())";
//            }
//        }
//        list.add(external);
//        return list;
//    }
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        dfs(list, 4, 4, "");

        for (String str : list) {
            System.out.println(str);
        }

    }

    /**
     * @param list  结果列表
     * @param left  左边剩余括号量
     * @param right 右边剩余括号量
     * @param str   总数量
     * @return
     */
    public static void dfs(List list, int left, int right, StringBuilder str) {

//     临界点，耗尽，开始收集
        if (left == 0 && right == 0) {
            list.add(str);
        }

        if (left <= right) {
            if (left > 0) {
                str.append("(");
                dfs(list, left - 1, right, str);
//              为何要删掉；sb是作为对象一直传递下去的，不删掉影响后面的使用；
                str.deleteCharAt(str.length() - 1);
            }

            str.append(")");
            dfs(list, left, right - 1, str);
            str.deleteCharAt(str.length() - 1);
        }
    }

}
