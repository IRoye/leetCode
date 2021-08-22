package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class Leetcode70ClimbStairs {
    public static int climbStairs(int n) {
        int memeory[] = new int[n];

        return climbStairsMem(n, memeory);

    }

    ;

    public static int climbStairsMem(int n, int[] map) {

        if (n == 1 || n == 0)
            return 1;

        if (map[n - 1] != 0) {
            return map[n - 1];
        }

        map[n - 1] = climbStairsMem(n - 1, map) + climbStairsMem(n - 2, map);

        return map[n - 1];

    }

    ;

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }
}
