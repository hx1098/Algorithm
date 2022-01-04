package leetcode.learning.T_06_QuickSort;

import org.junit.Test;

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
 * 关键点:
 *  定义一个-1的区间, 如果数据小于基准值, 就向右包含, 如果大于, 交换数据,
 *  最后将基准值 和 指针+1 位置的数据进行交换,
 *
 *
 */
public class T_01_QuickSort {

    public static void swap(int[] arr, int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int M = partition(arr, L, R);

        quickSort(arr, L, M - 1);
        quickSort(arr, M + 1, R);
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
    private static int partition(int[] arr, int l, int r) {
        //边界问题, 一旦出现l > r的时候, 程序退出
        if (l > r) {
            return -1;
        }
        //l == r说明左边界和右边界的重合了
        if (l == r) {
            return r;
        }
        //这个lessEqual就是括号, 向右进行一个数一个数的进行括起来. 而且都是小于基准值的数据.
        int lessEqual = l - 1;
        //取数组的第一个值作为基准值, 进行比较
        int index = l;
        //(本次循环的中分过来的数据个数, 就是R)  >  当前的index值,
        while (index < r) {
            //循环, 比较, 如果小于基准值, lessEqua继续向外扩张, 如果大于基准值, lessEqua不动,指向下一个数据进行比较
            if (arr[index] <= arr[r]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr, ++lessEqual, r);
        return lessEqual;
    }

    public static void main(String[] args) {
       /* int[] arr = {3, 7, 1, 9, 5};
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::print);*/




        System.out.println("================大数据量测试快排================");


        int testTime = 500000;//测试次数
        int maxSize = 100;//数组长度
        int maxValue = 100;//最大值
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generaRandomArray(maxSize, maxValue);
            int[] arr2 = copyArr(arr1);

            Arrays.sort(arr2);
            quickSort(arr1, 0, arr1.length - 1);

            boolean b = isEqualArray(arr1, arr2);
            if (!b) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "nice" :"error");
    }

    /**比较两个数组是否相同*/
    private static boolean isEqualArray(int[] arr, int[] arr2) {
        //1.先从是否为null处理
        //2.不为null, 直接一个一个进行比较
        if(arr == null && arr2 == null) return true;
        if((arr != null && arr2 == null) ||  (arr == null && arr2 != null)) return false;
        if(arr.length != arr2.length) return false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != arr2[i])
                return false;
        }
        return true;
    }

    /**
     * 拷贝数组，
     * @param arr1
     * @return
     */
    private static int[] copyArr(int[] arr1) {
        if (arr1 == null)   return null;
        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            res[i] = arr1[i];
        }
        return res;
    }

    /**
     * 生成一个数组
     * @param maxSize 最大长度
     * @param maxValue 最大值
     * @return int[]
     */
    private static int[] generaRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // arr[i] = (int) (Math.random() * (maxValue + 1));  // 使他有正有负
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    @Test
    public void testGeneraRandomArray(){
        int[] ints = generaRandomArray(10, 100);
        Arrays.stream(ints).forEach(System.out::println);
    }


    //测试Math.random
    @Test
    public void test2(){
        //加一最大值可以达到100, 不加1最大值只能到99
        for (int i = 0; i < 1000; i++) {
            int random = (int) (101*Math.random());
            System.out.println(random);
        }
    }
    //测试Math.random
    @Test
    public void test1(){
        int[] arr = new int[(int) (10 * Math.random())];
        System.out.println();
    }
}
