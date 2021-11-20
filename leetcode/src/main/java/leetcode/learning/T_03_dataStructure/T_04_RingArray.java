package leetcode.learning.T_03_dataStructure;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/20 9:26
 * @description
 * @editUser hx
 * @editTime 2021/11/20 9:26
 * @editDescription 数组实现 栈和队列
 *
 * 数组: 特点: 有下标, 查找容易, 但是增加删除下标需要移动
 * 队列: 先进的先出, 一头往里面塞, 一头往外拿,
 *
 * 思路:
 *  数组 arr   limit = 5
 *  变量begin, 标识开始位置数据
 *  变量end , 标识结束位置数据
 *  变量size, 标识数组有多少个元素
 *
 * push:
 *  边界: 大于limit 时候禁止push
 *  否则: end位置更改(),  size++
 *
 */
public class T_04_RingArray {

    public static class MyQueue{
        private int[] arr;
        private int begin;
        private int end;
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            this.arr = new int[limit];
            this.begin = 0;
            this.end = 0;
            this.size = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("队列满了, 不能再加了.");
            }
            size++;
            arr[end] = value;
            end = nextIndex(end);
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("队列没有数据了, 不能弹出了.");
            }
            size--;
            int ans = arr[begin];
            begin = nextIndex(begin);//重新评估位置
            return ans;
        }

        /**这个数据是如果达到边界值的时候变成0, 达不到就加一.*/
        private int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }
    }



}
