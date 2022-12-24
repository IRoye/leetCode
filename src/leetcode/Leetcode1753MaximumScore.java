package leetcode;

import java.util.Arrays;

/**
 * 1753. 移除石子的最大得分
 * 中等
 * 92
 * 相关企业
 * 你正在玩一个单人游戏，面前放置着大小分别为 a​​​​​​、b 和 c​​​​​​ 的 三堆 石子。
 * <p>
 * 每回合你都要从两个 不同的非空堆 中取出一颗石子，并在得分上加 1 分。当存在 两个或更多 的空堆时，游戏停止。
 * <p>
 * 给你三个整数 a 、b 和 c ，返回可以得到的 最大分数
 */
public class Leetcode1753MaximumScore {
    public static int maximumScore(int a, int b, int c) {
//     不算是算法类的问题了，根据例子找规律
        /**
         * 0. 排序，假设：a < b < c；
         * 1. 如果 a + b <= c，那么a、c此时选中，取一分；否则，a、b选中，取一分；
         * 2、继续第一步的操作，
         */
        int sum = 0;

//        1、 放置到数组
        int array[] = {a, b, c};

//       2、开始排序
        Arrays.sort(array);

//      3、开始加分

        while (!(array[0] + array[1] == 0 || array[0] + array[2] == 0 || array[1] + array[2] == 0)) {
            if (array[0] + array[1] <= array[2]) {
                if (array[0] != 0) {
                    array[0]--;
                    array[2]--;
                    sum++;
                } else {
                    array[1]--;
                    array[2]--;
                    sum++;
                }
            } else {
                if (array[0] != 0) {
                    array[0]--;
                    array[1]--;
                    sum++;
                } else {
                    array[1]--;
                    array[2]--;
                    sum++;
                }
            }

        }
        return sum;

    }

    ;

    public static void main(String[] args) {
//        int array[] = {2, 1, 4};
//        Arrays.sort(array);
//        System.out.println(array[0]);
//        System.out.println(array[1]);
//        System.out.println(array[2]);


        int sum = maximumScore(10, 9, 0);
        System.out.println(sum);

    }
}
