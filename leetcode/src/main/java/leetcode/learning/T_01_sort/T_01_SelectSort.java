package leetcode.learning.T_01_sort;

import java.util.Arrays;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/25 22:18
 * @description
 * @editUser hx
 * @editTime 2021/10/25 22:18
 * @editDescription 选则排序 重点在于 找到最小值, 排列在第i个位置
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
    //外层控制寻找几次最小值的次数
    //内层控制 本次寻找最小值比较的次数

    /**
     * 选则排序
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j= i+1; j < arr.length; j++) {
                min = arr[min] > arr[j] ? j : min;
            }
            swap(arr, min, i);
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
        selectSort(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
    public static void selectSort2(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;//设置当前循环的最小值作为基准值
            for (int j = i+1; j < arr.length; j++) {
                //j = i+1   是因为 i = 0 时候, j = 1, j =2 , j = 3 进行最小值的挑选 比较三次
                //j = i+1   是因为 i = 1 时候, j = 2, j =3 ,进行最小值的挑选, 比较两次
                //j = i+1   是因为 i = 2 时候, j = 3, 进行最小值的挑选, 比较1次
                min = arr[j] > arr[min] ? min : j;
            }
            swap(arr,i,min);
        }
    }




















}
