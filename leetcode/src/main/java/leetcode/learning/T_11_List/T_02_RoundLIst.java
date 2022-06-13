package leetcode.learning.T_11_List;

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
        private Node val;
        private Node next;

        public Node(Node val) {
            this.val = val;
        }
    }

    //第一种, 借助容器来实现判断是否是回文, stack
    public Boolean isRoundList(Node head) {
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





}
