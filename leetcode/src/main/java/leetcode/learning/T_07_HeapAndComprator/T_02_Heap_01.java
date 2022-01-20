package leetcode.learning.T_07_HeapAndComprator;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/1/17 13:35
 * @description 堆的实现
 * @editUser hx
 * @editTime 2022/1/17 13:35
 * @editDescription 1(0)
 * 2(1)       3(2)
 * 5(3)   6(4)  7(5)  8(6)
 * <p>
 * 1.找到父节点推理:  (3-1)/2  = 1, 1位置就是父节点
 * (4-1)/2  = 1, 1位置就是父节点
 * 综上:
 * (i-1)/2 可找到自己的父亲
 * <p>
 * 2.找到孩子节点的推理:
 * 2*0 +1= 1, 获取1位置的子节点
 * 2*0 +2= 2, 获取2位置的子节点
 * 2*1 +1= 3, 获取3位置的子节点
 * 综上:
 * 左孩子节点:  (i * 2) +1
 * 右孩子节点:  (i * 2) +2
 */

public class T_02_Heap_01 {


    private static class MyMaxHeap {

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
        //2.,然后将最后一个数据放在0位置 size--
        //3.根据公式选中0位置下面两个较大的孩子, 进行和0位置的数进行比较,
        //4.如果大于的话就不进行向下循环了,  小于的话就向下进行循环,
        //5.
        public Integer pop() {
            if (heapSize < 1)
                return null;
            int ans = heap[0];
            heap[0] = heap[heapSize];//将最后一个值放到 顶部位置,
            heapfiy(heap, 0, heapSize--);//进行位置调整
            // todo-hx 2022/1/19 22:51 pop操作
            return ans;
        }

        //将数据进行下沉
        private void heapfiy(int[] arr, int index, int heapSize) {
            int left = 2 * index + 1;
            int largest = ((left + 1) <= heapSize) &&
                    arr[left] > arr[left + 1] ? left : left + 1; //如果有右孩子, 并且 左孩子 大于 右孩子, 最大值向上移动, (选择一条下沉的路线)
            if(arr[largest] == heap[index])
                return;
            while (index < heapSize) {
                if (arr[index] < arr[largest])
                    swap(arr,index++,largest);
                index = largest * 2 + 1;
            }
        }

        //将大根堆加进来以后需要维持大根堆的结构, 加到最后一个数据的位置要进行和 自己的父亲比较大小
        //
        private void heapInsert(int[] arr, int heapSize) {
            while (arr[heapSize] > arr[(heapSize - 1) / 2]) {
                swap(arr, heapSize, (heapSize - 1) / 2);
                heapSize = (heapSize - 1) / 2;
            }
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = arr[temp];
        }


    }


}
