package leetcode.learning.T_09_PrefixTree;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/3/3 7:04
 * @description 基数排序
 * @editUser hx
 * @editTime 2022/3/3 7:04
 * @editDescription
 */
public class T_03_RadixSort {

    public static void radixSort(int[] arr) {
        if(arr == null || arr.length < 2) return;
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    private static void radixSort(int[] arr, int i, int i1, int maxbits) {

    }

    //找到数组中最大的数据, 并且返回几位
    private static int maxbits(int[] arr) {
        int maxValue = Integer.MAX_VALUE;
        for (int i : arr) {
            maxValue = Math.max(maxValue, i);
        }
        int res = 0;
        while (maxValue != 0) {
            res++;
            maxValue /= 10;
        }
        return res;
    }
}
