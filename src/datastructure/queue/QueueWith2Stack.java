package datastructure.queue;

import java.util.LinkedList;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数，appendTail和deleteHead，
 * 分别完成在队列尾部插入节点和删除头部节点的功能
 *
 * @author googny
 * @since 2015/7/12
 */
public class QueueWith2Stack {

    private LinkedList stack1 = new LinkedList();
    private LinkedList stack2 = new LinkedList();

    public void appendTail(Object ele) {
        stack1.push(ele);
    }

    public Object deleteHead() {
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.size() == 0) {
            throw new IllegalStateException("No Such Element In queue");
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueWith2Stack queue = new QueueWith2Stack();
//        System.out.println(queue.deleteHead());
        queue.appendTail(1);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}
