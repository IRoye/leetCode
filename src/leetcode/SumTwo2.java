package leetcode;

import java.util.ArrayList;
import java.util.List;

/***
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class SumTwo2 {


    /**
     * 表头是从个位数开始的
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode1 addTwoNumbers(ListNode1 l1, ListNode1 l2) {
        // 新建一个链表, 节点初始化为0
        // 这个节点就是所谓的dummy node
        ListNode1 l3 = new ListNode1(0);

        ListNode1 p3 = l3;
        // 代表进位
        int carry = 0;
        // 开始遍历，
        while (l1 != null || l2 != null) {
            // 每次都需要判断当前值是不是null
            int currentValuel1 = l1 != null ? l1.val : 0;
            int currentValuel2 = l2 != null ? l2.val : 0;

            // 两个值相加
            int value = currentValuel1 + currentValuel2 + carry;

            // 两个值相加，如果大于10那么就是取余数
            p3.next = new ListNode1(value % 10);
            p3 = p3.next;

            // 进位是相加值 / 10
            carry = value / 10;

            // 切换到下一个
            l1 = l1.next;
            l2 = l2.next;
        }
        // 遍历完成之后，他们同时结束，而且相加的值是 > 10的话，那么有
        if (carry > 0) {
            p3.next = new ListNode1(carry);
        }
        return l3.next;
    }

    public static void main(String[] args) {
        // (2 -> 4 -> 3) + (5 -> 6 -> 4)
        SumTwo2 st = new SumTwo2();
        ListNode1 list1 = new ListNode1(2);
        ListNode1 list2 = new ListNode1(4);
        ListNode1 list3 = new ListNode1(3);

        list1.next = list2;
        list2.next = list3;

        ListNode1 list5 = new ListNode1(5);
        ListNode1 list6 = new ListNode1(6);
        ListNode1 list4 = new ListNode1(4);

        list5.next = list6;
        list6.next = list4;

        ListNode1 result =  st.addTwoNumbers(list1, list5);
        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);


    }
}
