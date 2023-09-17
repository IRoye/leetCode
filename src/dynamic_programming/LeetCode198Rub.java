package dynamic_programming;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class LeetCode198Rub {
    public static int rob(int[] nums) {
        int lastSelectedIndex = 0;
        int max = 0;
        int[] cache = new int[] { 0, 0};
        for (int i = 0; i < nums.length; i++) {
            int indexResult = steal(i, nums, lastSelectedIndex, cache);
            if (i == nums.length - 1) max = indexResult;
        }
        return max;
    };

    /**
     * 为了标记"唯一制约因素就是相邻的房屋装有相互连通的防盗系统"，这里需要有状态维护，标记当前index是不是被选择
     * 记录字后一次被选中的index即可
     * @param index 当前遍历的数组坐标
     * @param nums 当前便利的数组
     * @return
     */
    public static int steal(int index, int[] nums, int lastSelectedIndex, int[] cache) {
        if (index == 0) {
            lastSelectedIndex = 0;
            cache[0] = nums[index];
            return nums[index];
        }
        if (index == 1) {
            lastSelectedIndex = nums[0] >= nums[1] ? 0 : 1;
            cache[1] = Math.max(nums[0], nums[1]);
            return Math.max(nums[0], nums[1]);
        }

        if (lastSelectedIndex == index - 1) {
            /**
             * 如果index的上一个位置已经选择了，那么index必然不能选择，对于index，直接返回上一个位置的值steal(index - 1, nums, lastSelectedIndex)
             */
            return cache[1];
        } else {
            /**
             * 如果index上一个位置没有选择，lastSelectedIndex是上上个位置，那么需要比较steal(index - 2) + nums[index]是否大于 steal(idnex - 1)
             * 如果大于等于，那么当前位置，steal(index) =  steal(index - 2) + nums[index]
             * 如果小于，那么当前位置steal（index） - steal(index - 1)，即当前位置不选择，使用steal(index - 1)
             */
//            int last2 = steal(index - 2, nums, lastSelectedIndex);
//            int last1 = steal(index - 1, nums, lastSelectedIndex);
            int last2 = cache[0];
            int last1 = cache[1];
            if (last2 + nums[index] >= last1) {
                cache[0] = cache[1];
                cache[1] = last2 + nums[index];
                return last2 + nums[index];
            } else {
                cache[0] = cache[1];
                cache[1] = last1;
                return last1;
            }
        }
    };
    public static void main(String[] args) {
//        int [] nums = new int []{2,7,9,3,1};
        int [] nums = new int [] {183,219,57,193,94,233,202,154,65,240,97,234,100,249,186,66,90,238,168,128,177,235,50,81,185,165,217,207,88,80,112,78,135,62,228,247,211};
//        1,2,3,1
//        int [] nums = new int [] {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};

       int result =  rob(nums);
        System.out.println(result);

//
//        int index = 0;
//        int lastSelectedIndex = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            int indexResult = steal(i, nums, lastSelectedIndex);
//            System.out.println(indexResult);
//        }
    }
}
