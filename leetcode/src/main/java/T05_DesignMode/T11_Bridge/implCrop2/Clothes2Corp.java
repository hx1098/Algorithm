package T05_DesignMode.T11_Bridge.implCrop2;

import T05_DesignMode.T11_Bridge.Corp2;
import T05_DesignMode.T11_Bridge.Product;
import T05_DesignMode.T11_Bridge.implPro.Clothers2;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/11 22:26
 * @description
 * @editUser hx
 * @editTime 2021/10/11 22:26
 * @editDescription 二代机床
 */
public class Clothes2Corp extends Corp2 {

    /**
     * 构造函数, 由子类的定义传递什么类型的产品
     * 传递一个 clothers 进来
     * @param clothers
     */
    public Clothes2Corp(Clothers2 clothers) {
        super(clothers);
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("衣服公司赚钱了...");
    }
}
