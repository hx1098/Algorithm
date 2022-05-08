package leetcode.learning.T_10_Tree;

import cn.hutool.core.util.ReUtil;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/5/5 6:30
 * @description
 * @editUser hx
 * @editTime 2022/5/5 6:30
 * @editDescription 是否是搜索二叉树,
 *   要点: 1.判断节点是否是为空的
 *        2.找到左树最大值, 看是否小于头节点
 *        3.找到右子树最小值, 看是否大于头节点
 *        4.左右两个条件都成立, 就是搜索二叉树
 */
public class T_008_IsBinarySearchTree {

    public static class TreeNode{
        private int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public  class Info {
        private boolean isBST;
        private int maxLeft;
        private int minRight;

        public Info(boolean isBST, int maxLeft, int minRight) {
            this.isBST = isBST;
            this.maxLeft = maxLeft;
            this.minRight = minRight;
        }
    }

    public Info isSeachTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Info leftInfo = isSeachTree(root.left);
        Info rightInfo = isSeachTree(root.right);
        //找到左子树的最大值，和root比较，
        int maxLeft = root.val;
        int minRifht = root.val;
        if (leftInfo != null) {
            maxLeft = Math.max(leftInfo.maxLeft, maxLeft);
            minRifht = Math.min(rightInfo.minRight, minRifht);
        }
        if (rightInfo != null) {
            maxLeft = Math.max(leftInfo.maxLeft, maxLeft);
            minRifht = Math.min(rightInfo.minRight, minRifht);
        }

        //判断两边的值
        boolean isBST = true;
        if (leftInfo != null && !leftInfo.isBST) {
            isBST = false;
        }
        if (rightInfo != null && !rightInfo.isBST) {
            isBST = false;
        }
        boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.maxLeft < root.val);
        boolean rightMinMoreX = rightInfo == null ? true : (rightInfo.minRight > root.val);
        if (!leftMaxLessX || !rightMinMoreX) {
            isBST = false;
        }
        return new Info(isBST, maxLeft, minRifht);

    }



}
