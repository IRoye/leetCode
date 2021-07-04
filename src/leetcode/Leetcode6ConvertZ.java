package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 */
public class Leetcode6ConvertZ {
    public static String convert(String s, int numRows) {

        String s1 = "";
        Map<Integer, String> map = new HashMap<>();

//      计数器
        int index = 0;

        boolean flag = true;

        for (int i = 0; i < s.length(); i++) {
            if (map.get(index) == null) {
                map.put(index, String.valueOf(s.charAt(i)));
            } else {
                map.put(index, map.get(index) + String.valueOf(s.charAt(i)));
            }

            if (flag) index++;
            if (!flag) index--;

            if (index == numRows - 1) {
                flag = false;
            }

            if (index == 0) {
                flag = true;
            }
        }

        for (String v : map.values()) {

            s1 += v;

        }

        return s1.toString();

    }

    public static void main(String[] args) {
        String s = convert("PAYPALISHIRING", 4);

        System.out.println(s);

    }
}
