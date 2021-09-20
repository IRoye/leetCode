package leetcode;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class Leetcode104MaxDepth {
    public static int maxDepth(TreeNode root) {

        int number = traverse(root);

        return number;

    }

    ;

    public static int traverse(TreeNode t) {
        int left = 0;
        int right = 0;
        if (t == null) {
            return 1;
        }
        left = traverse(t.left) + 1;
        right = traverse(t.right) + 1;
        return left > right ? left : right;
    }

    ;

    public static void add(Integer a) {
        a = a + 1;
    }

    public static void main(String[] args) {
        Integer b = 2;

        add(b);

        System.out.println(b);
    }
}
