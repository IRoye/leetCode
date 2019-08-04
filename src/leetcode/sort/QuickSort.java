package leetcode.sort;

/**
 * 快速排序
 */
public class QuickSort {

    /***
     * 递归排序
     * @param a 子数组
     * @param lo 子数组最小Index
     * @param hi 子数组的最大index
     */
    public static int sort(int[] a, int lo, int hi) {
        // 1. 一般来来说，取子数组的最小index来作为切分元素
        int partition = a[lo];
        int i = lo;
        int j = hi + 1;
        // 开始递归查找
        while (true) {
            while (partition >= a[i]) {
                i++;
                if (i == hi) {
                    break;
                }
            }
            while (partition <= a[j]) {
                j--;
                if (j == lo) {
                    break;
                }
            }
            // 两个指针,i, j 现在是临界状态，如果现在是, 说明左侧的元素已经扫描完了，右侧的原因也已经扫描完了。
            if (i >= j) break;
            //交换元素的位置
            exchange(a, i, j);
        }
        // 最后一步，将a[lo]的值和a[j]的值进行交换，这是最后一次的交换
        exchange(a, a[lo], a[j]);
        // 返回j的位置，j的位置现在已经被替换成了切分元素，也就是说， 切分元素左边的值都是小于切分元素的，右边的值都是大于切分元素的，将这个值return出去，分为左右两侧， 继续递归调用
        return j;
    }

    public static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {

    }

}
