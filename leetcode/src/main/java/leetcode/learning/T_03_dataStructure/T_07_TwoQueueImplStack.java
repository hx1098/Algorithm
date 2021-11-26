package leetcode.learning.T_03_dataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/24 7:45
 * @description
 * @editUser hx
 * @editTime 2021/11/24 7:45
 * @editDescription 两个队列实现栈的结构,
 *
 *  * 思路：
 *  *  队列： 先进的先出, a->b->c  c先出, b后出, a最后
 *  *  栈:   先进的后出,  a->b->c  a先出, b后出, c最后
 *      1.定义两个linkedList
 *      2.实现数据互相拷贝
 *          1.push 功能
 *          2.pop  删除一个数据,并返回
 *          3.peek 弹出一个数据, 但是不删除.
 *      最后在实现引用的互换, 用来进行循环toQueue 和 heloQueue 的数据互换
 *
 *
 *
 */
public class T_07_TwoQueueImplStack {
    // todo-hx 2021/11/24 13:41
    /**两个队列实现栈的结构*/
    public class MyStack<T>{
        private Queue<T> toQueue;
        private Queue<T> helpQueue;

        public MyStack() {
            toQueue = new LinkedList<T>();
            helpQueue = new LinkedList<T>();
        }

        public void push(T val) {
            toQueue.offer(val);
        }

        /**
         * //todo-hx 不理解peek的东西
         * 弹出最先进入队列的数据
         * 分析： 1. 队列的头，  对应的就是 栈底的数据， 将队列的头返回出去就行了。
         *       2. 不删除的操作需要放回去， 将
         */
       // public T peek() {
            // 剩下一个要返回的元素
           /* while (toQueue.size() > 1) {
                helpQueue.offer(toQueue.poll());
            }
            T ans = toQueue.poll();
            helpQueue.offer(ans);

            Queue<T> temp = toQueue;
*/
           // return T;
       // }



    }

    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(1);
        integerStack.peek();//弹出栈顶的数据, 但是不删除该数据.
        integerStack.pop();//移除 此堆栈顶部的对象，并将该对象作为此函数的值返回

        Queue<Integer> toQueue = new LinkedList<>();
        toQueue.offer(1);
        toQueue.offer(2);
        toQueue.offer(3);
        toQueue.offer(4);
        toQueue.forEach((e) -> System.out.println(e));


    }

}
