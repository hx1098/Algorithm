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
        while (test != null) {
            stack.push(test);
            test = test.next;
        }
        System.out.println(stack);
        while (head != null) {
            System.out.println(head.val + "::" + stack.pop().val );
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    //不借助容器来实现 判断一个list是否是回文结构
    //思路: 1.找出中点, 2. 将中点后的指针反转,指向中点位置, 3.判断是否是回文, 4.将中点后的位置指针反转, 恢复到原来的状态
    public static Boolean isRoundList2(Node head) {
        //1.找出中点
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.val);
        //2.将中点后的指针反转




        return true;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(3);
        node.next.next.next.next.next.next = new Node(2);
        node.next.next.next.next.next.next.next = new Node(1);

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);


        Boolean roundList = isRoundList(node);
        System.out.println(roundList);
        Boolean roundList1 = isRoundList(head);
        System.out.println(roundList1);
        System.out.println("============================");

        Boolean roundList2 = isRoundList2(node);
        System.out.println(roundList2);
        Boolean roundList3 = isRoundList2(head);
        System.out.println(roundList3);

    }





}
