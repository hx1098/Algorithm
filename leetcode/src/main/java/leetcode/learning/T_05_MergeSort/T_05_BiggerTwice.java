package leetcode.learning.T_05_MergeSort;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/12/21 15:54
 * @description 求数组中大两倍数对数量
 * @editUser hx
 * @editTime 2021/12/21 15:54
 * @editDescription 描述:
 * 在一个数组中, 对于每个数num,求有多少个后面的数 * 2 依然小于 num, 求总个数.
 * 比如: [3,1,7,0,2]
 * 3的后面有1，0,
 * 1的后面有0，
 * 7的后面有0,2,
 * 0的后面有,
 * 2的后面有,
 * 所有, 一共有5个
 *
 * 思路: 最终的问题还是先排序, 将大的问题化为小的问题.
 * 遇到的问题: 1.边界问题
 *
 *
 */
public class T_05_BiggerTwice {


    public static int biggerTwice(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int M = l + ((r - l) >> 1);
        return process(arr, l, M) + process(arr, M + 1, r) + merge(arr, l, M, r);
    }

    private static int merge(int[] arr, int l, int m, int r) {
        int ans = 0;

        //<editor-fold desc="在每一个最小单位排序的基础之上增加了计算 大于两倍的数的数量 ">
        int winR = m + 1;
        for (int i = l; i <= m; i++) {
            while (winR <= r && arr[i] > (arr[winR] * 2)) {
                winR++;
            }
            ans += winR - m - 1;
        }
        //</editor-fold>


        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int i = 0;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[j + l] = help[j];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 7, 0, 2};
        System.out.println(biggerTwice(arr));
    }
}
