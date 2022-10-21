package leetcode.learning.T_01_sort;

import java.util.Arrays;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/25 22:18
 * @description
 * @editUser hx
 * @editTime 2021/10/25 22:18
 * @editDescription 插入排序
 */
public class T_03_InsertSort {


    /**插入排序
     *  思想:    1. 0~0 位置保证有序
     *          2. 0~1 位置保证有序
     *          3. 0~2 位置保证有序
     *          4. 0~3 位置保证有序.
     *          .....
     **/
    public static void insertSort(int[] arr) {
        //边界问题
        if(arr == null || arr.length < 2)return;
        // 外层仅仅判断的数据要循环多少次,
        for (int i = 1; i < arr.length; i++) {
            System.out.println("=============");
            //内层判断 当前目标的左边是否有数据, 并且左边的数和目标数据 大小,
            for (int j = i - 1; j >= 0 && arr[j] > arr[j+1] ; j--) {
                System.out.println("i = " + i + " , j = " + j);
                swap(arr,j,j+1);
            }
            Arrays.stream(arr).forEach(System.out::print);
        }
    }

    /**两个数进行交换*/
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 9,3,2};
        //insertSort(arr);
        InsertSort2(arr);
       /* for (int i : arr) {
            System.out.print(i);
        }*/
    }

    //0~0 保证有序,
    //0~1 保证有序,
    //0~2 保证有序
    //0~n-1 保证有序
    public static void InsertSort2(int[] arr) {
        //1.外层循环控制 一个数一个数向上面叠加,
        //2.内层循环控制 找到合适的位置,
        for (int i = 0; i < arr.length - 1; i++) {

        }
    }










}
