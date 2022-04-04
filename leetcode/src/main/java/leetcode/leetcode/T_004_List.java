package leetcode.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/4/3 14:03
 * @description
 * @editUser hx
 * @editTime 2022/4/3 14:03
 * @editDescription 单链表结构 反转, 和 双链表结构反转
 */
public class T_004_List {

    public class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 链表反转
     */
    public static void revertList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
    }


    public class DoubleListNode {
        private int value;
        private DoubleListNode last;//上一个
        private DoubleListNode next;//下一个

        public DoubleListNode(int val) {
            this.value = val;
        }
    }

    /**
     * 双端链表反转
     */
    public static void revertDoubleList(DoubleListNode head) {
        DoubleListNode pre = null;
        DoubleListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
    }


}