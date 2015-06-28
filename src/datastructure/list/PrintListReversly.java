package datastructure.list;

import java.util.LinkedList;

/**
 * 输入一个链表的头结点，从尾到头反过来打印出每个结点的值
 * 注意：不能改变原链表的顺序
 *
 * @author googny
 * @since 2015/6/28
 */
public class PrintListReversly {

    public void printListReversly(LinkedList list) {
        LinkedList stack = new LinkedList();
        for (Object ele : list) {
            stack.push(ele);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().toString());
        }
    }

    public void printListReversly_recursively(ListNode head) {
        if(head!=null){
            if(head.next != null){
                printListReversly_recursively(head.next);
            }
            System.out.println(head.key);
        }
    }
}

class ListNode {
    int key;
    ListNode next;
}
