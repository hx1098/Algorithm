package leetcode.learning.T_03_dataStructure;

import java.util.LinkedList;
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
 *
 *
 *
 */
public class T_07_TwoQueueImplStack {
    // todo-hx 2021/11/24 13:41
    /**两个队列实现栈的结构*/
    public class MyStack{
        private LinkedList<Integer> ToQueue;
        private LinkedList<Integer>



    }

    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(1);
        integerStack.pop();//移除 此堆栈顶部的对象，并将该对象作为此函数的值返回
        integerStack.peek();//弹出栈顶的数据, 但是不删除该数据.
    }

}
