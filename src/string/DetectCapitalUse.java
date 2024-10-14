package string;

/**
 * 520. 检测大写字母
 * 简单
 * 相关标签
 * 相关企业
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 */
public class DetectCapitalUse {

    public boolean detectCapitalUse(String word) {

        // 【1】、全部大写
        int allUpperCase = 0;

//          【2】、全部小写；
        int allLowerCase = 0;

//           【3】、首字母大写
        int firstCharUpperCase = 0;
        for (int i = 0; i < word.length(); i++) {

//           条件3
            if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z' && word.length() > 1) {
                if (i >0 && word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                    firstCharUpperCase ++;
                }
            }

//          条件1
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                allUpperCase ++;
            }

            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                allLowerCase ++;
            }
        }

        if (firstCharUpperCase == word.length() - 1) return  true;
        if (allLowerCase == word.length() || allUpperCase == word.length()) return true;

        return  false;
    }
}
