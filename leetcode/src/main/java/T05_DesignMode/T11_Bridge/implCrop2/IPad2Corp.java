package T05_DesignMode.T11_Bridge.implCrop2;

import T05_DesignMode.T11_Bridge.Corp2;
import T05_DesignMode.T11_Bridge.Product;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/11 22:36
 * @description
 * @editUser hx
 * @editTime 2021/10/11 22:36
 * @editDescription 二代机床
 */
public class IPad2Corp extends Corp2 {

    /**
     * 构造函数, 由子类的定义传递什么类型的产品
     * 传入Ipad类型
     * @param product
     */
    public IPad2Corp(Product product) {
        super(product);
    }

    /***/
    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("忘记数钱了, 呜呜呜呜....");
    }
}
