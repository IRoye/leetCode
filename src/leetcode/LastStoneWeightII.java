package leetcode;

import java.util.Arrays;

/**
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * <p>
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LastStoneWeightII {

    public static int lastStoneWeightII(int[] stones) {

//  动态规划；
//       求和

        int total = Arrays.stream(stones).reduce(0, Integer::sum);

//      将其平分，其实可以等价为一堆石子，划分为近似相等的2堆，如果最后两堆越接近的话，那么最后互相粉碎的效果就会越好，这样就能达到目的；

        int half = total / 2;


//      多开一位，考虑起始位置，值默认为0
        int[][] dp = new int[stones.length + 1][half + 1];


//       初始化
//        必须从1开始，否则相当于重复计算了
//        dp[0][0....w]初始化为0，表示将前0个石头分成一组的重量都是0
        for (int i = 1; i < stones.length + 1; i++) {


//            从第一列开
            for (int j = 1; j < half + 1; j++) {

//                [0][1] = dp[0][1] = 0
//                  [0][2
//           如果当前的j的值是大于等于当前石头的重量的
//                System.out.println("j:");
//                System.out.println(j);
//                System.out.println("stones[i]:");
//                System.out.println(stones[i - 1]);
//
//               装入第i个石头，现在有空间
                if (j >= stones[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], stones[i - 1] + dp[i - 1][j - stones[i - 1]]);
                }
//               不装入第i件石头，现在j < stones[i]，装不上。
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i1 = 0; i1 < stones.length + 1; i1 ++) {
            for(int j1 = 0; j1 < half + 1; j1 ++) {
                System.out.print(dp[i1][j1]);
            }
            System.out.println();
        }
//
//        System.out.println(stones.length);
        int sum = dp[stones.length][half];
        return Math.abs(total - (2 * sum));
    }

    ;

    public static int lastStoneWeightII2(int[] stones) {

//  动态规划；
//       求和

        int total = Arrays.stream(stones).reduce(0, Integer::sum);

//      将其平分，其实可以等价为一堆石子，划分为近似相等的2堆，如果最后两堆越接近的话，那么最后互相粉碎的效果就会越好，这样就能达到目的；

        int half = total / 2;


//      多开一位，考虑起始位置，值默认为0
        int[][] dp = new int[stones.length][half + 1];


//       初始化
//        dp[0][0....w]初始化为0，表示将前0个石头分成一组的重量都是0
        for (int i = 0; i < stones.length; i++) {


//            从第一列开
            for (int j = 1; j < half + 1; j++) {

//                [0][1] = dp[0][1] = 0
//                  [0][2
//           如果当前的j的值是大于等于当前石头的重量的
//                System.out.println("j:");
//                System.out.println(j);
//                System.out.println("stones[i]:");
//                System.out.println(stones[i - 1]);
//
//               装入第i个石头，现在有空间
                if (j >= stones[i]) {
                    dp[i][j] = Math.max(dp[i==0 ? 0 : i - 1][j], stones[i] + dp[i ==0 ? 0: i - 1][j - stones[i]]);
                }
//               不装入第i件石头，现在j < stones[i]，装不上。
                else {
                    dp[i][j] = dp[i == 0? 0:i - 1][j];
                }
            }
        }

        for (int i1 = 0; i1 < stones.length; i1 ++) {
            for(int j1 = 0; j1 < half + 1; j1 ++) {
                System.out.print(dp[i1][j1]);
//                System.out.print("");
            }
            System.out.println();
        }
//
//        System.out.println(stones.length);
        int sum = dp[stones.length - 1][half];
        return Math.abs(total - (2 * sum));
    }

    public static void main(String[] args) {
//        int a[] = {1, 2};
//        int a[] = {21, 60, 61, 20, 31};
//        int result = lastStoneWeightII2(a);
//        System.out.println("结果：");
//        System.out.println(result);


        for (int i = 0; i< 10; i++) {
            System.out.println(i);
        }
//        System.out.println(i);
    }
}
