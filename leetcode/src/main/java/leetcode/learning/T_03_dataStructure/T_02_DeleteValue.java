package leetcode.learning.T_03_dataStructure;


/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/12 6:43
 * @description
 * @editUser hx
 * @editTime 2021/11/12 6:43
 * @editDescription 从链表中删除同一个值
 */
public class T_02_DeleteValue {

    /**链表的定义*/
    public  class Node{
        public int value;
        public Node next;
        public Node(int head) {
            this.value = head;
        }
    }


    /**
     * 0.判断是否都是null
     * 1.边界  2->2->2->2->2
     * 如果要删除值,与链表总的值都一样, 则要直接返回了
     * 2.如果不一样,
     */
    public static Node deleteNode(Node head, int num) {
        /**找到第一个num 和 node中的值不一样的节点, 如果一直等于num, 就让head一直向下走*/
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        //能走到这里说明有两种情况,
        //1.链表中全都是要删除的值: head == null;  return head
        //2.链表中有值不是要要删除的, head != null; 走while循环
        Node temp = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                temp.next = cur.next;
            } else {
                temp = cur;
            }
            cur = cur.next;
        }
        return head;
    }

}
