package leetcode;

/***
 * leetCode 第四题
 */
public class MergeSort {

    /***
     * 将两个有序的数组合并成一个数组
     * @param nums
     */
    public static void sort(int[] nums) {
        int length = nums.length;

        int lo = 0;
        int hi = length - 1;


        int aux[] = new int[length];

        // 将数组nums中的数据转移到 aux中去
        for (int k = 0; k < 6; k++) {
            aux[k] = nums[k];
        }

        // 转移到aux之后
        int i = lo;
        //int j = mid;
        int j = 4;

        // 开始循环
        for (int k = lo; k < 6; k++) {
            // 4种情况
            // 1. 左边的元素遍历完
            if (i > 3) {
                nums[k] = aux[j++];
            }
            // 2. 右边的元素遍历完
            else if (j > 5) {
                nums[k] = aux[i++];
            }
            // 3. 比较
            else if (aux[i] < aux[j]) {
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
            }
        }

        for (int x = 0; x < nums.length; x++) {
            System.out.println(nums[x]);
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0.0;
        // 1.定义两个指针，分别指向两个不同的数组
        // 两个数组的话，需要是遍历 num1.length + nums2.length
        int total = nums1.length + nums2.length;
        int[] nums3 = new int[total];
        int i = 0;
        int j = 0;
        for (int k = 0; k < total; k++) {
            if (i > nums1.length - 1) {
                nums3[k] = nums2[j++];
            } else if (j > nums2.length - 1) {
                nums3[k] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                nums3[k] = nums1[i++];
            } else {
                nums3[k] = nums2[j++];
            }
        }
        // 计算中位数
        if (total % 2 == 0) {
            double a = nums3[(total / 2 ) - 1];
            double b = nums3[total / 2];
            result = (a + b) / 2;
        } else {
            result = nums3[(total + 1) / 2 - 1];
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);

    }
}
