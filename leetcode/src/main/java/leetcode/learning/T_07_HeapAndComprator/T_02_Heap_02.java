package leetcode.learning.T_07_HeapAndComprator;

import lombok.Value;

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

public class T_02_Heap_02 {

    public class MyMaxHeap{
        private int[] heap;
        private final int limit;
        private int heapSize;

        public MyMaxHeap(int limit) {
            heap = new int[limit];
            this.limit = limit;
            this.heapSize = 0;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }
        public boolean isFull() {
            return heapSize == limit;
        }
        public void push(int obj) {
            if(limit == heapSize)
                throw new RuntimeException("heap is full");
            heap[heapSize] = obj;
            heapInsert(heap, heapSize++);
        }

        //新加进来的已经再index的位置了， 此时向上移动位置
        private void heapInsert(int[] arr, int index) {
            while (arr[index] < arr[(index - 1) / 2]) {
                swap(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        //弹出一个,将第一个位置和最后一个位置进行交换, 最后调整位置
        public int poll() {
            if(heapSize<=0)
                throw new RuntimeException("heap is null");
            int ans = heap[0];

            swap(heap, 0, heapSize);
            heapify(heap, 0, --heapSize);

            return ans;
        }

        //左孩子, 右孩子
        //看看左边的数据和右边的数据哪个大(如果有右孩子的话)
        private void heapify(int[] arr, int index, int heapSize) {
            int left = 2 * index + 1;
            while (left < heapSize) {
                int largest = heapSize >= (left + 1) && arr[left] > arr[left + 1] ? left : left + 1;
                swap(arr, index, largest);
                index = left;
                left = 2 * index + 1;
            }
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }







}
