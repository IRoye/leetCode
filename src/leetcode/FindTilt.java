package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 563.二叉树的坡度
 */
public class FindTilt {
//    public int findTilt(TreeNode root) {
//
//    }
//
//    ;

    public static int findTiltSum(TreeNode root) {
        // 递归遍历
        if (root != null) {
            // 1. 已经到了叶子节点
            if (root.left == null && root.right == null) {
                return 0;
            }
            // 其他
           //  当前节点的坡度 + 当前左子节点的坡度 + 当前右子节点的坡度
            return Math.abs(nodeSum(root.left) - nodeSum(root.right)) + findTiltSum(root.left) + findTiltSum(root.right);
        }
        //  如果是null的话，返回0
        return 0;
    }

    /**
     * 为计算节点的坡度提供基础
     *
     * @param root
     * @return
     */
    public static int nodeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + nodeSum(root.left) + nodeSum(root.right);
    }

    public static void main(String[] args) {
        Integer a[] = {4, 2, 9, 3, 5, null, 7};

        TreeNode root = createTreeNodeByQueue(a);

        System.out.println(root.left.left.val);
        int sum = 0;
//        int value = findTiltSum(root, sum);
////        System.out.println(value);
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
                isLeft = true;
                // 移除队列下的root元素, 这样根元素的左子节点重新来一遍如上的遍历。
                queue.poll();
            }
        }
        return root;
    }
}


