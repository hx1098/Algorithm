package T05_DesignMode.T22_Interpreter.ext;

import T05_DesignMode.T22_Interpreter.Expresssion;

import java.util.HashMap;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/3 13:34
 * @description
 * @editUser hx
 * @editTime 2021/11/3 13:34
 * @editDescription 加法解析器
 */
public class AddExpression extends  SymbolExpression{


    public AddExpression(Expresssion left, Expresssion right) {
        super(left, right);
    }

    /**把左右两边表达式运算的结果加起来.*/
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }


}
