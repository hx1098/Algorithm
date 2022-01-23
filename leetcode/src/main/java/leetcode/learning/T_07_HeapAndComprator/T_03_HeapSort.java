package leetcode.learning.T_07_HeapAndComprator;

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
public class T_03_HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }



        
    }
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = heapSize >= (left + 1)
                    && arr[left] > arr[left + 1] ? left : left + 1;
            largest = arr[largest] > arr[index] ? largest : index;
            if (index == largest)
                return;
            swap(arr, index, largest);
            index = largest;
            left = left * 2 + 1;
        }
    }
    //数据交换
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
