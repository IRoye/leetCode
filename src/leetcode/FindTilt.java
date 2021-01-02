package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 563.二叉树的坡度
 */
public class FindTilt {
    public int findTilt(TreeNode root) {
        return 0;
    }

    ;

    public static void main(String[] args) {
        int a[] = {4, 2, 9, 3, 5, 7};
        TreeNode node = createTreeNode(a, 0);
//        System.out.println(node.left.val);
//        System.out.println(node.right.val);
        Queue<Integer> queue = new LinkedList<>();
//
        queue.add(5);
        queue.add(2);
        queue.offer(2);

//       retrive but do not remove
        Integer a1 = queue.peek();
//         Integer a2 = queue.peek();
        System.out.println(a1);
//        System.out.println(a2);
//       retrive and remove

    }

    /**
     * 根据数组构造二叉树, 前序遍历，根节点，左子树右子树。
     *
     * @param array 完整的数组
     * @param index 当前节点值索引
     * @return
     */
    public static TreeNode createTreeNode(int[] array, int index) {
        // 如果当前的索引值计算大于数组的最大索引，返回null
        if (index > array.length - 1) {
            return null;
        }
        int value = array[index];
        TreeNode node = new TreeNode(value);
        node.left = createTreeNode(array, index * 2 + 1);
        node.right = createTreeNode(array, index * 2 + 2);
        return node;
    }

    /**
     * @param array
     * @return
     * @description: 构造树
     */
    public static TreeNode createTreeNodeByQueue(Integer[] array) {
        // 1.构建根节点
        int value = array[0];
        TreeNode root = new TreeNode(value);
        //  使用队列的先进先出的特性
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 2. 遍历剩下的数组数据
        // 标识这次的遍历是给左子树还是右子树
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            TreeNode node = queue.peek();
            Integer v = array[i];
            if (isLeft) {
                if (v != null) {
                    node.left = new TreeNode(v);
                    queue.offer(node.left);
                }
                // 下次遍历去右边
                isLeft = false;
            } else {
                if (v != null) {
                    node.right = new TreeNode(v);
                    queue.offer(node.right);
                }
                // 移除队列下的root元素, 这样根元素的左子节点重新来一遍如上的遍历。
                queue.poll();
            }
        }
        return root;
    }
}


