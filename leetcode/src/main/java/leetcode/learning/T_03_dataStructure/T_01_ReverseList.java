package leetcode.learning.T_03_dataStructure;


import java.util.ArrayList;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/7 9:45
 * @description
 * @editUser hx
 * @editTime 2021/11/7 9:45
 * @editDescription 单链表反转, 双链表反转
 */
public class T_01_ReverseList {


    /**
     * singleList
     */
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }

    /*反转前:
     * a -> b -> c ->null
     * 反转后:
     * c -> b -> a ->null
     *
     * 关键点在于: 找到a 节点的pre和 next 节点
     *
     * */
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        /**head是空的, 说明链表已经没有数据了*/
        while (head != null) {
            //    1.将下一个值先存储起来,
            //    2.将当前值的下一个指针指向上一个值, 其实就是头节点的上一个值(单链表中中头节点第一次循环是没有上一个值的, 其实就是null,第二次循环才会有值 )
            //    3.将本次循环的上一个指针指向head,第一次循环时候pre是空的, 每一次的循环都为下一次的循环做准备, 以便下一次的循环使用到
            //    4.将头指向 该 链表的下一个数据, 一次循环
            next = head.next;
            head.next = pre; //是将  null <-- a
            pre = head;    // null <--- a <---
            head = next;  //将 head 的指针指向 下一个 head, 进行下一轮循环
        }
        return pre;
    }

    /**测试单链表*/
    public static Node testReverseLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        int N = list.size();
        for (int i = 1; i < N; i++) {
            list.get(i).next = list.get(i - 1);
        }
        return list.get(N - 1);
    }


    /**非常判断一个人呢的codeing能力
     * 
     * */
    public static Node generateRandomLinkedList(int len, int value) {
        return null;
    }

    public static void main(String[] args) {
        double ceil = Math.ceil(1);
        System.out.println(ceil);
        System.out.println(ceil >= 1);
    }


}
