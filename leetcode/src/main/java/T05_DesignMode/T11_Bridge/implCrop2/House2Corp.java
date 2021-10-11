package T05_DesignMode.T11_Bridge.implCrop2;

import T05_DesignMode.T11_Bridge.Corp2;
import T05_DesignMode.T11_Bridge.Product;
import T05_DesignMode.T11_Bridge.implPro.House2;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/11 22:30
 * @description
 * @editUser hx
 * @editTime 2021/10/11 22:30
 * @editDescription 二代机床
 */
public class House2Corp extends Corp2 {

    /**
     * 构造函数, 由子类的定义传递什么类型的产品
     *
     * @param house
     */
    public House2Corp(House2 house) {
        super(house);
    }

    /**赚钱计算利润了....*/
    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("房地产公司可赚钱了......");
    }
}
