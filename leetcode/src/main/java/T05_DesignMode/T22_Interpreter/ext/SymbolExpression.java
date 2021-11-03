package T05_DesignMode.T22_Interpreter.ext;

import T05_DesignMode.T22_Interpreter.Expresssion;

import java.util.HashMap;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/3 13:30
 * @description
 * @editUser hx
 * @editTime 2021/11/3 13:30
 * @editDescription  符号解析器
 */
public abstract class SymbolExpression extends Expresssion {

    /***/
    protected Expresssion left;

    protected Expresssion right;

    /**所有的解析公式都应该只关心自己左右两边的表达式结果。*/
    public SymbolExpression(Expresssion left, Expresssion right) {
        this.left = left;
        this.right = right;
    }
}
