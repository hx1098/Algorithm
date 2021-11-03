package T05_DesignMode.T22_Interpreter.ext;

import T05_DesignMode.T22_Interpreter.Expresssion;

import java.util.HashMap;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/3 13:26
 * @description
 * @editUser hx
 * @editTime 2021/11/3 13:26
 * @editDescription
 */
public class VarExpression extends Expresssion {

    /***/
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(key);
    }
}
