package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你字符串 key 和 message ，分别表示一个加密密钥和一段加密消息。解密 message 的步骤如下：
 *
 * 使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母 顺序 。
 * 将替换表与普通英文字母表对齐，形成对照表。
 * 按照对照表 替换 message 中的每个字母。
 * 空格 ' ' 保持不变。
 * 例如，key = "happy boy"（实际的加密密钥会包含字母表中每个字母 至少一次），据此，可以得到部分对照表（'h' -> 'a'、'a' -> 'b'、'p' -> 'c'、'y' -> 'd'、'b' -> 'e'、'o' -> 'f'）。
 * 返回解密后的消息。
 */
public class Leetcode2325DecodeMessage {

    /**
     * 遍历key，用map组装；
     * @param key
     * @param message
     * @return
     */
    public static String decodeMessage(String key, String message) {
//      int letter = {'a', 'b'};
        Map <Character, Character>letters = new HashMap<Character, Character>();
        int index = 0;
        for(int i = 0; i < key.length(); i++) {

           if (letters.get(key.charAt(i)) == null && (key.charAt(i) >= 97 && key.charAt(i) <= 122)) {
               System.out.println("key  = " + key.charAt(i) + " value: " + (char) (96 + index + 1));
               letters.put(key.charAt(i), (char) (96 + index + 1));
               index ++;
           }
        }
//        System.out.println("------");
//
//        for (Map.Entry<Character, Character> entry: letters.entrySet()) {
//            System.out.println("key  = " + entry.getKey() + " value: " + entry.getValue());
//        }

//       根据message获取
        String result = "";
        for (int j = 0; j < message.length(); j++) {
           result += letters.get(message.charAt(j)) == null ? message.charAt(j) : letters.get(message.charAt(j));
        }
        return  result;

    };

    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        String result = decodeMessage(key, message);

        System.out.println(result);

    }
}
