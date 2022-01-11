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
public class T_02_QuickSort_V2_02 {

    public static void quickSort2(int[] arr,int L,int R) {
        if (arr == null || arr.length < 2) return;
        process(arr, 0, arr.length - 1);
    }

    public static void  process(int[] arr,int L,int R) {
        //这里的if是跳出递归的条件
        if (L >= R) {
            return;
        }
        int[] M = neitherLandFlag(arr, L, R);
        process(arr, L, M[0] - 1);
        process(arr, M[1] + 1, R);
    }

    //
    //思想:
    //1.基准值的选取: arr[R]
    //  左边界的选取: less = L-1 (因为数据是从数组0开始的, 第一次循环是从-1开始)
    //  右边界的选取: more = R, 这里的R作为基准值并不参与边界的选取, R-1是第一个边界值,
    //2.滑动指针选取: index = L, 此指针从数组的第一个数据开始进行选取, 一次进行数据的比较, 循环如下:
    // 情况1: arr[index] < arr[R]; swap(arr,arr[index++], arr[++less]), 实际上是自己跟自己进行交换, 同时index++, less++
    // 情况2: arr[index] > arr[R]; swap(arr,arr[index],arr[--more]), 实际上是arr[index] 与 arr[more-1] 的数据进行交换, 即大于的数据放到了后面, arr[--more]位置的数据并未判断是否与arr[index]进行比较, 所以index指针不变.
    // 情况3: arr[index] = arr[R]; 直接index++, 进入下一轮循环
    //3.循环的结束问题:
    //  index和more重合的时候就是结束的时候,L < R
    //
    // 所以这里需要首先进行判断L和R两个数据的大小,
    //  L >R 时候, 这种情况其实可以直接忽略的, 几乎不存在这种情况.
    //  L==R 时候才会结束.
    //
    private static int[] neitherLandFlag(int[] arr, int L, int R) {
        if(L > R) return new int[]{-1, -1};
        if(L ==R) return new int[]{L, R};
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            System.out.println("index=" + index + ", less=" + less + ", more=" + more);
            Arrays.stream(arr).forEach(System.out::print);
            System.out.println();
            if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else if (arr[index] > arr[R]) {
                swap(arr,index,--more);
            }else{
                index++;
            }
        }

        swap(arr, more, R);
        System.out.println("index=" + index + ", less=" + less + ", more=" + more);
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println("================");
        return new int[]{less + 1, more};
    }


    //两数交换
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 9, 5};
        //流程分析
        //index=0, less=-1, more=4
        //37195
        //index=1, less=0, more=4
        //37195
        //index=1, less=0, more=3
        //39175
        //index=1, less=0, more=2
        //31975
        //index=2, less=1, more=2
        //31579
        quickSort2(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(System.out::print);
    }








}
