package datastructure.queue;

import java.util.LinkedList;

/**
 * 通过一系列的压入和弹出操作来分析两个队列模拟一个栈的push，top，pop等操作
 *
 * @author googny
 * @since 2015/7/12
 */
public class StackWith2Queue {
    private LinkedList queue1 = new LinkedList();
    private LinkedList queue2 = new LinkedList();
    private boolean queue1HasEle = true;

    public void push(Object ele) {
        if (queue1HasEle) {
            queue1.add(ele);
        } else {
            queue2.add(ele);
        }
    }

    public Object top() {
        return top(false);
    }

    public Object pop() {
        return top(true);
    }

    public Object top(boolean remove) {
        if (!queue1HasEle) {
            LinkedList tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        if (queue1.size() == 1) {
            Object ele = queue1.poll();
            if (!remove) {
                queue2.add(ele);
            }
            queue1HasEle = false;
            return ele;
        }
        throw new IllegalStateException("No Such Element In Stack");
    }

    public static void main(String[] args) {
        StackWith2Queue stack = new StackWith2Queue();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.top());
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
