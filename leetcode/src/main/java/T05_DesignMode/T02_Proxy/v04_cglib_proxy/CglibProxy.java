package T05_DesignMode.T02_Proxy.v04_cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/10/21 16:24
 * @description
 * @editUser hx1098
 * @editTime 2022/10/21 16:24
 * @editDescription
 */
public class CglibProxy implements MethodInterceptor {


    public Object getInstance(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        befre();
        Object o1 = methodProxy.invokeSuper(o, objects);
        after();
        return o1;
    }

    private void after() {
        System.out.println("OK的话准备办事儿。。。");
    }

    private void befre() {
        System.out.println("我是媒婆，我已经确认你的需求，。。");
    }
}
