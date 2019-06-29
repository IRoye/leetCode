package leetcode;

/**
 * 4. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        // 设置最长的回文子串长度是1
        if (s.isEmpty()) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        String max = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {

            // 分两种情况，切分的点区分奇数和偶数
            // 1. 奇数，类似aba 这种
            String odd = findPalindrome(s, i, i);
            max = odd.length() > max.length() ? odd : max;
            // 偶数的情况， 例如 aaaa
            String even = findPalindrome(s, i, i + 1);
            max = even.length() > max.length() ? even : max;
        }
        return  max;
    }

    public static void main(String[] args) {

        String s = "bb";
        String result = longestPalindrome(s);
        System.out.println(result);
    }

    /**
     * 给定一个字符串，根据起始位置，找出对应的回文串
     *
     * @param str
     * @param begin
     * @param end
     */
    public static String findPalindrome(String str, int begin, int end) {
        if (str == "") {
            return "";
        }
        while (begin >= 0 && end <= str.length() -1 && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        };

        System.out.println(begin);
        System.out.println(end);
        System.out.println(str.substring(begin + 1, end));
        System.out.println("__________");

        return str.substring(begin + 1, end);
    }
}
