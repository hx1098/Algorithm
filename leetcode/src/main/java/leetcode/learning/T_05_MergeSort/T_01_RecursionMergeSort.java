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
        //这里递归到每个数组为最小的单元就是有序的了, 最后进行合并, 而合并之后就是有序的了.
        int middle = L + ((R - L) >> 1);
        if (L == R) {
            return;
        }
        //0~middle 有序
        process(arr, L, middle);
        //middle+1 ~ right 有序
        process(arr, middle + 1, R);

        //合并
        merge(arr,L,middle,R);

    }

    //将两边的数据进行合并, 小的放左边, 大的放右边
    private static void merge(int[] arr, int L, int M, int R) {
        //    1.定义一个r-l + 1 长的数组, 用来装最大长度的数组
        //    2.定义一个p1 = l 的数组, p2 = M+1 的数组的指针,
        //    3.如果两个数组都没有越界, 将arr[p1++], arr[p2++] 比较小的先放到help数组中
        //    4.要抹p1 越界了, 要抹p2越界了,
        //    5.将该数组拷贝到arr数组中,
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) { //左边只能大于等于M, 右边只能小于等于R
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
        int[] arr = {3, 2, 4, 89, 0, 5};
        //sort(arr);
        mergeSort2(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    //非递归的方式实现
    public  static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int mergeSize = 1;//设置步长
        int N = arr.length;
        while (N > mergeSize) {
            int L = 0;
            while (L < N) {
                if (mergeSize >= N - L) {//如果当前的步长大于L~N的距离, 说明L N之间没有数据了
                    break;
                }
                int M = L + mergeSize -1;//默认步长为1， 第一组数据下标为：0， 那第二个组数据的下标 就是0加上步长， 为：1
                int R = M + Math.min(mergeSize, N - M - 1);// 如果右组凑够了一组，就是步长, mergeseize, 凑不够就是N-M-1, 一般来说是最后一组凑不够
                merge(arr, L, M, R);
                L = R + 1;
            }
            // todo-repeate 2021/12/7 22:26 这个归并排序防止溢出不懂,
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }

    }

}
