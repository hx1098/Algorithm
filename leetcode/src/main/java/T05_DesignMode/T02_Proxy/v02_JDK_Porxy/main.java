package T05_DesignMode.T02_Proxy.v02_JDK_Porxy;

import java.lang.reflect.Proxy;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/10/18 15:30
 * @description
 * @editUser hx1098
 * @editTime 2022/10/18 15:30
 * @editDescription
 */
public class main {

    public static void main(String[] args) throws Exception {


        IHello iHello = (IHello)Proxy.newProxyInstance(IHello.class.getClassLoader(),
                new Class[]{IHello.class},
                new MyInvocationHandler(new HelloImpl()));

        iHello.sayHello();

    }

}
