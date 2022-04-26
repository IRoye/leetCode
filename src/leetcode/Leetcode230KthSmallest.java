package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二叉搜索树的查找；
 * 1.
 */
public class Leetcode230KthSmallest {

    public int kthSmallest(TreeNode root, int k) {

//  1、定义一个栈，用于遍历存储
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();

//  2、首先添加根节点
        deque.add(root);
        TreeNode current = root;
        int count = 1;
//  3、开始中序的遍历
        while (!deque.isEmpty() && current != null) {
            // 3.1、找到当前节点下述的所有的left
            while (current.left != null) {
                current = current.left;
                deque.push(current);
            }
//           3.2、然后，当前节点打印
            TreeNode node = deque.pop();
            count++;
            System.out.println(node.val);
            if (count == k) {
                return node.val;
            }
//            3.3、看看当前节点有没有右子树
            current = current.right;
        }
        return -1;
    }

    ;

    /**
     *
     * @param root 根节点
     * @param k 需要获取第几个数
     * @param k1 当前处在第几个数
     * @param value 记录当前的目标值
     */


}
