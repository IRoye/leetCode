package leetcode.recursion;

/**
 * no.938
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。二叉搜索树保证具有唯一的值
 */
public class RangeSumBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null){
            return 0;
        }
        if(root.val < L){
            return rangeSumBST(root.right, L, R);
        }
        if(root.val > R){
            return rangeSumBST(root.left, L, R);
        }
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    public void createBST(TreeNode root, int element) {
        if (root == null) {
            root = new TreeNode(element);
        } else {
            if (element < root.val) {
                TreeNode left = new TreeNode(element);
                root.left = left;
            }
            if (element > root.val) {
                TreeNode right = new TreeNode(element);
                root.right = right;
            }
        }
    }

    public static void main(String[] args) {
        RangeSumBST bst = new RangeSumBST();

    }
}
