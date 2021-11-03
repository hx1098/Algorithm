package T05_DesignMode.T22_Interpreter.ext;

import T05_DesignMode.T22_Interpreter.Expresssion;

import java.util.HashMap;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/3 13:37
 * @description
 * @editUser hx
 * @editTime 2021/11/3 13:37
 * @editDescription 减法表达式
 */
public class SubExpression extends SymbolExpression{

    public SubExpression(Expresssion left, Expresssion right) {
        super(left, right);
    }

    /**左右连个表达式进行相减*/
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) - super.right.interpreter(var);
    }

}
