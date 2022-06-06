package leetcode.learning.T_11_List;

import cn.hutool.core.util.ReUtil;
import lombok.val;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/6/3 6:41
 * @description
 * @editUser hx
 * @editTime 2022/6/3 6:41
 * @editDescription  快慢指针, 根据快慢指针找中点位置
 *
 * 1.给定一个奇数个链表, 返回一个中点位置, 偶数个返回上中点
 * 2.给定一个奇数个链表, 返回一个中点位置, 偶数个返回下中点
 * 2.给定一个奇数个链表, 奇数返回一个中点位置的前一个点, 偶数个返回上中点的前一个中点
 * 2.奇数个链表, 返回一个中点前一个, 偶数个 :返回下中点的前一个
 *
 */
public class T_01_LinkedListMId {

    public static  class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    /**奇数个返回中点, 偶数返回上中点*/
    public static Node midOrUpMidNode(Node val) {
        if (val == null || val.next == null || val.next.next == null) {
            return val;
        }
        Node fast = val;
        Node slow = val;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**奇数个返回中点, 偶数个返回下中点*/
    public static Node midOrDownMOdNode(Node val) {
        if (val == null || val.next == null || val.next.next == null) {
            return val;
        }
        Node fast = val.next;
        Node slow = val.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast;
    }

    /**奇数个返回中点, 偶数个返回上中点*/
    public static Node right1(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> list = new ArrayList<>();
        Node cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        return list.get((list.size() - 1) / 2);
    }
    public static Node right2(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> list = new ArrayList<>();
        Node cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        return list.get((list.size()) / 2);
    }


    public static void main(String[] args) {
        Node test = null;
        test = new Node(0);
        test.next = new Node(1);
        test.next.next = new Node(2);
        test.next.next.next = new Node(3);
        test.next.next.next.next = new Node(4);
        test.next.next.next.next.next = new Node(5);
        test.next.next.next.next.next.next = new Node(6);
        test.next.next.next.next.next.next.next = new Node(7);
        test.next.next.next.next.next.next.next.next = new Node(8);

        System.out.println("============奇数中点, 偶数上中点==============");
        Node node = midOrUpMidNode(test);
        System.out.println(node.val);
        Node right1 = right1(test);
        System.out.println(right1.val);

        System.out.println("============奇数中点, 偶数上中点==============");

        Node right2 = right2(test);
        System.out.println(right2.val);
    }


}
