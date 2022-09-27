package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 这个是看了解析才知道用栈去解答：
 * <p>
 * 遍历字符。如果遇到了左侧字符，那么放入栈内，一直放知道遇到右侧字符。
 * 如果遇到了右侧的字符，那么取出栈的最顶部的字符来和当前的这个右侧的字符进行匹配。如果匹配到了，那么continue，如果没有匹配的话，那么pass
 */
public class Leetcode20IsValid {
    public static boolean isValid(String s) {
        if (s.length() == 1) return false;
        if (s.length() == 0) return true;
//    定义对应的map，用于查找
        Map<Character, Character> map = new HashMap<>() {
            {
                put('(', ')');
                put('{', '}');
                put('[', ']');
            }
        };

//
        Deque<Character> deque = new LinkedList<>();

//      做法
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
//           如果遇到了左侧字符，那么放进栈内
            if (map.containsKey(c)) {
                deque.add(c);
            } else {
                Character top = deque.pollLast();
                if (map.containsKey(top) && map.get(top).equals(c)) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        if (deque.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        Boolean isValid = isValid("){");
        System.out.println(isValid);
    }
}
