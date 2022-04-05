package leetcode.leetcode;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/4/6 6:47
 * @description
 * @editUser hx
 * @editTime 2022/4/6 6:47
 * @editDescription 二叉树的基本逻辑结构,
 */
public class T_005_Tree {

    //二叉树的逻辑结构
    public class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }

        // todo-repeate 2022/4/6 7:08 关于递归序 如何理解
        //二叉树的先序遍历
        public void pre(Node head) {
            if (head == null) {
                return;
            }
            System.out.println(head);
            pre(head.left);
            pre(head.right);
        }

        //中序遍历
        public void inner(Node head) {
            if (head == null) {
                return;
            }
            inner(head.left);
            System.out.println(head);
            inner(head.right);
        }

        //后序遍历
        public void pos(Node head) {
            if (head == null) {
                return;
            }
            pos(head.left);
            pos(head.right);
            System.out.println(head);
        }
    }



}
