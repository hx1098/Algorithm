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
 *  *  队列： 先进的先出,
 *  *  栈:   先进的后出,
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
         * 分析：队列上尾部数据  就是  栈上 要弹出的数据.
         *
         *  正产队列：-> 5 4 3 2 1 -> 队列A
         *  队列的尾部 "5" 就是 栈 应该弹出的一个数据,
         *
         */
        public T peek() {
            // 剩下一个要返回的元素
            while (toQueue.size() > 1) {
                helpQueue.offer(toQueue.poll());
            }
            //poll 已经将最后一个元素移出了A,
            T ans = toQueue.poll();
            //此时最后一个元素 有加入了 B队列
            helpQueue.offer(ans);
            //A, B 两个队列进行引用互换
            Queue<T> temp = toQueue;
            toQueue = helpQueue;
            helpQueue = temp;
            return ans;
        }

        /**
         * 与 peek最大的不同在于: poll会吧元素给删除掉
         * */
        public T Poll() {
            //返回所有的元素, 知道只剩下一个元素的时候.
            while (toQueue.size() > 1) {
                helpQueue.add(toQueue.poll());
            }
            T ans = toQueue.poll();
            Queue<T> temp = toQueue;
            toQueue = helpQueue;
            helpQueue = temp;
            return ans;
        }



    }

    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(1);
        integerStack.push(2);
        //integerStack.peek();//弹出栈顶的数据, 但是不删除该数据.
        //integerStack.pop();//移除 此堆栈顶部的对象，并将该对象作为此函数的值返回

        integerStack.forEach(e-> System.out.println(e));


       /* Queue<Integer> toQueue = new LinkedList<>();
        toQueue.offer(1);
        toQueue.offer(2);
        toQueue.offer(3);
        toQueue.offer(4);
        toQueue.forEach((e) -> System.out.println(e));*/


    }

}
