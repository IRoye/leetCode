package string;

/**
 * 58. 最后一个单词的长度
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大
 * 子字符串
 * 。
 */
public class LengthOfLastWord {


    public static int lengthOfLastWord(String s) {

        int length = 0;
        for (int i = s.length() - 1; i >= 0; i --) {
            if (s.charAt(i) == ' ' && length == 0) {
                continue;
            } else if (s.charAt(i) == ' ' && length != 0) {
                break;
            } else {
                length ++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }

}
