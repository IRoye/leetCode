package sort;

/**
 * @description: 回顾最基础的冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int a[] = {9, 7, 8, 1, 12, 23};

        for (int i = 0; i < a.length; i++) {
            // 这里减去1 是因为每一轮的比较，比到倒数第length - 1就够了，到倒数第二个，倒数第二个再和倒数第一个进行比较。
            // 这里减去i是因为，每一轮的比较，都会再右侧新增一个已经排好序的元素，因此每一轮就可以减少一次，不用再比较后面已经排好序的了。
            boolean isSorted = true; // 用于标识这一轮排序是不是已经有序了。
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
//                  交换
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    isSorted = false;
                }
            }
//            如果这一路都没有交换的话，那么证明都是已经有序了的，就不需要再做之后排序了，直接break掉。
            if (isSorted) {
                break;
            }
        }

        for (int k = 0; k < a.length; k ++) {
            System.out.println(a[k]);
        }
    }
}
