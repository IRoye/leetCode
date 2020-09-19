package leetcode;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValid {
    public static void main(String[] args) {
        String arr = "}}}}}";
        System.out.println(isValid(arr));

//        DataInputStream
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(' || curr == '[' || curr == '{') {
                stack.push(curr);
            }
            if (curr == ')' || curr == ']' || curr == '}') {
                // 匹配到右括号，取出当前栈顶的元素，判断是否是匹配的
                if (!stack.isEmpty()) {
                    char p = stack.peek();
                    if (p == '(' && curr == ')' || p == '[' && curr == ']' || p == '{' && curr == '}') {
                        stack.pop();
                        continue;
                    } else {
                        break;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.empty() ? true : false;
    }
}
