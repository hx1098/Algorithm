package leetcode.learning.T_01;

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
            //内层判断 当前目标的左边是否有数据, 并且左边的数和目标数据 大小,
            for (int j = i - 1; j >= 0 && arr[j] > arr[j+1] ; j--) {
                swap(arr,j,j+1);
            }
        }
    }

    /**两个数进行交换*/
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 8, 4, 9};
        insertSort(arr);
        for (int i : arr) {
            System.out.print(i);
        }
    }


    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }


}
