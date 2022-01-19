package leetcode.learning.T_07_HeapAndComprator;

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

public class T_02_Heap{



    //<editor-fold desc="手写堆实现">
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
        //这里需要heapInsert
        public void push(int val) {
            if (heapSize == limit)
                throw new RuntimeException("heap is full");
            heap[heapSize] = val;
            //每次heapSize++ 之后, 该堆就会增加一个数据, 也即堆的孩子增加了一个.
            heapInsert(heap, heapSize++);
        }

        //新加进来的数据, 需要跟上级进行比较,
        //如果移动到了0位置, 或者干不掉自己的父亲的时候, 就需要停止下来.
        private void heapInsert(int[] heap, int heapSize) {
            //这里实际上是有两个条件的:
            //1. index = 0 , heap[0]  heap[(0-1)/2]  自己本身和自己进行比 是相等的.
            //2. index!= 0 , 正产执行的
            while (heap[heapSize] > heap[(heapSize - 1) / 2]) {
                swap(heap,heapSize,(heapSize-1)/2);
                heapSize = (heapSize - 1) / 2;
            }
        }

        //返回最大值, 并且在大根堆中, 把最大值删除掉
        //剩下的数据, 仍然保持大根堆组织结构
        public void pop() {
            int ans = heap[0];
            //将这个孩子 与 主干断开联系,
            swap(heap, 0, --heapSize);
            //看自己的孩子是否适合当
            heapify(heap, 0, heapSize);
        }

        private void heapify(int[] heap, int index, int heapSize) {
            //左孩子
            int left = 2 * index + 1;
            //看是否有左子树
            while (left < heapSize) {
                //看是否有右孩子,
                //如果有右孩子, 并且有孩子的值比左海子的值大, 吧右孩子的下标赋值给largest
                int largest = left + 1 < heapSize && heap[left + 1] > heap[left] ? left + 1 : left;
                largest = heap[largest] > heap[index] ? largest : index;
                if (largest == index)
                    break;
                swap(heap, largest, index);
                index = largest;
                left = index * 2 + 1;
            }
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main2(String[] args) {
        System.out.println(-1 % 2);
        System.out.println(1 / 2);
        System.out.println(3 / 2);
        System.out.println(4 / 2);


    }
    //</editor-fold>


}
