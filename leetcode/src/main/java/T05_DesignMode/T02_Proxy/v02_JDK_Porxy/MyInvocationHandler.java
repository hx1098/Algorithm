package T05_DesignMode.T02_Proxy.v02_JDK_Porxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/10/18 16:16
 * @description
 * @editUser hx1098
 * @editTime 2022/10/18 16:16
 * @editDescription
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("------插入前置通知代码-------------");
        Object rs = method.invoke(target, args);
        System.out.println("------插入后置处理代码-------------");

        return rs;
    }
}
