package T05_DesignMode.T02_Proxy.v02_JDK_Porxy;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/10/18 16:15
 * @description
 * @editUser hx1098
 * @editTime 2022/10/18 16:15
 * @editDescription
 */
public class HelloImpl implements IHello{

    @Override
    public void sayHello() {
        System.out.println("Hello world!");
    }
}
