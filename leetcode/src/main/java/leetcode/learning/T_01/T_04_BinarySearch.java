package leetcode.learning.T_01;

import java.util.Queue;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/28 15:34
 * @description
 * @editUser hx
 * @editTime 2021/10/28 15:34
 * @editDescription 二分查找(前提是有序)
 */
public class T_04_BinarySearch {


    /**
     * 查找数组中是否有这个数字
     * 分析:
     * 1.边界问题: 数组 == null  或者  arr.length == 0  直接返回false
     * 2.主逻辑:
     * 2.1定义一个指针middle, 定义一个R右边界, 定义一个L左边界,
     * 2.2求出数组的中间值, 比较这个mdddle > < = num(索要查找的值)
     * 2.3 大于的话, 舍去右边半截数据, 将R 右边界 == middle    跳到 2.2执行
     * 2.4 小于的话, 舍去左边半截数据, 将L 左边界 == middle    跳到 2.2执行
     * 2.5 等于的话, 就直接返回true.
     * 2.6 何时停止: 直到L == R, 或者 L > R 时候停止.
     *
     * @param arr 传入的数组
     * @param num 要查找的数据
     * @return boolean
     */
    public static Boolean binarySearch(int[] arr, int num) {
        if(arr == null || arr.length == 0) return false;
        // 初始状态下, 左边界为0, 右边界为arr.length-1 (是因为数组长度是从0开始的, 所以要减一),
        int L = 0, R = arr.length - 1, middle = 0;
        while (L <= R) {
            middle = (L + R) >> 1;
            if (num > arr[middle]) {
                //放弃左侧的时候, 左侧要下标要加1, 因为middle已经比较过了.
                L = middle +1;
            } else if (num < arr[middle]) {
                //放弃右侧的时候, 右侧要下标要减1, 因为middle已经比较过了.
                R = middle -1;
            } else if (num == arr[middle]) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 10, 13};
        Boolean aBoolean = binarySearch(arr, 9);
        System.out.println(aBoolean);
    }


}
