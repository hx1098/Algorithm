package leetcode.leetcode;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/4/3 14:03
 * @description
 * @editUser hx
 * @editTime 2022/4/3 14:03
 * @editDescription 单链表结构 反转
 */
public class T_004_List {

    public class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    /**链表反转*/
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




    public static void main(String[] args) {

    }


}
