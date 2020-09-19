package list;

public class insert {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
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


        ListNode node6 = new ListNode(6);

        node1.next = node6;
        node6.next = node2;
        ListNode p = node1;
        while (p.next != null){
            System.out.println(p.val);
            p = p.next;
        }

    }

    }
