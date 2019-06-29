package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Recursive(root, list);

        return list;
    }

    public static void main(String[] args) {
        // 构造一棵二叉树 [1,null,2,3]
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;

        // 如何遍历
        List <Integer> result =  inorderTraversal(root);
        System.out.println(result);

    }

    public static void Recursive(TreeNode root, List container) {
        if (root != null) {
            if (root.left != null) {
                Recursive(root.left, container);
            }
            container.add(root.val);
            if (root.right != null) {
                Recursive(root.right, container);
            }
        }
    }

}
