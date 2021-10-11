package T05_DesignMode.T11_Bridge.implPro;

import T05_DesignMode.T11_Bridge.Product;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/11 22:09
 * @description
 * @editUser hx
 * @editTime 2021/10/11 22:09
 * @editDescription 这个是我集团公司盖的房子
 */
public class House2 extends Product {

    /**豆腐渣就豆腐渣吧, 反正是房子*/
    @Override
    public void beProducted() {
        System.out.println("集团公司生产出来的房子质量还是比较好的....");
    }

    /**质量刚刚的, 还是能卖出去的*/
    @Override
    public void beSelled() {
        System.out.println("生产的豆腐渣房子卖出去了...哈哈哈");
    }
}
