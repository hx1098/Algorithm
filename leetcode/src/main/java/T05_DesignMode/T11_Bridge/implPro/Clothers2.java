package T05_DesignMode.T11_Bridge.implPro;

import T05_DesignMode.T11_Bridge.Product;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/11 22:13
 * @description
 * @editUser hx
 * @editTime 2021/10/11 22:13
 * @editDescription 集团公司生产出来的衣服.
 */
public class Clothers2 extends Product {

    /**虽然都是A货*/
    @Override
    public void beProducted() {
        System.out.println("集团生产的衣服就是好看, 设计的好好...");
    }

    /**赚钱就行*/
    @Override
    public void beSelled() {
        System.out.println("生产出来的衣服卖出去了....");
    }
}
