package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树结点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDiffInBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int minDiffInBST(TreeNode root) {
        List<Integer> array = new ArrayList<>();


        Recursive(root, array);

        System.out.println(array);
        // 初始化出问题了
        int min = array.get(1) - array.get(0);

        for (int i = 0, j = i + 1; i < array.size() - 1 && j < array.size(); i++, j++) {
            if (array.get(j) - array.get(i) <= min) {
                min = array.get(j) - array.get(i);
            }
        }
        return min;
    }

    public static void Recursive(TreeNode root, List array) {
        if (root != null) {
            if (root.left != null) {
                Recursive(root.left, array);
            }
            array.add(root.val);
            if (root.right != null) {
                Recursive(root.right, array);
            }
        }
    }

      static int ans = 0;

     public static int longestUnivaluePath(TreeNode root) {
         arrowLength(root);
         return  ans;
     }

     public static int arrowLength(TreeNode node) {
         if (node == null) {
             return 0;
         }
         int leftLength = arrowLength(node.left);
         int rightLength = arrowLength(node.right);

         int currentLeft = 0;
         int currentRight = 0;
         if (node.left != null && node.val == node.left.val) {
             currentLeft = leftLength + 1;
         }
         if (node.right != null && node.val == node.right.val) {
             currentRight = rightLength + 1;
         }
         // 是返回出错了？？？
         // ans 应该是保存的最后的
          ans = currentLeft + currentRight > ans ? currentLeft + currentRight : ans;
           // 因为最后只可能返回的是一条线的。不能分叉。
          return  Math.max(currentLeft, currentRight);
     }


//    public static void main(String[] args) {
    // [1,0,48,null,null,12,49,null,null,null,null]
//        TreeNode root = new TreeNode(4);
//        TreeNode item2 = new TreeNode(2);
//        TreeNode item1 = new TreeNode(1);
//        TreeNode item3 = new TreeNode(3);
//
//        TreeNode item6 = new TreeNode(6);

//        root.left = item2;
//        item2.left = item1;
//        item2.right = item3;
//        root.right = item6;

//        TreeNode item1 = new TreeNode(1);
//        TreeNode item0 = new TreeNode(0);
//        TreeNode item48 = new TreeNode(48);
//
//        item1.left = item0;
//        item1.right = item48;
//
//        int result = minDiffInBST(item1);
//
//        System.out.println(result);
//    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        TreeNode root1 = new TreeNode(4);
//        TreeNode root2 = new TreeNode(5);
//        TreeNode root3 = new TreeNode(4);
//
//        TreeNode root4 = new TreeNode(4);
//        TreeNode root5 = new TreeNode(5);
//
//
//        root.left = root1;
//        root1.right = root2;
//        root1.left = root3;
//
//        root1.right = root4;
//        root2.right = root5;
        int result = longestUnivaluePath(root);

        System.out.println(result);


    }

}
