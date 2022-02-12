package leetcode.learning.T_07_HeapAndComprator;

import cn.hutool.core.util.ReUtil;

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

public class T_02_Heap_01{

    //大根堆
    private static class MymaxHeap{
        private int[] heap;
        private final int limit;
        private int heapSize;

        public MymaxHeap(int limit) {
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

        /**
         *   堆中添加一个数据
         *  todo 边界问题
         *  将最后一个数据添加到最后一个位置
         *  调整整个堆结构
         *  数组从0开始, 调整顺序之后,将Size++
         * @param val
         */
        public void push(int val) {
            if (heapSize >= limit) {
                throw new RuntimeException("heap is full");
            }
            heap[heapSize] = val;
            heapInsert(heap,heapSize++);
        }

        /**
         * 弹出并删除一个数据
         * 1.将最顶部的数据先用一个变量保存起来,
         * 2.将最后一个数据 条调整到 顶部,
         * 3.调整顶部的数据位置, 向下沉
         *     --
         * @return
         */
        public Integer pop() {
            if(heapSize == 0) return null;
            int res = heap[0];
            heap[0] = heap[heapSize];
            heapify(heap, 0, --heapSize);
            return res;
        }

        /**
         * 将0位置的数据 和 自己较大孩子 作比较, 决定是否下沉
         * 1.获取左孩子,
         * 2.找到以 index 位置为顶的 较大的孩子的下标(其中并判断是否有右孩子), 命名为largest
         * 3.largest 和 自己的顶部(index) 进行比较, 找出最大的顶,如果相等, return
         * 4.将index位置数据和较大位置的数据进行交换
         * 5.将 顶部数据 赋值给index, 以供下次循环使用
         * 6.求出左孩子的值, 供下次使用.
         * @param arr 数组堆
         * @param index 当前下沉堆的指针
         * @param heapSize 堆大小
         */
        private void heapify(int[] arr, int index, int heapSize) {
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


        //调整大根堆的顺序
        private void heapInsert(int[] arr, int index) {
            //只要自己的孩子 大于 自己的父亲, 就继续, 否则就结束调整位置.
            while (arr[index] > arr[(index - 1) / 2]) {
                swap(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        //数据交换
        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }




    public static void main(String[] args) {
        // todo-hx 2022/1/21 14:05 大顶堆测试,,,

        MymaxHeap mymaxHeap = new MymaxHeap(5);
        mymaxHeap.push(1);
        mymaxHeap.push(2);
        mymaxHeap.push(3);
        mymaxHeap.push(4);
        mymaxHeap.push(5);






    }





}
