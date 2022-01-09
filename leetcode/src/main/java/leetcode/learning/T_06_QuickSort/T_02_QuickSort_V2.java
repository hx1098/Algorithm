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
 *
 * 这个也是荷兰国旗问题
 *
 */
public class T_02_QuickSort_V2 {


    //1.判断是否为null
    public static void quickSort(int[] arr, int L, int R) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int[] M = neitherLandFlag(arr, L, R);
        quickSort(arr, L, M[0] - 1);
        quickSort(arr, M[1] + 1, R);
    }

    //basecase
    //1.如果L>R, 不存在这种情况, 如果L=R, 返回[L,R]
    //2.找到最右侧的作为一个基准值arr[R], (less)左侧的边界从L-1开始, (more)右侧的边界从R开始, index指针从L开始,
    //  如果arr[index] < arr[R]基准值, 指针index++,less++, arr[index] 和 arr[less]交换
    //  如果arr[index] > arr[R]基准值, 指针index不变,more--, arr[index] 和 arr[more]交换
    //  如果arr[index] = arr[R]基准值, 直接index++
    //  结束: 直到 index指针 和 more 重合的时候结束
    //3. todo 交换值.
    private static int[] neitherLandFlag(int[] arr, int L, int R) {
        if(L > R) return new int[]{-1, -1};
        if(L == R) return new int[]{L, R};
        int less = L - 1;//定义一个左侧边界值
        int more = R;//定义一个右侧边界值,
        int index = L;//定义一个向右的指针
        while (index < more) {
            if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else if (arr[index] > arr[R]) {
                swap(arr,index,--more);
            } else {
                index++;
            }
        }
        //最后的一个数需要进行交换,more在执行到这里的时候一定到了基准值的前一个位置.将arr[r]这个基准值和 第一个大于基准值的 数据进行交换.
        swap(arr,more,R);
        return new int[]{less+1,more};//等于基准值的第一个位置 ~ 等于区域的最后一个位置
    }

    /**两数交换*/
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 9, 5};
        //39175
        //31975
        //31597
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::print);
    }








}
