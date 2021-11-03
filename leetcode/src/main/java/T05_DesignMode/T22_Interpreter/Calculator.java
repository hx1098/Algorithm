package T05_DesignMode.T22_Interpreter;

import T05_DesignMode.T22_Interpreter.ext.AddExpression;
import T05_DesignMode.T22_Interpreter.ext.SubExpression;
import T05_DesignMode.T22_Interpreter.ext.VarExpression;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/3 13:39
 * @description
 * @editUser hx
 * @editTime 2021/11/3 13:39
 * @editDescription 将表达式进行封装
 */
public class Calculator {

    /**定义的表达式*/
    private Expresssion expresssion;

    /**构造函数传参, 并进行解析*/
    public Calculator(String expStr) {
        //    定义一个堆栈,安排运算的先后顺序
        Stack<Expresssion> stack = new Stack<>();

        //  表达式拆为字符数组,
        char[] charArray = expStr.toCharArray();
        //    运算
        Expresssion left = null;
        Expresssion right = null;
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '+':
                    //将加法结果放入到堆栈中
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left, right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left, right));
                    break;
                default:
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
            }
        }
        //    把运算结果跑出来
        this.expresssion = stack.pop();
    }

    /**进行运算*/
    public int run(HashMap<String, Integer> var) {
        return this.expresssion.interpreter(var);
    }



}
