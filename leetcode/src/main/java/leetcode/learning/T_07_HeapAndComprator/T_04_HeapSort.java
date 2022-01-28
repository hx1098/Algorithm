package leetcode.learning.T_07_HeapAndComprator;

import java.util.PriorityQueue;

/**
 *
 * 题目: 已知一个几乎有序的数组, 几乎有序是指, 如果把数组排好序的话, 每个元素移动的位置
 * 的距离一定不超过K, 并且K相对于数组长度来说是比较小的.
 *
 * 请选择一个合适的排序策略, 对这个数组进行排序
 *
 */
public class T_04_HeapSort {


    public static void sortArrayDistanceLessK(int[] arr, int k) {
        //非法的或者是已经排好序
        if (arr == null && arr.length < 2) return;
        if(k == 0) return;

        //使用优先级队列使用优先级队列
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;

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

    }


}
