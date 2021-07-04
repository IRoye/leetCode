package leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
 * <p>
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 * <p>
 * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 * <p>
 * 注意：Tony 可以按任意顺序购买雪糕。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：costs = [1,3,2,4,1], coins = 7
 * 输出：4
 * 解释：Tony 可以买下标为 0、1、2、4 的雪糕，总价为 1 + 3 + 2 + 1 = 7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-ice-cream-bars
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxIceCream {
    public static int maxIceCream(int[] costs, int coins) {

        if (costs == null || coins == 0) return 0;

        Arrays.sort(costs);

        if (costs[0] > coins) return 0;

        int count = 0;

        int sum = 0;

        for (int i = 0; i < costs.length; i++) {
            if (costs[i] <= coins) {

                // 钱数
                count += costs[i];

//              剩余钱数
                coins -= costs[i];

                sum ++;

            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        [1,6,3,1,2,5]20
        int [] costs = {1,6,3,1,2,5}; int coins = 20;
        int result = maxIceCream(costs, coins);

        System.out.println(result);
    }
}
