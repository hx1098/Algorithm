package leetcode.learning.T_10_Tree;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/5/7 6:34
 * @description
 * @editUser hx
 * @editTime 2022/5/7 6:34
 * @editDescription 根据上一题类似,  给定一个值sum 和 一个二叉树, 收集路径和等于sum 的路径
 *
 *
 */
public class T_010_PathSumCollection {

    public class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> getCollections(int sum, TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> ans = new ArrayList<>();
        process(root, sum, 0, new ArrayList<>(), ans);
        return ans;

    }

    /**
     *
     * @param sum  给定值
     * @param preSum 之前的累加和
     * @param currentPath 当前路径
     * @param ans 当前要返回的路径和 collections
     */
    private void process(TreeNode root,int sum, int preSum, List<Integer> currentPath, List<List<Integer>> ans) {
        //1.如果左节点和右节点是叶子节点,并且sum = pre + sum
        if (root.left == null && root.right == null) {
            if (sum == (preSum + root.val)) {
                currentPath.add(root.val);
                ans.add(currentPath);
                //返回上一层
                currentPath.remove(currentPath.size() - 1);
            }
        }
        //2.如果不是叶子节点, 将值加进来
        preSum += root.val;
        currentPath.add(root.val);
        if (root.left != null) {
            process(root.left, sum, preSum, currentPath, ans);
        }
        if (root.right != null) {
            process(root.right, sum, preSum, currentPath, ans);
        }

        // todo-repeate 2022/5/11 6:39  暂时不太理解, 为啥要这样
        //调用完自己的所有子过程, 需要返回到上一级, 删除掉干干净净的回到上一级
        currentPath.remove(currentPath.size() - 1);

    }


}
