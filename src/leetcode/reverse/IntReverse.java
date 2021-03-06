package leetcode.reverse;

/**
 * 整数翻转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果 反转后 整数溢出那么就返回 0。
 */
public class IntReverse {

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result > Integer.MAX_VALUE) return 0;
            if (result < Integer.MIN_VALUE) return 0;
            int current = x % 10;
            // 现在判断的整数最大值和最小值的个数数
            if (result  > Integer.MAX_VALUE / 10 + current / 10) return 0;
            if (result  < Integer.MIN_VALUE / 10 - current / 10) return 0;
            result = result * 10  + current;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int a = reverse(1534236469);
        System.out.println(a);
    }
}


