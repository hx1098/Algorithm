package leetcode.learning.T_05_MergeSort;


/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/12/17 20:06
 * @description
 * @editUser hx
 * @editTime 2021/12/17 20:06
 * @editDescription 逆序对问题
 *  一个左边的数和一个右边的数构成了一个降序
 *  { 3,1,0,4,3,1}
 *  1. 第一个3为视角:  (3,1) (3,0),(3,1)
 *  2. 第二个1为视角:  (1,0)
 *  3. ......
 *  其实就是求多个少个比右边小,
 *
 *
 *
 *
 */
public class T_04_ReversePair {

    public int reversePair(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length);
    }

    private int process(int[] arr, int L, int R) {
        if (R == L) {
            return 0;
        }
        int M = L + ((R - L) >> 1);
        // todo-repeate 2021/12/17 22:48 不是太理解
        return process(arr, 0, M) + process(arr, M + 1, R) + merge(arr, L, M, R);
    }

    private int merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int p1 = M;
        int p2 = R;
        int i = help.length - 1;
        int res = 0;
        while (p1 >= L && p2 > M) {
            res += arr[p1] > arr[p2] ? (p2 - M) : 0;
            help[i--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
        }
        while (p1 >= L) {
            help[i--] = arr[p1--];
        }
        while (p2 < M) {
            help[i--] = arr[p2--];
        }

        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        // todo-hx 2021/12/17 22:48
        return res;
    }




}
