package leetcode;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  用这段代码来消除判断。自己代码的写法，太冗余。
 *
 * if (slow == fast) return true;
 *
 * 			slow = slow->next;
 * 			fast = fast->next;
 * 			if (fast) fast=fast->next;
 * // *
 */
public class Leetcode141HasCycle {
    public boolean hasCycle(ListNode head) {

        if (head == null) return false;
//        使用快慢指针

        // 1. 如果快指针到了null，那么就不是；
//        2. 如果快慢指针相遇了，那么肯定是有环了

        ListNode dummy = new ListNode(-1);

        dummy.next = head;

        ListNode node1 = head;
        ListNode node2 = head;

        if (node2.next != null && node2.next.next == null) {
            if (node2.next.value == node1.value) {
                return true;
            } else {
                return false;
            }
        }

//      只有两个

        while (node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;

            if (node1.value == node2.value) {
                return true;
            }
        }
        return false;
    }

    ;

    public static void main(String[] args) {

    }

    ;
}
