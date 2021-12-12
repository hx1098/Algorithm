package leetcode.learning.T_05_MergeSort;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/12/12 22:23
 * @description
 * @editUser hx
 * @editTime 2021/12/12 22:23
 * @editDescription  递归和归并 实现的排序
 */
public class RecursionMergeSort2 {


    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    //归并排序的首要条件就是将每个元素拆分为一个一个的， 最后再进行合并
    private static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int middle = L + ((R - L) >> 1);
        process(arr,L,middle);
        process(arr, middle + 1, R);

        //进行数据合并
        merge(arr, L, middle, R);

    }

    private static void merge(int[] arr, int L, int M, int R) {
        //
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];// todo-repeate 2021/12/12 22:57
        }
        while (p1 <= M) {// todo-repeate 2021/12/12 22:57
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for (int i1 = 0; i1 < help.length; i1++) {
            arr[L + i1] = help[i1];// todo-repeate 2021/12/12 22:58
        }

    }
    

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 89, 0, 5};
        //sort(arr);
        mergeSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
