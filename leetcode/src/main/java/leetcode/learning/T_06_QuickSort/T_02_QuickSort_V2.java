package leetcode.learning.T_06_QuickSort;

import java.util.Arrays;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/12/22 14:20
 * @description
 * @editUser hx
 * @editTime 2021/12/22 14:20
 * @editDescription 荷兰国旗问题，
 *  有点像归并排序， 但是归并排序是先拆到一个一个的， 而后再一对一对的合并，
 *  快排是随机找出一个基准值, 放到准确的一个位置,然后再进行一个个的找基准值, 总得来首也是拆分到一个一个的数据为止, 这时基本已经排好了序.
 *                   ,
 * 实在不懂可以看这个视频:
 * https://www.bilibili.com/video/BV1rV411j7f6?share_source=copy_web
 * https://www.bilibili.com/video/BV1B34y1S7Yi?from=search&seid=14497850874747043816&spm_id_from=333.337.0.0
 * https://www.bilibili.com/video/BV1XL411g7qF
 *
 * 这个也是荷兰国旗问题
 *
 */
public class T_02_QuickSort_V2 {

    public static void quick2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    public static void process2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] M = netherLandFlag(arr, L, R);
        process2(arr, L, M[0] - 1);
        process2(arr, M[1] + 1, R);
    }

    private static int[] netherLandFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[] { -1, -1 };
        }
        if (L == R) {
            return new int[] { L, R };
        }
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R);
        return new int[] { less + 1, more };
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 9, 5};

        quick2(arr);
        Arrays.stream(arr).forEach(System.out::print);

    }


}
