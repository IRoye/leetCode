package leetcode;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 示例 2：
 * <p>
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 示例 3：
 * <p>
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * "bsbininm"
 * "jmjkbkjkv"
 * <p>
 * "pmjghexybyrgzczy"
 * "hafcdqbgncrcbihkd"
 */
public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
//        构造二维数组
        int[][] array = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {

            char currentText1 = text1.charAt(i - 1);

            for (int j = 1; j <= text2.length(); j++) {

                char currentText2 = text2.charAt(j - 1);

                if (currentText1 == currentText2) {

                    array[i][j] = array[i - 1][j - 1] + 1;

                } else {
                    array[i][j] = Math.max(array[i - 1][j], array[i][j - 1]);
                }
            }
        }

//        for (int i = 0; i < text1.length() + 1; i++) {
//            for (int j = 0; j < text2.length() + 1; j++) {
//                System.out.print(array[i][j]);
//            }
//            System.out.println();
//        }
        return array[text1.length()][text2.length()];
    }

    ;

    public static void main(String[] args) {
        int result = longestCommonSubsequence("bsbininm", "jmjkbkjkv");
        System.out.println(result);
    }
}
