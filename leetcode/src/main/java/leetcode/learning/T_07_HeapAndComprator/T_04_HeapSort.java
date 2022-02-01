package leetcode.learning.T_07_HeapAndComprator;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * 题目: 已知一个几乎有序的数组, 几乎有序是指, 如果把数组排好序的话, 每个元素移动的位置
 * 的距离一定不超过K, 并且K相对于数组长度来说是比较小的.
 *
 * 请选择一个合适的排序策略, 对这个数组进行排序
 *
 *
 *思路:
 * 构造一个小根堆的数据结构,
 *
 */
public class T_04_HeapSort {


    public static void sortArrayDistanceLessK(int[] arr, int k) {
        /*if (k == 0) {
            return;
        }
        //默认是小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        //将所有数据都放入小根堆,或者将K个数据放入小根堆
        int index = 0;
        for (; index <= Math.min(arr.length - 1, k - 1); index++) {
            heap.add(arr[arr[index]]);
        }

        //如果满足K个数据, 就弹出小根堆的第一个数据(就是K个数据中最小值), 同时将数组的第i个数据更改为最小值.
        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }

        //最后将所有的数据进行弹出.
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
*/


        if (k == 0) {
            return;
        }
        // 默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        // 0...K-1
        for (; index <= Math.min(arr.length - 1, k - 1); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }



    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 8, 1, 6, 3};
        sortArrayDistanceLessK(arr, 3);

        Arrays.stream(arr).forEach(System.out::print);

    }


}
