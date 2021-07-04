package leetcode;

/**
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * <p>
 * 移除链表需要分3中情况
 * <p>
 * 1. 最常见的是，元素在非空链表的中间，既不是头结点也不是尾节点
 * 2. 节点是尾节点，那么需要遍历为尾节点，当前节点置空
 * 3. 删除头结点
 */
public class RemoveElements {
//

    /**
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
//        定义dummy node
        ListNode dummyNode = new ListNode(-1);

//
        dummyNode.next = head;

//      指向当前dummy节点

        ListNode curr = dummyNode;

        System.out.println(curr.next.value);

        while (curr.next != null) {
            if ((Integer) curr.next.value == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }

        }

//       返回头结点
        return dummyNode.next;

    }

    ;

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        removeElements(node1, 6);
    }
}
