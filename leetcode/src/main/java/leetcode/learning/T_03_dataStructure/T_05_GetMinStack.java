package leetcode.learning.T_03_dataStructure;

import java.util.Stack;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/21 22:42
 * @description
 * @editUser hx
 * @editTime 2021/11/21 22:42
 * @editDescription 获取最小栈
 * 题目:　实现一个特殊的栈，在基本功能的基础上，在实现返回栈中最小元素的功能
 * １．pop,push,getMin 操作的市价复杂度是 O(1), 常数级别
 * 2. 设计栈类型可以使用现成的站结构
 * <p>
 * 解释: 最小栈什么意思: 我每次push一个元素时候, 都能根据getMin方法来获取当前栈中的最小值.
 * pop, push 是基本功能
 * getMin 属于特殊的功能
 * 仅此而已
 * <p>
 * 分析:
 * 1.栈先进后出
 * 2.用数组实现还是用列表
 */
public class T_05_GetMinStack {

    public static class MyStack1 {

        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public void push(Integer value) {
            //边界条件
           /* if (dataStack.empty()) {
                dataStack.push(value);
                minStack.push(value);
            }
            //为空
            dataStack.push(value);
            Integer pre = minStack.pop();
            minStack.push(value > pre ? pre : value);*/

            if (minStack.isEmpty()) {
                minStack.push(value);
            } else if(value <= this.getMinStatic()) {
                minStack.push(value);
            }
            dataStack.push(value);
        }

        /**需要考虑你的值是否是最小站问题*/
        public Integer pop() {
            if (dataStack.isEmpty()) {
                throw new RuntimeException("当前栈为空");
            }
            int pop = dataStack.pop();
            if (pop == this.getMinStatic()) {
                this.minStack.pop();
            }
            return pop;
        }

        public Integer getMinStatic() {
            if (this.minStack.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }
            return minStack.peek();
        }
    }


}
