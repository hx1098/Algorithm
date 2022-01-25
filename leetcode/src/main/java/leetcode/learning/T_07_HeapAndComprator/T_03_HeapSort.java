package leetcode.learning.T_07_HeapAndComprator;

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
 * 堆排序的思想:
 *  1.将一个排序的数组构成一个大顶堆, 最大值就是顶点位置的数据,假设有N个数据
 *  2.将顶部数据 和 底部最后一个数据进行交换, 最后一个数据就排好了,
 *  3.将0~N-1个数据进行重新构成一个大顶堆的形式, 然后再进行将arr[0]的数据进行与N-1处的数据进行交换,
 *  ----依次进行循环, 知道最后一个数据
 *
 */
public class T_03_HeapSort {


    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //每次调整一个数据, 将数据调整成一个大顶堆
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        //将顶部的数据 与 最后一个数据 进行位置交换, 然后吧当前的大顶堆最后一个数据断开连接
        //第一次 将n位置的数据断开连接
        //第二次,将n-1位置的数据断开连接
        //第三次, 将n-2位置的数据断开连接
        //.............
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }


    }


    /**
     * 目标: 姜指定的牧宝数据进行一个一个的进行向上找到位置.
     *1.计算出左边界的下标
     *2.循环
     *
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {//这里判断的是有么有左孩子, 同时也判断了是否超出数组的最大值
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;//判断是否有右孩子, 并且左孩子小于右孩子, 将孩子的最大值赋值
            largest = arr[largest] > arr[index] ? largest : index;//判断0位置的数据与 自己的孩子 值哪一个大
            //如果两个值一样大, 不交换直接退出
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;//将本此选出来的最大值作为顶，
            left = 2 * index + 1;//计算下一个left的下标
        }
    }


   @Test
   public void test1(){
       int[] arr = {2, 1, 3};
       heapify(arr, 0, arr.length-1);
       Arrays.stream(arr).forEach(System.out::print);
   }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        //大顶堆预期值: 96854
        heapSort(arr);
        Arrays.stream(arr).forEach(System.out::print);
        //预期结果

    }

}
