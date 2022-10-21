package T05_DesignMode.T02_Proxy.v03_jdk_proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/10/21 15:37
 * @description
 * @editUser hx1098
 * @editTime 2022/10/21 15:37
 * @editDescription
 */
public class main {

    public static void main(String[] args) {
        Object instance = new JDKProxy().getInstance(new Garil());
        try {
            Method findLove = instance.getClass().getMethod("findLove", null);
            findLove.invoke(instance);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

}
