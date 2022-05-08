package leetcode.learning.T_10_Tree;

import cn.hutool.core.util.ReUtil;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/5/7 6:34
 * @description
 * @editUser hx
 * @editTime 2022/5/7 6:34
 * @editDescription 给定一个值, 查询路径和时候存在.  测试地址:   https://leetcode.com/problems/path-sum
 *      1.搞一个全局变量, isHave
 *      2.判断改节点是否为null, 如果为null, 直接返回false
 *      3.将isHave设置为false
 *      4.调用process,
 *      5.返回isHave
 *
 *      第四个步骤需要做的操作:
 *      1.判断root节点是否是最底层的子节点, 如果是, preSum+当前的val值, 判断是否等于给定的值, 等于直接返回
 *      2.如果不是子节点, root.val + preSum(之前的累加和)
 *      3.判断当前的左子树是否为空, 不为空直接帝都调用当前方法
 *      4.判断当前的右子树是否为空, 不为空直接掉用当前方法.
 *
 */
public class T_009_PathSum {

    public class TreeNode {
        private int val;
        private TreeNode right;
        private TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isHave = false;

    public static boolean pathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        isHave = false;
        process(root, 0, sum);
        return isHave;
    }

    /**
     * @param root   当前的节点
     * @param preSum 之前节点累加的和
     * @param sum    给定的值, 你的目标值
     */
    private static void process(TreeNode root, int preSum, int sum) {
        //1.如果你的左孩子和右孩子都为空, 将isHave返回出去
        if (root.left == null && root.right == null) {
            boolean bool = (root.val + preSum) == sum;
            if (bool) return;
        }
        //2.如果不是子节点, 将原来的值加上来
        preSum += root.val;
        //3.判断左右节点是否为空,不为空, 直接递归调用就行了
        if (root.left != null) {
            process(root.left, preSum, sum);
        }
        if (root.right != null) {
            process(root.right, preSum, sum);
        }
    }

}
