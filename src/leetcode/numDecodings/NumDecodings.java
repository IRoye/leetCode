package leetcode.numDecodings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumDecodings {

    public static void main(String[] args) {
        // 状态转移方程，f(n) = f(n-1) + f(n-2)
        String str = "226";
        char[] nums = str.toCharArray();
        int array[] = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            int count = decode(array, i, nums);
            System.out.println(count);
        }
    }

    /**
     * 最理想的情况下：
     * 1. 最后一位数单独组成一组，有一种可能，那么剩余的(n - 1)个数的话，还有f(n - 1)种可能
     * 2. 最后一位数和倒数第二位数组成一组, 那么剩余的(n -2)个数组成一组，有f(n - 2)种可能
     * 两种情况下共有 f(n - 1) + f(n - 1)种可能
     *
     * @param args
     * @param index
     * @return
     */
    public static int decode(int args[], int index, char[] item) {
        if (index <= 2) {
            if(index == 1) {
                if(item[index] == '0') args[1] = 0;
            }
            args[index] = index;
        } else {
            // 需要排除的情况
            // 当前数组最后一位的值
            int current = item[index - 1] - '0';
            int lastcurrent = item[index - 2] - '0';
            if (current == 0 && lastcurrent >= 1 && lastcurrent <= 2) {
                args[index] = decode(args, index - 1, item);
            }
            if (current != 0 && Integer.valueOf(lastcurrent + "" + current) <= 26 && Integer.valueOf(lastcurrent + "" + current) >= 11) {
                args[index] = decode(args, index - 1, item) + decode(args, index - 2, item);
            }
        }
        return args[index];
    }
}
