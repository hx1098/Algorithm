package leetcode.learning.T_10_Tree;

import java.util.HashMap;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/4/24 6:35
 * @description
 * @editUser hx
 * @editTime 2022/4/24 6:35
 * @editDescription
 * 根据树的前序遍历和中序遍历进行重组装树
 */
public class T_004_RepairTree {

    public static class TreeNode {
        private int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buidlTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        return f(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public static TreeNode f(int[] pre, int L1, int R1, int[] in, int L2, int R2) {
        //先 : 123
        //中 : 231  这是一个不规则的树形结构, 防止左树为空, 或者右树为空的情况
        if (L1 > R1) return null;
        TreeNode head = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return head; //此时说明只有一个节点, 不需要向下找了
        }
        //在中序遍历中找到头结点
        int find = L2;
        while (pre[L1] != in[find]) {
            find++;
        }
        head.left = f(pre, L1, L1 + find - L2, in, L2, find-1);
        head.right = f(pre, L1 + find - L2 + 1, R1, in, find + 1, R2);
        return head;
    }


    /**
     * 这种方法是使用一个hash表来存储, 头节点在 中序遍历中的位置, 来确定左树和右树 在数组中的位置.
     * @param pre
     * @param in
     * @return
     */
    public static TreeNode buidlTre2(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return f2(pre, 0, pre.length - 1, in, 0, in.length - 1,map);
    }
    public static TreeNode f2(int[] pre, int L1, int R1, int[] in, int L2, int R2,HashMap<Integer,Integer> map) {
        //先 : 123
        //中 : 231  这是一个不规则的树形结构, 防止左树为空, 或者右树为空的情况
        if (L1 > R1) return null;
        TreeNode head = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return head; //此时说明只有一个节点, 不需要向下找了
        }
        //在中序遍历中找到头结点
        int find = map.get(pre[L1]);
        head.left = f2(pre, L1, L1 + find - L2, in, L2, find-1,map);
        head.right = f2(pre, L1 + find - L2 + 1, R1, in, find + 1, R2,map);
        return head;
    }

}
