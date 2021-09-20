package leetcode;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 * <p>
 * Find and return the maximum profit you can achieve
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode122MaxProfit {
    public static int maxProfit(int[] prices) {

        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
//           卖出
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

    ;

    public static void main(String[] args) {
        int a[] = {7, 1, 5, 3, 6, 4};
        int a2[] = {1, 2, 3, 4, 5};
        int a3[] = {7, 6, 4, 3, 1};

        System.out.println(maxProfit(a3));
    }
}
