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

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }
}
