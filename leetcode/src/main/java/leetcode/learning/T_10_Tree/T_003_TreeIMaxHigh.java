package leetcode.learning.T_10_Tree;

import T05_DesignMode.T15_Composite.version1.impl.Root;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/4/7 6:49
 * @description
 * @editUser hx
 * @editTime 2022/4/7 6:49
 * @editDescription 判断一个树的最大高度
 */
public class T_003_TreeIMaxHigh {

    public class TreeNode{
        private int val;
        private TreeNode right;
        private TreeNode left;

        private TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 求一个二叉树的最大高度, 就是求左边
     * 最后一步很好理解, 就是说: 如果只有一个节点, 就不是null, 0+1 = 1 高度就是1了,
     *                         如果有两个节点, 就不是null, 0 + 1+ 1 = 2;
     * @param head
     * @return
     */
    public int maxHigh(TreeNode head) {
        if (head == null) return 0;
        return Math.max(maxHigh(head.left), maxHigh(head.right)) + 1;
    }


}
