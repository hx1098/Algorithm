package T05_DesignMode.T11_Bridge.implPro;

import T05_DesignMode.T11_Bridge.Product;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/11 22:16
 * @description
 * @editUser hx
 * @editTime 2021/10/11 22:16
 * @editDescription
 */
public class Ipad2 extends Product {

    @Override
    public void beProducted() {
        System.out.println("集团生产出的iPad是这个样子的...");
    }

    @Override
    public void beSelled() {
        System.out.println("集团生产出来的A货卖出去了.....");
    }


}
