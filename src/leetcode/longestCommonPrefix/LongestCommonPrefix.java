package leetcode.longestCommonPrefix;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * <p>
 * 忘记的内容
 * Set集合中的元素不按特定顺序排序。因此我们无法向list一样根据索引获取数据
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        String result = "";
        for (int i = 0; i < length; i++) {
            Set<Character> sets = new HashSet<>();
            char current = strs[0].charAt(i);
            sets.add(current);
            // 遍历字符串数组
            for (int j = 1; j < strs.length; j++) {
                if (i > strs[j].length() - 1) {
                    sets.clear();
                    break;
                }
                char slings = strs[j].charAt(i);
                sets.add(slings);
            }
            if (sets.size() == 1) {
                result += sets.toArray()[0];
            } else {
                break;
            }
        }
        return result;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        String result = "";
        for (int i = 0; i < length; i++) {
            char current = strs[0].charAt(i);
            boolean flag = false;
            // 遍历字符串数组
            for (int j = 1; j < strs.length; j++) {
                if (i > strs[j].length() - 1) {
                    flag = false;
                    break;
                }
                char slings = strs[j].charAt(i);
                if (current == slings) {
                    flag = true;
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result += current;
            } else {
                if (strs.length == 1) {
                    result = strs[0];
                }
                break;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        String[] arrays = {"aca", "cba"};
        String result = longestCommonPrefix2(arrays);
        System.out.println(result);

    }
}
