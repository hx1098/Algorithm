package leetcode.learning.T_05_MergeSort;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/12/15 17:06
 * @description
 * @editUser hx
 * @editTime 2021/12/15 17:06
 * @editDescription 小和问题
 *  arr = { 1,3,4,2,5 }
 *  1左边比1小的数: 没有
 *  3左边比3小的数: 3,
 *  4左边比4小的数: 1,3
 *  2左边比2小的数: 1
 *  5左亮比5小的数: 1,3,4,2
 *  3+1+3+1+1+3+4+4= 16
 */
public class T_03_SmallSum {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length);
    }

    private static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int M = L + ((R - L) >> 1);
        return process(arr, L, M) +
                process(arr, M + 1, R) +
                merge(arr, L, M, R);

    }

    //定义一个临时数组,
    //定义一个p1, p2作为左指针和右指针
    //p1和p2都没有越界
    //p1越界,
    //p2越界
    //从help复制到arr
    private static int merge(int[] arr, int l, int m, int r) {
        int result = 0;
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int i = 0;
        while (p1 <= m && p2 <= r) {
            // todo-repeate 2021/12/16 22:22 不理解
            result += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] > arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return result;
    }

    public static void main(String[] args) {

    }
    

}
