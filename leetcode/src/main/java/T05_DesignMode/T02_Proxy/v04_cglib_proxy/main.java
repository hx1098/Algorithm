package T05_DesignMode.T02_Proxy.v04_cglib_proxy;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/10/21 16:22
 * @description
 * @editUser hx1098
 * @editTime 2022/10/21 16:22
 * @editDescription
 */
public class main {

    public static void main(String[] args) {

        Customer instance = (Customer)new CglibProxy().getInstance(Customer.class);
        instance.findLove();

    }

}
