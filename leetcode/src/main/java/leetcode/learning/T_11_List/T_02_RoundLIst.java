package leetcode.learning.T_11_List;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/6/13 6:37
 * @description
 * @editUser hx
 * @editTime 2022/6/13 6:37
 * @editDescription  判断一个链表是否是回文链表
 *
 * L1 -> L2 -> L3 -> L4 <-> R4 <- R3 <- R2 <- R1
 * 即 L1 = R1, L2 = R2
 *
 */
public class T_02_RoundLIst {

    public static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    //第一种, 借助容器来实现判断是否是回文, stack
    public static Boolean isRoundList(Node head) {
        Node test = head;
        Stack<Node> stack = new Stack<>();
        while (test == null) {
            stack.push(test);
            test = test.next;
        }
        while (head == null) {
            if (head.val != stack.peek().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    //不借助容器来实现 判断一个list是否是回文结构
    //思路: 将这个链表给对折起来, 一个左指针往右走, 一个右指针往左走, 直到其中一个变为空
    public static Boolean isRoundList2(Node head) {

        return true;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(4);
        node.next.next.next.next.next = new Node(3);
        node.next.next.next.next.next.next = new Node(2);
        node.next.next.next.next.next.next.next = new Node(1);

        Node head = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(3);
        node.next.next.next.next.next = new Node(2);
        node.next.next.next.next.next.next = new Node(1);


        Boolean roundList = isRoundList(node);
        System.out.println(roundList);
        Boolean roundList1 = isRoundList(head);
        System.out.println(roundList1);
    }





}
