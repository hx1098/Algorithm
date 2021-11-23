package leetcode.learning.T_03_dataStructure;

import java.util.Stack;

/**
 * @author hx
 * @createTime 2021/11/23 14:19
 * @option 两个栈实现队列
 * @description
 * 思路：
 *  队列： 先进的先出, a->b->c  c先出, b后出, a最后
 *  栈:   先进的后出,  a->b->c  a先出, b后出, c最后
 *
 *  定义两个栈, 进行数据互相导入, 就可以实现单项的队列
 *
 *  poll 和 pop
 *  poll是队列数据结构实现类的方法，从队首获取元素，同时获取的这个元素将从原队列删除；
 *  pop是栈结构的实现类的方法，表示返回栈顶的元素，同时该元素从栈中删除，当栈中没有元素时，调用该方法会发生异常
 *
 */
public class T_06_TwoStackImplQueue {

    public static class TwoStackQueue{
        /*定义两个数据栈, 便于后面进行数据的互相导入*/
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStackQueue() {
            this.stackPush = new Stack<>();
            this.stackPop = new Stack<>();
        }

        // todo-repeate 2021/11/23 17:06 不太理解
        /**将数据导出到另一个栈中,*/
        private void pushToPop() {
            if (!stackPop.empty()) {
                return;
            }
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }

        public void add(Integer val) {
            stackPush.push(val);
            pushToPop();
        }


        public Integer pop() {
            if (stackPush.empty() && stackPop.empty()) {
                throw new RuntimeException("Queue is empty");
            }
            pushToPop();
            return stackPop.pop();
        }

        public Integer peek() {
            if (stackPush.empty() && stackPop.empty()) {
                throw new RuntimeException("Queue is empty");
            }
            pushToPop();
            return stackPop.peek();
        }


    }

    public static void main(String[] args) {
        TwoStackQueue testQueue = new TwoStackQueue();
        testQueue.add(2);
        testQueue.add(4);
        testQueue.add(5);

        System.out.println(testQueue.pop());

        //Queue

    }
}
