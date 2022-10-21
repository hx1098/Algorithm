package T05_DesignMode.T02_Proxy.v03_jdk_proxy;

import org.junit.After;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/10/21 15:40
 * @description
 * @editUser hx1098
 * @editTime 2022/10/21 15:40
 * @editDescription
 */
public class JDKProxy implements InvocationHandler {

    private Object target;

    public Object getInstance(Object perosn) {
        this.target = perosn;
        Class<?> aClass = target.getClass();
        return Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(this.target, args);
        after();
        return invoke;
    }

    private void after() {
        System.out.println("ok的话，准备办事儿。。");
    }

    private void before() {
        System.out.println("我是媒婆，已经确定你的需求，开始物色。。。。。");
    }
}
