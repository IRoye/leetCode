package leetcode;

/**
 * 手写链表
 */
public class ListNode<E> {

    public E value;

    public ListNode next;

    public ListNode(E value) {
        this.value = value;
    }

    public ListNode reverse(ListNode head) {
        // 标记当前节点的 前一个节点
        ListNode prevNode = null;
        // 标记当前节点的下一个节点
        ListNode nextNode = null;
        // 用head 来标记当前节点，那么当前head是null的话，意味着到了尾部了
        while (head != null) {
            // 拿到当前节点的翻转之前的next节点
            nextNode = head.next;
            // 开始翻转
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }
        return null;

    }

}
