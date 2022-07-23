package leetcode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 使用两个指针，指针
 */
public class Leetcode19RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        int step = 0;
        while (first.next != null) {
            first = first.next;
            if (step < n) {
                step++;
            } else {
                second = second.next;
            }
        }
//      遍历到头了，开始进行删除操作
//      从second开始删除
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

//      测试开始

        removeNthFromEnd(node1, 3);

        ListNode header = node1;
        while (header != null) {
            System.out.println(header.value);
            header = header.next;
        }
    }
}
