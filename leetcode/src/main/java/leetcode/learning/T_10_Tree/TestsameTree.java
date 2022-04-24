package leetcode.learning.T_10_Tree;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/4/24 6:35
 * @description
 * @editUser hx
 * @editTime 2022/4/24 6:35
 * @editDescription
 */
public class TestsameTree {

    public class TreeNode{
        private int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) {
            return false;
        }
        if(p == null && q == null) return true;
        return p.val == q.val && isSameTree(q.left, q.left) && isSameTree(q.right, p.right);
    }

}
