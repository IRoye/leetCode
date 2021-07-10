package leetcode;

/**
 * 11. 盛最多水的容器
 * <p>
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode11MaxArea {

    public static int maxArea(int[] height) {

//  定义面积
        int aera = 0;

        int i = 0, j = height.length - 1;

        while (i < j) {
//          当前坐标的值
            int x = height[i];
            int y = height[j];

//          当前坐标拼接出来的面积
            aera = Math.max(Math.min(x, y) * (j - i), aera);

//          如果是当前的x < y 的话，那么x的坐标轴向右走一个，原因是，如果移动Y的话，那么，此时x和y的距离缩小，又是取的两者之间的较小的数和距离相乘，最后的结果只能是比当前小，还不如去移动x
            if (x <= y) {
                i++;
            } else {
                j--;
            }
        }
        return aera;

    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int a = maxArea(height);

        System.out.println(a);
    }
}
