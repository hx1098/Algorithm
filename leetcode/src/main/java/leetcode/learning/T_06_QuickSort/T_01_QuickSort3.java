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
public class T_01_QuickSort3 {


    //1.边界值
    //2.按照最右侧的数取出一个点作为基准值.
    public static void quickSort(int[] arr, int L, int R) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int M = partition(arr, L, R);
        //递归进行找边界

    }

    //边界: 1.L>R,直接返回-1(一般不会发生), 2. L==R, 返回L,(一个数的时候就返回自己本身, 无需进行比较了)
    //定义一个向前的指针, index,
    //定义一个区间, 区间开始为L-1(区间首次进来的时候是-1,循环以后是L-1)
    //循环体:
    // 1.循环条件: 如果index<R (index指针小于r, 才行)
    // 2.arr[index] < arr[R], 选定数组最右侧的 基准值 和 指针 进行比较,
    //         如果小于基准值, 就进行交换(区间向前进行扩大), 同时指针指向下一个
    //         如果大于基准值, 就不就行交换,  同时指针指向下一个
    //当比较到最后一个数据的时候, 已经跳出来了, 此时需要将基准值方到中间, ++lessEqual就是基准值了

    //第一次循环的数据变化:
    //37195
    //31795
    //31597

    //
    private static int partition(int[] arr, int L, int R) {
        if (L > R) return -1;
        if(L == R) return L;
        int index = L;//指针
        int lessEqual = L - 1;//小括号区间
        while (index < R) {
            if (arr[index] < arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr,++lessEqual,R);
        return lessEqual;
    }

    /**两值交换*/
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 9, 5};
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::print);




    }






}
