package T05_DesignMode.T22_Interpreter;

import java.util.HashMap;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/3 13:23
 * @description
 * @editUser hx
 * @editTime 2021/11/3 13:23
 * @editDescription  表达式
 */
public abstract class Expresssion {

    /**解析公式和数据, 其中var 中的 key 值是公式中的参数, value 值具体的数字*/
    public abstract int interpreter(HashMap<String, Integer> var);


}
