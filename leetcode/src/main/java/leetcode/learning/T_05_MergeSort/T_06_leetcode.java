package leetcode.learning.T_05_MergeSort;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/12/21 15:54
 * @description 给定一个数组arr,和两个整数a和b(a<=b),求arr中有多少个子数组, <br></br>累加在[a,b]这个范围中, 返回达标的子数组数量.
 * @editUser hx
 * @editTime 2021/12/21 15:54
 * @editDescription 描述 区间和达标的子数组数量:  https://leetcode-cn.com/problems/count-of-range-sum/
 *
 * 示例1:
 * 输入: nums = {-2, 5, -1}, lower = -2, upper = 2
 * 输出: 3
 * 解释: 存在三个区间, [0,0],[2,2],[0,2], 对应的区间分别是: -2, -1, 2
 *
 * 示例2:
 * 输入：nums = [0], lower = 0, upper = 0
 * 输出：1
 *
 *
 */
public class T_06_leetcode {

    public static int countOfRangeSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int l, int r) {
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 7, 0, 2};
        System.out.println();
    }
}
