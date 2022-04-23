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
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        String a = null;
        String b = null;
        System.out.println(a == b);
        System.out.println(a == null ^ b == null);
        a = "11";
        System.out.println(a == null ^ b == null);
    }

    public static boolean isSymmtricTreee(TreeNode p1, TreeNode p2) {
        //只要是两个不同的就返回false
        if (p1 == null ^ p2 == null) return false;//一个为空,一个不为空时候是条件成立, 两个都为空, 或者两个都不为空时候, 条件不成立
        if (p1 == null && p2 == null) return true;
        return p1.val == p2.val && isSymmtricTreee(p1.left, p2.right) && isSymmtricTreee(p1.right, p2.left);
    }
}
