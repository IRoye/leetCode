package leetcode.sort;

import java.util.*;

/**
 * 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * <p>
 * <p>
 * Arrays.asList使用是有问题的
 * 1. 对于基本数据类型，不适用，添加一个int数组，打印的时候显示只有一个对象元素
 * 2. 将数组和list做了一个关联，也就是该其中一个， 另一个也会改
 * 3. 长度被定死了，不支持add 和 remove 方法
 */
public class RelativeSortArray {


    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};

        String[] items = {"1", "2", "3"};
        System.out.println(items);
        List temp = Arrays.asList(items);
        temp.set(0, "11111");

        System.out.println(items[0]);

        int index = 0;

        // 需要按照插入的顺序来走
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();

        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], new ArrayList<Integer>());
        }

        int[] result = new int[arr1.length];

        // 新创建一个List
        List<Integer> integerList = new ArrayList<>();

        for (int j = 0; j < arr1.length; j++) {
            if (map.containsKey(arr1[j])) {
                map.get(arr1[j]).add(arr1[j]);
            } else {
                integerList.add(arr1[j]);
            }
        }

        integerList.sort(Comparator.naturalOrder());

        for (int arr : arr2) {
            List<Integer> innerList = map.get(arr);
            for (int innerIrem : innerList) {
                result[index++] = innerIrem;
            }
        }

        for (int resultItem : integerList) {
            result[index++] = resultItem;
        }
    }
}
