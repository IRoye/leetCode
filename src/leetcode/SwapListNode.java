package leetcode;

class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2() {
    }

    ListNode2(int val) {
        this.val = val;
    }

    ListNode2(int val, ListNode2 next) {
        this.val = val;
        this.next = next;
    }
}

public class SwapListNode {

    /**
     * @param node
     * @description: 两两交换节点下的数据，分组，一组一组进行迭代交换
     */
    public static ListNode swapNode(ListNode node) {
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = node;
        // 开始遍历
        ListNode p = dummyhead;
        while (p.next != null && p.next.next != null) {
            // 当前节点的下个节点
            ListNode node1 = p.next;
            // 当前节点的下个下个节点
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;

            p.next = node2;
            // 用于开始下一轮
            p = node1;
        }
        return dummyhead;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node = swapNode(node1);
        System.out.println(node.value);

    }
}
