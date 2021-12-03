package leetcode.learning.T_05_MergeSort;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/12/3 9:17
 * @description 递归之后, 二分进行 归并排序.
 * @editUser hx
 * @editTime 2021/12/3 9:17
 * @editDescription
 * 主逻辑:
 *      1.将数据一份为2, 实现左半部分有序, 在实现有半部分有序,(使用递归来实现)
 *      2.在进行归并排序
 *          1.定义两个指针, 左指针和右指针,
 *          2.先比较左侧数据,
 *              L1和R2, 如果L1 < R1, L1排在前面,
 *              L1和R2, 如果L1 < R1, R2排在前面,
 *          3,边界值:
 *              若L部分数据先比较完, 直接将 R部分数据拷贝过来,
 *              若R部分数据先比较完, 直接将 L部分数据拷贝过来,
 *
 */
public class T_01_RecursionMergeSort {

    public static void sort( int[] arr) {
        //   数据的边界, 没有数或者只有一个数的时候不用进行排序
        if (arr == null || arr.length == 1) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    // todo-hx 2021/12/3 21:39 这里有点绕不过来为啥递归有序了.
    private static void process(int[] arr,int L,int R) {

        int middle = L + ((R - L) >> 1);
        if (L == R) {
            return;
        }
        process(arr, L, middle);
        process(arr, middle + 1, R);

        //merge(arr,L,middle,R);

    }

    //将两边的数据进行合并, 小的放左边, 大的放右边
    private static void merge(int[] arr, int L, int middle, int R) {


    }


    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 8, 5, 0};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
