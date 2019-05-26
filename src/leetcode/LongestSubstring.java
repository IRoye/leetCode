package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {

        // 切分成字符串数组, 这样做就少了一个连续了，要求的是连续
        char[] subs = s.toCharArray();
        int max = 0; // 最大值初始化是0
        int flag = 0; // 重复字符的下标，初始指向第一个字符

        for (int i = 0; i < subs.length; i++) {
            if (i == 0) {
                max++;
                continue;
            } else {
                // 从当前遍历的位置往前找
                int index = s.lastIndexOf(s.charAt(i), i - 1);
                // 如果找到的话， 那么说明接下来有前面的重复的
                if (index != -1 && index >= flag) {
                    // 加一个判断条件，如果此时的s[flag] = s[i],也就是 那么, 也就在最后紧挨着
                    if(String.valueOf(s.charAt(flag)).equals(String.valueOf(s.charAt(i - 1)))){
                        flag = i;
                    }else {
                          // 对于相同的字符串在中间的情况 nfpdmpi
                         flag = index + 1;
                    }
                } else {
                    if (i - flag + 1 >= max) {
                        max = i - flag+ 1;
                    }
                }
            }

        }

        return max;
    }

    public static void main(String[] args) {
        // nfpdmpi
        int a = lengthOfLongestSubstring("nfpdmpi");
        System.out.println(a);
    }

}
