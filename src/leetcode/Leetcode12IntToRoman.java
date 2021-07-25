package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 12. 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 */
public class Leetcode12IntToRoman {
//    public String intToRoman(int num) {
//        int b = 10;
//        Map map = new HashMap<Integer, String>() {{
//
//            put(0, "");
//            put(1, "I");
//            put(2, "II");
//            put(3, "III");
//            put(4, "IV");
//            put(5, "V");
//            put(6, "VI");
//            put(7, "VII");
//            put(8, "VIII");
//            put(9, "IV");
//
//            put(10, "X");
//            put(20, "XX");
//            put(30, "XXX");
//            put(40, "XL");
//            put(50, "L");
//            put(60, "LX");
//            put(70, "LXX");
//            put(80, "LXXX");
//            put(90, "XC");
//
//            put(100, "C");
//            put(200, "CC");
//            put(300, "CCC");
//            put(400, "CD");
//            put(500, "D");
//            put(600, "DC");
//            put(700, "DCC");
//            put(800, "DCCC");
//            put(900, "CM");
//
//            put(1000, "M");
//            put(2000, "MM");
//            put(3000, "MMM");
//
//
//        }};
//
//        return map.get((num / 1000));
//    }

    public static void main(String[] args) {
        int a = 3;
        int b = 10;

        Map map = new HashMap<Integer, String>() {{
            put(1, "I");
            put(2, "II");
            put(3, "III");
            put(4, "IV");
            put(5, "V");
            put(6, "VI");
            put(7, "VII");
            put(8, "VIII");
            put(9, "IV");

            put(10, "X");
            put(20, "XX");
            put(30, "XXX");
            put(40, "XL");
            put(50, "L");
            put(60, "LX");
            put(70, "LXX");
            put(80, "LXXX");
            put(90, "XC");

            put(100, "C");
            put(200, "CC");
            put(300, "CCC");
            put(400, "CD");
            put(500, "D");
            put(600, "DC");
            put(700, "DCC");
            put(800, "DCCC");
            put(900, "CM");

            put(1000, "M");
            put(2000, "MM");
            put(3000, "MMM");


        }};

        String s = "";

        while (a != 0) {
//          获取 suffix
            int suffix = a % b;
            a = a - suffix;
            b = b * 10;

//          获取suffix 对应的罗马数字

            if (map.get(suffix) != null) {
               s = map.get(suffix) + s;
            }
            System.out.println(suffix);
        }

        System.out.println(s);
    }
}
