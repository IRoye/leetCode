package leetcode;

import java.util.Arrays;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * for (int k = 0; k < profit.length; k++) {
 * System.out.println(Arrays.toString(profit[k]));
 * <p>
 * 暴力解法有问题，超出时间限制。
 * }
 */
public class leetCode121MaxProfit {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) return 0;

        if (prices.length == 2) {
            return prices[1] > prices[0] ? prices[1] - prices[0] : 0;
        }

//  1. 首先构造二维数组，每一行代表买入的时机，每一列代表卖出的时机 。由于最后一天的话，买入没有意义，所以行最多是pri

//  构造prices.length - 1的数组
        int n = prices.length;

        int max = 0;

        for (int i = 0; i < n - 1; i++) {
//          行，当前买入的价格
            int price = prices[i];
            for (int j = i + 1; j < n; j++) {
//               列，当前卖出的价格
                int sold = prices[j];
//               当前利润；
                int currentProfit = sold - price > 0 ? sold - price : 0;
                max = currentProfit > max ? currentProfit : max;
            }
        }
//        for (int k = 0; k < profit.length; k++) {
////            System.out.println(Arrays.toString(profit[k]));
////        }

        return max;
    }

    ;

    /**
     * 需要是在未来的某一个不同的日子
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
//       1. dp[i] = max{ 前i - 1天的最大收益，第i天的价格 - (前i - 1天的最小价格) }；
//       前i - 1天的最大收益，这个一直更新
        int max = 0;
//       前i - 1天的最小价格
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < prices.length; i++) {
            min = min < prices[i - 1] ? min : prices[i - 1];
            max = max > prices[i] - min ? max : prices[i] - min;
        }
        return max;
    }

    ;

    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 6, 4};
        int[] price2 = {7, 6, 4, 3, 1};
        int[] price3 = {1, 2};

        System.out.println(maxProfit2(price3));

    }

}
