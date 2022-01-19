package leetcode.learning.T_07_HeapAndComprator;

import com.sun.org.apache.bcel.internal.generic.SWAP;
import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm;

import java.util.List;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/1/17 13:35
 * @description  堆的实现
 * @editUser hx
 * @editTime 2022/1/17 13:35
 * @editDescription
 *            1(0)
 *       2(1)       3(2)
 *   5(3)   6(4)  7(5)  8(6)
 *
 *  1.找到父节点推理:  (3-1)/2  = 1, 1位置就是父节点
 *                   (4-1)/2  = 1, 1位置就是父节点
 *   综上:
 *     (i-1)/2 可找到自己的父亲
 *
 *  2.找到孩子节点的推理:
 *                  2*0 +1= 1, 获取1位置的子节点
 *                  2*0 +2= 2, 获取2位置的子节点
 *                  2*1 +1= 3, 获取3位置的子节点
 *     综上:
 *        左孩子节点:  (i * 2) +1
 *        右孩子节点:  (i * 2) +2
 */

public class T_02_Heap_01 {



    private static class MyMaxHeap{

        private int[] heap;
        private final int limit;
        private int heapSize;

        public MyMaxHeap(int limit) {
            heap = new int[limit];
            this.limit = limit;
            heapSize = 0;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize == limit;
        }

        public void push(int val) {
            if (heapSize == limit)
                throw new RuntimeException("heap is full");
            //这里数组是从0开始的, 所以heapSize是新加进来的一个数
            heap[heapSize] = val;
            heapInsert(heap, heapSize++);
        }


        //pop方法实现就很有特点:
        //1.将0位置数据用一个变量存下来
        //2.然后将最后一个数据放在0位置, size--
        //3.根据公式选中0位置下面两个较大的孩子, 进行和0位置的数进行比较,
        //4.如果大于的话就不进行向下循环了,  小于的话就向下进行循环,
        //5.
        public Integer pop() {

            // todo-hx 2022/1/19 22:51 pop操作
            return 0;
        }

        //将大根堆加进来以后需要维持大根堆的结构, 加到最后一个数据的位置要进行和 自己的父亲比较大小
        //
        private void heapInsert(int[] arr, int heapSize) {
            while (arr[heapSize] > arr[(heapSize - 1) / 2]) {
                swap(arr,heapSize, (heapSize - 1) / 2);
                heapSize = (heapSize - 1) / 2;
            }
        }

        private void swap(int[] arr,int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = arr[temp];
        }


    }



}
