package leetcode;

import java.util.*;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FequencySort {
    public static String frequencySort(String s) {

        StringBuilder result = new StringBuilder();
//      哈希表存储字符串数量
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        List<Character> list = new ArrayList<>(map.keySet());

//       排序
        Collections.sort(list, (a, b) -> {
            return map.get(b) - map.get(a);
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            for (int j = 0; j < map.get(list.get(i)); j++) {
                result.append(list.get(i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String a = frequencySort("Aabb");

        System.out.println(a);
    }
}
