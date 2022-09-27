package leetcode;

/**
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class LeetCode27RemoveElement {

    /**
     * 按照题目给的提示，原地处理。旧的元素不用删除，不需要的元素可以往后排。
     * 定义两个指针，分别指向数组的前后位置，i，j
     * i，初始为0，j初始为length - 1
     * 条件
     * 1. 如果j本身等于了待删除的元素，那么j --;
     * 2. 如果i和j相遇了，那么没必要再替换了，说明现在后面都是待删除元素了，已经满足条件了；
     * 3. 正常条件下那就直接交换就可以了；
     * 4. 最后返回的长度是i前进的距离；
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            if (nums[i] == val) {
//             如果相等，开始替换
                if (nums[j] != nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                } else {
//                  如果相等，那么替换的位置向前走，知道可以替换，如果两个相等了，那么就代表替换完了。
                    j--;
                }
            } else {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int nums[] = {3,2,2,3};
        int val = 3;

//        int temp = nums[0];
//        nums[0] = nums[1];
//        nums[1] = temp;

//        System.out.println(nums[0]);
//        System.out.println(nums[1]);

        int result = removeElement(nums, 2);
        System.out.println(result);

    }
}
