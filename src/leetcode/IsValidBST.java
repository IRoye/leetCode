package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 最开始的一定是最小的那个，递归的每次一定是比前一次的值要大的，否则就返回false
 */
public class IsValidBST {

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        List items = new ArrayList<Integer>();
        traval(root, items);
        for(int i = 1; i  < items.size(); i++) {
            if((Integer)items.get(i) <= (Integer) items.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3};
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node2.left = node1;
        node2.right = node3;
        System.out.println(isValidBST(node2));
    }

    public static void traval(TreeNode root, List item){
       if(root != null) {
           traval(root.left, item);
           item.add(root.val);
           traval(root.right, item);
       }
    }
}

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}
