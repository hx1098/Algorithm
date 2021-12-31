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
public class T_01_QuickSort2 {

    //1.边界值判断
    //2.随机选取一个值M,  >= M的放右边, <M的放左边
    //3.分别对 >=M 区域 和 <M区域进行递归, 直到数据剩一个为止
    public static void quickSort(int[] arr, int L, int R) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int M = partition(arr, L, R);
        Arrays.stream(arr).forEach(System.out::print);

        //
    }

    //2.随机选取一个基准值M,  >= M的放右边, <M的放左边
    //1.边界问题, 1.L > R 结束, L=R时候
    //2.
    private static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        //当L增加到等于的时候， 一定是最后一个数据了， 将最后一个
        swap(arr, ++lessEqual, R);
        return lessEqual;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {3, 1, 6,4,9,5};
        quickSort(arr, 0, arr.length - 1);
    }




}
