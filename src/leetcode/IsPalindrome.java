package leetcode;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是
 */
public class IsPalindrome {
    public static boolean isPalindrome(int x) {
        boolean flag = true;
        char[] strs = (x + "").toCharArray();
//      遍历字符数组
        for (int i = 0, j = strs.length - 1; i < j; i++, j--) {
            if (strs[i] == strs[j]) continue;
            if (strs[i] != strs[j]) {
                flag = false;
                break;
            }

        }
        return flag;
    }

    ;

    /**
     * @param x
     * @return
     * @description: 不转为字符串进行计算
     */
    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x > 10) ) return false;
//       步骤：
//        将原数x % 10 取得倒数第一位，假如是12321，那么 12321 % 10 = 1，获取到最后一位，接下来，x = x / 10 = 1232。继续步骤，x % 10 = 2，此时拿到倒数第二位，
//        此时x = x / 10 = 123。如何判断
        int x1 = 0;
//        如果是12321 这样的数的话，那么那么123 = （x1 = x1 * 10 + x % 10）/ 10 如果是1221 那么直接就是 12 = （x1 = x1 * 10 + x % 10）
        while (x > x1) {
            x1 = x1 * 10 + x % 10;
            x = x / 10;
        }
        System.out.println(x);
        System.out.println(x1);
        if (x == x1 / 10 || x == x1) return true;

        return false;

    }

    ;

    public static void main(String[] args) {
        System.out.println(isPalindrome2(1));
    }
}
