package tree;

import leetcode.TreeNode;

import java.util.*;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LowestCommonAncestor {
    /**
     * @param root
     * @param p
     * @param q
     * @return
     * @description: 二叉树的最近公共祖先
     * 需要做：
     * 1. 深度优先遍历当前的树。
     * 2. 记录每个节点的父节点，通过map记录，通过一级一级的向上查找，组成最终的查找链。不能直接通过遍历Push元素来做，深度优先遍历总是从最左边开始。
     * 3. 通过组装的Map，开始查找。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1. 定义栈来遍历
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        // 2. 定义map，用于保存父子之间的关系
        Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
        Set<TreeNode> set = new HashSet<TreeNode>();
        set.add(p);
        set.add(q);

        deque.add(root);

        while (!deque.isEmpty()) {
            TreeNode treeNode = deque.pop();
            if (treeNode.right != null) {
                deque.add(treeNode.right);
                map.put(treeNode.right, treeNode);
            }
            if (treeNode.left != null) {
                deque.add(treeNode.left);
                map.put(treeNode.left, treeNode);
            }
        }

//      3. 构造完map后
        while (p != null) {
            if (map.get(p) == null) {
                set.add(p);
                p = map.get(p);
            } else {
                p = map.get(p);
                set.add(p);
            }
        }

        while (q != null) {
            if (map.get(q) == null) {
                set.add(q);
                q = map.get(q);
            } else {
                q = map.get(q);
                if (set.contains(q)) {
                    return q;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
