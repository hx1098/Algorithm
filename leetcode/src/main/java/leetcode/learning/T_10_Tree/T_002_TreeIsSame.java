package leetcode.learning.T_10_Tree;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/4/7 6:49
 * @description
 * @editUser hx
 * @editTime 2022/4/7 6:49
 * @editDescription  判断是否是镜面树 https://leetcode.com/problems/same-tree
 */
public class T_002_TreeIsSame {

    public class TreeNode{
        private int val;
        private TreeNode right;
        private TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
