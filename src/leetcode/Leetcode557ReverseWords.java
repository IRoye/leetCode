package leetcode;

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class Leetcode557ReverseWords {
    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();

        for (String item : s.split(" ")) {
            sb.append(new StringBuilder(item).reverse() + " ");
        }

        return sb.toString().trim();

    }

    ;

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";

        StringBuilder sb = new StringBuilder();

        for (String item : s.split(" ")) {
            sb.append(new StringBuilder(item).reverse() + " ");
        }

        System.out.println(sb.toString().trim());
    }
}
