package leetcode.learning.T_01_sort;

import org.junit.Test;

import java.io.CharArrayReader;
import java.util.Arrays;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/25 22:18
 * @description
 * @editUser hx
 * @editTime 2021/10/25 22:18
 * @editDescription 选则排序 重点在于 找到最小值, 排列在第一个位置
 */
public class T_01_SelectSort {

    //分析:
    // 1.边界问题: 如果这个数组为空, 或者 数组size 小于2, 则直接返回
    // 1.5  假设arr 的长度为N, 因为数组的长度是从0位置开始的, 所以要减一
    // 2.1  0 ~ N-1 位置, 找到最小值, 排序到第0位置,
    // 2.2  1 ~ N-1 位置, 找到最小值, 排序到第1位置,
    // 2.3  2 ~ N-1 位置, 找到最小值, 排序到第2位置,
    // 2.4  3 ~ N-1 位置, 找到最小值, 排序到第3位置,
    // ....
    /**选则排序*/
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i, minIndex);
        }

    }

    /**两个数进行交换*/
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        /*int[] arr = {10, 8, 4, 9};
        selectSort(arr);
        for (int i : arr) {
            System.out.print(i);
        }*/


        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generaRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            selectSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice" : "effor");

       /* int[] arr = generaRandomArray(maxSize, maxValue);
        printArray(arr);
        selectSort(arr);
        printArray(arr);*/

    }

    private static void printArray(int[] arr2) {
        if(arr2 == null) return;
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
        System.out.println();
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static void comparator(int[] arr2) {
        Arrays.sort(arr2);
    }

    private static int[] copyArray(int[] arr1) {
        if(arr1 == null) return null;
        int[] arrResult = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arrResult[i] = arr1[i];
        }
        return arrResult;
    }

    @Test
    public void test1(){
        for (int i = 0; i <100; i++) {
            //System.out.println(Math.random());
            double random = Math.random();
            int temp = (int) ((100+1) * random);
            if (temp == 100) {
                System.out.println(random);
            }
            System.out.println(temp);
        }

    }



    private static int[] generaRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // [-? , +?], 使其有正数有负数
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            //System.out.println(arr[i]);
        }
        return arr;
    }
    @Test
    public void test12(){
        generaRandomArray(1000, 1000);
    }


}
