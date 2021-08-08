package leetcode;

/**
 * 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class Leetcode61RotateList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode dummyHead = new ListNode(-101);
        dummyHead.next = head;
        ListNode curr1 = dummyHead;
        // 砍掉右侧的两个位置，拼接掉
        int lenght = 0;
        while (curr1.next != null) {
            curr1 = curr1.next;
            lenght++;
        }

        if (lenght == 0 || lenght == 1) {
            return head;
        }

        k = k % lenght;

        if (k == 0) return head;

        // 加入需要移动两位；
        // 那么在第3位的时候将list切断去拼接头
        ListNode curr2 = dummyHead.next;
        ListNode newHead = null;
        int i = 1;
        int target = lenght - k;
        while (curr2.next != null) {
            if (i == target) {
                newHead = curr2.next;
                curr2.next = null;
//              拼接到头；
                curr1.next = dummyHead.next;
                break;
            } else {
                curr2 = curr2.next;
            }
            i++;
        }
        return newHead;
    }

    ;

    public static void main(String[] args) {
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);

        ListNode node2 = new ListNode(1);


        rotateRight(node2, 1);


    }
}
