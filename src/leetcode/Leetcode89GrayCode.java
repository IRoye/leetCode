package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. 格雷编码
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * <p>
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 * <p>
 * 格雷编码序列必须以 0 开头。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * <p>
 * 对于给定的 n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
 * <p>
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * 示例 2:
 * <p>
 * 输入: 0
 * 输出: [0]
 * 解释: 我们定义格雷编码序列必须以 0 开头。
 * 给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
 * 因此，当 n = 0 时，其格雷编码序列为 [0]。
 */
public class Leetcode89GrayCode {
    public static List<Integer> grayCode(int n) {

        //  2位二进制的最大值：2^2 - 1, 最大值是3；

        //      初始化为0
        List<Integer> list = new ArrayList<Integer>() {{
            add(0);
        }};

        int count = (int) Math.pow(2, n) - 1;

        //       数组总共是4个值
        for (int i = 1; i <= count; i++) {
            int last = (Integer) list.get(list.size() - 1);
            for (int j = 1; j <= count; j++) {
                if (hammingWeight(last ^ j) == 1 && !list.contains(j)) {
                    list.add(j);
                    break;
                }
            }
        }
        return list;
    }

    ;

    public static void main(String[] args) {


        System.out.println(grayCode(2));
        System.out.println("-------");
        System.out.println(hammingWeight(1 ^3));

    }

    ;

    public static int hammingWeight(int n) {

//      限制位数
        n = n & 0xffffffff;
        int count = 0;
        int i = 0;
        while (n != 0) {
            // 关系运算符的优先级大于逻辑运算符
            if ((n & 1) == 1) {
                count += 1;
            }

            n = n >> 1;
            i++;
        }
        return count;
    }

}
