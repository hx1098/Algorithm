package leetcode.learning.T_05_MergeSort;

import com.sun.scenario.effect.Merge;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/12/12 22:23
 * @description
 * @editUser hx
 * @editTime 2021/12/12 22:23
 * @editDescription 递归和归并 实现的排序
 */
public class RecursionMergeSort2 {



    //region 递归和归并实现的排序
    public static void sort(int[] arr) {
        //判断数组是否为空
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    //递归实现每一个元素为一个单元,知道左边 == 右边
    //左半部分先有序,
    //有半部分后有序
    //之后在进行合并
    private static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    //定义一个help 数组.
    //if 两边都没有越界, 拷贝数据
    //如果左边越界, 拷贝左边数据 增正常情况下已有一个越界
    //如果右边越界, 拷贝右边数据 增正常情况下已有一个越界
    //将help 数组拷贝到 原数组中
    private static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int i1 = 0; i1 < help.length; i1++) {
            arr[L + i1] = help[i1];
        }
    }
    //endregion


    //1.边界问题判空
    //2.设置左边界, 设置步长, 后期根据步长来计算右边界
    //3.


    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int mergeSize = 1;
        while (mergeSize < N) {
            int L = 0;
            while (L < N) {
                //如果长度已经大于当前的数组了
                if (mergeSize >= N - L) {
                    break;
                }
                int M = L + mergeSize - 1;
                int R = M + Math.min(mergeSize, N - M - 1);
                merge2(arr, L, M, R);
                L = R + 1;
            }

            if (mergeSize > N / 2) {
                break;
            }

            mergeSize <<= 1;
        }


    }


    //定义一个help, i, p1左指针指向左半部分第一个, p2右指针指向有半部分第一个
    //如果 p1,p2 都没越界 两边的数据谁小拷贝谁
    //如果p1 越界 生效的全盘拷贝
    //如果p2 越界 剩下的全盘拷贝
    //将help数组 数据拷贝到 原数组
    private static void merge2(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = M + 1;
        int i = 0;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }



    public static void main(String[] args) {
        int[] arr = {10, 6, 3, 4};
        //sort(arr);
        mergeSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
