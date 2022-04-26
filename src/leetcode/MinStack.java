package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *  
 * <p>
 * 提示：
 * <p>
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 * <p>
 * <p>
 * 如果是按照leetcode官方题解的话，确实是忘记了有双端队列这么一回事了。
 * <p>
 * <p>
 * 考虑使用数组的话，每次push、pop操作都会有额外的空间浪费。
 * <p>
 * 最小的元素，必须需要考虑，进栈的时候，更新元素的最小值，出栈的时候，也需要更新元素的最小值。
 */
public class MinStack {

    Deque<Integer> data;

    Deque<Integer> min;

    public MinStack() {
        this.data = new LinkedList<>();
        this.min = new LinkedList<>();
    }

    ;

    public void push(int val) {

//   思路就是，每次进行push的时候，维护两个队列，一个是原始的队列，一个是存放最小值的队列。
//   每次开始push的时候，原始队列添加元素，min队列如果是初始的，添加。如果不是，那么开始拿当前的最小元素和其新添加的比较，如果新添加的小，那么min队列
//   push新添加元素，否则的话,那么将当前最小的元素再push一次，也就是为了匹配。这样，队列尾部的元素就是最小的。
//   之后要是再执行pop操作的话，两边保持一致，每次min取到的都是当前最小的。

        this.data.push(val);
        if (this.min.isEmpty()) {
            this.min.push(val);
        } else {
            if (this.min.getFirst() <= val) {
                this.min.push(this.min.getFirst());
            } else {
                this.min.push(val);
            }
        }

    }

    ;

    public void pop() {
        this.data.pop();
        this.min.pop();
    }

    ;

    public int top() {
        return this.data.getFirst();
    }

    ;

    public int getMin() {
        return this.min.getFirst();
    }

    ;

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.data);
        System.out.println(minStack.min);
        System.out.println(minStack.min.getFirst());
//        minStack.getMin();
//        minStack.pop();
//        minStack.top();
//        minStack.getMin();
    }


}
