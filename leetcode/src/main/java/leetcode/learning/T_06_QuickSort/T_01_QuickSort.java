package leetcode.learning.T_06_QuickSort;

import java.util.Arrays;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/12/22 14:20
 * @description
 * @editUser hx
 * @editTime 2021/12/22 14:20
 * @editDescription 快速排序, 挺晚了归并, 在听快排,
 * 实在不懂可以看这个视频:
 * https://www.bilibili.com/video/BV1rV411j7f6?share_source=copy_web
 * https://www.bilibili.com/video/BV1B34y1S7Yi?from=search&seid=14497850874747043816&spm_id_from=333.337.0.0
 * https://www.bilibili.com/video/BV1XL411g7qF
 */
public class T_01_QuickSort {

    public static void swap(int[] arr, int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int M = partition(arr, L, R);

       /* quickSort(arr, L, M - 1);
        quickSort(arr, M + 1, R);*/
    }


    private static int partition(int[] arr, int l, int r) {
        //边界问题, 一旦出现l > r的时候, 程序退出
        if (l > r) {
            return -1;
        }
        //l == r说明左边界和右边界的重合了
        if (l == r) {
            return l;
        }
        int lessEqual = l - 1;
        //取数组的第一个值作为基准值, 进行比较
        int index = l;
        while (index < r) {
            if (arr[index] <= arr[r]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr, ++lessEqual, r);
        return lessEqual;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 8, 2};
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::print);
    }


}
