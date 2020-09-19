package leetcode.romanToInt;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RomanToInt {

    public static int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<String, Integer>() {
            {
                put("I", 1);
                put("V", 5);
                put("X", 10);
                put("L", 50);
                put("C", 100);
                put("D", 500);
                put("M", 1000);
                put("IV", 4);
                put("IX", 9);
                put("XL", 40);
                put("XC", 90);
                put("CD", 400);
                put("CM", 900);
            }
        };
        // 直接加就行，不需要整理到list
        List<String> keys = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (i + 1 < s.length()) {
                char nextChar = s.charAt(i + 1);
                if (map.get(currentChar + "" + nextChar + "") != null) {
                    keys.add(currentChar + "" + nextChar + "");
                    i++;
                } else {
                    keys.add(currentChar + "");
                }
            } else {
                keys.add(currentChar + "");
            }
        }
        int sum = 0;
        for (int j = 0; j < keys.size(); j++) {
            int current = map.get(keys.get(j));
            sum += current;
        }
        return sum;
    }

    public static void main(String[] args) {

        String a = "III";
        int result = romanToInt(a);
        System.out.println(result);

    }
}
