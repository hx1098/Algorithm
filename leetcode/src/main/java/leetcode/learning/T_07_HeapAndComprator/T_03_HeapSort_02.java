package leetcode.learning.T_07_HeapAndComprator;

import jdk.nashorn.internal.IntDeque;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/1/19 15:53
 * @description
 * @editUser hx
 * @editTime 2022/1/19 15:53
 * @editDescription 堆排序
 *
 */
public class T_03_HeapSort_02 {


    //1.边界值判断
    //2.将数组构成一个大根堆
    //3.将最后一个值, 与 堆顶数据(arr[0]) 位置的数据进行交换, 并将(legth-1),
    //4. 循环将该数组重新组成一个大根堆,重组之后最后一个数据(length-i)数据与 堆顶进行交换, length--
    public static void heapSort(int[] arr) {
        if(arr == null || arr.length < 2) return;

        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, 0, arr.length);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

    }

    //调整成为整个大根堆
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = (left + 1) < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index)
                break;
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void test1(){
        int[] arr = {2, 1, 5, 3};
        heapify(arr, 0, arr.length);
        Arrays.stream(arr).forEach(System.out::print);

    }


    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        //大顶堆预期值: 96854
        heapSort(arr);
        Arrays.stream(arr).forEach(System.out::print);
        //预期结果

    }

}
