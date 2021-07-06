package leetcode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 */
public class Leetcode21MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        构造新的链表
        ListNode dummy = new ListNode(-1);

        ListNode head = dummy;

        if (l1 == null) {
            head.next = l2;
        }

        if (l2 == null) {
            head.next = l1;
        }

//      遍历两个链表
        while (l1 != null && l2 != null) {

            System.out.println(l1.value);
            System.out.println(l2.value);
            System.out.println("-------------------------");

            if ((Integer) l1.value <= (Integer) l2.value) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }

            head = head.next;

        }
        if (l1 == null && l2 != null) {
            head.next = l2;
        }

        if (l2 == null && l1 != null) {
            head.next = l1;
        }

        return head.next;
    }

    ;

    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node14 = new ListNode(4);

        node11.next = node12;
        node12.next = node14;

        ListNode node21 = new ListNode(1);
        ListNode node23 = new ListNode(3);
        ListNode node24 = new ListNode(4);

        node21.next = node23;
        node23.next = node24;

       ListNode result =  mergeTwoLists(node11, node21);

        System.out.println(result);


    }
}
